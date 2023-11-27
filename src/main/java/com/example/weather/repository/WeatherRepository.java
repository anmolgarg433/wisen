package com.example.weather.repository;

import com.example.weather.model.WeatherData;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface WeatherRepository extends JpaRepository<WeatherData, Long> {

    List<WeatherData> findByCityAndTimestampAfter(String city, LocalDateTime timestamp);
}
