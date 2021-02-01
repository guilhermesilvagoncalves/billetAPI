package com.br.billetAPI.controller;

import com.br.billetAPI.model.Billet;
import com.br.billetAPI.service.BilletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BilletController {

    @Autowired
    private BilletService billetService;

    @PostMapping("boleto")
    public ResponseEntity createNewBillet(@RequestBody Billet billetRequest){
        Billet billetResponse = billetService.createNewBillet(billetRequest);
        return ResponseEntity.ok(billetResponse);
    }

}
