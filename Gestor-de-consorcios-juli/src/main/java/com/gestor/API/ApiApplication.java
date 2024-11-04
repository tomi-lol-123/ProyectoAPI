package com.gestor.API;

import com.gestor.API.DTOs.EdificioDTO;
import com.gestor.API.DTOs.PersonaDTO;
import com.gestor.API.models.Unidad;
import com.gestor.API.services.Servicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}
	
	@Autowired
	Servicios Servicios;

	@Override
	public void run(String... args) throws Exception {

		/*-------------------------------------------EDIFICIO-------------------------------------------*/


//		for (EdificioDTO edificioDTO : Servicios.getEdificios()){
//			System.out.println(edificioDTO.toString());
//		}

//		Servicios.agregarEdificio("prueba2", "losparaisos333");
//		System.out.println(Servicios.buscarEdificio(12));

//		Servicios.agregarUnidad("2","2",false,12);
//		Servicios.agregarUnidad("3","2",false,12);
//		System.out.println(Servicios.buscarUnidad(1592,"",""));

//		Servicios.agregarPersona("DNI1","Lucas Aguilera");
//		System.out.println(Servicios.buscarPersona("DNI1"));

//		Servicios.alquilarUnidad(1593,"","","DNI1");

//		Servicios.agregarInquilinoUnidad(1593,"","","DNI1");

//		Servicios.agregarReclamo("DNI0",11,"cocina",1592,"prueba","algo","nuevo");
//		System.out.println(Servicios.buscarReclamo(1));

//		Servicios.agregarImagenAReclamo(1,"petito.com","png");
//		System.out.println(Servicios.buscarImagen(1));

//		Servicios.borrarImagen(1);


		/*-------------------------------------------IMAGEN-------------------------------------------*/


		//Servicios.agregarImagenAReclamo(6,"petito.com","png");


		/*-------------------------------------------PERSONA-------------------------------------------*/


		/*Servicios.agregarPersona();*/

		/*Servicios.eliminarPersona();*/

//		for (PersonaDTO inquilinos : Servicios.inquilinosPorUnidad(1591)){
//			System.out.println(inquilinos.toString());
//		}

//		for (PersonaDTO duenios : Servicios.dueniosPorUnidad(9)){
//			System.out.println(duenios.toString());
//		}

//		for (PersonaDTO habitantes : Servicios.habitantesPorEdificio(9)){
//			System.out.println(habitantes.toString());
//		}

//		for (PersonaDTO duenios : Servicios.dueniosPorEdificio(9)){
//			System.out.println(duenios.toString());
//		}

//		for (PersonaDTO habitantes : Servicios.habitadoPorEdificio(1)){
//			System.out.println(habitantes.toString());
//		}
//
//		for (UnidadDTO unidades : Servicios.getUnidadesPorEdificio(1)){
//			System.out.println(unidades.toString());
//		}


		/*-------------------------------------------RECLAMO-------------------------------------------*/


//		Servicios.reclamosPorEdificio();
//		Servicios.reclamosPorUnidad();
//		Servicios.reclamosPorNumero();
//		Servicios.reclamosPorPersona();
//		Servicios.cambiarEstado(6, "terminado");


		/*-------------------------------------------UNIDAD-------------------------------------------*/


//		Servicios.transferirUnidad(1589, "", "", "DNI30444780");
//		Servicios.agregarDuenioUnidad(1590, "", "", "DNI30444780");
//		Servicios.alquilarUnidad(1589, "", "", "DNI30314545");
//		Servicios.agregarInquilinoUnidad(1589, "", "", "DNI30012288");
//		Servicios.liberarUnidad(1589, "", "");
		//Servicios.habitarUnidad(1590, "", "");

		//List<Unidad> unidades = new ArrayList<>();
		//unidades.add(Servicios.findUnidadesById(1589));
		//unidades.add(Servicios.findUnidadesById(1590));
		//unidades.add(Servicios.findUnidadesById(1591));
//
		//for (Unidad unidad : unidades) {
		//	System.out.println(unidad.toString());
		//}

	}



}
