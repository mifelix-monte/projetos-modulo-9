package com.santander.projeto1_modulo9.service.impl;


import com.santander.projeto1_modulo9.dto.UsuarioRequest;
import com.santander.projeto1_modulo9.dto.UsuarioResponse;
import com.santander.projeto1_modulo9.model.Usuario;
import com.santander.projeto1_modulo9.repository.UsuarioRepository;
import com.santander.projeto1_modulo9.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public Page<Usuario> getAll(String nome, int page, int size) {
        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.Direction.DESC,
                "nome"
        );

            return usuarioRepository.findAll(pageRequest);
    }

    @Override
    public Page<UsuarioResponse> getAllByNome(String nome, int page, int size) {
        PageRequest pageRequest = PageRequest.of(
            page,
            size,
            Sort.Direction.DESC,
            "nome"
    );

    return usuarioRepository.findByNome(nome, pageRequest);
    }

    @Override
    public Page<UsuarioResponse> getAllByCpf(String cpf, int page, int size) {
        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.Direction.DESC,
                "cpf"
        );

        return usuarioRepository.findByCpf(cpf, pageRequest);
    }


    @Override
    public UsuarioResponse create(UsuarioRequest usuarioRequest) {
        Usuario usuario = new Usuario(usuarioRequest);
        usuarioRepository.save(usuario);
        return new UsuarioResponse(usuario);
    }

    @Override
    public Usuario getById(Integer id) {
        return usuarioRepository.findById(id).orElseThrow();
    }

    @Override
    public Usuario update(UsuarioRequest usuarioRequest, Integer id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();

        usuario.setNome(usuarioRequest.getNome());
        usuario.setCpf(usuarioRequest.getCpf());
        usuario.setSenha(usuarioRequest.getSenha());

        return usuarioRepository.save(usuario);
    }

    @Override
    public void delete(Integer id){
        var usuario = usuarioRepository.findById(id).orElseThrow();

        usuarioRepository.delete(usuario);
    }
}
