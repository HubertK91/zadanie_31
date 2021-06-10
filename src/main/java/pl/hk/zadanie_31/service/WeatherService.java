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

    public Weather getWeatherInfo(String q, String appId){
        WeatherDto weatherDto = weatherClient.getWeather(q, appId);
        return new Weather(weatherDto.getName(), weatherDto.getTemp(), weatherDto.getFeels_like(), weatherDto.getTemp_min(),
                weatherDto.getTemp_max(), weatherDto.getPressure());
    }
}
