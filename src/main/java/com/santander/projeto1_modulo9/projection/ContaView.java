package com.santander.projeto1_modulo9.projection;

import com.santander.projeto1_modulo9.model.TipoConta;
import org.springframework.beans.factory.annotation.Value;

public interface ContaView {

    Integer getSaldo();

    TipoConta getTipoConta();

    @Value("#{target.numero + ' - ' + target.agencia}")
    String getNumeroConta();

    UsuarioView getUsuario();

}
