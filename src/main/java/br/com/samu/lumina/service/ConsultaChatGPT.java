package br.com.samu.lumina.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class ConsultaChatGPT {
    public static String obterTraducao(String texto) {
        ObjectMapper mapper = new ObjectMapper();
        HttpClient client = HttpClient.newHttpClient();

        // Codificando o texto para URL (transformar espaços em %20, etc)
        String textoCodificado = URLEncoder.encode(texto, StandardCharsets.UTF_8);
        String langPair = URLEncoder.encode("en|pt-br", StandardCharsets.UTF_8);

        String url = "https://api.mymemory.translated.net/get?q=" + textoCodificado + "&langpair=" + langPair;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JsonNode rootNode = mapper.readTree(response.body());

            // A estrutura da MyMemory é: responseData -> translatedText
            return rootNode.path("responseData").path("translatedText").asText();

        } catch (Exception e) {
            System.out.println("Erro na tradução MyMemory: " + e.getMessage());
            return texto; // Se der erro, retorna o original em inglês
        }
    }
}