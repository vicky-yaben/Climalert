package com.example.demo.services;

import com.example.demo.entities.Email;

import java.util.List;

public interface EmailService {

    Email crearEmail(Email email);

    List<Email> obtenerEmails();

    List<Email> obtenerEmailsPendientes();

}
