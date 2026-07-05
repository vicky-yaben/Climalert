package com.example.demo.repositories;

import com.example.demo.entities.Clima;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ClimaRepository {

    private final List<Clima> historial = new ArrayList<>();
    private Long proximoId = 1L;

    public Clima guardar(Clima clima) {
        clima.setId(proximoId);
        proximoId++;

        historial.add(clima);

        return clima;
    }

    public List<Clima> buscarTodos() {
        return historial;
    }

    public Optional<Clima> buscarUltimo() {
        if (historial.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(historial.get(historial.size() - 1));
    }
}
