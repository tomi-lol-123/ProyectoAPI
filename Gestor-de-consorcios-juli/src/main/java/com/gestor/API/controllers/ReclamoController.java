package com.gestor.API.controllers;

import com.gestor.API.DTOs.ReclamoDTO;
import com.gestor.API.exceptions.EdificioException;
import com.gestor.API.exceptions.PersonaException;
import com.gestor.API.exceptions.ReclamoException;
import com.gestor.API.exceptions.UnidadException;
import com.gestor.API.models.Persona;
import com.gestor.API.models.Reclamo;
import com.gestor.API.services.Servicios;
import comands.AgregarImagenReclamoCommand;
import comands.AgregarReclamoCommand;
import comands.CambiarEstadoCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/reclamo")

public class ReclamoController {
    Servicios servicios;

    public ReclamoController(Servicios servicios) {
        this.servicios = servicios;
    }

    @PostMapping("/agregar_reclamo")
    public ResponseEntity<ReclamoDTO> agregarReclamo(@RequestBody AgregarReclamoCommand requestbody) throws PersonaException, EdificioException, UnidadException {
        return ResponseEntity.status(HttpStatus.OK)
                .body(servicios.agregarReclamo(requestbody.getUsuarioCodigo(),requestbody.getEdificioCodigo(),requestbody.getUbicacion(),requestbody.getUnidadCodigo(),requestbody.getDescripcion(), requestbody.getTipoReclamo(), requestbody.getEstado()));
    }

    @GetMapping("/reclamos_por_edificio/{edificio}")
    public  ResponseEntity<List<ReclamoDTO>>reclamosPorEdificio(@PathVariable int edificio) throws EdificioException {
        return ResponseEntity.status(HttpStatus.OK).body(servicios.reclamosPorEdificio(edificio));
    }

    @GetMapping("/reclamos_por_unidad/{unidad}")
    public  ResponseEntity<List<ReclamoDTO>>reclamosPorUnidad(@PathVariable int unidad) throws UnidadException {
        return ResponseEntity.status(HttpStatus.OK).body(servicios.reclamosPorUnidad(unidad));
    }

    @GetMapping("/reclamos_por_id/{numero}")
    public  ResponseEntity<ReclamoDTO>reclamosPorId(@PathVariable int numero) throws ReclamoException {
        return ResponseEntity.status(HttpStatus.OK).body(servicios.buscarReclamo(numero).toView());
    }


    @GetMapping("/reclamos_por_persona/{persona}")
    public  ResponseEntity<List<ReclamoDTO>>reclamosPorPersona(@PathVariable String persona) throws PersonaException {
        return ResponseEntity.status(HttpStatus.OK).body(servicios.reclamosPorPersona(persona));
    }
    @PutMapping("/agregar_imagen_reclamo")
    public ResponseEntity<ReclamoDTO>addImagenAReclamo(@RequestBody AgregarImagenReclamoCommand requestBody) throws ReclamoException {
        servicios.agregarImagenAReclamo(requestBody.getNumero(), requestBody.getDireccion(), requestBody.getTipo());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/cambiar_estado")
    public ResponseEntity<ReclamoDTO>updateEstado(@RequestBody CambiarEstadoCommand requestBody) throws ReclamoException {
        servicios.cambiarEstado(requestBody.getNumero(),requestBody.getEstado());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/borrarReclamo/{numeroReclamo}")
    public ResponseEntity<Void>deleteReclamo(@PathVariable int numeroReclamo) throws ReclamoException {
        servicios.eliminarReclamo(numeroReclamo);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }




}
