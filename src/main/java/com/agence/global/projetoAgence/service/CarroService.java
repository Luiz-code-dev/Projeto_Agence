package com.agence.global.projetoAgence.service;

import com.agence.global.projetoAgence.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public void deleteById(Integer id) {
        if (carroRepository.existsById(id)) {
            carroRepository.deleteById(id);
        }
    }
}
