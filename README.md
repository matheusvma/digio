# Documentação da API - Digio

Este documento detalha os endpoints disponíveis na API de produtos e compras de vinhos.

**Base URL:** `/app-vinhos`

---

### URLs

| Método | url                         | Descrição                                                                                        |
|--------|-----------------------------|--------------------------------------------------------------------------------------------------|
| `GET`  | /compras                    | Retorna uma lista de compras ordenadas de forma crescente.                                       |
| `GET`  | /compras-recorrentes        | Retorna uma lista de compras dos clientes mais fieis.                                            |
| `GET`  | /maior-compra/{ano}         | Retorna a maior compra do ano.                                                                   |
| `GET`  | /compras-recorrentes/{tipo} | Retorna uma uma recomendação  de vinho baseado nos tipos de vinhos que os clientes mais compram. |
