package com.TIComoApp.TIComo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Data;

@Data
@Document(collection = "asistentes")
public class Asistente extends Usuario{
	
	@Id
	private String id;
	@NonNull
	private String telefono;
	
	//Constructor
	public Asistente(String nombre, String apellidos, String email, String password,
			String passwordDoble, boolean cuentaActiva, int intentos, String telefono) {
		super(nombre, apellidos, email, password,passwordDoble, cuentaActiva, intentos);
		this.telefono = telefono;
	}
	
	
	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Asistente [telefono=" + telefono + "]";
	}
	public boolean telefonoValido(String telefono) {
		//MANTENIMIENTO
		//Compruebo que sea un número con length válida
		if(telefono.length() != 9) 
				return false;
		
		//Compruebo que sea un número en el rango de los válidos para ESPAÑA
		if(telefono.charAt(0) != '6' && telefono.charAt(0) != '7' && 
				telefono.charAt(0) != '8' && telefono.charAt(0) != '9')
			return false;
		
		//Compruebo que sea un número real y no contenga letras
		for(int i = 0; i < telefono.length(); i++)
			if(!Character.isDigit(telefono.charAt(i)))
				return false;
		
		return true;
		
	}
	
}
