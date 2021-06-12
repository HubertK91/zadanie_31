package pl.hk.zadanie_31.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.hk.zadanie_31.DataNotAvailableException;
import pl.hk.zadanie_31.controller.WeatherDto;

import java.net.URI;

@Service
public class WeatherClient {

    @Value("${app.APPID}")
    private String appID;
    @Value("${app.myserviceWeatherUrl}")
    private String baseUrl;

    private final RestTemplate restTemplate;

    public WeatherClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherDto getWeather(String city) {
        try {
            URI uri = UriComponentsBuilder.fromUriString(baseUrl)
                    .queryParam("q", city)
                    .queryParam("appId", appID)
                    .build().toUri();
            WeatherDto response = restTemplate.getForObject(uri, WeatherDto.class);
            response.getMain().setTemp_max((double) Math.round((response.getMain().getTemp_max() - 273.15)*100.0)/100.0);
            response.getMain().setTemp_min((double) Math.round((response.getMain().getTemp_min() - 273.15)*100.0)/100.0);
            response.getMain().setTemp((double) Math.round((response.getMain().getTemp() - 273.15)*100.0)/100.0);
            return response;

        } catch (Exception e) {
            throw new DataNotAvailableException();
        }
    }
}
