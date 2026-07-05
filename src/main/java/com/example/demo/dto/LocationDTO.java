package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class LocationDTO {

    @JsonProperty("name")
    private String nombre;

    @JsonProperty("region")
    private String region;

    @JsonProperty("country")
    private String pais;
}
