package com.santander.projeto1_modulo9.service.impl;

import com.santander.projeto1_modulo9.dto.ContaRequest;
import com.santander.projeto1_modulo9.dto.ContaResponse;
import com.santander.projeto1_modulo9.dto.UsuarioResponse;
import com.santander.projeto1_modulo9.model.Conta;
import com.santander.projeto1_modulo9.repository.ContaRepository;
import com.santander.projeto1_modulo9.repository.UsuarioRepository;
import com.santander.projeto1_modulo9.service.ContaService;
import com.santander.projeto1_modulo9.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaServiceImpl implements ContaService {

    @Autowired
    ContaRepository contaRepository;
    @Autowired
    UsuarioService usuarioService;

    @Override
    public Conta create(Integer idUsuario, ContaRequest contaRequest) {
        var usuario = usuarioService.getById(idUsuario);

        Conta conta = new Conta(contaRequest);
        conta.setUsuario(usuario);
        return contaRepository.save(conta);
        // return new Conta(contaRequest);

//            var usuario = usuarioService.getById(idUsuario);
//
//            Conta conta = new Conta();
//            conta.setTipoConta(contaRequest.getTipoConta());
//
//            conta.setUsuario(usuario);
//
//            conta = contaRepository.save(conta);
//
//            return new Conta(conta);
    }
}
