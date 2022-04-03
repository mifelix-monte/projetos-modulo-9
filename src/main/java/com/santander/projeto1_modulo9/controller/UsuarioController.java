package com.santander.projeto1_modulo9.controller;

import com.santander.projeto1_modulo9.dto.UsuarioRequest;
import com.santander.projeto1_modulo9.dto.UsuarioResponse;
import com.santander.projeto1_modulo9.model.Usuario;
import com.santander.projeto1_modulo9.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario") //rota
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping //listar todos
    public List<Usuario> getAll(@RequestParam(required = false) String nome){
        return usuarioService.getAll(nome);
    }

    @PostMapping//criar
    public UsuarioResponse create(@RequestBody UsuarioRequest usuarioRequest){
        return usuarioService.create(usuarioRequest);
    }

    //MÉTODO QUE IRÁ RETORNAR UM USUARIO
    //@PathVariable -> PEGA O ID DO USUARIO (UMA INFORMAÇÃO) NA URL
    @GetMapping("/{id}")
    public Usuario getById(@PathVariable Integer id) {
        return usuarioService.getById(id);
    } //RETORNA DIRETO O MAPEAMENTO DA MINHA SEARCE

    @PutMapping("/{id}")
    public Usuario update(@PathVariable Integer id, @RequestBody UsuarioRequest usuarioRequest){
        return usuarioService.update(usuarioRequest, id);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Integer id){
        usuarioService.delete(id);
    }
}
