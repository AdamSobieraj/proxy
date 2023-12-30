package com.example.proxy.weather;

class WeatherForecast {
    private String weatherData;

    public WeatherForecast() {
        refreshData();
    }

    public String getWeather() {
        return weatherData;
    }

    public void refreshData() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        weatherData = "Updated weather data";
    }
}