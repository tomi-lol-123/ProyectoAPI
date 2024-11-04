package com.gestor.API.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ReclamoDTO {

	private int numero;
	@JsonProperty("usuario")
	private PersonaDTO usuario;
	@JsonProperty("edificio")

	private EdificioDTO edificio;
	private String ubicacion;
	private String descripcion;
	private String tipoDeReclamo;
	@JsonProperty("unidad")
	private UnidadDTO unidad;
	private String estado;
	private List<ImagenDTO> imagenes;

	public ReclamoDTO(PersonaDTO usuario, EdificioDTO edificio, String ubicacion, UnidadDTO unidad, String descripcion, String tipoDeReclamo, String estado, List<ImagenDTO> imagenes) {
		this.usuario = usuario;
		this.edificio = edificio;
		this.ubicacion = ubicacion;
		this.descripcion = descripcion;
		this.tipoDeReclamo = tipoDeReclamo;
		this.unidad = unidad;
		this.estado = estado;
		this.imagenes = imagenes;
	}
	public ReclamoDTO(PersonaDTO usuario, EdificioDTO edificio, String ubicacion, UnidadDTO unidad, String descripcion, String tipoDeReclamo, String estado) {
		this.usuario = usuario;
		this.edificio = edificio;
		this.ubicacion = ubicacion;
		this.descripcion = descripcion;
		this.tipoDeReclamo = tipoDeReclamo;
		this.unidad = unidad;
		this.estado = estado;
	}
	public ReclamoDTO(int numero,PersonaDTO usuario, EdificioDTO edificio, String ubicacion, UnidadDTO unidad, String descripcion, String tipoDeReclamo, String estado) {
		this.numero=numero;
		this.usuario = usuario;
		this.edificio = edificio;
		this.ubicacion = ubicacion;
		this.descripcion = descripcion;
		this.tipoDeReclamo = tipoDeReclamo;
		this.unidad = unidad;
		this.estado = estado;
	}



}
