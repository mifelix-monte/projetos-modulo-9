package com.santander.projeto1_modulo9.service;

import com.santander.projeto1_modulo9.dto.UsuarioRequest;
import com.santander.projeto1_modulo9.dto.UsuarioResponse;
import com.santander.projeto1_modulo9.model.Usuario;

import java.util.List;

public interface UsuarioService {

    //criando um método que irá trazer uma lista de todos os usuarios da minha base
    List<Usuario> getAll(String nome);

    List<Usuario> getAll();

    UsuarioResponse create (UsuarioRequest usuarioRequest);
    Usuario getById(Integer id); //método que traz o usuário pelo id
    Usuario update(UsuarioRequest usuarioRequest, Integer id); //para atualizar o objeto inteiro,
    //com Integer id, preciso que ele me diga o id do usuario que eu quero atualizar
    void delete(Integer id);
}
