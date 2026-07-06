package com.example.demo.repositories;

import com.example.demo.entities.Email;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailRepository {

    private final List<Email> emails = new ArrayList<>();
    private Long proximoId = 1L;

    public Email guardar(Email email) {
        email.setId(proximoId);
        proximoId++;

        emails.add(email);

        return email;
    }

    public List<Email> buscarTodos() {
        return emails;
    }

    public List<Email> buscarPendientes() {
        return emails.stream()
                .filter(email -> !email.isEnviado())
                .toList();
    }
}