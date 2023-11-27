package java.com.example.weather.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class WeatherData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private double temperature;
    private LocalDateTime timestamp;

    // Constructors
    public WeatherData() {
        // Default constructor
    }

    public WeatherData(String city, double temperature, LocalDateTime timestamp) {
        this.city = city;
        this.temperature = temperature;
        this.timestamp = timestamp;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    // toString method for better logging and debugging
    @Override
    public String toString() {
        return "WeatherData{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", temperature=" + temperature +
                ", timestamp=" + timestamp +
                '}';
    }
}
