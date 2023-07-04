package com.igleon.mbback.controller;

import com.igleon.mbback.exception.ResourceNotFoundException;
import com.igleon.mbback.model.Bicicleta;
import com.igleon.mbback.repository.BicicletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ignac on 30-06-2023.
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/bicicletas")
public class BicicletaController {
    @Autowired
    private BicicletaRepository bicicletaRepository;

    @GetMapping
    public List<Bicicleta> getAllBicicletas() {
        return bicicletaRepository.findAll();
    }

    //Agregar bicicleta
    @PostMapping
    public Bicicleta createBicicleta(@RequestBody Bicicleta bicicleta) {
        return bicicletaRepository.save(bicicleta);
    }

    //Buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<Bicicleta> getBicicletaById(@PathVariable Long id){
        Bicicleta bicicleta = bicicletaRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No existe bicicleta con id: " + id)
        );
        return ResponseEntity.ok(bicicleta); //devuelve un codigo 200 de forma implicita
    }

    //update bicicleta
    @PostMapping("{id}")
    public ResponseEntity<Bicicleta> updateBicicleta(@PathVariable Long id, @RequestBody Bicicleta bicicletaDetails){
        Bicicleta updateBicicleta = bicicletaRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No existe bicicleta con id: " + id)
        );
        updateBicicleta.setMarca(bicicletaDetails.getMarca());
        updateBicicleta.setModelo(bicicletaDetails.getModelo());
        updateBicicleta.setAro(bicicletaDetails.getAro());
        updateBicicleta.setTipo(bicicletaDetails.getTipo());
        updateBicicleta.setColor(bicicletaDetails.getColor());
        updateBicicleta.setEstado(bicicletaDetails.getEstado());
        updateBicicleta.setPrecioArr(bicicletaDetails.getPrecioArr());
        bicicletaRepository.save(updateBicicleta);
        return ResponseEntity.ok(updateBicicleta);
    }

    //delete bicicleta by id
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteBicicleta(@PathVariable Long id){
        Bicicleta bicicleta = bicicletaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe bicicleta con id: " + id));
        bicicletaRepository.delete(bicicleta);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    };
}
