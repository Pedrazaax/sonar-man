package com.TIComoApp.TIComo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.TIComoApp.TIComo.model.Administrador;

class AdministradorTest {


	@Test
	void testAdministrador() {
		Administrador ejemplo=new Administrador("Antonio","Tomás", "Toledo@gmail.com","8Caracteres","8Caracteres", true, 5, "casita");
		Administrador ejemplo2=new Administrador("Antonio","Tomás", "Toledo@gmail.com","8Caracteres","8Caracteres", true, 5, "casita");
		assertEquals(ejemplo.getId(),ejemplo2.getId());
		assertEquals(ejemplo.getNombre(),ejemplo2.getNombre());
		assertEquals(ejemplo.getApellidos(),ejemplo2.getApellidos());
		assertEquals(ejemplo.getZona(),ejemplo2.getZona());
		assertEquals(ejemplo.getEmail(),ejemplo2.getEmail());
	}

	@Test
	void testGetZonaAdministrador() {
		Administrador ejemplo=new Administrador("Antonio","Tomás", "Toledo@gmail.com","8Caracteres","8Caracteres", true, 5, "casita");
		Administrador ejemplo2=new Administrador("Antonio","Tomás", "Toledo@gmail.com","8Caracteres","8Caracteres", true, 5, "casita");
		assertEquals(ejemplo.getZona(),ejemplo2.getZona());
	}
	

	@Test
	void testSetZonaAdministrador() {
		Administrador ejemplo=new Administrador("Antonio","Tomás", "Toledo@gmail.com","8Caracteres","8Caracteres", true, 5, "casita");
		Administrador ejemplo2=new Administrador("Antonio","Tomás", "Toledo@gmail.com","8Caracteres","8Caracteres", true, 5, "casita");
		ejemplo.setZona("Norte");
		ejemplo2.setZona("Norte");
		assertEquals(ejemplo.getZona(),ejemplo2.getZona());
	}

	@Test
	void testGetIdAdministrador() {
		Administrador ejemplo=new Administrador("Antonio","Tomás", "Toledo@gmail.com","8Caracteres","8Caracteres", true, 5, "casita");
		Administrador ejemplo2=new Administrador("Antonio","Tomás", "Toledo@gmail.com","8Caracteres","8Caracteres", true, 5, "casita");
		assertEquals(ejemplo.getId(),ejemplo2.getId());
	}
	
	@Test
	void testSetIdAdministrador() {
		Administrador ejemplo=new Administrador("Antonio","Tomás", "Toledo@gmail.com","8Caracteres","8Caracteres", true, 5, "casita");
		Administrador ejemplo2=new Administrador("Antonio","Tomás", "Toledo@gmail.com","8Caracteres","8Caracteres", true, 5, "casita");
		ejemplo.setId("5");
		ejemplo2.setId("5");
		assertEquals(ejemplo.getId(),ejemplo2.getId());
	}
	
	@Test
	void testGetNombreAdministrador() {
		Administrador ejemplo=new Administrador("Antonio","Tomás", "Toledo@gmail.com","8Caracteres","8Caracteres", true, 5, "casita");
		Administrador ejemplo2=new Administrador("Antonio","Tomás", "Toledo@gmail.com","8Caracteres","8Caracteres", true, 5, "casita");
		assertEquals(ejemplo.getNombre(),ejemplo2.getNombre());
	}
	
	@Test
	void testSetNombreAdministrador() {
		Administrador ejemplo=new Administrador("Antonio","Tomás", "Toledo@gmail.com","8Caracteres","8Caracteres", true, 5, "casita");
		Administrador ejemplo2=new Administrador("Antonio","Tomás", "Toledo@gmail.com","8Caracteres","8Caracteres", true, 5, "casita");
		ejemplo.setNombre("Roberto");
		ejemplo2.setNombre("Roberto");
		assertEquals(ejemplo.getNombre(),ejemplo2.getNombre());
	}
	
