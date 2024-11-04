package com.gestor.API.models;

import com.gestor.API.DTOs.PersonaDTO;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "personas")
public class Persona {
	@Id
	@Column(name = "documento")
	private String documento;

	@Column(name = "nombre")
	private String nombre;

	@OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)

	private List<Reclamo> reclamo;

	public Persona() {
	}

	public Persona(String documento, String nombre) {
		this.documento = documento;
		this.nombre = nombre;
	}

	public String getDocumento() {
		return documento;
	}

	public String getNombre() {
		return nombre;
	}

	public List<Reclamo> getReclamo() {
		return reclamo;
	}

	public void setReclamo(List<Reclamo> reclamo) {
		this.reclamo = reclamo;
	}

	public PersonaDTO toView() {
		return new PersonaDTO(documento, nombre);
	}

	public void save() {
		
	}

	public void delete() {
		
	}

	@Override
	public String toString() {
		return 	" -> Documento: " + documento +
				", nombre: " + nombre;
	}
}
