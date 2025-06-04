package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
        public static void main(String[] args)   {
            try{
                Conversor conversor = obtenerDatos();
                Conversor.exibir(conversor);

            } catch (Exception e){
                System.out.println("Error al obtener datos de la API: " + e.getMessage());
            }
        }
        public static Conversor obtenerDatos() throws IOException, InterruptedException{
            String url = "https://api.fastforex.io/fetch-all?api_key=MI_API_KEY";

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();
            return  gson.fromJson(response.body(), Conversor.class);
        }


    }
