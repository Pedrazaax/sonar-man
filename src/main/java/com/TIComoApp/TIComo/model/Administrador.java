/*********************************************************************
 *
 * Class Name: Administrador
 * Author/s name: Ángel García Consuegra Trujillo, José Miguel Tercero Valero, Antonio Domínguez Martín, Roberto Ortuño Blanco y Javier Familiar Gijón
 * Release/Creation date:
 * Class version: ultima version(21/11/2022)
 * Class description: Esta clase servira para todo lo relativo a la creación de los administradores del sistema TIComo
 *
 **********************************************************************
 */


package com.TIComoApp.TIComo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

//Para crear la coleccion en Mongo
import lombok.Data;

@Data
@Document(collection = "admins")
public class Administrador extends Usuario{
	
	@Id
	private String id;
	@NonNull
	private String zona;
	
	//Constructor
	public Administrador(String nombre, String apellidos,
			String email, String password,String passwordDoble,boolean cuentaActiva, int intentos, String zona) {
		super(nombre, apellidos, email, password,passwordDoble, cuentaActiva, intentos);
		this.zona = zona;
	}
	
	//Getters, Setters y toString
	
	
	public String getZona() {
		return zona;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	@Override
	public String toString() {
		return "Admin [zona=" + zona + "]";
	}
	
	

}
