package com.agence.global.projetoAgence.dao;

import com.agence.global.projetoAgence.entidades.Carro;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CarroDAOImpl implements CarroDAO{


    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertWithQuery(Carro carro) {
        entityManager.createNativeQuery("INSERT INTO carro (id, modelo, marca, data_fabricacao,carro_usado) VALUES (?,?,?,?,?)")
                .setParameter(1, carro.getId())
                .setParameter(2, carro.getModelo())
                .setParameter(3, carro.getMarca())
                .setParameter(4, carro.getDataFabricacao())
                .setParameter(5, carro.getCarroUsado())
                .executeUpdate();
    }


/*    @Transactional
    public List<Carro> ListarCarroUsado() {
        List<Carro> carros = new ArrayList<>();
        entityManager.createNativeQuery("SELECT * FROM carro WHERE carro_usado = true")
                .executeUpdate();

        return carros;*/




}
