package com.santander.projeto1_modulo9.service.impl;

import com.santander.projeto1_modulo9.dto.ContaRequest;
import com.santander.projeto1_modulo9.dto.ContaResponse;
import com.santander.projeto1_modulo9.dto.UsuarioResponse;
import com.santander.projeto1_modulo9.model.Conta;
import com.santander.projeto1_modulo9.repository.ContaRepository;
import com.santander.projeto1_modulo9.repository.UsuarioRepository;
import com.santander.projeto1_modulo9.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaServiceImpl implements ContaService {

    @Autowired
    ContaRepository contaRepository;
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public ContaResponse create(Integer idUsuario, ContaRequest contaRequest) {
            usuarioRepository.findById(idUsuario).orElseThrow();
            Conta conta = new Conta(contaRequest);
            contaRepository.save(conta);
            return new ContaResponse(conta);
    }
}
