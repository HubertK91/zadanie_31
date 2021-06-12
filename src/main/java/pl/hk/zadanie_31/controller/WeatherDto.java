package pl.hk.zadanie_31.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.hk.zadanie_31.model.WeatherMain;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WeatherDto {

    private WeatherMain main;
    private String name;
}
