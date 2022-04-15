package com.santander.projeto1_modulo9.controller;

import com.santander.projeto1_modulo9.dto.ContaRequest;
import com.santander.projeto1_modulo9.dto.ContaResponse;
import com.santander.projeto1_modulo9.dto.UsuarioRequest;
import com.santander.projeto1_modulo9.dto.UsuarioResponse;
import com.santander.projeto1_modulo9.model.Conta;
import com.santander.projeto1_modulo9.model.TipoConta;
import com.santander.projeto1_modulo9.model.Usuario;
import com.santander.projeto1_modulo9.projection.ContaView;
import com.santander.projeto1_modulo9.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    ContaService contaService;

    @PostMapping ("/usuario/{idUsuario}")
    public Conta create (@PathVariable Integer idUsuario, @RequestBody ContaRequest contaRequest){
        return contaService.create(idUsuario, contaRequest);
    }

    @GetMapping("/view")
    public List<ContaView> getAllContaViewByTipoConta(
            @RequestParam TipoConta tipoConta){
        return contaService.getAllViewByTipoConta(tipoConta);
    }

    @GetMapping("/{id}")
    public Conta getById(@PathVariable Integer id) {
        return contaService.getById(id);
    }

    @PutMapping("/{id}")
    public Conta update (@PathVariable Integer id, @RequestBody ContaRequest contaRequest){
        return contaService.update(id, contaRequest);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Integer id){
        contaService.delete(id);
    }
}
