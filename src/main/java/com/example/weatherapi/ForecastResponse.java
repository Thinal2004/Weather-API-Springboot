package com.example.weatherapi;

import java.util.List;

public record ForecastResponse(List<ForecastItem> list) {
    public record ForecastItem(
            long dt,
            String dt_txt,
            MainData main,
            List<WeatherCondition> weather
    ) {}

    public record MainData(double temp_max, double temp_min) {}
    public record WeatherCondition(int id) {}
}
