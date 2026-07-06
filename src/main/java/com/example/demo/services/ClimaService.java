package com.example.demo.services;

import com.example.demo.entities.Clima;

import java.util.List;
import java.util.Optional;

public interface ClimaService {

    Clima guardarClima(Clima clima);

    Optional<Clima> obtenerUltimoClima();

    List<Clima> obtenerHistorial();

    List<Clima> obtenerClimasNoProcesados();

    Clima obtenerYGuardarClimaActual();
}
