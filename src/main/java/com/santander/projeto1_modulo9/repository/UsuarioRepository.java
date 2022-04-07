package com.santander.projeto1_modulo9.repository;


import com.santander.projeto1_modulo9.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findById(Integer idUsuario);
    List<Usuario> findByNome(String nome);
}
