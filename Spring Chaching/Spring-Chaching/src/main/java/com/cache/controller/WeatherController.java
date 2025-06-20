package com.cache.controller;

import com.cache.dto.WeatherResponse;
import com.cache.service.WeatherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }


//    curl --location 'http://localhost:8080/api/data?city=Delhi'
    @GetMapping("/data")
    public ResponseEntity<WeatherResponse> getWeatherData(@RequestParam String city) {
        WeatherResponse weatherData = weatherService.getWeatherData(city);
        return ResponseEntity.ok(weatherData);
    }
}
