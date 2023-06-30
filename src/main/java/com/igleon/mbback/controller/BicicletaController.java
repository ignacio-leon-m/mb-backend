package com.igleon.mbback.controller;

import com.igleon.mbback.model.Bicicleta;
import com.igleon.mbback.repository.BicicletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ignac on 30-06-2023.
 */
@RestController
@RequestMapping("/api/v1/bicicletas")
public class BicicletaController {
    @Autowired
    private BicicletaRepository bicicletaRepository;

    @GetMapping
    public List<Bicicleta> getAllBicicletas() {
        return bicicletaRepository.findAll();
    }
}
