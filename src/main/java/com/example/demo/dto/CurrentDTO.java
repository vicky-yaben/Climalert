package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CurrentDTO {

    @JsonProperty("temp_c")
    private Double temperatura;

    @JsonProperty("humidity")
    private Integer humedad;

    @JsonProperty("condition")
    private ConditionDTO condicion;

    @JsonProperty("last_updated")
    private String ultimaActualizacion;
}