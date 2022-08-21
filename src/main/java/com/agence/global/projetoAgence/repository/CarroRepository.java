package com.agence.global.projetoAgence.repository;

import com.agence.global.projetoAgence.entidades.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Integer> {


    @Query("select c from Carro c where c.carroUsado = true")
    List<Carro> findAllByCarroUsado();
}
