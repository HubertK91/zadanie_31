package pl.hk.zadanie_31.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
    public String home(Model model, @ModelAttribute(name = "data") WeatherDto weatherDto){
        model.addAttribute("weatherData", weatherDto);
        return "home";
    }

    @PostMapping("/")
    public String findCityWeather(WeatherDto weatherDto2, RedirectAttributes redirectAttributes) {
        String name = weatherDto2.getName();
        Weather weather = weatherService.getWeatherInfo(name);
        WeatherDto weatherDto = new WeatherDto(weather.getMain(),weather.getName());
        redirectAttributes.addFlashAttribute("data", weatherDto);
        return "redirect:/";
    }
}
