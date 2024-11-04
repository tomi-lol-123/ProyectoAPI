package com.gestor.API.models;

import com.gestor.API.DTOs.ImagenDTO;
import com.gestor.API.controllers.ReclamoController;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "imagenes")
public class Imagen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numero;

	@Column(name = "path")
	private String direccion;

	@Column(name = "tipo")
	private String tipo;

	@ManyToOne
	@JoinColumn(name = "idreclamo")
	private Reclamo reclamo;

	public Imagen(int numero, String direccion, String tipo, Reclamo reclamo) {
		this.numero = numero;
		this.direccion = direccion;
		this.tipo = tipo;
		this.reclamo = reclamo;
	}

	public Imagen(String direccion, String tipo, Reclamo reclamo) {
		this.direccion = direccion;
		this.tipo = tipo;
		this.reclamo = reclamo;
	}

	public Imagen(String direccion, String tipo) {
		this.direccion = direccion;
		this.tipo = tipo;
	}

	public Imagen() {
	}

  public ImagenDTO toView(){
		return new ImagenDTO(direccion,tipo);
  }

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Reclamo getReclamo() {
		return reclamo;
	}

	public void setReclamo(Reclamo reclamo) {
		this.reclamo = reclamo;
	}

	public void save(int numeroReclamo) {
		
	}


	@Override
	public String toString() {
		return " -> Numero:" + numero +
				", direccion: " + direccion +
				", tipo: " + tipo;
	}
}
