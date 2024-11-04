package com.gestor.API.controllers;

import com.gestor.API.DTOs.PersonaDTO;
import com.gestor.API.exceptions.EdificioException;
import com.gestor.API.exceptions.PersonaException;
import com.gestor.API.exceptions.UnidadException;
import com.gestor.API.services.Servicios;
import comands.AgregarPersonaCommand;
import comands.EliminarPersonaCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/persona")

public class PersonaController {
    Servicios servicios;

    public PersonaController(Servicios servicios) {
        this.servicios = servicios;
    }

    @GetMapping("/buscar_persona/{persona}")
    public ResponseEntity<PersonaDTO> getPersona(@PathVariable String persona) throws PersonaException {
        return ResponseEntity.status(HttpStatus.OK).body(servicios.buscarPersona(persona).toView());
    }

    @GetMapping("/habitado_por_edificio/{edificio}")
    public ResponseEntity<List<PersonaDTO>>getPersonasPorEdificio(@PathVariable int edificio) throws EdificioException {
        return ResponseEntity.status(HttpStatus.OK).body(servicios.habitadoPorEdificio(edificio));
    }

    @GetMapping("/duenios_por_edificio/{edificio}")
    public ResponseEntity<List<PersonaDTO>>getDueniosPorEdificio(@PathVariable int edificio) throws EdificioException {
        return ResponseEntity.status(HttpStatus.OK).body(servicios.dueniosPorEdificio(edificio));
    }

    @GetMapping("/habitantes_por_edificio/{edificio}")
    public ResponseEntity<List<PersonaDTO>>getHabitantesPorEdificio(@PathVariable int edificio) throws EdificioException {
        return ResponseEntity.status(HttpStatus.OK).body(servicios.habitantesPorEdificio(edificio));
    }

    @GetMapping("/duenios_por_unidad/{unidad}")
    public ResponseEntity<List<PersonaDTO>>getDueniosPorUnidad(@PathVariable int unidad) throws UnidadException{
        return ResponseEntity.status(HttpStatus.OK).body(servicios.dueniosPorUnidad(unidad));
    }

    @GetMapping("/inquilinos_por_unidad/{unidad}")
    public ResponseEntity<List<PersonaDTO>>getInquilinosPorUnidad(@PathVariable int unidad)throws UnidadException{
        return ResponseEntity.status(HttpStatus.OK).body(servicios.inquilinosPorUnidad(unidad));
    }

    //modifique agregarPersona haciendo que retorne una personaDTO
    @PostMapping("/agregar_persona")
    public ResponseEntity<PersonaDTO> agregarPersona(@RequestBody AgregarPersonaCommand requestBody){
        return ResponseEntity.status(HttpStatus.OK).body(servicios.agregarPersona(requestBody.getDocumento(), requestBody.getNombre()));
    }


    @DeleteMapping("/eliminar_persona/{persona}")
    public ResponseEntity<Void> deletePersona(@PathVariable String persona) throws PersonaException {
        servicios.eliminarPersona(persona);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}

