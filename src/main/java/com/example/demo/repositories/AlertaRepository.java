package com.example.demo.repositories;

import com.example.demo.entities.Alerta;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AlertaRepository {

    private final List<Alerta> alertas = new ArrayList<>();
    private Long proximoId = 1L;

    public Alerta guardar(Alerta alerta) {
        alerta.setId(proximoId);
        proximoId++;

        alertas.add(alerta);

        return alerta;
    }

    public List<Alerta> buscarTodas() {
        return alertas;
    }
}