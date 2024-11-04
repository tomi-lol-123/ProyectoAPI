package com.gestor.API.persistencia.DAOs;

import com.gestor.API.models.Persona;
import com.gestor.API.models.Reclamo;
import com.gestor.API.persistencia.repositories.ReclamoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReclamoDAO {

    private final ReclamoRepository reclamoRepository;

    // Constructor para inyección de dependencias
    public ReclamoDAO(ReclamoRepository reclamoRepository) {
        this.reclamoRepository = reclamoRepository;
    }

    // Retorna todos los reclamos
    public List<Reclamo> findAll() {
        return reclamoRepository.findAll();
    }

    // Busca un reclamo por ID
    public Optional<Reclamo> findById(int id) {
        return reclamoRepository.findById(id);
    }

    // Guarda o actualiza un reclamo
    public void save(Reclamo reclamo) {
        reclamoRepository.save(reclamo);
    }

    // Actualiza un reclamo, es redundante con save()
    public Reclamo update(Reclamo reclamo) {
        return reclamoRepository.save(reclamo);
    }

    public void deleteById(int id){
        reclamoRepository.deleteById(id);
    }
}
