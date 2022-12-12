package com.TIComoApp.TIComo.services;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TIComoApp.TIComo.model.Entrega;
import com.TIComoApp.TIComo.model.Pedido;
import com.TIComoApp.TIComo.repository.PedidoRepository;
@Service
public class PedidosService {
	//MANTENIMIENTO
	@Autowired
	private PedidoRepository pedidosRepo;

	public List<Pedido> findByidCliente(String id) throws Exception {
		List<Pedido> p = pedidosRepo.findByidCliente(id);
		
		if(p.isEmpty())
			throw new Exception("No hay pedidos para este usuario");
		
		return p;
	}

	public Pedido save(Pedido pedido) throws IllegalArgumentException, IllegalAccessException, Exception {
		
		this.checkMethod(pedido);
		
		return pedidosRepo.insert(pedido);
	}
	
	public void checkMethod(Entrega entrega) throws Exception {
		
		for (Field f : entrega.getClass().getDeclaredFields()) {			
			if (f.getName().equals("id")) {
		        continue;
		    }
			f.setAccessible(true);

			if(Objects.isNull(f.get(entrega)))
				throw new Exception("Error en la entrega");		
		}
	}
	
	public void checkMethod(Pedido pedido) throws Exception {
		
		for (Field f : pedido.getClass().getDeclaredFields()) {
			
			if (f.getName().equals("id")) {
		        continue;
		    }
			f.setAccessible(true);

			if(Objects.isNull(f.get(pedido)))
				throw new Exception("Error en el pedido");		
		}
	}

	public Pedido findById(String id) throws Exception {
		
		if(id.isEmpty())
			throw new Exception("Id Inválido");
		
		Optional<Pedido> p = pedidosRepo.findById(id);
		
		if(!p.isPresent())
			throw new Exception("No existe pedido para ese id");
		
		return p.get();
		
	}

	public Pedido pedidoRealizado(String id, Entrega entrega) throws IllegalArgumentException, IllegalAccessException, Exception {
		
		Pedido pedidoFromDB = this.findById(id);	
		pedidoFromDB.setPedidoRealizado(true);	
		pedidoFromDB.setIdEntrega(entrega.getId());
		return this.save(pedidoFromDB);
		
	}

	public void deletePedido(String id) throws Exception {
		
		Pedido p = this.findById(id);
		
		pedidosRepo.delete(p);
		
	}

	public void modificarPedido(Pedido pedido) throws Exception {
		
		Optional<Pedido> p = pedidosRepo.findById(pedido.getId());
		
		if(!p.isPresent())
			throw new Exception("Imposible modificar, no existe el pedido");
		
		pedidosRepo.save(pedido);
		
		
	}
}
