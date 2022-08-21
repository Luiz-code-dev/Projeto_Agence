package com.agence.global.projetoAgence.dao;

import com.agence.global.projetoAgence.entidades.Funcionario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class FuncionarioDAOImpl implements FuncionarioDAO{


    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    public void insertWithQuery(Funcionario funcionario) {
        entityManager.createNativeQuery("INSERT INTO funcionario (id, nome, matricula) VALUES (?,?,?)")
                .setParameter(1, funcionario.getId())
                .setParameter(2, funcionario.getNome())
                .setParameter(3, funcionario.getMatricula())
                .executeUpdate();
    }
}
