package com.gestor.API.persistencia.DAOs;

import com.gestor.API.models.Persona;
import com.gestor.API.persistencia.repositories.PersonaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PersonaDAO {
    PersonaRepository personaRepository;

    public PersonaDAO(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public Optional<Persona> findById(String id) {
        return personaRepository.findById(id);
    }

    public void save(Persona persona){
        personaRepository.save(persona);
    }

    public void deleteById(String id){
        personaRepository.deleteById(id);
    }
}

