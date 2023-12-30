package com.example.proxy.weather;

class WeatherForecastProxy extends WeatherForecast {
    private boolean dataUpdated = false;

    @Override
    public void refreshData() {
        super.refreshData();
        dataUpdated = true;
    }

    @Override
    public String getWeather() {
        // Aktualizujemy dane o pogodzie lazy, tylko jeśli wywołano refreshData
        if (dataUpdated) {
            super.refreshData();
            dataUpdated = false;
        }
        return super.getWeather();
    }
}