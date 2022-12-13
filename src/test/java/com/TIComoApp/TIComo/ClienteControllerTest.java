package com.TIComoApp.TIComo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.TIComoApp.TIComo.controller.ClienteController;
import com.TIComoApp.TIComo.model.Cliente;
import com.TIComoApp.TIComo.repository.ClienteRepository;

@SpringBootTest
class ClienteControllerTest {

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ClienteController clientecontroller;

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	void testA() {
		Cliente res = new Cliente("Paco", "PEPE", "paco@gmail.com", "8Caracteres", "8Caracteres", true, 5,
				"12345678A", "Dirección", "666666666");
		Cliente res2 = new Cliente("Paco", "PEPE", "pac@gmail", "8Caracteres", "8Caracteres", true, 5,
				"12345678A", "Dirección", "666666666");
		Cliente res3 = new Cliente("Paco", "PEPE", "pac@gmail.com", "8aracteres", "8Caracteres", true, 5,
				"12345678A", "Dirección", "666666666");
		Cliente res4 = new Cliente("Paco", "PEPE", "pac@gmail.com", "8Caractere", "8Caractere", true, 5,
				"12345678A", "Dirección", "666666666");
		Cliente res5 = new Cliente("Paco", "PEPE", "pac@gmail.com", "8Caracteres", "8Caracteres", true, 5,
				"12345678", "Dirección", "666666666");
		Cliente res6 = new Cliente("Paco", "PEPE", "pac@gmail.com", "8Caracteres", "8Caracteres", true, 5,
				"12345678A", "Dirección", "166666666");

		clientecontroller.create(res);
		clientecontroller.create(res2);
		clientecontroller.create(res3);
		clientecontroller.create(res4);
		clientecontroller.create(res4);
		clientecontroller.create(res5);
		clientecontroller.create(res6);

	}

	@Test
	void testB() {
		Cliente res = new Cliente("Paco", "PEPE", "pacortdyiop@gmail.com", "8Caracteres", "8Caracteres", true, 5,
				"12345678A", "Dirección", "666666666");
		Cliente res2 = new Cliente("Paco", "PEPE", "pac@gmail", "8Caracteres", "8Caracteres", true, 5,
				"12345678A", "Dirección", "666666666");
		Cliente res3 = new Cliente("Paco", "PEPE", "pac@gmail.com", "8aracteres", "8Caracteres", true, 5,
				"12345678A", "Dirección", "666666666");
		Cliente res4 = new Cliente("Paco", "PEPE", "pac@gmail.com", "8Caractere", "8Caractere", true, 5,
				"12345678A", "Dirección", "666666666");
		Cliente res5 = new Cliente("Paco", "PEPE", "pac@gmail.com", "8Caracteres", "8Caracteres", true, 5,
				"12345678", "Dirección", "666666666");
		Cliente res6 = new Cliente("Paco", "PEPE", "pac@gmail.com", "8Caracteres", "8Caracteres", true, 5,
				"12345678A", "Dirección", "166666666");

		clientecontroller.update("1A", res3);

	}

	@Test
	void testD() {
		List<Cliente> list = clientecontroller.index();
		assertNotEquals(0, list.size());
	}

	@Test
	void testobtenerCliente() {

		assertNotEquals(null, clientecontroller.obtenerCliente("63624df247774a5c1af31a30"));

	}
}