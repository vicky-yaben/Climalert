package com.example.demo.services.impl;

import com.example.demo.entities.Email;
import com.example.demo.repositories.EmailRepository;
import com.example.demo.services.EmailService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {
    private final EmailRepository emailRepository;


    public EmailServiceImpl(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    @Override
    public Email crearEmail(Email email){
        return emailRepository.guardar(email);
    }

    @Override
    public List<Email> obtenerEmails(){
        return emailRepository.buscarTodos();
    }

    @Override
    public List<Email> obtenerEmailsPendientes(){
        return emailRepository.buscarPendientes();
    }
}
