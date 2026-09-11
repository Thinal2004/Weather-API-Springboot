package com.example.weatherapi;

import java.util.List;

public record WeatherResponse(String name,
                              MainData main,
                              WindData wind,
                              int visibility,
                              int timezone,
                              SysData sys, // Added to capture country and sun times
                              List<WeatherCondition> weather
                              ) {
    // We nest MainData to match the nested "main" object in the JSON response
    public record MainData(double temp,
                           int humidity,
                           int pressure,
                           double feels_like, // Matches OWM exact JSON key
                           double temp_min,
                           double temp_max) {}

    // Matches the "wind" JSON object (speed and direction)
    public record WindData(double speed, int deg) {}

    // Matches the items inside the "weather" JSON array (cloudy, sunny, etc.)
    public record WeatherCondition(int id, String main, String description) {}

    public record SysData(
            String country,
            long sunrise,
            long sunset
    ) {}
}
