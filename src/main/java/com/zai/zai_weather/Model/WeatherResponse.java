package com.zai.zai_weather.Model;


public class WeatherResponse {

    private double wind_speed;
    private double temperature_degrees;

    
    public WeatherResponse(double wind_speed, double temperature_degrees) {
        this.wind_speed = wind_speed;
        this.temperature_degrees = temperature_degrees;
    }
    public double getWind_speed() {
        return wind_speed;
    }
    public void setWind_speed(double wind_speed) {
        this.wind_speed = wind_speed;
    }
    public double getTemperature_degrees() {
        return temperature_degrees;
    }
    public void setTemperature_degrees(double temperature_degrees) {
        this.temperature_degrees = temperature_degrees;
    }

    
}
