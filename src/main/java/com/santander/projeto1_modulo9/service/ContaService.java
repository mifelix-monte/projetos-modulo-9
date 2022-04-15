package com.santander.projeto1_modulo9.service;

import com.santander.projeto1_modulo9.dto.ContaRequest;
import com.santander.projeto1_modulo9.dto.ContaResponse;
import com.santander.projeto1_modulo9.model.Conta;
import com.santander.projeto1_modulo9.model.TipoConta;
import com.santander.projeto1_modulo9.projection.ContaView;

import java.util.List;

public interface ContaService {

    Conta create (Integer idUsuario, ContaRequest contaRequest);
    List<ContaView> getAllViewByTipoConta(TipoConta tipoConta);
    Conta update(Integer id, ContaRequest contaRequest);
    void delete(Integer id);
    Conta getById(Integer id);
}
