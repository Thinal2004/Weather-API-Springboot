package com.example.weatherapi;

public record WeatherResponse(String name, MainData main) {
    // We nest MainData to match the nested "main" object in the JSON response
    public record MainData(double temp, int humidity) {}
}
