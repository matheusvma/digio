package com.example.digio.dto.response;

import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;

@Builder
public record CustomerPurchasesDetailResponseDTO(
        String nome,
        String cpf,
        List<CustomerPurchasesDetail> detalhesComprasClientes
) {

    @Builder
    public record CustomerPurchasesDetail(
            ProductDetail produto,
            PurchasesDetail detalhesCompra
    ) {}

    @Builder
    public record ProductDetail(
            String codigo,
            String tipoVinho,
            BigDecimal preco,
            String safra,
            Integer anoCompra
    ) {}

    @Builder
    public record PurchasesDetail(
            Integer quantidade,
            BigDecimal valorTotal
    ) {}
}
