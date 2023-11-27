
import com.example.weather.model.WeatherData;

import java.util.List;

public interface WeatherService {

    List<WeatherData> getWeatherData(String city);

    void updateWeatherData(String city);
}
