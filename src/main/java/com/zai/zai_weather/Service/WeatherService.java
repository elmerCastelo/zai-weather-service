package com.zai.zai_weather.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zai.zai_weather.Component.OpenMapWeatherClient;
import com.zai.zai_weather.Component.WeatherCache;
import com.zai.zai_weather.Component.WeatherStackClient;
import com.zai.zai_weather.Model.WeatherResponse;

@Service
public class WeatherService {

     @Autowired
     private WeatherCache weatherCache;
    
     @Autowired
     private OpenMapWeatherClient openMapWeatherClient;

     @Autowired
     private WeatherStackClient weatherStackClient;


    public WeatherResponse getWeather(String city){


        if (weatherCache.isValid()) return weatherCache.get();
        {
            try {
                WeatherResponse response = weatherStackClient.fetch(city);
                weatherCache.update(response);
                return response;
            } catch (Exception e1) {
                try {
                    WeatherResponse fallback = openMapWeatherClient.fetch(city);
                    weatherCache.update(fallback);
                    return fallback;
                } catch (Exception e2) {
                    if (weatherCache.hasStale()) {
                        return weatherCache.get();
                    }
                    throw new RuntimeException("All weather providers are down");
                }
            }
        }
    }
}
