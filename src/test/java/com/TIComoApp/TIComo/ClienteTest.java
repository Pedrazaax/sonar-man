package com.TIComoApp.TIComo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.TIComoApp.TIComo.model.Administrador;
import com.TIComoApp.TIComo.model.Cliente;

 class ClienteTest {
	@Test
	void testCliente() {
		Cliente ejemplo = new Cliente("Paco", "Corral", "FCorral@gmail.com", "8Caracteres", "8Caracteres", true, 5,
				"12345678A", "Dirección", "666666666");
		Cliente ejemplo2 = new Cliente("Paco", "Corral", "FCorral@gmail.com", "8Caracteres", "8Caracteres", true, 5,
				"12345678A", "Dirección", "666666666");
		assertEquals(ejemplo.getNombre(),ejemplo2.getNombre());
		assertEquals(ejemplo.getApellidos(),ejemplo2.getApellidos());
		assertEquals(ejemplo.getEmail(),ejemplo2.getEmail());
		assertEquals(ejemplo.getPassword(),ejemplo2.getPassword());
		assertEquals(ejemplo.getNIF(),ejemplo2.getNIF());
		assertEquals(ejemplo.getDireccionCompleta(),ejemplo2.getDireccionCompleta());
		assertEquals(ejemplo.getTelefono(),ejemplo2.getTelefono());	
	}

	@Test
	void testGetNIFCliente() {
		Cliente ejemplo = new Cliente("Paco", "Corral", "FCorral@gmail.com", "8Caracteres", "8Caracteres", true, 5,
				"12345678A", "Dirección", "666666666");
		Cliente ejemplo2 = new Cliente("Paco", "Corral", "FCorral@gmail.com", "8Caracteres", "8Caracteres", true, 5,
				"12345678A", "Dirección", "666666666");
		assertEquals(ejemplo.getNIF(),ejemplo2.getNIF());
	}

	@Test
	void testSetNIFCliente() {
		Cliente ejemplo = new Cliente("Paco", "Corral", "FCorral@gmail.com", "8Caracteres", "8Caracteres", true, 5,
				"12345678A", "Dirección", "666666666");
		Cliente ejemplo2 = new Cliente("Paco", "Corral", "FCorral@gmail.com", "8Caracteres", "8Caracteres", true, 5,
				"12345678A", "Dirección", "666666666");
		ejemplo.setNIF("98215238B");
		ejemplo2.setNIF("98215238B");
		assertEquals(ejemplo.getNIF(),ejemplo2.getNIF());
	}

	@Test
	void testGetDireccionCompletaCliente() {
		Cliente ejemplo = new Cliente("Paco", "Corral", "FCorral@gmail.com", "8Caracteres", "8Caracteres", true, 5,
				"12345678A", "Dirección", "666666666");
		Cliente ejemplo2 = new Cliente("Paco", "Corral", "FCorral@gmail.com", "8Caracteres", "8Caracteres", true, 5,
				"12345678A", "Dirección", "666666666");
		assertEquals(ejemplo.getDireccionCompleta(),ejemplo2.getDireccionCompleta());
	}

	@Test
	void testSetDireccionCompletaCliente() {
		Cliente ejemplo = new Cliente("Paco", "Corral", "FCorral@gmail.com", "8Caracteres", "8Caracteres", true, 5,
				"12345678A", "Dirección", "666666666");
		Cliente ejemplo2 = new Cliente("Paco", "Corral", "FCorral@gmail.com", "8Caracteres", "8Caracteres", true, 5,
				"12345678A", "Dirección", "666666666");
		ejemplo.setDireccionCompleta("Juan Avila 12");
		ejemplo2.setDireccionCompleta("Juan Avila 12");
		assertEquals(ejemplo.getDireccionCompleta(),ejemplo2.getDireccionCompleta());
	}

	@Test
	void testGetTelefonoCliente() {
		Cliente ejemplo = new Cliente("Paco", "Corral", "FCorral@gmail.com", "8Caracteres", "8Caracteres", true, 5,
				"12345678A", "Dirección", "666666666");
		Cliente ejemplo2 = new Cliente("Paco", "Corral", "FCorral@gmail.com", "8Caracteres", "8Caracteres", true, 5,
				"12345678A", "Dirección", "666666666");
		assertEquals(ejemplo.getTelefono(),ejemplo2.getTelefono());
	}

	@Test
	void testSetTelefonoCliente() {
		Cliente ejemplo = new Cliente("Paco", "Corral", "FCorral@gmail.com", "8Caracteres", "8Caracteres", true, 5,
				"12345678A", "Dirección", "666666666");
		Cliente ejemplo2 = new Cliente("Paco", "Corral", "FCorral@gmail.com", "8Caracteres", "8Caracteres", true, 5,
				"12345678A", "Dirección", "666666666");
		ejemplo.setTelefono("817291863");
		ejemplo2.setTelefono("817291863");
		assertEquals(ejemplo.getTelefono(),ejemplo2.getTelefono());
	}

	@Test
	void testGetNombreCliente() {
		Cliente ejemplo = new Cliente("Paco", "Corral", "FCorral@gmail.com", "8Caracteres", "8Caracteres", true, 5,
				"12345678A", "Dirección", "666666666");
		Cliente ejemplo2 = new Cliente("Paco", "Corral", "FCorral@gmail.com", "8Caracteres", "8Caracteres", true, 5,
				"12345678A", "Dirección", "666666666");
		assertEquals(ejemplo.getNombre(),ejemplo2.getNombre());
	}

	@Test
	void testSetNombreCliente() {
		Cliente ejemplo = new Cliente("Paco", "Corral", "FCorral@gmail.com", "8Caracteres", "8Caracteres", true, 5,
				"12345678A", "Dirección", "666666666");
		Cliente ejemplo2 = new Cliente("Paco", "Corral", "FCorral@gmail.com", "8Caracteres", "8Caracteres", true, 5,
				"12345678A", "Dirección", "666666666");
		ejemplo.setNombre("Leandro");
		ejemplo2.setNombre("Leandro");
		assertEquals(ejemplo.getNombre(),ejemplo2.getNombre());
	}

	@Test
	void testGetApellidosCliente() {
		Cliente ejemplo = new Cliente("Paco", "Corral", "FCorral@gmail.com", "8Caracteres", "8Caracteres", true, 5,
				"12345678A", "Dirección", "666666666");
		Cliente ejemplo2 = new Cliente("Paco", "Corral", "FCorral@gmail.com", "8Caracteres", "8Caracteres", true, 5,
				"12345678A", "Dirección", "666666666");
		assertEquals(ejemplo.getApellidos(),ejemplo2.getApellidos());
	}

	@Test
	void testSetApellidosCliente() {
		Cliente ejemplo = new Cliente("Paco", "Corral", "FCorral@gmail.com", "8Caracteres", "8Caracteres", true, 5,
				"12345678A", "Dirección", "666666666");
		Cliente ejemplo2 = new Cliente("Paco", "Corral", "FCorral@gmail.com", "8Caracteres", "8Caracteres", true, 5,
				"12345678A", "Dirección", "666666666");
		ejemplo.setApellidos("Fernandez");
		ejemplo2.setApellidos("Fernandez");
		assertEquals(ejemplo.getApellidos(),ejemplo2.getApellidos());
	}

	@Test
	void testGetEmailCliente() {
		Cliente ejemplo = new Cliente("Paco", "Corral", "FCorral@gmail.com", "8Caracteres", "8Caracteres", true, 5,
				"12345678A", "Dirección", "666666666");
		Cliente ejemplo2 = new Cliente("Paco", "Corral", "FCorral@gmail.com", "8Caracteres", "8Caracteres", true, 5,
				"12345678A", "Dirección", "666666666");
		assertEquals(ejemplo.getEmail(),ejemplo2.getEmail());
	}

	@Test
	void testSetEmailCliente() {
		Cliente ejemplo = new Cliente("Paco", "Corral", "FCorral@gmail.com", "8Caracteres", "8Caracteres", true, 5,
				"12345678A", "Dirección", "666666666");
		Cliente ejemplo2 = new Cliente("Paco", "Corral", "FCorral@gmail.com", "8Caracteres", "8Caracteres", true, 5,
				"12345678A", "Dirección", "666666666");
		ejemplo.setEmail("LFernandez@gmail.com");
		ejemplo2.setEmail("LFernandez@gmail.com");
		assertEquals(ejemplo.getEmail(),ejemplo2.getEmail());
	}

	@Test
	void testGetPasswordCliente() {
		Cliente ejemplo = new Cliente("Paco", "Corral", "FCorral@gmail.com", "8Caracteres", "8Caracteres", true, 5,
				"12345678A", "Dirección", "666666666");
		Cliente ejemplo2 = new Cliente("Paco", "Corral", "FCorral@gmail.com", "8Caracteres", "8Caracteres", true, 5,
				"12345678A", "Dirección", "666666666");
		assertEquals(ejemplo.getPassword(),ejemplo2.getPassword());
	}

	@Test
	void testSetPasswordCliente() {
		Cliente ejemplo = new Cliente("Paco", "Corral", "FCorral@gmail.com", "8Caracteres", "8Caracteres", true, 5,
				"12345678A", "Dirección", "666666666");
		Cliente ejemplo2 = new Cliente("Paco", "Corral", "FCorral@gmail.com", "8Caracteres", "8Caracteres", true, 5,
				"12345678A", "Dirección", "666666666");
		ejemplo.setPassword("12445178Aa");
		ejemplo2.setPassword("12445178Aa");
		assertEquals(ejemplo.getPassword(),ejemplo2.getPassword());
	}
	
	@Test
	void testtoStringCliente() {
		Cliente ejemplo = new Cliente("Paco", "Corral", "FCorral@gmail.com", "8Caracteres", "8Caracteres", true, 5,
				"12345678A", "Dirección", "666666666");
		Cliente ejemplo2 = new Cliente("Paco", "Corral", "FCorral@gmail.com", "8Caracteres", "8Caracteres", true, 5,
				"12345678A", "Dirección", "666666666");
		assertEquals(ejemplo.toString(),ejemplo2.toString());
		
	}
	
	@Test
	void testContraseniaSeguraCliente() {
		Cliente ejemplo = new Cliente("Paco", "Corral", "FCorral@gmail.com", "8Caracteres", "8Caracteres", true, 5,
				"12345678A", "Dirección", "666666666");
		Cliente ejemplo2 = new Cliente("Paco", "Corral", "FCorral@gmail.com", "8Caracteres", "8Caracteres", true, 5,
				"12345678A", "Dirección", "666666666");
		assertEquals(ejemplo.contraseniaSegura(ejemplo.getPassword()),ejemplo2.contraseniaSegura(ejemplo2.getPassword()));
	
	}

}