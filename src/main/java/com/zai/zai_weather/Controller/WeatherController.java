package com.zai.zai_weather.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zai.zai_weather.Model.WeatherResponse;
import com.zai.zai_weather.Service.WeatherService;

@RestController
@RequestMapping("/v1/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping
    public ResponseEntity<WeatherResponse> getWeather(String city) {
        return ResponseEntity.ok(weatherService.getWeather(city));
    }


}
