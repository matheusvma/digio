package com.example.digio.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    private Integer codigo;
    private String tipo_vinho;
    private BigDecimal preco;
    private String safra;
    private Long ano_compra;

}