package com.gestor.API.controllers;

import com.gestor.API.DTOs.EdificioDTO;
import com.gestor.API.exceptions.EdificioException;
import com.gestor.API.services.Servicios;
import comands.AgregarEdificioComand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/edificio")

public class EdificioController {

    Servicios servicios;

    public EdificioController(Servicios servicios) {
        this.servicios = servicios;
    }

    @GetMapping("/edificios")
    public ResponseEntity<List<EdificioDTO>> getAllEdificios(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(servicios.getEdificios());
    }


   @GetMapping("/buscar_edificio/{edificio}")
    public ResponseEntity<EdificioDTO> getEdificioById(@PathVariable int edificio) throws EdificioException {
       return ResponseEntity.status(HttpStatus.OK).body(servicios.buscarEdificio(edificio).toView());
   }
    //modifique agregarEdificio haciendo que retorne un edificioDto
   @PostMapping("/agregar_edificio")
    public ResponseEntity<EdificioDTO> agregarEdificio(@RequestBody AgregarEdificioComand requestBody){
        return ResponseEntity.status(HttpStatus.OK).body(servicios.agregarEdificio(requestBody.getNombre(), requestBody.getDireccion()));


    }

}
