package com.example.demo.entities;

import lombok.Data;

@Data
public class Email {

    private Long id;

    private String destinatario;
    private String remitente;
    private String asunto;
    private String contenido;

    private boolean enviado;

    public Email(String destinatario, String remitente, String asunto, String contenido) {
        this.destinatario = destinatario;
        this.remitente = remitente;
        this.asunto = asunto;
        this.contenido = contenido;
        this.enviado = false;
    }

    public void enviar() {
        // Por ahora queda pendiente.
        // Después acá podríamos usar un adapter o un servicio externo.
    }
}