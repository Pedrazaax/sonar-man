package com.TIComoApp.TIComo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;


import com.TIComoApp.TIComo.model.Asistente;
import com.TIComoApp.TIComo.model.Cliente;
import com.TIComoApp.TIComo.repository.AsistenteRepository;
import com.TIComoApp.TIComo.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;



@Service
public class AsistenteService {
	@Autowired
	private AsistenteRepository asistenteRepository;
	
	@Autowired
	private ClienteRepository clienteRepo;
	
	public List<Cliente> listarUsuarios() throws Exception {
        List<Cliente> lista = clienteRepo.findAll();
        if (lista.size() == 0) {
            throw new Exception("No hay usuarios en la base de datos.");
        } else {
            return lista;
        }
    }
	
	public void create(Asistente asistente) throws Exception {
		if(asistente.getNombre().equals("")||asistente.getApellidos().equals("") || asistente.getEmail().equals("")
				|| asistente.getTelefono().equals("")||asistente.getPassword().equals("")|| asistente.getPasswordDoble().equals(""))
			throw new Exception("Formulario vacío");
		
		if(!asistente.contraseniaSegura(asistente.getPassword()))
			throw new Exception("La contraseña debe tener al menos 8 caracteres, mayusculas, minusculas y al menos un número");
		
		if(!asistente.getPassword().equalsIgnoreCase(asistente.getPasswordDoble()))
			throw new Exception("Las contraseñas no coinciden");
		
		if(!asistente.formatoCorreoCorrecto(asistente.getEmail()))
			throw new Exception("El correo electronico no es valido");
		
		Optional<Asistente> compruebaSiExiste=asistenteRepository.findByEmail(asistente.getEmail());
		
		if(compruebaSiExiste.isPresent())
			throw new Exception("Este correo ya está registrado");
		
		if(!asistente.telefonoValido(asistente.getTelefono()))
			throw new Exception("El telefono no es valido");
		
		asistente.setPassword(BCrypt.hashpw(asistente.getPassword(), BCrypt.gensalt()));
		asistente.setPasswordDoble(asistente.getPassword());
		asistenteRepository.insert(asistente);
	}



	public List<Asistente> findAll() {
		
		return asistenteRepository.findAll();
	}



	public Optional<Asistente> findByEmail(String email) {
		return asistenteRepository.findByEmail(email);
	}



	public void delete(Asistente asistente) {
		asistenteRepository.delete(asistente);
		
	}
}