	@Test
	void testGetApellidosAdministrador() {
		Administrador ejemplo=new Administrador("Antonio","Tomás", "Toledo@gmail.com","8Caracteres","8Caracteres", true, 5, "casita");
		Administrador ejemplo2=new Administrador("Antonio","Tomás", "Toledo@gmail.com","8Caracteres","8Caracteres", true, 5, "casita");
		assertEquals(ejemplo.getApellidos(),ejemplo2.getApellidos());
	}

	@Test
	void testSetApellidosAdministrador() {
		Administrador ejemplo=new Administrador("Antonio","Tomás", "Toledo@gmail.com","8Caracteres","8Caracteres", true, 5, "casita");
		Administrador ejemplo2=new Administrador("Antonio","Tomás", "Toledo@gmail.com","8Caracteres","8Caracteres", true, 5, "casita");
		ejemplo.setApellidos("Fernandez");
		ejemplo2.setApellidos("Fernandez");
		assertEquals(ejemplo.getApellidos(),ejemplo2.getApellidos());
	}

	
	@Test
	void testGetEmailAdministrador() {
		Administrador ejemplo=new Administrador("Antonio","Tomás", "Toledo@gmail.com","8Caracteres","8Caracteres", true, 5, "casita");
		Administrador ejemplo2=new Administrador("Antonio","Tomás", "Toledo@gmail.com","8Caracteres","8Caracteres", true, 5, "casita");
		assertEquals(ejemplo.getEmail(),ejemplo2.getEmail());
	}

	@Test
	void testSetEmailAdministrador() {
		Administrador ejemplo=new Administrador("Antonio","Tomás", "Toledo@gmail.com","8Caracteres","8Caracteres", true, 5, "casita");
		Administrador ejemplo2=new Administrador("Antonio","Tomás", "Toledo@gmail.com","8Caracteres","8Caracteres", true, 5, "casita");
		ejemplo.setEmail("Rfvanz@gmail.com");
		ejemplo2.setEmail("Rfvanz@gmail.com");
		assertEquals(ejemplo.getEmail(),ejemplo2.getEmail());
	}
	
	@Test
	void testGetPasswordAdministrador() {
		Administrador ejemplo=new Administrador("Antonio","Tomás", "Toledo@gmail.com","8Caracteres","8Caracteres", true, 5, "casita");
		Administrador ejemplo2=new Administrador("Antonio","Tomás", "Toledo@gmail.com","8Caracteres","8Caracteres", true, 5, "casita");
		assertEquals(ejemplo.getPassword(),ejemplo2.getPassword());
	}
	
	@Test
	void testSetPasswordAdministrador() {
		Administrador ejemplo=new Administrador("Antonio","Tomás", "Toledo@gmail.com","8Caracteres","8Caracteres", true, 5, "casita");
		Administrador ejemplo2=new Administrador("Antonio","Tomás", "Toledo@gmail.com","8Caracteres","8Caracteres", true, 5, "casita");
		ejemplo.setPassword("12345678Bb");
		ejemplo2.setPassword("12345678Bb");
		assertEquals(ejemplo.getPassword(),ejemplo2.getPassword());
	}
	
	@Test
	void testtoStringAdministrador() {
		Administrador ejemplo=new Administrador("Antonio","Tomás", "Toledo@gmail.com","8Caracteres","8Caracteres", true, 5, "casita");
		Administrador ejemplo2=new Administrador("Antonio","Tomás", "Toledo@gmail.com","8Caracteres","8Caracteres", true, 5, "casita");
		assertEquals(ejemplo.toString(),ejemplo2.toString());
		
	}
	@Test
	void testContraseniaSeguraAdministrador() {
		Administrador ejemplo=new Administrador("Antonio","Tomás", "Toledo@gmail.com","8Caracteres","8Caracteres", true, 5, "casita");
		Administrador ejemplo2=new Administrador("Antonio","Tomás", "Toledo@gmail.com","8Caracteres","8Caracteres", true, 5, "casita");
		assertEquals(ejemplo.contraseniaSegura(ejemplo.getPassword()),ejemplo2.contraseniaSegura(ejemplo2.getPassword()));
	}

}

