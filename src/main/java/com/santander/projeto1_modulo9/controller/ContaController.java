package com.santander.projeto1_modulo9.controller;

import com.santander.projeto1_modulo9.dto.ContaRequest;
import com.santander.projeto1_modulo9.dto.ContaResponse;
import com.santander.projeto1_modulo9.dto.UsuarioRequest;
import com.santander.projeto1_modulo9.dto.UsuarioResponse;
import com.santander.projeto1_modulo9.model.Conta;
import com.santander.projeto1_modulo9.model.Usuario;
import com.santander.projeto1_modulo9.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    ContaService contaService;

    @PostMapping ("/usuario/{idUsuario}")
    public ContaResponse create (@PathVariable Integer idUsuario, @RequestBody ContaRequest contaRequest){
        return contaService.create(idUsuario, contaRequest);
    }
}
