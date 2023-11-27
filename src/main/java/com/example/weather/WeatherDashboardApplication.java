package com.example.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WeatherDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherDashboardApplication.class, args);
    }
}