package com.example.weather.service;

import com.example.weather.model.WeatherData;
import com.example.weather.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class WeatherServiceImpl implements WeatherService {

    private static final String OPEN_WEATHER_API_KEY = "YOUR_OPENWEATHER_API_KEY";
    private static final String OPEN_WEATHER_API_URL = "http://api.openweathermap.org/data/2.5/weather?q={city}&appid={apiKey}";

    @Autowired
    private WeatherRepository weatherRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<WeatherData> getWeatherData(String city) {
        LocalDateTime threshold = LocalDateTime.now().minusMinutes(30);
        return weatherRepository.findByCityAndTimestampAfter(city, threshold);
    }

    @Override
    public void updateWeatherData(String city) {
        WeatherData newWeatherData = openWeatherApiCall(city);
        weatherRepository.save(newWeatherData);
    }

    private WeatherData openWeatherApiCall(String city) {
        String apiUrl = OPEN_WEATHER_API_URL.replace("{city}", city).replace("{apiKey}", OPEN_WEATHER_API_KEY);

        ResponseEntity<OpenWeatherApiResponse> responseEntity = restTemplate.getForEntity(apiUrl, OpenWeatherApiResponse.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            OpenWeatherApiResponse apiResponse = responseEntity.getBody();
            if (apiResponse != null) {
                double temperature = apiResponse.getMain().getTemp();
                LocalDateTime timestamp = LocalDateTime.now();
                return new WeatherData(city, temperature, timestamp);
            }
        }

        // If the API call fails or the response is not as expected, return null or handle the error accordingly
        return null;
    }

    // Inner class representing the response structure from the OpenWeather API
    private static class OpenWeatherApiResponse {
        private Main main;

        public Main getMain() {
            return main;
        }

        public void setMain(Main main) {
            this.main = main;
        }
    }

    // Inner class representing the 'main' section of the OpenWeather API response
    private static class Main {
        private double temp;

        public double getTemp() {
            return temp;
        }

        public void setTemp(double temp) {
            this.temp = temp;
        }
    }
}
