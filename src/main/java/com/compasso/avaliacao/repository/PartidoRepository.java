package com.compasso.avaliacao.repository;

import com.compasso.avaliacao.entity.Associado;
import com.compasso.avaliacao.entity.Partido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface PartidoRepository extends JpaRepository<Partido, Long> {
    List<Partido> findByIdeologia(String ideologia);
}
