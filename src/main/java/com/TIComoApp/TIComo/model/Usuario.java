/*********************************************************************
 *
 * Class Name: Usuario
 * Author/s name: Ángel García Consuegra Trujillo, José Miguel Tercero Valero, Antonio Domínguez Martín, Roberto Ortuño Blanco y Javier Familiar Gijón
 * Release/Creation date:
 * Class version: ultima version(21/11/2022)
 * Class description: Esta clase servira para todo lo relativo a la creación de la clase padre usuario, de la que luego se crean las clases clientes, riders y administradores del sistema TIComo
 *
 **********************************************************************
 */

package com.TIComoApp.TIComo.model;




import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.data.annotation.Id;

import com.mongodb.lang.NonNull;


//Para crear la coleccion en Mongo
import lombok.Data;


@Data
public class Usuario {
	@NonNull
	private String nombre;
	@NonNull
	private String apellidos;
	@NonNull
	private String email;
	@NonNull
	private String password;
	@NonNull
	private String passwordDoble;
	@NonNull
	private boolean cuentaActiva = true;
	@NonNull
	private int intentos = 5;



	//Constructor
	public Usuario(String nombre, String apellidos, String email, String password,String passwordDoble,boolean cuentaActiva, int intentos) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.password = password;
		this.passwordDoble = passwordDoble;
		this.cuentaActiva = cuentaActiva;
		this.intentos = intentos;

	}
	public Usuario() {
		
	}

	//Getters, Setters y toString

	public int getIntentos() {
		return intentos;
	}
	public void setIntentos(int intentos) {
		this.intentos = intentos;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}


	//MANTENIMIENTO -->
	public String getPasswordDoble() {
		return passwordDoble;
	}
	public void setPasswordDoble(String passwordDoble) {
		this.passwordDoble = passwordDoble;
	}// <--
	
	public void setPassword(String password) {
		this.password = password;
	}
    public boolean isCuentaActiva() {
		return cuentaActiva;
	}
    public void setCuentaActiva(boolean cuentaActiva) {
		this.cuentaActiva = cuentaActiva;
		
		if(this.cuentaActiva) {
			this.intentos = 5;
		}else {
			this.intentos = 0;
		}
	}


	@Override
	public String toString() {
		return super.toString();
	}

	public boolean contraseniaSegura(String password) {
		boolean segura = false;
		char clave;
		int  contNumero = 0, contLetraMay = 0, contLetraMin=0;
		for (int i = 0; i < password.length(); i++) {
			clave = password.charAt(i);
			String passValue = String.valueOf(clave);
			if (passValue.matches("[A-Z]")) {
				contLetraMay++;
			} else if (passValue.matches("[a-z]")) {
				contLetraMin++;
			} else if (passValue.matches("[0-9]")) {
				contNumero++;
			}
		}
		if(contLetraMay>0 && contLetraMin>0 && contNumero>0 && password.length()>=8) {
			segura = true;
		}
		return segura;


	}
	
	
	
	public boolean formatoCorreoCorrecto(String email) {
		// Patrón para validar el email
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
 
        // El email a validar
 
        Matcher mather = pattern.matcher(email);
        
        if (mather.find() == true) {
            return true;
        } else {
            return false;
        }
    
    }
    

	
	
	
	
}