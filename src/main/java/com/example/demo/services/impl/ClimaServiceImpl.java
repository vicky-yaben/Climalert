package com.example.demo.services.impl;

import com.example.demo.entities.Clima;
import com.example.demo.repositories.ClimaRepository;
import com.example.demo.services.ClimaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClimaServiceImpl implements ClimaService {

    private final ClimaRepository climaRepository;

    public ClimaServiceImpl(ClimaRepository climaRepository) {
        this.climaRepository = climaRepository;
    }

    @Override
    public Clima guardarClima(Clima clima) {
        return climaRepository.guardar(clima);
    }

    @Override
    public Optional<Clima> obtenerUltimoClima() {
        return climaRepository.buscarUltimo();
    }

    @Override
    public List<Clima> obtenerHistorial() {
        return climaRepository.buscarTodos();
    }

    @Override
    public List<Clima> obtenerClimasNoProcesados() {
        return climaRepository.buscarNoProcesados();
    }
}