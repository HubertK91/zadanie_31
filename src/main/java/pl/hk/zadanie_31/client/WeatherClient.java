package pl.hk.zadanie_31.client;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.hk.zadanie_31.DataNotAvailableException;
import pl.hk.zadanie_31.controller.WeatherDto;

@Service
public class WeatherClient {

    private final RestTemplate restTemplate;

    public WeatherClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherDto getWeather(String q, String appId) {
        try {
            return restTemplate.getForObject(q + appId, WeatherDto.class);
        } catch (Exception e) {
            throw new DataNotAvailableException();
        }
    }
}
