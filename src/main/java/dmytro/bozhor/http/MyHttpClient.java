package dmytro.bozhor.http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MyHttpClient {

    public static void main(String[] args) throws IOException, InterruptedException {
        var httpClient = HttpClient.newBuilder().build();

        var request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://www.google.com"))
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.headers());
        System.out.println(response.body());

    }
}
