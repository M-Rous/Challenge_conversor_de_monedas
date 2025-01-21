package principal;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import modelos.MonedaCambio;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConvertirMoneda {

    private final String API_KEY = "b9db735460162fa395cfa4fd";

    public double convertir(String monedaOrigen, String monedaDestino, double monto) {
        // Construir la URI correcta
        String url = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + monedaOrigen;
        URI uri = URI.create(url);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .build();

        try {
            // Enviar la solicitud y obtener la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String jsonResponse = response.body();

            // Analizar el JSON y obtener la conversion de moneda con conversion_rates
            JsonObject jsonObject = new Gson().fromJson(jsonResponse, JsonObject.class);
            JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

            // Obtener la tasa de cambio para la moneda destino
            double tasaCambio = conversionRates.get(monedaDestino).getAsDouble();

            // Calcular el monto convertido
            return monto * tasaCambio;

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error al conectar con la API de conversión de monedas", e);
        }
    }

}
