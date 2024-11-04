package com.gestor.API.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.gestor.API.DTOs.EdificioDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "edificios")
public class Edificio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "direccion")
	private String direccion;

	@OneToMany(mappedBy = "edificio", fetch = FetchType.EAGER)

	private List<Reclamo> reclamo;

	@OneToMany(mappedBy = "edificio", fetch = FetchType.EAGER)
	private List<Unidad> unidades;

	public Edificio() {}

	public Edificio(int codigo, String nombre, String direccion) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.direccion = direccion;
		unidades = new ArrayList<Unidad>();
	}

	public Edificio(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
	}

	public void agregarUnidad(Unidad unidad) {
		unidades.add(unidad);
	}
	
	public Set<Persona> habitado(){
		Set<Persona> habitado = new HashSet<Persona>();
		for(Unidad unidad : unidades) {
			List<Persona> duenios = unidad.getDuenios();
			for(Persona p : duenios)
				habitado.add(p);
			List<Persona> inquilinos = unidad.getInquilinos();
			for(Persona p : inquilinos)
				habitado.add(p);
		}
		return habitado;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public List<Unidad> getUnidades() {
		return unidades;
	}

	public List<Reclamo> getReclamo() {
		return reclamo;
	}

	public void setReclamo(List<Reclamo> reclamo) {
		this.reclamo = reclamo;
	}

	public Set<Persona> duenios() {
		Set<Persona> resultado = new HashSet<Persona>();
		for(Unidad unidad : unidades) {
			List<Persona> duenios = unidad.getDuenios();
			for(Persona p : duenios)
				resultado.add(p);
		}
		return resultado;
	}

	public Set<Persona> habitantes() {
		Set<Persona> resultado = new HashSet<Persona>();
		for(Unidad unidad : unidades) {
			if(unidad.estaHabitado()) {
				List<Persona> inquilinos = unidad.getInquilinos();
				if(inquilinos.size() > 0) 
					for(Persona p : inquilinos)
						resultado.add(p);
				else {
					List<Persona> duenios = unidad.getDuenios();
					for(Persona p : duenios)
						resultado.add(p);
				}
			}
		}
		return resultado;
	}
	public EdificioDTO toView() {
		return new EdificioDTO(codigo, nombre, direccion);
	}


	@Override
	public String toString() {
		return " -> Codigo: " + codigo +
				", nombre: " + nombre +
				", direccion: " + direccion +
				", reclamo: " + reclamo +
				", unidades: " + unidades;
	}
}
