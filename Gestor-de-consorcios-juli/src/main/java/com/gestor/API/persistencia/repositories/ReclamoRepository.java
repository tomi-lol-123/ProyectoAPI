package com.gestor.API.persistencia.repositories;

import com.gestor.API.models.Reclamo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReclamoRepository extends JpaRepository<Reclamo, Integer> {
}
