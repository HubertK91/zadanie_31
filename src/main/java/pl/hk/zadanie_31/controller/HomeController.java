package pl.hk.zadanie_31.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.hk.zadanie_31.model.Weather;
import pl.hk.zadanie_31.service.WeatherService;

@Controller
public class HomeController {

    private final WeatherService weatherService;

    public HomeController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/")
    public String home(Model model, WeatherDto weather, @ModelAttribute("data") WeatherDto weatherDto){
        model.addAttribute("weather", weather);
        model.addAttribute("weatherData", weatherDto);
        return "home";
    }


    @PostMapping("/")
    public String findCityWeather(@RequestParam(required = false) String q,
                                  @RequestParam(required = false) String appId, RedirectAttributes redirectAttributes) {
        Weather weather = weatherService.getWeatherInfo(q, appId);
        WeatherDto weatherDto = new WeatherDto(weather.getName(), weather.getTemp(), weather.getFeels_like(), weather.getTemp_min(),
                weather.getTemp_max(), weather.getPressure());
        redirectAttributes.addFlashAttribute("data", weatherDto);
        return "redirect:/";
    }
}
