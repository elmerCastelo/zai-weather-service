package com.zai.zai_weather.Component;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.zai.zai_weather.Model.WeatherResponse;

@Component
public class OpenMapWeatherClient {

    @Value("${openweathermap.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public WeatherResponse fetch(String city){

        String url = "http://api.openweathermap.org/data/2.5/weather?q=" +
        city + ",AU&appid=" + apiKey + "&units=metric";
        var node = restTemplate.getForObject(url, JsonNode.class);

        double temp = node.get("main").get("temp").asDouble();
        double wind = node.get("wind").get("speed").asDouble();

        return new WeatherResponse(temp,wind);
    }
}
