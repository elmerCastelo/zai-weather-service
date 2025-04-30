package com.zai.zai_weather.Component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.zai.zai_weather.Model.WeatherResponse;

@Component
public class WeatherStackClient {


    @Value("${weatherstack.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();


    public WeatherResponse fetch(String city) {
        String url = "http://api.weatherstack.com/current?access_key=" + apiKey + "&query=" + city;
        var node = restTemplate.getForObject(url, JsonNode.class);

        double temp = node.get("current").get("temperature").asDouble();
        double wind = node.get("current").get("wind_speed").asDouble();

        return new WeatherResponse(temp, wind);
    }
    
}
