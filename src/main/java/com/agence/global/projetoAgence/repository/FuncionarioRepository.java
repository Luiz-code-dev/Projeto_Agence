package com.agence.global.projetoAgence.repository;

import com.agence.global.projetoAgence.entidades.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

    Funcionario findByUsername(String username);

    Funcionario findByMatricula(Integer matricula);
}
