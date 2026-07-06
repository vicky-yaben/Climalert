package com.example.demo.schedulers;

import com.example.demo.entities.Clima;
import com.example.demo.entities.Email;
import com.example.demo.services.ClimaService;
import com.example.demo.services.EmailService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AlertaClimaScheduler {
    private final ClimaService climaService;
    private final EmailService emailService;

    private final List<String> destinatarios = List.of(
            "admin@clima.com",
            "emergencias@clima.com",
            "meteorologia@clima.com"
    );

    public AlertaClimaScheduler(ClimaService climaService, EmailService emailService) {
        this.climaService = climaService;
        this.emailService = emailService;
    }

    @Scheduled(fixedRate = 60000)
    public void evaluarClimasYGenerarAlertas(){
        List<Clima> climasNoProcesados = climaService.obtenerClimasNoProcesados();

        for (Clima clima : climasNoProcesados){
            if (esClimaCritico(clima)){
                generarEmailsDeAlerta(clima);
            }
            clima.setProcesado(true);

            System.out.println("Clima procesado con id " + clima.getId());
        }
    }

    private boolean esClimaCritico(Clima clima){
        return clima.getTemperaturaCelsius() > 35 && clima.getHumedad() > 60;
    }

    private void generarEmailsDeAlerta(Clima clima){
        for (String destinatario : destinatarios){
            Email email = new Email(
                    destinatario,
                    "climalert@clima.com",
                    "Alerta meteorologica",
                    generarContenidoEmail(clima)
            );

            emailService.crearEmail(email);

            System.out.println("Email de alerta guardado para " + destinatario);
        }

    }

    private String generarContenidoEmail(Clima clima){
        return "Se detectaron condiciones climáticas críticas.\n\n"
                + "Ciudad: " + clima.getCiudad() + "\n"
                + "Región: " + clima.getRegion() + "\n"
                + "País: " + clima.getPais() + "\n"
                + "Temperatura Celsius: " + clima.getTemperaturaCelsius() + "°C\n"
                + "Temperatura Fahrenheit: " + clima.getTemperaturaFahrenheit() + "°F\n"
                + "Humedad: " + clima.getHumedad() + "%\n"
                + "Condición: " + clima.getCondicion() + "\n"
                + "Velocidad del viento: " + clima.getVelocidadVientoKmh() + " km/h\n"
                + "Fecha de actualización: " + clima.getFechaActualizacion();
    }
}
