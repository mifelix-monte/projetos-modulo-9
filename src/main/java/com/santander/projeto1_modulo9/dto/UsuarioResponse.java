package com.santander.projeto1_modulo9.dto;

import com.santander.projeto1_modulo9.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter
@AllArgsConstructor

//TEM AS INFORMAÇÕES QUE EU QUERO VOLTAR COMO RESPOSTA DA API:
public class UsuarioResponse {
    private Integer id;
    private String cpf;
    private String nome;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

    //CONSTRUTOR DE UsuarioResponse QUE RECEBE UM USUARIO:
    public UsuarioResponse(Usuario usuario) {
        this.id = usuario.getId();
        this.cpf = usuario.getCpf();
        this.nome = usuario.getNome();
        this.dataCriacao = usuario.getDataCriacao();
        this.dataAtualizacao = usuario.getDataAtualizacao();
    }

    //MÉTODO QUE RECEBE UMA LISTA DE USUARIO E MAPEIA ESSA LISTA PARA UsuarioResponse
    public static List<UsuarioResponse> toResponse(List<Usuario> usuarios){
        return usuarios.stream().map(UsuarioResponse::new).collect(Collectors.toList());
    }
}