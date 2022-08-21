package com.agence.global.projetoAgence.controller;

import com.agence.global.projetoAgence.ApplicationContextLoad;
import com.agence.global.projetoAgence.dao.FuncionarioDAO;
import com.agence.global.projetoAgence.entidades.Funcionario;
import com.agence.global.projetoAgence.entidades.Usuario;
import com.agence.global.projetoAgence.repository.FuncionarioRepository;
import com.agence.global.projetoAgence.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.Optional;

@RestController
@RequestMapping(value = "/v1")
public class ServicosControlller {

    @Autowired
    private FuncionarioDAO funcionarioDAO;

    @PostMapping(value = "/funcionarios", produces = "application/json")
    public ResponseEntity<Funcionario> cadastrar(@RequestBody @Valid Funcionario funcionario) {
        try {

            if (funcionario != null) {

                funcionarioDAO.insertWithQuery(funcionario);

            }
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (RuntimeException e) {

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


    }
}
