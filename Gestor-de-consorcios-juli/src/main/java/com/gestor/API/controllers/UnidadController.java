package com.gestor.API.controllers;

import com.gestor.API.DTOs.UnidadDTO;
import com.gestor.API.commands.TransferirUnidadCommand;
import com.gestor.API.models.Unidad;
import com.gestor.API.services.Servicios;
import com.gestor.API.services.TransferirUnidadRequest;
import com.gestor.API.exceptions.EdificioException;
import com.gestor.API.exceptions.PersonaException;
import com.gestor.API.exceptions.UnidadException;
import comands.HabitarUnidadCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/*
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
*/
import javax.lang.model.element.VariableElement;
import java.util.List;

@RestController
@RequestMapping("/unidad")

public class UnidadController {

    Servicios servicios;

    public UnidadController(Servicios servicios) {
        this.servicios = servicios;
    }

    @GetMapping("/unidades_por_edificio/{idEdificio}")
    public ResponseEntity<List<UnidadDTO>> unidadesPorEdificio(@PathVariable int idEdificio) throws EdificioException {
        return ResponseEntity.status(HttpStatus.OK)
                .body(servicios.getUnidadesPorEdificio(idEdificio));
    }

    @PutMapping("/transferir")
    public ResponseEntity<UnidadDTO> transferirUnidad(@RequestBody com.gestor.API.commands.TransferirUnidadCommand requestBody) throws UnidadException, PersonaException {
        return ResponseEntity.status(HttpStatus.OK)
                .body(servicios.transferirUnidad(requestBody.getCodigo(), requestBody.getDocumento()));
    }

    @PutMapping("/agregar_duenio")
    public ResponseEntity<UnidadDTO> agregarDuenioUnidad(@RequestBody com.gestor.API.commands.TransferirUnidadCommand requestBody) throws UnidadException, PersonaException {
        return ResponseEntity.status(HttpStatus.OK)
                .body(servicios.agregarDuenioUnidad(requestBody.getCodigo(), requestBody.getDocumento()));
    }

    @PutMapping("/alquilar_unidad")
    public ResponseEntity<UnidadDTO> alquilarUnidad(@RequestBody com.gestor.API.commands.TransferirUnidadCommand requestBody) throws UnidadException, PersonaException{
        return ResponseEntity.status(HttpStatus.OK)
                .body(servicios.alquilarUnidad(requestBody.getCodigo(), requestBody.getDocumento()));
    }


    @PutMapping("/agregar_inquilino")
    public ResponseEntity<UnidadDTO> agregarInquilinoUnidad(@RequestBody com.gestor.API.commands.TransferirUnidadCommand requestBody) throws UnidadException, PersonaException{
        return ResponseEntity.status(HttpStatus.OK)
                .body(servicios.agregarInquilinoUnidad(requestBody.getCodigo(), requestBody.getDocumento()));
    }


    @PutMapping("/liberar_unidad/{idUnidad}")
    public ResponseEntity<UnidadDTO> liberarUnidad(@PathVariable int idUnidad) throws UnidadException {
        return ResponseEntity.status(HttpStatus.OK)
                .body(servicios.liberarUnidad(idUnidad));
    }

    @PutMapping("/habitar_unidad/{idUnidad}")
    public ResponseEntity<UnidadDTO> habitarUnidad(@PathVariable int idUnidad) throws UnidadException {
        return ResponseEntity.status(HttpStatus.OK)
                .body(servicios.habitarUnidad(idUnidad));
    }

    @GetMapping("/buscar_unidad/{unidad}")
    public ResponseEntity<UnidadDTO> buscarUnidad(@PathVariable int unidad ) throws UnidadException {
        return ResponseEntity.status(HttpStatus.OK).body(servicios.buscarUnidad(unidad).toView2());
    }

}
