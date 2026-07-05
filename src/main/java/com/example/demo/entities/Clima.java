package com.example.demo.entities;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Data
public class Clima {

    private Long id;
    private String ubicacion;
    private Double temperatura;
    private Integer humedad;
    private String condicion;
    private LocalDate fechaConsulta;
}
