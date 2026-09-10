package com.example.weatherapi;

import java.util.List;

public record WeatherResponse(String name, MainData main, WindData wind, List<WeatherCondition> weather) {
    // We nest MainData to match the nested "main" object in the JSON response
    public record MainData(double temp, int humidity) {}

    // Matches the "wind" JSON object (speed and direction)
    public record WindData(double speed, int deg) {}

    // Matches the items inside the "weather" JSON array (cloudy, sunny, etc.)
    public record WeatherCondition(String main, String description) {}
}
