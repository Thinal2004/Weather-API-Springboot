package com.example.weatherapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    private final WeatherService weatherService;

    // Spring automatically injects the WeatherService here
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public WeatherResponse getWeather(@RequestParam String city) {
        // Pass the city from the URL to our service layer
        return weatherService.getWeatherForCity(city);
    }

    @GetMapping("/forecast")
    public ForecastResponse getForecast(@RequestParam String city) {
        return weatherService.getForecast(city);
    }
}
