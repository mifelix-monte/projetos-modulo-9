package com.santander.projeto1_modulo9.service;

import com.santander.projeto1_modulo9.dto.ContaRequest;
import com.santander.projeto1_modulo9.dto.ContaResponse;
import com.santander.projeto1_modulo9.model.Conta;

public interface ContaService {

    Conta create (Integer idUsuario, ContaRequest contaRequest);
}
