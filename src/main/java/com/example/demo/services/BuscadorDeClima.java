package com.example.demo.services;

import com.example.demo.dto.WeatherApiResponseDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class BuscadorDeClima {
    private final RestTemplate restTemplate;

    @Value("${weatherapi.base-url}")
    private String baseUrl;

    @Value("${weatherapi.key}")
    private String apiKey;

    @Value("${weatherapi.ubicacion}")
    private String ubicacion;

    public BuscadorDeClima(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherApiResponseDTO buscarClimaActual() {
        URI uri = UriComponentsBuilder.fromUriString(baseUrl)
                .path("/current.json")
                .queryParam("key", apiKey)
                .queryParam("q", ubicacion)
                .queryParam("aqi", "no")
                .build()
                .toUri();

        return restTemplate.getForObject(uri, WeatherApiResponseDTO.class);
    }
}
