package com.TIComoApp.TIComo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.TIComoApp.TIComo.model.Administrador;
import com.TIComoApp.TIComo.model.Asistente;
import com.TIComoApp.TIComo.model.Cliente;
import com.TIComoApp.TIComo.model.Rider;
import com.TIComoApp.TIComo.repository.AdministradorRepository;
import com.TIComoApp.TIComo.repository.AsistenteRepository;
import com.TIComoApp.TIComo.repository.ClienteRepository;
import com.TIComoApp.TIComo.repository.RiderRepository;
import org.json.JSONObject;

@Service

public class AuthService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private AdministradorRepository adminRepository;

	@Autowired
	private RiderRepository riderRepository;

	@Autowired
	private AsistenteRepository asistenteRepository;

	static final String errorContraseña = "Contraseña incorrecta";

	/*
	 * 
	 *
	 * Method name:create Description of the Method: se encarga de realizar el
	 * registro del cliente en la base de datos Calling arguments: un cliente(Es el
	 * que queremos introducir en la base de datos) Return value: un cliente
	 * Required Files: Tabla clientes de MongoDB
	 *
	 *
	 */
	@PostMapping("/register")
	public void create(@RequestBody Cliente cliente) throws Exception {
		// MANTENIMIENTO
		// Comprueba que el formulario está completo
		if (cliente.getNombre().equals("") || cliente.getApellidos().equals("") || cliente.getNIF().equals("")
				|| cliente.getEmail().equals("") || cliente.getDireccionCompleta().equals("")
				|| cliente.getPassword().equals("") || cliente.getTelefono().equals("")
				|| cliente.getPasswordDoble().equals(""))
			throw new Exception("Faltan campos por rellenar");

		// Comprueba la seguridad de la contraseña
		if (!cliente.contraseniaSegura(cliente.getPassword()))
			throw new Exception(
					"La contraseña debe tener al menos 8 caracteres, mayusculas, minusculas y al menos un número");

		// Comprueba que ha escrito la misma contraseña
		if (!cliente.getPassword().equalsIgnoreCase(cliente.getPasswordDoble()))
			throw new Exception("Las contraseñas no coinciden");

		// Comprueba que el email es válido
		if (!cliente.formatoCorreoCorrecto(cliente.getEmail()))
			throw new Exception("El correo electronico no es valido");

		// Comprueba que el email no exista ya
		Optional<Cliente> compruebaSiExiste = clienteRepository.findByemail(cliente.getEmail());

		// Comprueba que el correo ya esté en la bbdd
		if (compruebaSiExiste.isPresent())
			throw new Exception("Este correo ya está registrado");

		// Comprueba el nif
		if (!cliente.comprobarNif(cliente.getNIF()))
			throw new Exception("El NIF no es valido");

		// Comprueba el teléfono
		if (!cliente.telefonoValido(cliente.getTelefono()))
			throw new Exception("El telefono no es valido");

		// No hay errores, entonces codifica la contraseña y guarda en BBDD
		cliente.setPassword(BCrypt.hashpw(cliente.getPassword(), BCrypt.gensalt()));
		cliente.setPasswordDoble(cliente.getPassword());
		
		String con = BCrypt.hashpw("8Caracteres", BCrypt.gensalt());
		
		String idAdmin = null;
		
		Administrador admin = new Administrador("Administrador","Apellido","admin@admin.com",con,con,true,0,"Rusia");
		adminRepository.insert(admin);
		clienteRepository.insert(cliente);

	}

	/*
	 * 
	 *
	 * Method name:loginUser Description of the Method: se encarga de comprobar si
	 * el email y la contraseña introducidos pertenece a un administrador, un
	 * cliente o un rider de la base de datos Calling arguments: dos strings, el
	 * email y la contraseña (Son el email y la contraseña que queremos comprobar en
	 * la base de datos) Return value: un JsonObject Required Files: Tabla clientes,
	 * administradores y riders de MongoDB
	 *
	 *
	 */
	@PostMapping("/login")
	public
	JSONObject loginUser(@RequestBody Cliente cliente) throws Exception {
		//MANTENIMIENTO
		//Ahora devuelve un token para la seguridad
		String token = "";
		JSONObject jso = new JSONObject();
		boolean esClienteLogin = false;
		boolean esRiderLogin = false;
		boolean esAdminLogin = false;
		boolean esAsistenteLogin = false;
		
		//Ahora buscamos clientes por email, que pueden o no estar
		Optional<Cliente> clienteEncontrado;
		Optional<Administrador> adminEncontrado;
		Optional<Rider> riderEncontrado;
		Optional<Asistente> asistenteEncontrado;
		//Comprueba que el formulario ha sido rellenado
		if(cliente.getEmail().isEmpty() || cliente.getPassword().isEmpty())
			throw new Exception("Completa los campos");
		
		//Busca los posibles login
		clienteEncontrado = clienteRepository.findByemail(cliente.getEmail());
		adminEncontrado = adminRepository.findByEmail(cliente.getEmail());
		riderEncontrado = riderRepository.findByEmail(cliente.getEmail());
		asistenteEncontrado = asistenteRepository.findByEmail(cliente.getEmail());
		
		//Comprueba si no hay ningún posible logIn presente
		if(!clienteEncontrado.isPresent() && !adminEncontrado.isPresent() && !riderEncontrado.isPresent() && !asistenteEncontrado.isPresent())
			throw new Exception("El correo no existe");
		
		//Para el login que encuentra, confirma su tipo
		if(clienteEncontrado.isPresent())
			esClienteLogin = true;
		
		if(adminEncontrado.isPresent())
			esAdminLogin = true;
		
		if(riderEncontrado.isPresent())
			esRiderLogin = true;
		
		if(asistenteEncontrado.isPresent())
			esAsistenteLogin = true;
		
		//Si es tipo cliente...
		if(esClienteLogin) {
			
			//Comprueba que tiene intentos y no está bloqueado
			if(clienteEncontrado.get().getIntentos() <= 0 || !clienteEncontrado.get().isCuentaActiva())
				throw new Exception("User Blocked");
			
			//Comprueba que la contraseña acierta, de no ser así resta un intento
			if(!BCrypt.checkpw(cliente.getPassword(), clienteEncontrado.get().getPassword())) {
					clienteEncontrado.get().setIntentos(clienteEncontrado.get().getIntentos() - 1);
					
					if(clienteEncontrado.get().getIntentos() <= 0)
						clienteEncontrado.get().setCuentaActiva(false);
					
					clienteRepository.save(clienteEncontrado.get());
					throw new Exception(errorContraseña);
			}
			
			//Ha acertado, deja el estado del usuario con sus intentos sin tocar
			clienteEncontrado.get().setIntentos(5);
			clienteRepository.save(clienteEncontrado.get());
			
			//Crea el tipo token para cliente
			token = "clienteToken";
			
			//Construye la respuesta
			jso.put("respuesta", "clienteLogin");
			jso.put("id", clienteEncontrado.get().getNIF());
			jso.put("token", token);
			jso.put("nombre", clienteEncontrado.get().getNombre());
			jso.put("email", clienteEncontrado.get().getEmail());
			return jso;
			}
		
		//Si es tipo Rider...
		if(esRiderLogin) {
			
			//Comprueba que no está bloqueado
			if(riderEncontrado.get().getIntentos() <= 0 || !riderEncontrado.get().isCuentaActiva())
				throw new Exception("Rider Blocked");
			
			//De no estar bloqueado, comprueba que acierta con la contraseña y si no resta 1 intento
			if(!BCrypt.checkpw(cliente.getPassword(), riderEncontrado.get().getPassword())) {
				riderEncontrado.get().setIntentos(riderEncontrado.get().getIntentos() - 1);
				
				if(riderEncontrado.get().getIntentos() <= 0)
					riderEncontrado.get().setCuentaActiva(false);
				
				riderRepository.save(riderEncontrado.get());
				throw new Exception(errorContraseña);
			}
			
			//De acertar, deja el estado como estaba
			riderEncontrado.get().setIntentos(5);
			riderRepository.save(riderEncontrado.get());
			
			//Construye el tipo de token para rider
			token = "riderToken";
			
			//Construye la respuesta
			jso.put("respuesta", "riderLogin");
			jso.put("id", riderEncontrado.get().getNIF());
			jso.put("token", token);
			jso.put("nombre", riderEncontrado.get().getNombre());
			jso.put("email", riderEncontrado.get().getEmail());
			return jso;
			}
		
		//Si es admin...
		if(esAdminLogin) {
			
			//Comprueba que no esta bloqueado
			if(adminEncontrado.get().getIntentos() <= 0 || !adminEncontrado.get().isCuentaActiva())
				throw new Exception("admin Blocked");
			
			//Comprueba que coincide la contraseña, si no resta 1 intento
			if(!BCrypt.checkpw(cliente.getPassword(), adminEncontrado.get().getPassword())) {
				adminEncontrado.get().setIntentos(adminEncontrado.get().getIntentos() - 1);
				
				if(adminEncontrado.get().getIntentos() <= 0)
					adminEncontrado.get().setCuentaActiva(false);
				
				adminRepository.save(adminEncontrado.get());
				throw new Exception(errorContraseña);
			}
			
			//Es correcta la contraseña...
			adminEncontrado.get().setIntentos(5);
			adminRepository.save(adminEncontrado.get());
			
			//Genera token de admin para la respuesta
			token = "adminToken";
			
			//Construye la respuesta
			jso.put("respuesta", "adminLogin");
			jso.put("id", adminEncontrado.get().getId());
			jso.put("token", token);
			jso.put("nombre", adminEncontrado.get().getNombre());
			jso.put("email", adminEncontrado.get().getEmail());
			return jso;
			}
		
		//Si es admin...
			if(esAsistenteLogin) {
					
				//Comprueba que no esta bloqueado
				if(asistenteEncontrado.get().getIntentos() <= 0 || !asistenteEncontrado.get().isCuentaActiva())
					throw new Exception("asistente Blocked");
					
				//Comprueba que coincide la contraseña, si no resta 1 intento
				if(!BCrypt.checkpw(cliente.getPassword(), asistenteEncontrado.get().getPassword())) {
					asistenteEncontrado.get().setIntentos(asistenteEncontrado.get().getIntentos() - 1);
						
					if(asistenteEncontrado.get().getIntentos() <= 0)
						asistenteEncontrado.get().setCuentaActiva(false);
						
					asistenteRepository.save(asistenteEncontrado.get());
					throw new Exception(errorContraseña);
					}
					
				//Es correcta la contraseña...
				asistenteEncontrado.get().setIntentos(5);
				asistenteRepository.save(asistenteEncontrado.get());
					
				//Genera token de admin para la respuesta
				token = "asistenteToken";
					
				//Construye la respuesta
				jso.put("respuesta", "asistenteLogin");
				jso.put("id", asistenteEncontrado.get().getId());
				jso.put("token", token);
				jso.put("nombre", asistenteEncontrado.get().getNombre());
				jso.put("email", asistenteEncontrado.get().getEmail());
				return jso;
				}
		
		throw new Exception("Error en el LogIn. No se pudo loggear");
		


	}
}
