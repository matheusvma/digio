package com.example.digio.service;

import com.example.digio.client.AppClient;
import com.example.digio.model.dto.Compra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private AppClient appClient;

    /**
     * Função responsável por buscar as compras de forma ordenada no client.
     * @return
     */
    public List<Compra> buscarCompras() throws IOException, InterruptedException {

        return this.appClient.obterProdutos();
    }

    /**
     * Função responsável por buscar todos os perfis cadastrados na base.
     * @return
     */
    public Compra buscaMaiorCompraAno() {

        return this.appClient.findAll();
    }
}
