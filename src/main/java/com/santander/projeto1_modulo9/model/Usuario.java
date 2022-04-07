package com.santander.projeto1_modulo9.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.santander.projeto1_modulo9.dto.UsuarioRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Table(name = "usuario") //aqui estou dizendo o nome da tabela no banco de dados
@Entity //estou falando para o JPA que essa classe faz referência a tabela no banco de dados
// e ele vai se responsabilizar para genrenciá-la
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)//Para o JPA conseguir gerenciar o "@CreatedDate" e o "@LastModifiedDate".
// Precisa informar que estas classes serão auditadas, então vai ficar auditando as mesmas.


//para gerar um construtor vazio, porque quando o JPA for preencher esta classe com algum valor do bando de dados,
// ele precisa de um construtor vazio
public class Usuario {

    @Id //desta forma o JPA vai reconhecer que o ID é o identificar da tabela no banco
    @GeneratedValue(strategy = GenerationType.IDENTITY)//essa estratégia irá gerar meu Id automaticamente
    private Integer id; //porque no banco de dados ele está como Integer também

    //"@Column" faz a referência, para o JPA ir no banco de dados, procurar o nome da coluna e popular aqui
    @Column(name = "cpf", nullable = false, unique = true)
    //"nullable = false": quer dizer que o "cpf" não pose ser nulo
    // e "unique = true": quer dizer que o valor tem que ser único
    private String cpf;

    @Column(name = "senha")
    private String senha;

    @Column(name = "nome")
    private String nome;

    @Column(name = "data_criacao")
    @CreatedDate //dessa forma ele vai reconhecer que esse campo é a data de criação
    @UpdateTimestamp
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao")
    @LastModifiedDate //explica que se refere a data da última atualização
    @UpdateTimestamp
    private LocalDateTime dataAtualizacao;

    //mapeando as contas de usuário na classe dele:

    @JsonIgnore
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL ) //porque tem um usuário para várias contas,
    // (mappedBy = "usuario"): estou informando como ele vai mapear as informações,
    // isso vai fazer que ele vá na minha Conta e procure por usuario
    private List<Conta> contas;

    //CONSTRUTOR QUE RECEBE UM UsuarioRequest E PASSA AS INFORMAÇÕES QUE VEIO DO UsuarioRequest NO USUARIO
    public Usuario(UsuarioRequest usuarioRequest) {
        this.cpf = usuarioRequest.getCpf();
        this.nome = usuarioRequest.getNome();
        this.senha = usuarioRequest.getSenha();
    }

}
