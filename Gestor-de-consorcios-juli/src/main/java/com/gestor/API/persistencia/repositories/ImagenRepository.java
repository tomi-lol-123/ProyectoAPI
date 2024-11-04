package com.gestor.API.persistencia.repositories;

import com.gestor.API.models.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagenRepository extends JpaRepository<Imagen, Integer> {
}
