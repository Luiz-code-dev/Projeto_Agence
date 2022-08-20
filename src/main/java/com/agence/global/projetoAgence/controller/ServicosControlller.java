package com.agence.global.projetoAgence.controller;

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
    private UsuarioRepository usuarioRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;


    @GetMapping(value = "{id}", produces = "application/json")
    public ResponseEntity<Usuario> init(@PathParam(value = "id") Long id){

        Optional<Usuario> usuario = usuarioRepository.findById(id);

        return new ResponseEntity<>(usuario.get(), HttpStatus.OK);



    }

    @PostMapping(value = "/funcionarios", produces = "application/json")
    public ResponseEntity<Funcionario> cadastrar(@RequestBody @Valid Funcionario funcionario) {
        try {

            if (funcionario.getNome() != null && !funcionario.getNome().isEmpty()) {
                funcionario = funcionarioRepository.findByUsername(funcionario.getNome());
            }
            if (funcionario.getMatricula() != null && funcionario.getMatricula() > 0) {
                funcionario = funcionarioRepository.findByMatricula(funcionario.getMatricula());
            }
            Funcionario funcionarioSalvo = funcionarioRepository.save(funcionario);

            return new ResponseEntity<Funcionario>(funcionarioSalvo, HttpStatus.OK);
        } catch (RuntimeException e) {

            return null;
        }


    }

}
