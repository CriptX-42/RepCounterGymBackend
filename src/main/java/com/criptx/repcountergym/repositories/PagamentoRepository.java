package com.criptx.repcountergym.repositories;

import com.criptx.repcountergym.domain.Treino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Treino, Integer> {
}
