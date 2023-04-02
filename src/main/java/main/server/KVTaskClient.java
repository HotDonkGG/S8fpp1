package main.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class KVTaskClient {
    private final String apiUrl;
    private String apiToken;

    public KVTaskClient(String apiUrl) {
        this.apiUrl = apiUrl;
      this.apiToken = register();
    }

    private String register() {

        HttpClient httpClient = HttpClient.newHttpClient();
        var url = URI.create(apiUrl + "/register");
        var request = HttpRequest.newBuilder()
                .uri(url)
                .GET()
                .build();
        try {
           var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
           apiToken = response.body();
        } catch (IOException | InterruptedException e ) {
            System.out.println(e.getMessage());
        }

        return apiToken;
    }

    public void put(String key, String json) throws IOException {
        URL url = new URL(apiUrl + "/save/" + key + "?API_TOKEN=" + apiToken);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);

        byte[] postDataBytes = json.getBytes(StandardCharsets.UTF_8);
        connection.getOutputStream().write(postDataBytes);

        connection.getResponseCode();
    }
//localhost:8078/save/1?API_TOKEN=1680362422576
// http://localhost:8078/load/1?API_TOKEN=1680362422576
    public String load(String key) throws IOException {
        URL url = new URL(apiUrl + "/load/" + key + "?API_TOKEN=" + apiToken);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        return response.toString();
    }
}