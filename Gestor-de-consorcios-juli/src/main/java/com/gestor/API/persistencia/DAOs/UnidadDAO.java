package com.gestor.API.persistencia.DAOs;

import com.gestor.API.models.Edificio;
import com.gestor.API.models.Unidad;
import com.gestor.API.persistencia.repositories.UnidadRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UnidadDAO {

    UnidadRepository unidadRepository;

    public UnidadDAO(UnidadRepository unidadRepository) {
        this.unidadRepository = unidadRepository;
    }

    public List<Unidad> findAll() {
        return unidadRepository.findAll();
    }

    public Optional<Unidad> findById(int id) {
        return unidadRepository.findById(id);
    }

    public void save(Unidad unidad) {
        unidadRepository.save(unidad);
    }

}
