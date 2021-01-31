package com.br.billetAPI.service;

import com.br.billetAPI.model.Billet;
import com.br.billetAPI.repository.BilletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Random;

@Service
public class BilletService {

    @Autowired
    private BilletRepository billetRepository;

    public Billet createNewBillet(Billet billet) {
        Billet newBillet = new Billet(billet);
        newBillet.setCode(this.generateRandomCode());
        newBillet.setDueDate(LocalDate.now().plusDays(30L));
        return billetRepository.save(newBillet);
    }

    private String generateRandomCode() {
        StringBuilder text = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 13; i++) {
            text.append(random.nextInt(10)); // gerar um número aleatório entre 0 e 9
        }
        return text.toString();
    }
}
