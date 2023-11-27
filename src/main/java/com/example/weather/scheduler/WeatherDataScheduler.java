package com.example.weather.scheduler;

import com.example.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class WeatherDataScheduler {

    @Autowired
    private WeatherService weatherService;
    
    @Scheduled(fixedRate = 3600000)
    public void updateWeatherData() {
        weatherService.updateAllCities();
    }
}
