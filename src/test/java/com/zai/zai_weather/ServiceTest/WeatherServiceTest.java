package com.zai.zai_weather.ServiceTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.zai.zai_weather.Component.OpenMapWeatherClient;
import com.zai.zai_weather.Component.WeatherCache;
import com.zai.zai_weather.Component.WeatherStackClient;
import com.zai.zai_weather.Model.WeatherResponse;
import com.zai.zai_weather.Service.WeatherService;

@ExtendWith(MockitoExtension.class)
public class WeatherServiceTest {

    @Mock
    private WeatherStackClient weatherStackClient;

    @Mock
    private OpenMapWeatherClient openWeatherMapClient;

    @Mock
    private WeatherCache weatherCache;

    @InjectMocks
    private WeatherService weatherService;

   @Test
    void testPrimaryProviderSuccess() {
        String city = "melbourne";
        WeatherResponse response = new WeatherResponse( 25.0, 5.0);

        // Mock behavior
        when(weatherCache.isValid()).thenReturn(false); 
        when(weatherStackClient.fetch(city)).thenReturn(response);

        
        WeatherResponse result = weatherService.getWeather(city);

        assertEquals(response.getTemperature_degrees(), result.getTemperature_degrees());
        assertEquals(response.getWind_speed(), result.getWind_speed());
        verify(weatherStackClient).fetch(city);
        verify(weatherCache).isValid();
    }   
    
}
