package com.example.demo.entities;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Alerta {
    private Long id;

    private Clima clima;
    private LocalDateTime fechaGeneracion;
    private String descripcion;
//    private Boolean mailEnviado;

}
