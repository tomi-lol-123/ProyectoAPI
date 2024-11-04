package com.gestor.API.models;
/*
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
*/
import com.gestor.API.DTOs.EdificioDTO;
import com.gestor.API.DTOs.PersonaDTO;
import com.gestor.API.DTOs.UnidadDTO;
import com.gestor.API.exceptions.UnidadException;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "unidades")
//@JsonIgnoreProperties({"edificio", "reclamo", "duenios", "inquilinos"})
public class Unidad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int identificador;

	@Column(name = "piso")
	private String piso;

	@Column(name = "numero")
	private String numero;

	@Column(name = "habitado")
	private boolean habitado;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "codigoedificio")
	private Edificio edificio;

	@OneToMany(mappedBy = "unidad", fetch = FetchType.EAGER)

	private List<Reclamo> reclamo;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "duenios",
			joinColumns = @JoinColumn(name = "identificador"),
			inverseJoinColumns = @JoinColumn(name = "documento")
	)
	private List<Persona> duenios;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "inquilinos",
			joinColumns = @JoinColumn(name = "identificador"),
			inverseJoinColumns = @JoinColumn(name = "documento")
	)
	private List<Persona> inquilinos;

	public Unidad() {
	}

	public Unidad(int id, String piso, String numero, Edificio edificio) {
		this.identificador = id;
		this.piso = piso;
		this.numero = numero;
		this.habitado = false;
		this.edificio = edificio;
		this.duenios = new ArrayList<Persona>();
		this.inquilinos = new ArrayList<Persona>();
	}

	public Unidad(String piso, String numero, boolean habitado, Edificio edificio) {
		this.piso = piso;
		this.numero = numero;
		this.habitado = habitado;
		this.edificio = edificio;
	}

	public void transferir(Persona nuevoDuenio) {
		duenios = new ArrayList<Persona>();
		duenios.add(nuevoDuenio);
	}

	public void agregarDuenio(Persona duenio) {
		duenios.add(duenio);
	}

	public void alquilar(Persona inquilino) throws UnidadException {
		if(!this.habitado) {
			this.habitado = true;
			inquilinos = new ArrayList<Persona>();
			inquilinos.add(inquilino);
		}
		else
			throw new UnidadException("La unidad esta ocupada");
	}

	public void agregarInquilino(Persona inquilino) {
		inquilinos.add(inquilino);
	}

	public boolean estaHabitado() {
		return habitado;
	}

	public void liberar() {
		this.inquilinos = new ArrayList<Persona>();
		this.habitado = false;
	}

	public void habitar() throws UnidadException {
		if(this.habitado)
			throw new UnidadException("La unidad ya esta habitada");
		else
			this.habitado = true;
	}

	public List<Reclamo> getReclamo() {
		return reclamo;
	}

	public void setReclamo(List<Reclamo> reclamo) {
		this.reclamo = reclamo;
	}

	public int getId() {
		return identificador;
	}

	public String getPiso() {
		return piso;
	}

	public String getNumero() {
		return numero;
	}

	public Edificio getEdificio() {
		return edificio;
	}

	public List<Persona> getDuenios() {
		return duenios;
	}

	public List<Persona> getInquilinos() {
		return inquilinos;
	}

	public UnidadDTO toView() {
		EdificioDTO auxEdificio = edificio.toView();
		return new UnidadDTO(identificador, piso, numero, habitado, auxEdificio);
	}




	public UnidadDTO toView2() {
		EdificioDTO auxEdificio = edificio.toView();
		List<PersonaDTO> auxDuenios = duenios.stream()
				.map(Persona::toView)
				.collect(Collectors.toList());
		List<PersonaDTO> auxInquilinos = inquilinos.stream()
				.map(Persona::toView)
				.collect(Collectors.toList());

		return new UnidadDTO(identificador, piso, numero, habitado, auxEdificio,auxDuenios,auxInquilinos);
	}


	@Override
	public String toString() {
		return " -> Identificador:" + identificador +
				", piso: " + piso +
				", numero: " + numero +
				", habitado: " + habitado +
				", edificio: " + edificio.getCodigo() +
				", duenios: " + duenios +
				", inquilinos: " + inquilinos;
	}
}
