package com.example.digio.client;

//import java.net.http.HttpClient;

public class AppClient {
//    private static final String URL_PRODUTOS = "https://rgr3viiqdl8sikgv.public.blob.vercel-storage.com/produtos-mnboX5IPl6VgG390FECTKqHsD9SkLS.json";
//    private static final String URL_CLIENTES = "https://rgr3viiqdl8sikgv.public.blob.vercelstorage.com/clientes-Vz1U6aR3GTsjb3W8BRJhcNKmA81pVh.json";
//
//    private final HttpClient client;
//    private final ObjectMapper mapper;
//
//    public ApiClient() {
//        this.client = HttpClient.newHttpClient();
//        this.mapper = new ObjectMapper();
//    }
//
//    public List<Produto> obterProdutos() throws IOException, InterruptedException {
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create(URL_PRODUTOS))
//                .GET()
//                .build();
//
//        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        return mapper.readValue(response.body(), new TypeReference<List<Produto>>() {});
//    }
//
//    public List<Cliente> obterClientes() throws IOException, InterruptedException {
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create(URL_CLIENTES))
//                .GET()
//                .build();
//
//        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        return mapper.readValue(response.body(), new TypeReference<List<Cliente>>() {});
//    }
//
//    public static void main(String[] args) {
//        ApiClient apiClient = new ApiClient();
//        try {
//            List<Produto> produtos = apiClient.obterProdutos();
//            List<Cliente> clientes = apiClient.obterClientes();
//
//            System.out.println("Produtos:");
//            for (Produto p : produtos) {
//                System.out.println("- " + p.nome + " (Preço: " + p.preco + ")");
//            }
//
//            System.out.println("\nClientes:");
//            for (Cliente c : clientes) {
//                System.out.println("- " + c.nome + " (Email: " + c.email + ")");
//            }
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
}
