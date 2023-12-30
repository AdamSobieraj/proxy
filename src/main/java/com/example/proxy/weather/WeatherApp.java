package com.example.proxy.weather;

import java.util.Random;

public class WeatherApp {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        WeatherForecast weatherForecast = new WeatherForecast();
        int numIterations = 10;

        Random random = new Random();

        for (int i = 0; i < numIterations; i++) {
            System.out.println("Iteration " + (i + 1) + ": " + weatherForecast.getWeather());

            if (random.nextDouble() <= 0.2) {
                weatherForecast.refreshData();
                System.out.println("Weather data updated!");
            }
        }

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Total execution time: " + (elapsedTime / 1000.0) + " seconds");

        System.out.println("\nTesting Lazy WeatherForecastProxy:");
        long lazyStartTime = System.currentTimeMillis();

        WeatherForecastProxy lazyProxy = new WeatherForecastProxy();

        for (int i = 0; i < numIterations; i++) {
            System.out.println("Iteration " + (i + 1) + ": " + lazyProxy.getWeather());

            if (random.nextDouble() <= 0.2) {
                lazyProxy.refreshData();
                System.out.println("Weather data updated!");
            }
        }

        long lazyEndTime = System.currentTimeMillis();
        long lazyElapsedTime = lazyEndTime - lazyStartTime;
        System.out.println("Total execution time (Lazy Proxy): " + (lazyElapsedTime / 1000.0) + " seconds");
    }
}
