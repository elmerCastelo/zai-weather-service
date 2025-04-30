package com.zai.zai_weather.Component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zai.zai_weather.Model.WeatherResponse;

@Component
public class WeatherCache {

    private WeatherResponse lastResponse;

    private long timeStamp;

    public void update(WeatherResponse weatherResponse) {
        this.lastResponse = weatherResponse;
        this.timeStamp = System.currentTimeMillis();
    }   
    
    public boolean isValid(){
        return lastResponse != null && (System.currentTimeMillis() - timeStamp) < 3000;    
    }
    public boolean hasStale(){
        return lastResponse != null;
    }
    public WeatherResponse get() {
        return lastResponse;
    }
    
}
