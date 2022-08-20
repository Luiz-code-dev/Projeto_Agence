package com.agence.global.projetoAgence.controller;

import com.agence.global.projetoAgence.entidades.Usuario;
import com.agence.global.projetoAgence.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1")
public class ServicosControlller {

    @Autowired
    private UsuarioRepository usuarioRepository;


   /* @PostMapping(value = "/auth", produces = "application/json")
    public ResponseBody loginUsuario (){

        try {

        }catch (){

        }

    }*/

    @GetMapping(value = "{id}", produces = "application/json")
    public ResponseEntity<Usuario> init(@PathParam(value = "id") Long id){

        Optional<Usuario> usuario = usuarioRepository.findById(id);

        return new ResponseEntity<>(usuario.get(), HttpStatus.OK);



    }


}
