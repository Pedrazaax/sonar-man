/*********************************************************************
 *
 * Class Name: EntregaController
 * Author/s name: Ángel García Consuegra Trujillo, José Miguel Tercero Valero, Antonio Domínguez Martín, Roberto Ortuño Blanco y Javier Familiar Gijón
 * Release/Creation date:
 * Class version: ultima version(21/11/2022)
 * Class description: Esta clase servira de controlador para todas las funciones posibles de la clase pedido en la base de datos
 *
 **********************************************************************
 */
package com.TIComoApp.TIComo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.TIComoApp.TIComo.model.Cliente;
import com.TIComoApp.TIComo.model.Entrega;
import com.TIComoApp.TIComo.model.Pedido;
import com.TIComoApp.TIComo.repository.PedidoRepository;
import com.TIComoApp.TIComo.services.PedidosService;
import com.mongodb.lang.NonNull;

@CrossOrigin
@RestController
@RequestMapping("ticomo/pedidos")


//MANTENIMIENTO
public class PedidoController {	
	
	@Autowired
	private PedidosService pedidosServ;
		
	
	
	/*
	* 
	*
	* Method name:obtenerPedidos
	* Description of the Method: se encarga de mostrar una lista de los distintos pedidos asignados a un cliente de la base de datos
	* Calling arguments: Un id de cliente(para buscarle en la base de datos)
	* Return value: List<Pedido>
	* Required Files: Tabla pedidos y de clientes de MongoDB
	*
	*/
	
	@PostMapping("/obtenerPedidosCliente")
	public List<Pedido> obtenerPedidos(@RequestBody String idCliente) {
		//MANTENIMIENTO
		try {
			if(idCliente.isEmpty())
				throw new Exception("Inicie sesión");
			return pedidosServ.findByidCliente(idCliente);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN,e.getMessage());
		}
		
		
	}
	
	/*
	* 
	*
	* Method name: create
	* Description of the Method: se encarga de introducir en la base de datos un pedido
	* Calling arguments: Una pedido
	* Return value: Una pedido
	* Required Files: Tabla pedidos de MongoDB
	*
	*
	*/
	
	@PostMapping("crearPedido")
	public
	Pedido create(@RequestBody Pedido pedido) {
		
		try {
			if(pedido.getNombrePlato().isEmpty() || pedido.getCantidadPlato() <= 0
					|| pedido.getPrecioPlato() <= 0)
					throw new Exception("Hay un error con el pedido");
			return pedidosServ.save(pedido);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN,e.getMessage());
		}
		
	}
	/*
	* 
	*
	* Method name: pedidoRealizado
	* Description of the Method: se se encarga de marcar un pedido en concreto como realizado, asigandolo a una entrega en concreto en la base de datos
	* Calling arguments: Un id (Para buscar el pedido en la base de datos) y una entrega (Para buscar la entrega en la base de datos)
	* Return value: Un pedido
	* Required Files: Tabla entregas y pedidos de MongoDB
	*
	*
	*/
	
	@PostMapping("pedidoRealizado")
	public
	Pedido pedidoRealizado(@RequestBody Map<String,String> mapita) throws Exception {
			//MANTENIMIENTO
			try {
				if(mapita.get("idPedido").isEmpty())
					throw new Exception("id no válido");
				
				String id = mapita.get("idPedido");
				mapita.remove("idPedido");
				Entrega e = new Entrega(mapita.get("idCliente"),mapita.get("nombreCliente")
						,mapita.get("apellidosCliente"),mapita.get("direccion"),mapita.get("telefonoCliente")
						,mapita.get("pedidosRealizados")
						,Double.parseDouble(mapita.get("precioTotal")),mapita.get("nombreRestaurante"));
				
				pedidosServ.checkMethod(e);
				return pedidosServ.pedidoRealizado(id,e);
			}catch(Exception e) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
			}
	}
	
	
	/*
	* 
	*
	* Method name: delete
	* Description of the Method: se encarga de eliminar un pedido en concreto en la base de datos
	* Calling arguments: Un id (Para buscar el pedido en la base de datos)
	* Return value: void
	* Required Files: Tabla pedidos de MongoDB
	*
	*
	*/
	@PostMapping("deletePedido")
	public
	void delete(@RequestBody String id) {
		
		
		try {
			if(id.isEmpty())
				throw new Exception("No se pudo borrar por ese id");
			
			pedidosServ.deletePedido(id);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
		
		

	}

	/*
	* MANTENIMIENTO
	*
	* Method name: modificarPedido
	* Este método se se encarga de actualizar un pedido.
	*
	*
	*/
	@PutMapping(value= "/actualizar")
	public void modificarPedido(@RequestBody Pedido pedido) {
	
		try {
			
			if(pedido.getNombrePlato().isEmpty() || pedido.getCantidadPlato() <= 0
					|| pedido.getPrecioPlato() <= 0)
					throw new Exception("Hay un error con el pedido");
			
			pedidosServ.modificarPedido(pedido);
			
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
		
	}
	
	@GetMapping(value="/{id}")
	public Pedido findByIdPedido(@PathVariable String id){
		try {
			return pedidosServ.findById(id);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

}