package com.gestor.API.controllers;

import com.gestor.API.DTOs.ImagenDTO;
import com.gestor.API.exceptions.ImagenException;
import com.gestor.API.models.Imagen;
import com.gestor.API.models.Reclamo;
import com.gestor.API.services.Servicios;
import comands.AgregarImagenReclamoCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/imagen")

public class ImagenController {

    //crear imagen, borrar imagen
    Servicios servicios;

    public ImagenController(Servicios servicios) {
        this.servicios = servicios;
    }


    @PostMapping("/agregar")
    public ResponseEntity<ImagenDTO> agregarImagen(@RequestBody AgregarImagenReclamoCommand requestbody) throws ImagenException{

        Imagen imagen = new Imagen(requestbody.getDireccion(), requestbody.getTipo());


        return ResponseEntity.status(HttpStatus.OK).body(servicios.saveImagen(imagen));
    }

    @GetMapping("/buscar_imagen/{imagen}")
    public ResponseEntity<ImagenDTO> getImagenById(@PathVariable int imagen) throws ImagenException {
        return ResponseEntity.status(HttpStatus.OK).body(servicios.buscarImagen(imagen).toView());

    }

    @DeleteMapping("/eliminar/{numeroImagen}")
    public ResponseEntity<Void>deleteImagen(@PathVariable int numeroImagen) throws ImagenException {
        servicios.eliminarImagen(numeroImagen);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }








}
