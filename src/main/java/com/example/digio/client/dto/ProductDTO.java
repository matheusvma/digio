package com.example.digio.client.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.math.BigDecimal;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record ProductDTO(
        Integer codigo,
        String tipoVinho,
        BigDecimal preco,
        String safra,
        Integer anoCompra
) {
}
