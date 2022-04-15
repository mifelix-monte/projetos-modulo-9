package com.santander.projeto1_modulo9.service.impl;

import com.santander.projeto1_modulo9.dto.ContaRequest;
import com.santander.projeto1_modulo9.dto.ContaResponse;
import com.santander.projeto1_modulo9.dto.UsuarioResponse;
import com.santander.projeto1_modulo9.model.Conta;
import com.santander.projeto1_modulo9.model.TipoConta;
import com.santander.projeto1_modulo9.model.Usuario;
import com.santander.projeto1_modulo9.projection.ContaView;
import com.santander.projeto1_modulo9.repository.ContaRepository;
import com.santander.projeto1_modulo9.repository.UsuarioRepository;
import com.santander.projeto1_modulo9.service.ContaService;
import com.santander.projeto1_modulo9.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    }


    @Override
    public List<ContaView> getAllViewByTipoConta(TipoConta tipoConta) {
        return contaRepository.findAllByTipoConta(tipoConta);
    }

    @Override
    public Conta getById(Integer id) {
        return contaRepository.findById(id).orElseThrow();
    }

    @Override
    public Conta update(Integer id, ContaRequest contaRequest) {
        Conta conta = contaRepository.findById(id).orElseThrow();

        conta.setNumero(contaRequest.getNumero());
        conta.setAgencia(contaRequest.getAgencia());
        conta.setSaldo(contaRequest.getSaldo());
        conta.setTipoConta(contaRequest.getTipoConta());

        return contaRepository.save(conta);
    }

    @Override
    public void delete(Integer id){
        var usuario = contaRepository.findById(id).orElseThrow();

        contaRepository.delete(usuario);
    }
}
