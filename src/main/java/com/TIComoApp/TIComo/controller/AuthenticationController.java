/*********************************************************************
 *
 * Class Name: AuthenticationController
 * Author/s name: Ángel García Consuegra Trujillo, José Miguel Tercero Valero, Antonio Domínguez Martín, Roberto Ortuño Blanco y Javier Familiar Gijón
 * Release/Creation date:
 * Class version: ultima version(21/11/2022)
 * Class description: Esta clase servira de controlador para las funciones de resgistrarse el cliente y loguearse el administrador, el cliente y el rider en la base de datos
 *
 **********************************************************************
 */


package com.TIComoApp.TIComo.controller;

import org.bson.json.JsonObject;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.TIComoApp.TIComo.model.Cliente;
//MANTENIMIENTO
@CrossOrigin
@RestController
@RequestMapping("ticomo/authentication")
public class AuthenticationController {
	
	@Autowired
	private com.TIComoApp.TIComo.services.AuthService authServ;
	
	/*
	* 
	*
	* Method name:create
	* Description of the Method: se encarga de realizar el registro del cliente en la base de datos
	* Calling arguments: un cliente(Es el que queremos introducir en la base de datos)
	* Return value: un cliente
	* Required Files: Tabla clientes de MongoDB
	*
	*
	*/
	@PostMapping("/register")
	public
	void create(@RequestBody Cliente cliente) throws Exception {
		//MANTENIMIENTO
		try {
			
			if(cliente.getNombre().equals("") || cliente.getApellidos().equals("") || cliente.getNIF().equals("")
					|| cliente.getEmail().equals("") || cliente.getDireccionCompleta().equals("") ||
					cliente.getPassword().equals("") || cliente.getTelefono().equals("") || cliente.getPasswordDoble().equals(""))
					throw new Exception("Formulario vacío");
			
			authServ.create(cliente);
			
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
			
	}

	/*
	* 
	*
	* Method name:loginUser
	* Description of the Method: se encarga de comprobar si el email y la contraseña introducidos pertenece a un administrador, un cliente o un rider de la base de datos
	* Calling arguments: dos strings, el email y la contraseña (Son el email y la contraseña que queremos comprobar en la base de datos)
	* Return value: un JsonObject
	* Required Files: Tabla clientes, administradores y riders de MongoDB
	*
	*
	*/
	
	@PostMapping("/login")
	public
	String loginUser(@RequestBody Cliente cliente) throws Exception {
		//MANTENIMIENTO
		
		try {
			
			if(cliente.getPassword().equals("") || cliente.getEmail().equals("") || !cliente.isCuentaActiva()
					|| cliente.getIntentos()<= 0)
					throw new Exception("Error login");
			
			JSONObject jso = authServ.loginUser(cliente);
			return jso.toString();
			
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}


	}
}