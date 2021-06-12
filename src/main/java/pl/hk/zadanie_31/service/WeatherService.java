package pl.hk.zadanie_31.service;

import org.springframework.stereotype.Service;
import pl.hk.zadanie_31.client.WeatherClient;
import pl.hk.zadanie_31.controller.WeatherDto;
import pl.hk.zadanie_31.model.Weather;

@Service
public class WeatherService {

    private final WeatherClient weatherClient;

    public WeatherService(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }

    public Weather getWeatherInfo(String city){
        WeatherDto weatherDto = weatherClient.getWeather(city);
        return new Weather(weatherDto.getMain(),weatherDto.getName());
    }
}
