package com.example.demo.entities;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Clima {

    private Long id;

    private String ciudad;
    private String region;
    private String pais;

    private Double temperaturaCelsius;
    private Double velocidadVientoKmh;
    private Double TemperaturaFahrenheit;
    private Integer humedad;
    private String condicion;

    private LocalDateTime fechaActualizacion;

    private boolean procesado;

    public Clima() {
        this.fechaActualizacion = LocalDateTime.now();
        this.procesado = false;
    }
}