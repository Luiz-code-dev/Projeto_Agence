package com.agence.global.projetoAgence.controller;

import com.agence.global.projetoAgence.ApplicationContextLoad;
import com.agence.global.projetoAgence.dao.CarroDAO;
import com.agence.global.projetoAgence.dao.FuncionarioDAO;
import com.agence.global.projetoAgence.entidades.Carro;
import com.agence.global.projetoAgence.entidades.Funcionario;
import com.agence.global.projetoAgence.repository.FuncionarioRepository;
import com.agence.global.projetoAgence.service.CarroService;
import com.agence.global.projetoAgence.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(value = "/v1")
public class ServicosControlller {

    @Autowired
    private FuncionarioDAO funcionarioDAO;

    @Autowired
    private FuncionarioService funcionarioService;
    @Autowired
    private CarroDAO carroDAO;

    @Autowired
    private CarroService carroService;


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

    @DeleteMapping(value = "/funcionarios/{idFuncionario}")
    public ResponseEntity<String> delete(@PathVariable Long idFuncionario){

        funcionarioService.deleteById(idFuncionario.intValue());

        return new ResponseEntity<String>("Funcionario deletado com sucesao", HttpStatus.OK);
    }


    @GetMapping(value = "/funcionarios", produces = "application/json")
    public ResponseEntity<List<Funcionario>> funcioraios () {
        try {
        List<Funcionario> list = (List<Funcionario>) ApplicationContextLoad.getApplicationContext()
                .getBean(FuncionarioRepository.class).findAll();

            return new ResponseEntity<List<Funcionario>>(list, HttpStatus.OK);

        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping(value = "/carros", produces = "application/json")
    public ResponseEntity<Carro> cadastrarCarros(@RequestBody @Valid Carro  carro ) {
        try {
            if (carro != null) {
                carroDAO.insertWithQuery(carro);
            }
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

     @DeleteMapping(value = "/carros/{idCarro}")
    public ResponseEntity<String> deleteCarros(@PathVariable Long idCarro){

        carroService.deleteById(idCarro.intValue());

        return new ResponseEntity<String>("Carro deletado com sucesao", HttpStatus.OK);
    }
}
