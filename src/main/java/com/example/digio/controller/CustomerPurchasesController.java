package com.example.digio.controller;

import com.example.digio.dto.response.CustomerPurchasesDetailResponseDTO;
import com.example.digio.service.CustomerPurchasesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app-vinhos")
@RequiredArgsConstructor
@Log4j2
public class CustomerPurchasesController {

    private final CustomerPurchasesService service;

    @GetMapping("/compras")
    public ResponseEntity<List<CustomerPurchasesDetailResponseDTO>> getPurchases() {
       log.info("Controller getPurchases...");

       return ResponseEntity.ok(service.getCustomerPurchasesDetail());
    }

    @GetMapping("/maior-compra/{year}")
    public ResponseEntity<CustomerPurchasesDetailResponseDTO> getBiggestPurchaseYear(
            @PathVariable Integer year
    ) {
        log.info("Controller getBiggestPurchaseYear...");

        return ResponseEntity.ok(service.getBiggestPurchaseYearByYear(year));
    }

    @GetMapping("/compras-recorrentes")
    public ResponseEntity<List<CustomerPurchasesDetailResponseDTO>> getCustomerFaithful() {
        log.info("Controller getCustomerFaithful...");

        return ResponseEntity.ok(service.getCustomerFaithful());
    }

    @GetMapping("/compras-recorrentes/{type}")
    public ResponseEntity<CustomerPurchasesDetailResponseDTO.ProductDetail> getCustomerTypeRecommendation(
            @PathVariable String type
    ) {
        log.info("Controller getCustomerTypeRecommendation...");

        return ResponseEntity.ok(service.getCustomerTypeRecommendation(type));
    }

}
