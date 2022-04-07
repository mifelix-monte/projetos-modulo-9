package com.santander.projeto1_modulo9.model;


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
    @Enumerated(EnumType.STRING) //informando como ele vai salvar este dado, então estou dizendo que ele é um Enum
    // e qual é o tipo dele (ORDINAL ou STRING).
    // ORDINAL: salva como número e o STRING salva como uma string mesmo (PF, PJ)
    private TipoConta tipoConta;

    //a tabela de Conta tem um relacionamento com a tabela Usuário, então é preciso ser feito um mapeamento:

    @ManyToOne(cascade = CascadeType.ALL) //tenho muitas classes conta para um mesmo usuário
    //cascade: quer dizer que todas as alterações na Conta, ele vai fazer as alterações também em cascata no usuário
    @JoinColumn(name = "usuario_id", referencedColumnName = "id") //estou juntando Usuario e Conta
    //(n): nome que está referenciando a tabela usuario na tabela conta e ele faz referência ao campo Id
    // dentro do usuario.
    // referencedColumnName: vai entrar dentro do Usuario e procurar o campo id.
    private Usuario usuario;

    public Conta(ContaRequest contaRequest){
        this.numero = contaRequest.getNumero();
        this.agencia = contaRequest.getAgencia();
        this.saldo = contaRequest.getSaldo();
        this.tipoConta = contaRequest.getTipoConta();
    }

    //Apenas para fins de exemplo, se cada Usuário tivesse apenas uma conta, a única coisa que iria mudar seria o
    //@OneToOne, o restante seria igual. Exemplo:

    //@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "usuario_id", referencedColumnName = "id")
    //private Usuario usuario;
    //e na classe usuário, ao invés de anotar OneToMany, também seria OneToOne.
    //Conta continuaria dependendo de Usuario para existir
}
