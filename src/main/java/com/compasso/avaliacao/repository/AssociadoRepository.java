package com.compasso.avaliacao.repository;

import com.compasso.avaliacao.entity.Associado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface AssociadoRepository extends JpaRepository<Associado, Long> {
    List<Associado> findByCargo(String cargo);
}
