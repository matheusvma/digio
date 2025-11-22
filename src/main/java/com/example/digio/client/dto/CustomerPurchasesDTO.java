package com.example.digio.client.dto;

import java.util.List;

public record CustomerPurchasesDTO(
        String nome,
        String cpf,
        List<PurchasesDTO> compras
) {
}
