package com.cache.service;

import com.cache.dto.WeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class WeatherService {
    private static final Logger log = LoggerFactory.getLogger(WeatherService.class);
    private Map<String, String> weatherData = new ConcurrentHashMap<>();
    private final RedisService redisService;

    public WeatherService(RedisService redisService) {
        this.redisService = redisService;
        weatherData.put("Delhi", "55C");
        weatherData.put("Up", "50C");
        weatherData.put("Azamgarh", "45C");
        weatherData.put("Raunapar", "43C");
        weatherData.put("Gurgaon", "53C");
    }

//    @Cacheable("weather")
    public WeatherResponse getWeatherData(String city) {
        WeatherResponse weatherResponse = redisService.get(city, WeatherResponse.class);
        if (weatherResponse != null) {
            log.info("Cache Hit for city {}", city);
            return weatherResponse;
        } else {
            log.info("Cache Miss for city {}", city);
            String s = weatherData.get(city);
            if (s == null) {
                log.error("Data not found for {}", city);
                return null;
            }
            weatherResponse = new WeatherResponse();
            weatherResponse.setCity(city);
            weatherResponse.setTemp(s);

            redisService.set(city, weatherResponse, 120L);
            return weatherResponse;
        }
    }
}
