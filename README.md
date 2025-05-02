# Zai Weather Service - Java Springboot

## Introduction

This is a solution to the Zai Code Challenge. The service provides weather information for Melbourne, using:
    -Primary Provider: WeatherStack API
    -Failover Provider: OpenWeatherMap API

The API returns a unified JSON response containing:
    -temperature_degrees (°C)
    -wind_speed (km/h)
It includes basic failover logic, 3-second in-memory caching, and is designed with scalability and reliability in mind.

**Requirements**
- Java 17 or later
- Spring Boot
- Maven
- Internet access (for API calls)

## Running the Project Locally

1. Clone the repository:
   ```bash
   git clone https://github.com/elmerCastelo/zai-weather-service.git
   cd zai-weather-service

2. Navigate into the project directory:
   cd zai-weather-service
   
3. Open the project in your favorite IDE (e.g., IntelliJ IDEA,Vs Code).
4. Configure the environment variables:
   
   -WeatherStack API Key: Create an account on WeatherStack and get an API key.
   -OpenWeatherMap API Key: Create an account on OpenWeatherMap and get an API key.
   -Set the following keys in your application.properties file:
         weatherstack.api.key=${WEATHERSTACK_API_KEY}
         openweathermap.api.key=${OPENWEATHERMAP_API_KEY}
   
5. To run the project:
   ./mvnw spring-boot:run
   
6.The weather service will be available at http://localhost:8999/v1/weather?city=melbourne.   





   
