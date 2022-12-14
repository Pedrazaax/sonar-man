package com.TIComoApp.TIComo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.TIComoApp.TIComo.model.Asistente;
import com.TIComoApp.TIComo.repository.AsistenteRepository;

@SpringBootTest
public class AsistenteTest {

	private Asistente asistente, asistente2;

	@Test
	void testCrear() {
		asistente = new Asistente("Prueba", "Prueba", "Prueba@Prueba.es", "8Caracteres", "8Caracteres", true, 5,
				"678124547");
		asistente2 = new Asistente("Prueba", "Prueba", "Prueba@Prueba.es", "8Caracteres", "8Caracteres", true, 5,
				"678124547");
		assertEquals(asistente.getApellidos(), asistente.getApellidos());
		assertEquals(asistente.getEmail(), asistente.getEmail());
		assertEquals(asistente.getId(), asistente.getId());
		assertEquals(asistente.getIntentos(), asistente.getIntentos());
		assertEquals(asistente.getNombre(), asistente.getNombre());
		assertEquals(asistente.getTelefono(), asistente.getTelefono());

	}

	@Test
	void testSetId() {
		asistente = new Asistente("Prueba", "Prueba", "Prueba@Prueba.es", "8Caracteres", "8Caracteres", true, 5,
				"678124547");
		asistente2 = new Asistente("Prueba", "Prueba", "Prueba@Prueba.es", "8Caracteres", "8Caracteres", true, 5,
				"678124547");
		asistente.setId("2");
		asistente2.setId("2");
		assertEquals(asistente.getId(), asistente2.getId());
	}
	
	@Test
	void testSetTelefono() {
		asistente = new Asistente("Prueba", "Prueba", "Prueba@Prueba.es", "8Caracteres", "8Caracteres", true, 5,
				"678124547");
		asistente2 = new Asistente("Prueba", "Prueba", "Prueba@Prueba.es", "8Caracteres", "8Caracteres", true, 5,
				"678124547");
		asistente.setTelefono("675846357");
		asistente2.setTelefono("675846357");
		assertEquals(asistente.getId(), asistente2.getId());
	}
	
	@Test
	void testTelefonoValido() {
		asistente2 = new Asistente("Prueba", "Prueba", "Prueba@Prueba.es", "8Caracteres", "8Caracteres", true, 5,
				"678124547");
		assertEquals(asistente2.telefonoValido("678124547"),true);
	}

}