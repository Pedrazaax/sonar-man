package com.TIComoApp.TIComo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.TIComoApp.TIComo.model.Administrador;
import com.TIComoApp.TIComo.model.Asistente;
import com.TIComoApp.TIComo.services.AsistenteService;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
//MANTENIMIENTO
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
@JsonAutoDetect(getterVisibility=Visibility.ANY)
@CrossOrigin
@RestController
@RequestMapping("ticomo/asistente")
public class AsistenteController {
	
	@Autowired
	private AsistenteService asistenteService;
	
	
	
	
	@PostMapping("/register")
	public void create(@RequestBody Asistente asistente) throws Exception {
		//MANTENIMIENTO
		try {
			if(asistente.getNombre().equals("")||asistente.getApellidos().equals("") || asistente.getEmail().equals("")
					|| asistente.getTelefono().equals("")||asistente.getPassword().equals("")|| asistente.getPasswordDoble().equals(""))
				throw new Exception("Formulario vacío");
			
			
			asistenteService.create(asistente);
			
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@GetMapping("")
	public List<Asistente> index(){
		return asistenteService.findAll();
	}
	@DeleteMapping("/{email}")
	public void delete(@PathVariable String email) {
		Optional<Asistente> asistente = asistenteService.findByEmail(email);
		if(asistente.isPresent()) {
			asistenteService.delete(asistente.get());
		}
	}
}
