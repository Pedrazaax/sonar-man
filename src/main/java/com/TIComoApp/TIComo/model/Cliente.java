/*********************************************************************
 *
 * Class Name: Cliente
 * Author/s name: Ángel García Consuegra Trujillo, José Miguel Tercero Valero, Antonio Domínguez Martín, Roberto Ortuño Blanco y Javier Familiar Gijón
 * Release/Creation date:
 * Class version: ultima version(21/11/2022)
 * Class description: Esta clase servira para todo lo relativo a la creación de los clientes del sistema TIComo
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
@Document(collection = "clientes")
public class Cliente extends Usuario{
	
	@Id
	private String NIF;
	@NonNull
	private String direccionCompleta;
	@NonNull
	private String telefono;
	
	//Constructor
	public Cliente(String nombre, String apellidos, String email, String password, String passwordDoble,
			boolean cuentaActiva, int intentos, String NIF,String direccionCompleta, String telefono) {
		super(nombre, apellidos, email, password,passwordDoble, cuentaActiva, intentos);
		this.NIF = NIF;
		this.direccionCompleta = direccionCompleta;
		this.telefono = telefono;
	}
	
	//Getters, Setters y toString
	public String getNIF() {
		return NIF;
	}

	public void setNIF(String nIF) {
		NIF = nIF;
	}

	public String getDireccionCompleta() {
		return direccionCompleta;
	}

	public void setDireccionCompleta(String direccionCompleta) {
		this.direccionCompleta = direccionCompleta;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Cliente [NIF=" + NIF + ", direccionCompleta=" + direccionCompleta + ", telefono=" + telefono + "]";
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
	//MANTENIMIENTO
	public boolean comprobarNif(String nif2){
		
		//Compruebo que tiene 9 caracteres
		if(nif2.length() != 9) 
			return false;
		//Compruebo que hay dígitos hasta el último caracter
		for(int i = 0; i < nif2.length()-1; i++) {
			if(!Character.isDigit(nif2.charAt(i)))
				return false;
		}
		//Compruebo que el último caracter sea una letra
		if(!Character.isAlphabetic(nif2.charAt(nif2.length()-1)))
			return false;
		
		return true;
	}


	

	
	

}