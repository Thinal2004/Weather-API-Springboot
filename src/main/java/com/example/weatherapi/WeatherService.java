package com.example.weatherapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class WeatherService {
    private final RestClient restClient;
    @Value("${weather.api.key}")
    private String apiKey;

    public WeatherService() {
        // Initialize the modern RestClient introduced in Spring 6
        this.restClient = RestClient.create();
    }

    public WeatherResponse getWeatherForCity(String city) {
        // RestClient makes the HTTP GET request and automatically converts
        // the JSON response into our WeatherResponse record.
        return restClient.get()
                .uri("https://api.openweathermap.org/data/2.5/weather?q={city}&units=metric&appid={key}", city, apiKey)
                .retrieve()
                .body(WeatherResponse.class);
    }
}