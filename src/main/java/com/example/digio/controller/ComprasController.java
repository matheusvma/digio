package com.example.digio.controller;

import com.example.digio.model.dto.Compra;
import com.example.digio.service.ProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@RestController
@RequestMapping(value = "/api/compras")
@Api(tags = "compras", value = "Controlador Rest API Compras")
@EnableSwagger2
@AllArgsConstructor
public class ComprasController {

    @Autowired
    private ProdutoService produtoService;

    /**
     * Função responsável por receber uma requisição com o método GET.
     * Responsavel por retornar uma lista das compras ordenadas de forma crescente por valor, deve conter o nome dos clientes, cpf dos clientes,
     * dado dos produtos, quantidade das compras e valores totais de cada compra.
     * @return
     */
    @ApiOperation(value = "Retornar uma lista das compras ordenadas de forma crescente")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Requisição Inválida"),
            @ApiResponse(code = 500, message = "Erro na aplicação")
    })
    @GetMapping( consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Compra>> buscarCompras() {
        return ResponseEntity.status(HttpStatus.OK).body(this.produtoService.buscarCompras());
    }

    /**
     * Função responsável por receber uma requisição com o método GET.
     * Responsavel por retornar a maior compra do ano informando os dados da compra disponibilizados,
     * deve ter o nome do cliente, cpf do cliente, dado do produto, quantidade da compra e seu valor total.
     * @return
     */
    @ApiOperation(value = "Retornar a maior compra do ano")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Requisição Inválida"),
            @ApiResponse(code = 500, message = "Erro na aplicação")
    })
    @GetMapping( value = "/maior-compra/{ano}" ,consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Compra> buscaMaiorCompraAno(@RequestParam(name = "ano") Integer ano) {
        return ResponseEntity.status(HttpStatus.OK).body(this.produtoService.buscaMaiorCompraAno(ano));
    }

}
