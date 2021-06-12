package pl.hk.zadanie_31.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WeatherMain {
    private Double temp;
    private Double temp_min;
    private Double temp_max;
    private Double pressure;
}
