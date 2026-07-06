package com.example.demo.schedulers;

import com.example.demo.entities.Clima;
import com.example.demo.services.ClimaService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ClimaScheduler {

    private final ClimaService climaService;

    public ClimaScheduler(ClimaService climaService) {
        this.climaService = climaService;
    }

    @Scheduled(fixedRate = 300000)
    public void obtenerClimaCadaCincoMinutos() {

        Clima climaGuardado = climaService.obtenerYGuardarClimaActual();

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
