package com.example.demo.controllers;

import com.example.demo.entities.Email;
import com.example.demo.services.EmailService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emails")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public Email crearEmail(@RequestBody Email email) {
        return emailService.crearEmail(email);
    }

    @GetMapping
    public List<Email> obtenerEmails(@RequestParam(required = false) Boolean pendiente) {
        if (pendiente != null && pendiente) {
            return emailService.obtenerEmailsPendientes();
        }

        return emailService.obtenerEmails();
    }
}