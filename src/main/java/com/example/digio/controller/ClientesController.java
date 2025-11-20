package com.example.digio.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@RequestMapping(value = "/api/clientes")
@Api(tags = "clientes", value = "Controlador Rest API Clientes")
@EnableSwagger2
@AllArgsConstructor
public class ClientesController {

    /**
     * Função responsável por receber uma requisição com o método GET responsavel por retornar o Top 3 clientes mais fieis,
     * clientes que possuem mais compras recorrentes com maiores valores.
     * @return
     */
    @ApiOperation(value = "Retornar o Top 3 clientes mais fieis")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Requisição Inválida"),
            @ApiResponse(code = 500, message = "Erro na aplicação")
    })
    @GetMapping( value = "/clientes-fieis", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
//    public ResponseEntity<PerfilResponse> criarPerfil() {
    public void buscaClientesFieis() {
        Perfil perfil = this.perfilService.salvarPerfil(perfilMapper.requestParaEntidade(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(perfilMapper.entidadeParaResponse(perfil));
    }

    /**
     * Função responsável por receber uma requisição com o método GET responsavel por retornar o Top 3 clientes mais fieis,
     * clientes que possuem mais compras recorrentes com maiores valores.
     * @return
     */
    @ApiOperation(value = "Retornar o Top 3 clientes mais fieis")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Requisição Inválida"),
            @ApiResponse(code = 500, message = "Erro na aplicação")
    })
    @GetMapping( value = "/recomendacao/cliente/tipo", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
//    public ResponseEntity<PerfilResponse> criarPerfil() {
    public void buscaClientesFieis() {
        Perfil perfil = this.perfilService.salvarPerfil(perfilMapper.requestParaEntidade(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(perfilMapper.entidadeParaResponse(perfil));
    }

}
