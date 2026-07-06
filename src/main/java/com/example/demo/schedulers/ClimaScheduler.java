package com.example.demo.schedulers;

import com.example.demo.entities.Clima;
import com.example.demo.services.ClimaService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ClimaScheduler {

    private final ClimaService climaService;

    public ClimaScheduler(ClimaService climaService) {
        this.climaService = climaService;
    }

    @Scheduled(fixedRate = 300000)
    public void obtenerClimaCadaCincoMinutos() {
        Clima clima = new Clima();

        clima.setCiudad("Buenos Aires");
        clima.setRegion("CABA");
        clima.setPais("Argentina");

        clima.setTemperaturaCelsius(36.5);
        clima.setTemperaturaFahrenheit(97.7);
        clima.setVelocidadVientoKmh(12.0);

        clima.setHumedad(65);
        clima.setCondicion("Soleado");

        clima.setFechaActualizacion(LocalDateTime.now());
        clima.setProcesado(false);

        Clima climaGuardado = climaService.guardarClima(clima);

        System.out.println("Clima guardado con id "
                + climaGuardado.getId()
                + ": "
                + climaGuardado.getCiudad()
                + " - "
                + climaGuardado.getTemperaturaCelsius()
                + "°C - humedad "
                + climaGuardado.getHumedad()
                + "%");
    }
}
