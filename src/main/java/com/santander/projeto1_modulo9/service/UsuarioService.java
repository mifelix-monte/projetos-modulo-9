package com.santander.projeto1_modulo9.service;

import com.santander.projeto1_modulo9.dto.UsuarioRequest;
import com.santander.projeto1_modulo9.dto.UsuarioResponse;
import com.santander.projeto1_modulo9.model.Usuario;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UsuarioService {

    Page<UsuarioResponse> getAllByCpf(String cpf, int page, int size);
    Page<UsuarioResponse> getAllByNome(String nome, int page, int size);
    UsuarioResponse create (UsuarioRequest usuarioRequest);
    Usuario getById(Integer id);
    Usuario update(UsuarioRequest usuarioRequest, Integer id);
    void delete(Integer id);
    Page<Usuario> getAll(String nome, int page, int size);
}
