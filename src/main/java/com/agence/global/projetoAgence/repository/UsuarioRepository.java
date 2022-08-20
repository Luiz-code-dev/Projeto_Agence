package com.agence.global.projetoAgence.repository;

import com.agence.global.projetoAgence.entidades.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    @Query("select f from Funcionario f where f.nome = ?1")
    Usuario findUserByLogin(String login);

}
