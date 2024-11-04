package com.gestor.API.persistencia.repositories;

import com.gestor.API.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, String> {
}
