package com.santander.projeto1_modulo9.repository;

import com.santander.projeto1_modulo9.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {
    Optional<Conta> findById(Integer idUsuario);
}
