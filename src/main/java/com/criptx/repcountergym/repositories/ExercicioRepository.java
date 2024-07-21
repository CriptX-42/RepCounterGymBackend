package com.criptx.repcountergym.repositories;

import com.criptx.repcountergym.domain.Exercicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExercicioRepository extends JpaRepository<Exercicio, Integer> {
}
