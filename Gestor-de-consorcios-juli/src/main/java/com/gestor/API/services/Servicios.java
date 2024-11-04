package com.gestor.API.services;

import com.gestor.API.DTOs.*;
import com.gestor.API.exceptions.*;
import com.gestor.API.models.*;
import com.gestor.API.persistencia.DAOs.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class Servicios {

	EdificioDAO edificioDAO;
	UnidadDAO unidadDAO;
	PersonaDAO personaDAO;
	ImagenDAO imagenDAO;
	ReclamoDAO reclamoDAO;

	public Servicios(EdificioDAO edificioDAO,
					 UnidadDAO unidadDAO,
					 PersonaDAO personaDAO,
					 ImagenDAO imagenDAO,
					 ReclamoDAO reclamoDAO
	) {
		this.edificioDAO = edificioDAO;
		this.unidadDAO = unidadDAO;
		this.personaDAO = personaDAO;
		this.imagenDAO = imagenDAO;
		this.reclamoDAO = reclamoDAO;
	}

	public List<EdificioDTO> getEdificios(){
		List<EdificioDTO> edificiosDTOs = new ArrayList<>();
		List<Edificio> edificios = edificioDAO.findAll();

		for (Edificio edificio : edificios) {
			edificiosDTOs.add(edificio.toView());
		}

		return edificiosDTOs;
	}

	public List<UnidadDTO> getUnidadesPorEdificio(int id) throws EdificioException {
		List<UnidadDTO> resultado = new ArrayList<>();
		Edificio edificio = buscarEdificio(id);
		List<Unidad> unidades = edificio.getUnidades();

		for (Unidad unidad : unidades)
			resultado.add(unidad.toView());

		return resultado;
	}

	public List<PersonaDTO> habitadoPorEdificio(int id) throws EdificioException{
		List<PersonaDTO> resultado = new ArrayList<>();
		Edificio edificio = buscarEdificio(id);
		Set<Persona> habitado = edificio.habitado();

		for (Persona persona : habitado)
			resultado.add(persona.toView());

		return resultado;
	}

	public List<PersonaDTO> dueniosPorEdificio(int id) throws EdificioException{
		List<PersonaDTO> resultado = new ArrayList<>();
		Edificio edificio = buscarEdificio(id);
		Set<Persona> duenios = edificio.duenios();

		for(Persona persona : duenios)
			resultado.add(persona.toView());

		return resultado;
	}

	public List<PersonaDTO> habitantesPorEdificio(int id) throws EdificioException{
		List<PersonaDTO> resultado = new ArrayList<>();
		Edificio edificio = buscarEdificio(id);
		Set<Persona> habitantes = edificio.habitantes();

		for (Persona persona : habitantes)
			resultado.add(persona.toView());

		return resultado;
	}

	public List<PersonaDTO> dueniosPorUnidad(int codigo) throws UnidadException{
		List<PersonaDTO> resultado = new ArrayList<PersonaDTO>();
		Unidad unidad = buscarUnidad(codigo);
		List<Persona> duenios = unidad.getDuenios();

		for (Persona persona : duenios)
			resultado.add(persona.toView());

		return resultado;
	}

	public List<PersonaDTO> inquilinosPorUnidad(int codigo) throws UnidadException {
		List<PersonaDTO> resultado = new ArrayList<>();
		Unidad unidad = buscarUnidad(codigo);
		List<Persona> inquilinos = unidad.getInquilinos();

		for (Persona persona : inquilinos)
			resultado.add(persona.toView());

		return resultado;
	}

	public UnidadDTO transferirUnidad(int codigo, String documento) throws UnidadException, PersonaException {
		Unidad unidad = buscarUnidad(codigo);
		Persona persona = buscarPersona(documento);

		unidad.transferir(persona);
		unidadDAO.save(unidad);

		return unidad.toView();
	}

	public UnidadDTO agregarDuenioUnidad(int codigo, String documento) throws UnidadException, PersonaException {
		Unidad unidad = buscarUnidad(codigo);
		Persona persona = buscarPersona(documento);

		unidad.agregarDuenio(persona);
		unidadDAO.save(unidad);

		return unidad.toView();
	}

	public UnidadDTO alquilarUnidad(int codigo, String documento) throws UnidadException, PersonaException{
		Unidad unidad = buscarUnidad(codigo);
		Persona persona = buscarPersona(documento);

		unidad.alquilar(persona);
		unidadDAO.save(unidad);

		return unidad.toView();
	}

	public UnidadDTO agregarInquilinoUnidad(int codigo, String documento) throws UnidadException, PersonaException{
		Unidad unidad = buscarUnidad(codigo);
		Persona persona = buscarPersona(documento);

		unidad.agregarInquilino(persona);
		unidadDAO.save(unidad);

		return unidad.toView();
	}

	public UnidadDTO liberarUnidad(int codigo) throws UnidadException {
		Unidad unidad = buscarUnidad(codigo);

		unidad.liberar();
		unidadDAO.save(unidad);

		return unidad.toView();
	}

	public UnidadDTO habitarUnidad(int codigo) throws UnidadException {
		Unidad unidad = buscarUnidad(codigo);

		unidad.habitar();
		unidadDAO.save(unidad);

		return unidad.toView();
	}


	public PersonaDTO agregarPersona(String documento, String nombre) {
		Persona personaNueva=new Persona(documento,nombre);
		personaDAO.save(personaNueva);
		return personaNueva.toView();
	}

	public EdificioDTO agregarEdificio(String nombre, String direccion) {
		Edificio nuevoEdificio = new Edificio(nombre, direccion);
		edificioDAO.save(nuevoEdificio);

		return nuevoEdificio.toView();
	}

	public void agregarUnidad(String piso, String numero, boolean habitado, int codigoEdificio) {
		Optional<Edificio>  optionalEdificio = edificioDAO.findById(codigoEdificio);
		if (optionalEdificio.isPresent()) {
			unidadDAO.save(new Unidad(piso, numero, habitado, optionalEdificio.get()));
		}
	}

	public ReclamoDTO agregarReclamo(String usuarioCodigo, int edificioCodigo, String ubicacion, int unidadCodigo, String descripcion, String tipoReclamo, String estado) throws EdificioException, UnidadException, PersonaException {
		Persona persona = buscarPersona(usuarioCodigo);
		Edificio edificio = buscarEdificio(edificioCodigo);
		Unidad unidad = buscarUnidad(unidadCodigo);
		Reclamo nuevoReclamo= new Reclamo(persona, edificio, ubicacion, unidad, descripcion, tipoReclamo, estado);

		reclamoDAO.save(nuevoReclamo);
		return  nuevoReclamo.toView();
	}

	public void eliminarPersona(String documento) throws PersonaException {
		Optional<Persona> persona = personaDAO.findById(documento);
		if (persona.isPresent()) {
			personaDAO.deleteById(documento);
		}
	}

	public void eliminarReclamo(int numero) throws ReclamoException{
		Optional<Reclamo> reclamo = reclamoDAO.findById(numero);
		if (reclamo.isPresent()){
			reclamoDAO.deleteById(numero);
		}
	}

	public void eliminarImagen(int numero) throws ImagenException{
		Optional<Imagen> imagen = imagenDAO.findById(numero);
		if (imagen.isPresent()){
			imagenDAO.deleteById(numero);
		}

	}



	public List<ReclamoDTO> reclamosPorEdificio(int codigo) throws EdificioException {
		Edificio edificio = buscarEdificio(codigo);
		List<Reclamo> reclamos = edificio.getReclamo();
		return reclamos.stream()
				.map(Reclamo::toView)
				.collect(Collectors.toList());
	}

/*
	public List<Reclamo> reclamosPorUnidad(int codigo, String piso, String numero) throws UnidadException {
		Unidad unidad = buscarUnidad(codigo, piso, numero);
		return unidad.getReclamo();
	}
*/
public List<ReclamoDTO> reclamosPorUnidad(int unidad) throws UnidadException {
	Unidad unidadObj = buscarUnidad(unidad); // Método que busca la unidad
	List<Reclamo> reclamos = unidadObj.getReclamo();  // Obtén la lista de reclamos
	// Convertir la lista de Reclamos a ReclamoDTO
	return reclamos.stream()
			.map(Reclamo::toView)  // Convierte Reclamo a ReclamoDTO
			.collect(Collectors.toList());
}


	public List<ReclamoDTO> reclamosPorPersona(String documento) throws PersonaException {
		Persona persona = buscarPersona(documento);
		List<Reclamo> reclamos = persona.getReclamo();
		return reclamos.stream()
				.map(Reclamo::toView)
				.collect(Collectors.toList());
	}



	public void cambiarEstado(int numero,String estado) throws ReclamoException {
		Reclamo reclamo = buscarReclamo(numero);
		reclamo.cambiarEstado(estado);
		reclamoDAO.save(reclamo);
	}

	public Edificio buscarEdificio(int codigo) throws EdificioException {
		try {
			Optional<Edificio> edificioOptional = edificioDAO.findById(codigo);
			if (edificioOptional.isEmpty()) {
				throw new EdificioException("Unidad no encontrada");
			}
			return edificioOptional.get();
		}
		catch (Exception e) {
			throw new EdificioException("Error al buscar el edificio: " + e.getMessage());
		}
	}

	public Unidad buscarUnidad(int codigo) throws UnidadException {
		try {
			Optional<Unidad> unidadOptional = unidadDAO.findById(codigo);
			if (unidadOptional.isEmpty()) {
				throw new UnidadException("Unidad no encontrada");
			}
			return unidadOptional.get();
		}
		catch (Exception e) {
			throw new UnidadException("Error al buscar la unidad: " + e.getMessage());
		}
	}

	public Persona buscarPersona(String documento) throws PersonaException {
		try {
			Optional<Persona> personaOptional = personaDAO.findById(documento);
			if (personaOptional.isEmpty()) {
				throw new PersonaException("Unidad no encontrada");
			}
			return personaOptional.get();
		}
		catch (Exception e) {
			throw new PersonaException("Error al buscar la persona: " + e.getMessage());
		}
	}

	public Reclamo buscarReclamo(int numero) throws ReclamoException {
		try {
			Optional<Reclamo> reclamoOptional = reclamoDAO.findById(numero);
			if (reclamoOptional.isEmpty()) {
				throw new ReclamoException("Unidad no encontrada");
			}
			return reclamoOptional.get();
		}
		catch (Exception e) {
			throw new ReclamoException("Error al buscar el reclamo: " + e.getMessage());
		}
	}










	public void agregarImagenAReclamo(int id, String direccion, String tipo) throws ReclamoException {
		Reclamo reclamo = buscarReclamo(id);
		Imagen imagen = new Imagen(direccion, tipo, reclamo);
		saveImagen(imagen);
	}

	public ImagenDTO saveImagen(Imagen imagen) {
		imagenDAO.save(imagen);
		return imagen.toView();
	}




	public Imagen buscarImagen(int codigo) throws ImagenException {
		try {
			Optional<Imagen> imagenOptional = imagenDAO.findById(codigo);
			if (imagenOptional.isEmpty()) {
				throw new PersonaException("Imagen no encontrada");
			}
			return imagenOptional.get();
		}
		catch (Exception e) {
			throw new ImagenException("Error al buscar la imagen: " + e.getMessage());
		}
	}



	public void borrarImagen(int codigo){
		Optional<Imagen> imagenOptional = imagenDAO.findById(codigo);
		if (imagenOptional.isPresent()){
			imagenDAO.delete(imagenOptional.get());
		}
	}












	public Unidad findUnidadesById(int id) throws UnidadException {
		return buscarUnidad(id);
	}


}
