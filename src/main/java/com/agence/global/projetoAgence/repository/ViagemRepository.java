package com.agence.global.projetoAgence.repository;

import com.agence.global.projetoAgence.entidades.Viagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViagemRepository extends JpaRepository<Viagem, Integer> {
}
