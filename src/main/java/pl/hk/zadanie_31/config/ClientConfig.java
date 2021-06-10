package pl.hk.zadanie_31.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ClientConfig {

    @Bean
    @Autowired
    public RestTemplate weatherRestTemplate(@Value("${https://api.openweathermap.org/data/2.5/weather}") String weatherHostUrl){
        return new RestTemplateBuilder()
                .rootUri(weatherHostUrl)
                .additionalInterceptors(new LoggingInterceptor())
                .build();
    }
}
