package pl.hk.zadanie_31.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Weather {

    private String name;
    private double temp;
    private double feels_like;
    private double temp_min;
    private double temp_max;
    private double pressure;



}
