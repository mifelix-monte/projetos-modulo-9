package com.santander.projeto1_modulo9.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.santander.projeto1_modulo9.dto.ContaRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Table(name = "conta")
@Entity
@Getter @Setter
@NoArgsConstructor
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "agencia")
    private Integer agencia;

    @Column(name = "data_criacao")
    @CreatedDate //dessa forma ele vai reconhecer que esse campo é a data de criação
    @UpdateTimestamp
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao")
    @LastModifiedDate
    @UpdateTimestamp
    private LocalDateTime dataAtualizacao;

    @Column(name = "saldo")
    private BigDecimal saldo;

    @Column(name = "tipo_conta")
    @Enumerated(EnumType.STRING)
    private TipoConta tipoConta;

    //a tabela de Conta tem um relacionamento com a tabela Usuário, então é preciso ser feito um mapeamento:

    @ManyToOne(cascade = CascadeType.ALL) //tenho muitas classes conta para um mesmo usuário
    //cascade: quer dizer que todas as alterações na Conta, ele vai fazer as alterações também em cascata no usuário
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    @JsonIgnore
    @OneToMany(mappedBy = "conta", cascade = CascadeType.ALL)
    private List<Transacao> transacoes;

    public Conta(ContaRequest contaRequest){
        this.numero = contaRequest.getNumero();
        this.agencia = contaRequest.getAgencia();
        this.saldo = contaRequest.getSaldo();
        this.tipoConta = contaRequest.getTipoConta();
    }
}
