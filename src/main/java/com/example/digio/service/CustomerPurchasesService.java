package com.example.digio.service;


import com.example.digio.client.ProductsClient;
import com.example.digio.client.dto.CustomerPurchasesDTO;
import com.example.digio.client.dto.ProductDTO;
import com.example.digio.dto.response.CustomerPurchasesDetailResponseDTO;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class CustomerPurchasesService {

    private final ProductsClient client;

    private List<ProductDTO> productsDTO;
    private List<CustomerPurchasesDTO> customerPurchasesDTO;

    @PostConstruct
    void init() {
        productsDTO = client.getProducts();
        customerPurchasesDTO = client.getCustumerPurchases();
    }

    public List<CustomerPurchasesDetailResponseDTO> getCustomerPurchasesDetail() {

        return createListCustomerPurchasesDetailResponseDTO().stream().map(dto -> {

            var listSorted = dto.detalhesComprasClientes()
                    .stream()
                    .sorted(Comparator.comparing(detalhe -> detalhe.produto().preco()))
                    .toList();

            return CustomerPurchasesDetailResponseDTO.builder()
                    .cpf(dto.cpf())
                    .nome(dto.nome())
                    .detalhesComprasClientes(listSorted)
                    .build();
        }).toList();
    }

    public CustomerPurchasesDetailResponseDTO getBiggestPurchaseYearByYear(Integer year) {
        return createListCustomerPurchasesDetailResponseDTO().stream()
                .max(Comparator.comparing(dto ->
                dto.detalhesComprasClientes().stream()
                        .filter(detail -> year.equals(detail.produto().anoCompra()))
                        .map(detail -> detail.detalhesCompra().valorTotal())
                        .max(Comparator.naturalOrder())
                        .orElse(BigDecimal.ZERO))).get();
    }

    public List<CustomerPurchasesDetailResponseDTO> getCustomerFaithful() {

        return createListCustomerPurchasesDetailResponseDTO().stream()
                .sorted(
                        Comparator.comparingInt((CustomerPurchasesDetailResponseDTO dto) -> dto.detalhesComprasClientes().size())
                                .reversed()
                                .thenComparing(CustomerPurchasesService::calcularValorTotal, Comparator.reverseOrder())
                )
                .limit(3)
                .toList();
    }

    private static BigDecimal calcularValorTotal(CustomerPurchasesDetailResponseDTO dto) {
        return dto.detalhesComprasClientes().stream()
                .map(detalhe -> detalhe.detalhesCompra().valorTotal())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public CustomerPurchasesDetailResponseDTO.ProductDetail getCustomerTypeRecommendation(String type) {

        Map<CustomerPurchasesDetailResponseDTO.ProductDetail, Integer> quantityByProduct = createListCustomerPurchasesDetailResponseDTO().stream()
                .flatMap(customerPurchasesDetailResponseDTO -> customerPurchasesDetailResponseDTO.detalhesComprasClientes().stream())
                .filter(customerPurchasesDetail -> customerPurchasesDetail.produto().tipoVinho().equals(type))
                .collect(Collectors.groupingBy(
                        CustomerPurchasesDetailResponseDTO.CustomerPurchasesDetail::produto,
                        Collectors.summingInt(
                                detail -> detail.detalhesCompra().quantidade()
                        )
                ));

        return quantityByProduct.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(CustomerPurchasesDetailResponseDTO.ProductDetail.builder().build());
    }

    private List<CustomerPurchasesDetailResponseDTO> createListCustomerPurchasesDetailResponseDTO() {
        return customerPurchasesDTO.stream().map(dto -> {

            var customerPurchasesDetails = dto.compras().stream().map(purchases -> {

                var productDetail = productsDTO.stream()
                        .filter(productDTO -> productDTO.codigo() == Integer.parseInt(purchases.codigo()))
                        .findFirst()
                        .map(productDTO -> CustomerPurchasesDetailResponseDTO.ProductDetail.builder()
                                .codigo(productDTO.codigo().toString())
                                .tipoVinho(productDTO.tipoVinho())
                                .preco(productDTO.preco())
                                .safra(productDTO.safra())
                                .anoCompra(productDTO.anoCompra())
                                .build())
                        .get();

                var purchasesDetail = CustomerPurchasesDetailResponseDTO.PurchasesDetail.builder()
                        .quantidade(purchases.quantidade())
                        .valorTotal(productDetail.preco().multiply(new BigDecimal(purchases.quantidade())))
                        .build();

                return CustomerPurchasesDetailResponseDTO.CustomerPurchasesDetail.builder()
                        .produto(productDetail)
                        .detalhesCompra(purchasesDetail)
                        .build();
            }).toList();

            return CustomerPurchasesDetailResponseDTO.builder()
                    .nome(dto.nome())
                    .cpf(dto.cpf())
                    .detalhesComprasClientes(customerPurchasesDetails)
                    .build();
        }).toList();
    }


}
