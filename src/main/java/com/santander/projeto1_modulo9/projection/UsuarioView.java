package com.santander.projeto1_modulo9.projection;

import org.springframework.beans.factory.annotation.Value;

public interface UsuarioView {

    @Value("#{target.nome + ' - ' + target.cpf}")
    String getNomeCpf();

}
