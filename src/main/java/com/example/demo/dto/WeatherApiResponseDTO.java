package com.example.demo.dto;

import lombok.Data;
@Data
public class WeatherApiResponseDTO {
    private LocationDTO location;
    private CurrentDTO current;
}
