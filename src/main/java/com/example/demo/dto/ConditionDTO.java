package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ConditionDTO {

    @JsonProperty("text")
    private String texto;
}