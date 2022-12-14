package com.TIComoApp.TIComo;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.List;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.TIComoApp.TIComo.controller.AsistenteController;
import com.TIComoApp.TIComo.controller.PedidoController;
import com.TIComoApp.TIComo.model.Asistente;
import com.TIComoApp.TIComo.model.Cliente;
import com.TIComoApp.TIComo.model.Pedido;
import com.TIComoApp.TIComo.repository.AsistenteRepository;

@SpringBootTest
class AsistenteControllerTest {

	@Autowired
	private AsistenteRepository asistenteRepo;
	@Autowired
	private AsistenteController asistenteController;
	@Autowired
	private PedidoController pedidoController;
	


	@Test
	void testCrearAsistente() throws Exception {
		Asistente res = new Asistente("Prueba", "Prueba", "Prueba@Pruebas.es", "8Caracteres", "8Caracteres", true, 5,
				"678124548");

		Asistente res2 = new Asistente("Prueba", "Prueba", "Prueba@Pruebag.es", "8Caracteres", "8Caracteres", true, 5,
				"678124549");

		Asistente res3 = new Asistente("Prueba", "Prueba", "Prueba@Pruebaq.es", "8Caracteres", "8Caracteres", true, 5,
				"678124540");

		Asistente res4 = new Asistente("Prueba", "Prueba", "Prueba@Pruebah.es", "8Caracteres", "8Caracteres", true, 5,
				"678124541");
		asistenteController.create(res);
		asistenteController.create(res2);
		asistenteController.create(res3);
		asistenteController.create(res4);

		asistenteRepo.delete(res);
		asistenteRepo.delete(res2);
		asistenteRepo.delete(res3);
		asistenteRepo.delete(res4);
	}

	@Test
	void testDeleteAsistente() throws Exception {
		Asistente res = new Asistente("Prueba", "Prueba", "Prueba@Pruebas.es", "8Caracteres", "8Caracteres", true, 5,
				"678124548");
		asistenteController.create(res);
		asistenteController.delete("Prueba@Pruebas.es");
	}

	@Test
	void testCrearPedido() {
		asistenteController.crearPedido(new Pedido("125", "Atascaburras", 5, 2, "", ""));
		pedidoController.delete("125");

	}
	
	@Test
	void testModificarPedido() {
		asistenteController.crearPedido(new Pedido("125", "Atascaburras", 5, 2, "", ""));
		asistenteController.modificarPedido(new Pedido("125", "Atascaburras", 5, 2, "", ""));
		asistenteController.eliminarPedido(new Pedido("125", "Atascaburras", 5, 2, "", ""));
	}
	
	@Test
	void testEliminarPedido() {
		asistenteController.crearPedido(new Pedido("125", "Atascaburras", 5, 2, "", ""));
		asistenteController.eliminarPedido(new Pedido("125", "Atascaburras", 5, 2, "", ""));

	}
	
	@Test
	void testListarUsuarios() throws Exception {
		ArrayList <Cliente> lista = new ArrayList<Cliente>();
		lista = (ArrayList<Cliente>) asistenteController.listarUsuarios();
		assertNotNull(lista);

	}

	@Test
	void testListarPedidos() {
		ArrayList <Pedido> lista = new ArrayList<Pedido>();
		try {
		lista = (ArrayList<Pedido>) asistenteController.listarPedidosParaCliente("638b485141e3fe47b7ad07c5");
		}catch(Exception e) {
			assertEquals(lista.size(),0);
		}
		
	}

}
