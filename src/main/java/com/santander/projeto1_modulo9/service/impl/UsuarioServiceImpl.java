package com.santander.projeto1_modulo9.service.impl;

import com.santander.projeto1_modulo9.dto.UsuarioRequest;
import com.santander.projeto1_modulo9.dto.UsuarioResponse;
import com.santander.projeto1_modulo9.model.Usuario;
import com.santander.projeto1_modulo9.repository.UsuarioRepository;
import com.santander.projeto1_modulo9.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsuarioServiceImpl implements UsuarioService {

    //chamar classe de repository para conseguir usar os métodos dela

    @Autowired //vai entrar na classe de Repository e o Spring irá instanciar para mim, se não teria que fazer:
    //UsuarioRepository usuarioRepository = new UsuarioRepository(){}
    UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> getAll(String nome) {
        if (nome != null) {
            return usuarioRepository.findByNome(nome);
        } else {
            return usuarioRepository.findAll();
        }
    }

    @Override
    public List<Usuario> getAll() {
        return null;
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

    //MÉTODO DE ATUALIZAR
    @Override
    public Usuario update(UsuarioRequest usuarioRequest, Integer id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();

        //CAMPOS EDITÁVEIS DO USUARIO
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
