package com.example.demo.services.impl;

import com.example.demo.dto.WeatherApiResponseDTO;
import com.example.demo.entities.Clima;
import com.example.demo.repositories.ClimaRepository;
import com.example.demo.services.BuscadorDeClima;
import com.example.demo.services.ClimaService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ClimaServiceImpl implements ClimaService {

    private final ClimaRepository climaRepository;
    private final BuscadorDeClima buscadorDeClima;

    public ClimaServiceImpl(ClimaRepository climaRepository, BuscadorDeClima buscadorDeClima) {
        this.climaRepository = climaRepository;
        this.buscadorDeClima = buscadorDeClima;
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

    @Override
    public Clima obtenerYGuardarClimaActual() {
        WeatherApiResponseDTO dto = buscadorDeClima.buscarClimaActual();

        Clima clima = convertirDtoAClima(dto);

        return climaRepository.guardar(clima);
    }

    private Clima convertirDtoAClima(WeatherApiResponseDTO dto) {
        Clima clima = new Clima();

        clima.setCiudad(dto.getLocation().getNombre());
        clima.setRegion(dto.getLocation().getRegion());
        clima.setPais(dto.getLocation().getPais());

        clima.setTemperaturaCelsius(dto.getCurrent().getTemperaturaCelsius());
        clima.setTemperaturaFahrenheit(dto.getCurrent().getTemperaturaFahrenheit());
        clima.setVelocidadVientoKmh(dto.getCurrent().getVelocidadVientoKmh());

        clima.setHumedad(dto.getCurrent().getHumedad());
        clima.setCondicion(dto.getCurrent().getCondicion().getTexto());

        clima.setFechaActualizacion(LocalDateTime.now());
        clima.setProcesado(false);

        return clima;
    }
}