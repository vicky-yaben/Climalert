package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CurrentDTO {

    @JsonProperty("temp_c")
    private Double temperaturaCelsius;

    @JsonProperty("temp_f")
    private Double temperaturaFahrenheit;

    @JsonProperty("humidity")
    private Integer humedad;

    @JsonProperty("condition")
    private ConditionDTO condicion;

    @JsonProperty("wind_kph")
    private Double velocidadVientoKmh;

    @JsonProperty("last_updated")
    private String ultimaActualizacion;
}