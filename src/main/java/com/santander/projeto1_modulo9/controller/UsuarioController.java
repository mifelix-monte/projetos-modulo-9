package com.santander.projeto1_modulo9.controller;

import com.santander.projeto1_modulo9.dto.UsuarioRequest;
import com.santander.projeto1_modulo9.dto.UsuarioResponse;
import com.santander.projeto1_modulo9.model.Usuario;
import com.santander.projeto1_modulo9.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public Page<Usuario> getAll(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "3") int size
    ) {
        return usuarioService.getAll(nome, page, size);
    }

    @GetMapping("/nome")
    public Page<UsuarioResponse> getAllByNome(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "3") int size
            ){
        return usuarioService.getAllByNome(nome, page, size);
    }

    @GetMapping("/cpf")
    public Page<UsuarioResponse> getAllByCpf(
            @RequestParam String cpf,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "3") int size
            ) {
                return usuarioService.getAllByCpf(cpf, page, size);
    }

    @PostMapping
    public UsuarioResponse create(@RequestBody UsuarioRequest usuarioRequest){
        return usuarioService.create(usuarioRequest);
    }

    @GetMapping("/{id}")
    public Usuario getById(@PathVariable Integer id) {
        return usuarioService.getById(id);
    }

    @PutMapping("/{id}")
    public Usuario update(@PathVariable Integer id, @RequestBody UsuarioRequest usuarioRequest){
        return usuarioService.update(usuarioRequest, id);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Integer id){
        usuarioService.delete(id);
    }
}
