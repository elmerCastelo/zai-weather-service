package com.zai.zai_weather.ControllerTest;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.zai.zai_weather.Controller.WeatherController;
import com.zai.zai_weather.Model.WeatherResponse;
import com.zai.zai_weather.Service.WeatherService;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WeatherController.class)
@AutoConfigureMockMvc
class WeatherControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WeatherService weatherService;

    @Test
    void shouldReturnWeatherForCity() throws Exception {
        WeatherResponse response = new WeatherResponse(25.0, 5.0);
        String city = "melbourne";

        when(weatherService.getWeather(city)).thenReturn(response);

        mockMvc.perform(get("/v1/weather?city=" + city))
                .andExpect(status().isOk())
                .andExpect(jsonPath("temperature_degrees").value(5.0))
                .andExpect(jsonPath("wind_speed").value(25.0));
    }
}