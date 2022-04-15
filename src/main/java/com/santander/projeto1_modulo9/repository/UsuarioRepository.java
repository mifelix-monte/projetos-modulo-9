package com.santander.projeto1_modulo9.repository;


import com.santander.projeto1_modulo9.dto.UsuarioResponse;
import com.santander.projeto1_modulo9.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query("select new com.santander.projeto1_modulo9.dto.UsuarioResponse(u.id, u.cpf, u.nome, u.dataCriacao, u.dataAtualizacao) from Usuario u " +
            "where u.nome = :nome")
    Page<UsuarioResponse> findByNome(@Param("nome") String nome, Pageable pageable);

    //Page<Usuario> findByNome(String nome, Pageable pageable);

    Optional<Usuario> findById(Integer idUsuario);

    @Query("select new com.santander.projeto1_modulo9.dto.UsuarioResponse(u.id, u.cpf, u.nome, u.dataCriacao, u.dataAtualizacao) from Usuario u " +
            "where u.cpf = :cpf")

    Page<UsuarioResponse> findByCpf(@Param("cpf") String cpf, Pageable pageable);
}
