package com.DIAW.Clima_API.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClimaService {

    public final String BASE_URL_1 = "https://api.open-meteo.com/v1/";
    public final String BASE_URL_2 = "https://geocoding-api.open-meteo.com/v1/";

    private String consultarURL(String apiUrl) {
        String dados = "";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            dados = response.getBody();
        } else {
            // Handle error response
            System.out.println("Error: " + response.getStatusCode());
        }
        return dados;
    }

    public String getTempoBH() {
        String latitude = "-19.9208";
        String longitude = "-43.9378";
        String apiUrl = BASE_URL_1 + "forecast?latitude=" + latitude + "&longitude=" + longitude + "&current=temperature_2m";
        return consultarURL(apiUrl);
    }

    public String getTempo(String cidade) {
        String apiUrl = BASE_URL_2 + "search?name=" + cidade + "&count=1&language=pt&format=json";
        return consultarURL(apiUrl);
    }

}
