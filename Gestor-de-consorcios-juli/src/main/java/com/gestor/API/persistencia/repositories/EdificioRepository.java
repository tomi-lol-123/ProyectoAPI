package com.gestor.API.persistencia.repositories;

import com.gestor.API.models.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EdificioRepository extends JpaRepository <Edificio, Integer> {
}
