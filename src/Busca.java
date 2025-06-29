import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Busca {

    Gson gson =  new GsonBuilder()
            .setPrettyPrinting()
            .create();

    HttpClient client = HttpClient.newHttpClient();

    public RateApi buscadorDeMoeda(String moeda)  {

        String moedaescolhida = moeda.trim().toUpperCase();
        if (moedaescolhida == null || moedaescolhida.isEmpty()){
            return null;
        }else {
            String url = "https://v6.exchangerate-api.com/v6/52497baced7dc1be46fefe4a/latest/" + moedaescolhida;

            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(URI.create(url))
                    .build();

            try {
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());


                return gson.fromJson(response.body(), RateApi.class);

            } catch (IOException | InterruptedException | IllegalStateException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }
}
