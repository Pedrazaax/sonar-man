package com.TIComoApp.TIComo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.TIComoApp.TIComo.model.Administrador;
import com.TIComoApp.TIComo.model.Rider;



class RiderTest {

	@Test
	void testRider() {
		Rider ejemplo= new Rider("Antonio","Tomás","Corral@gmail.com", "wazaasdasdasdasdasd1A", "wazaasdasdasdasdasd1A", true, 5, "62000000A", "Coche", "4444AAA", "B2");
		Rider ejemplo2= new Rider("Antonio","Tomás","Corral@gmail.com", "wazaasdasdasdasdasd1A", "wazaasdasdasdasdasd1A", true, 5, "62000000A", "Coche", "4444AAA", "B2");
		assertEquals(ejemplo.getNombre(),ejemplo2.getNombre());
		assertEquals(ejemplo.getApellidos(),ejemplo2.getApellidos());
		assertEquals(ejemplo.getEmail(),ejemplo2.getEmail());
		assertEquals(ejemplo.getPassword(),ejemplo2.getPassword());
		assertEquals(ejemplo.getNIF(),ejemplo2.getNIF());
		assertEquals(ejemplo.getTipoVehiculo(),ejemplo2.getTipoVehiculo());
		assertEquals(ejemplo.getMatricula(),ejemplo2.getMatricula());
		assertEquals(ejemplo.getCarnet(),ejemplo2.getCarnet());
	}

	@Test
	void testGetNIFRider() {
		Rider ejemplo= new Rider("Antonio","Tomás","Corral@gmail.com", "wazaasdasdasdasdasd1A", "wazaasdasdasdasdasd1A", true, 5, "62000000A", "Coche", "4444AAA", "B2");
		Rider ejemplo2= new Rider("Antonio","Tomás","Corral@gmail.com", "wazaasdasdasdasdasd1A", "wazaasdasdasdasdasd1A", true, 5, "62000000A", "Coche", "4444AAA", "B2");		
		assertEquals(ejemplo.getNIF(),ejemplo2.getNIF());
	}

	@Test
	void testSetNIFRider() {
		Rider ejemplo= new Rider("Antonio","Tomás","Corral@gmail.com", "wazaasdasdasdasdasd1A", "wazaasdasdasdasdasd1A", true, 5, "62000000A", "Coche", "4444AAA", "B2");
		Rider ejemplo2= new Rider("Antonio","Tomás","Corral@gmail.com", "wazaasdasdasdasdasd1A", "wazaasdasdasdasdasd1A", true, 5, "62000000A", "Coche", "4444AAA", "B2");		
		ejemplo.setNIF("82712409N");
		ejemplo2.setNIF("82712409N");
		assertEquals(ejemplo.getNIF(),ejemplo2.getNIF());
	}

	@Test
	void testGetTipoVehiculoRider() {
		Rider ejemplo= new Rider("Antonio","Tomás","Corral@gmail.com", "wazaasdasdasdasdasd1A", "wazaasdasdasdasdasd1A", true, 5, "62000000A", "Coche", "4444AAA", "B2");
		Rider ejemplo2= new Rider("Antonio","Tomás","Corral@gmail.com", "wazaasdasdasdasdasd1A", "wazaasdasdasdasdasd1A", true, 5, "62000000A", "Coche", "4444AAA", "B2");		
		assertEquals(ejemplo.getTipoVehiculo(),ejemplo2.getTipoVehiculo());
	}

	@Test
	void testSetTipoVehiculoRider() {
		Rider ejemplo= new Rider("Antonio","Tomás","Corral@gmail.com", "wazaasdasdasdasdasd1A", "wazaasdasdasdasdasd1A", true, 5, "62000000A", "Coche", "4444AAA", "B2");
		Rider ejemplo2= new Rider("Antonio","Tomás","Corral@gmail.com", "wazaasdasdasdasdasd1A", "wazaasdasdasdasdasd1A", true, 5, "62000000A", "Coche", "4444AAA", "B2");		
		ejemplo.setTipoVehiculo("Moto");
		ejemplo2.setTipoVehiculo("Moto");
		assertEquals(ejemplo.getTipoVehiculo(),ejemplo2.getTipoVehiculo());
	}

	@Test
	void testGetMatriculaRider() {
		Rider ejemplo= new Rider("Antonio","Tomás","Corral@gmail.com", "wazaasdasdasdasdasd1A", "wazaasdasdasdasdasd1A", true, 5, "62000000A", "Coche", "4444AAA", "B2");
		Rider ejemplo2= new Rider("Antonio","Tomás","Corral@gmail.com", "wazaasdasdasdasdasd1A", "wazaasdasdasdasdasd1A", true, 5, "62000000A", "Coche", "4444AAA", "B2");		
		assertEquals(ejemplo.getMatricula(),ejemplo2.getMatricula());
	}

	@Test
	void testSetMatriculaRider() {
		Rider ejemplo= new Rider("Antonio","Tomás","Corral@gmail.com", "wazaasdasdasdasdasd1A", "wazaasdasdasdasdasd1A", true, 5, "62000000A", "Coche", "4444AAA", "B2");
		Rider ejemplo2= new Rider("Antonio","Tomás","Corral@gmail.com", "wazaasdasdasdasdasd1A", "wazaasdasdasdasdasd1A", true, 5, "62000000A", "Coche", "4444AAA", "B2");		
		ejemplo.setMatricula("3427 BLC");
		ejemplo2.setMatricula("3427 BLC");
		assertEquals(ejemplo.getMatricula(),ejemplo2.getMatricula());
	}

	@Test
	void testGetCarnetRider() {
		Rider ejemplo= new Rider("Antonio","Tomás","Corral@gmail.com", "wazaasdasdasdasdasd1A", "wazaasdasdasdasdasd1A", true, 5, "62000000A", "Coche", "4444AAA", "B2");
		Rider ejemplo2= new Rider("Antonio","Tomás","Corral@gmail.com", "wazaasdasdasdasdasd1A", "wazaasdasdasdasdasd1A", true, 5, "62000000A", "Coche", "4444AAA", "B2");		
		assertEquals(ejemplo.getCarnet(),ejemplo2.getCarnet());
	}

	@Test
	void testSetCarnetRider() {
		Rider ejemplo= new Rider("Antonio","Tomás","Corral@gmail.com", "wazaasdasdasdasdasd1A", "wazaasdasdasdasdasd1A", true, 5, "62000000A", "Coche", "4444AAA", "B2");
		Rider ejemplo2= new Rider("Antonio","Tomás","Corral@gmail.com", "wazaasdasdasdasdasd1A", "wazaasdasdasdasdasd1A", true, 5, "62000000A", "Coche", "4444AAA", "B2");		
		ejemplo.setCarnet("A");
		ejemplo2.setCarnet("A");
		assertEquals(ejemplo.getCarnet(),ejemplo2.getCarnet());
	}

	@Test
	void testGetNombreRider() {
		Rider ejemplo= new Rider("Antonio","Tomás","Corral@gmail.com", "wazaasdasdasdasdasd1A", "wazaasdasdasdasdasd1A", true, 5, "62000000A", "Coche", "4444AAA", "B2");
		Rider ejemplo2= new Rider("Antonio","Tomás","Corral@gmail.com", "wazaasdasdasdasdasd1A", "wazaasdasdasdasdasd1A", true, 5, "62000000A", "Coche", "4444AAA", "B2");		
		assertEquals(ejemplo.getNombre(),ejemplo2.getNombre());
	}

	@Test
	void testSetNombreRider() {
		Rider ejemplo= new Rider("Antonio","Tomás","Corral@gmail.com", "wazaasdasdasdasdasd1A", "wazaasdasdasdasdasd1A", true, 5, "62000000A", "Coche", "4444AAA", "B2");
		Rider ejemplo2= new Rider("Antonio","Tomás","Corral@gmail.com", "wazaasdasdasdasdasd1A", "wazaasdasdasdasdasd1A", true, 5, "62000000A", "Coche", "4444AAA", "B2");		
		ejemplo.setNombre("Roberto");
		ejemplo2.setNombre("Roberto");
		assertEquals(ejemplo.getNombre(),ejemplo2.getNombre());
	}

	@Test
	void testGetApellidosRider() {
		Rider ejemplo= new Rider("Antonio","Tomás","Corral@gmail.com", "wazaasdasdasdasdasd1A", "wazaasdasdasdasdasd1A", true, 5, "62000000A", "Coche", "4444AAA", "B2");
		Rider ejemplo2= new Rider("Antonio","Tomás","Corral@gmail.com", "wazaasdasdasdasdasd1A", "wazaasdasdasdasdasd1A", true, 5, "62000000A", "Coche", "4444AAA", "B2");		
		assertEquals(ejemplo.getApellidos(),ejemplo2.getApellidos());
	}

	@Test
	void testSetApellidosRider() {
		Rider ejemplo= new Rider("Antonio","Tomás","Corral@gmail.com", "wazaasdasdasdasdasd1A", "wazaasdasdasdasdasd1A", true, 5, "62000000A", "Coche", "4444AAA", "B2");
		Rider ejemplo2= new Rider("Antonio","Tomás","Corral@gmail.com", "wazaasdasdasdasdasd1A", "wazaasdasdasdasdasd1A", true, 5, "62000000A", "Coche", "4444AAA", "B2");		
		ejemplo.setApellidos("Fernandez");
		ejemplo2.setApellidos("Fernandez");
		assertEquals(ejemplo.getApellidos(),ejemplo2.getApellidos());
	}

	@Test
	void testGetEmailRider() {
		Rider ejemplo= new Rider("Antonio","Tomás","Corral@gmail.com", "wazaasdasdasdasdasd1A", "wazaasdasdasdasdasd1A", true, 5, "62000000A", "Coche", "4444AAA", "B2");
		Rider ejemplo2= new Rider("Antonio","Tomás","Corral@gmail.com", "wazaasdasdasdasdasd1A", "wazaasdasdasdasdasd1A", true, 5, "62000000A", "Coche", "4444AAA", "B2");		
		assertEquals(ejemplo.getEmail(),ejemplo2.getEmail());

	}

	@Test
	void testSetEmailRider() {
		Rider ejemplo= new Rider("Antonio","Tomás","Corral@gmail.com", "wazaasdasdasdasdasd1A", "wazaasdasdasdasdasd1A", true, 5, "62000000A", "Coche", "4444AAA", "B2");
		Rider ejemplo2= new Rider("Antonio","Tomás","Corral@gmail.com", "wazaasdasdasdasdasd1A", "wazaasdasdasdasdasd1A", true, 5, "62000000A", "Coche", "4444AAA", "B2");		
		ejemplo.setEmail("Rfvanz@gmail.com");
		ejemplo2.setEmail("Rfvanz@gmail.com");
		assertEquals(ejemplo.getEmail(),ejemplo2.getEmail());
	}

	@Test
	void testGetPasswordRider() {
		Rider ejemplo= new Rider("Antonio","Tomás","Corral@gmail.com", "wazaasdasdasdasdasd1A", "wazaasdasdasdasdasd1A", true, 5, "62000000A", "Coche", "4444AAA", "B2");
		Rider ejemplo2= new Rider("Antonio","Tomás","Corral@gmail.com", "wazaasdasdasdasdasd1A", "wazaasdasdasdasdasd1A", true, 5, "62000000A", "Coche", "4444AAA", "B2");		
		assertEquals(ejemplo.getPassword(),ejemplo2.getPassword());
	}

	@Test
	void testSetPasswordRider() {
		Rider ejemplo= new Rider("Antonio","Tomás","Corral@gmail.com", "wazaasdasdasdasdasd1A", "wazaasdasdasdasdasd1A", true, 5, "62000000A", "Coche", "4444AAA", "B2");
		Rider ejemplo2= new Rider("Antonio","Tomás","Corral@gmail.com", "wazaasdasdasdasdasd1A", "wazaasdasdasdasdasd1A", true, 5, "62000000A", "Coche", "4444AAA", "B2");		
		ejemplo.setPassword("12345678Bb");
		ejemplo2.setPassword("12345678Bb");
		assertEquals(ejemplo.getPassword(),ejemplo2.getPassword());
	}

	@Test
	void testtoStringRider() {
		Rider ejemplo= new Rider("Antonio","Tomás","Corral@gmail.com", "wazaasdasdasdasdasd1A", "wazaasdasdasdasdasd1A", true, 5, "62000000A", "Coche", "4444AAA", "B2");
		Rider ejemplo2= new Rider("Antonio","Tomás","Corral@gmail.com", "wazaasdasdasdasdasd1A", "wazaasdasdasdasdasd1A", true, 5, "62000000A", "Coche", "4444AAA", "B2");		
		assertEquals(ejemplo.toString(),ejemplo2.toString());
	}
	@Test
	void testContraseniaSeguraRider() {
		Rider ejemplo= new Rider("Antonio","Tomás","Corral@gmail.com", "wazaasdasdasdasdasd1A", "wazaasdasdasdasdasd1A", true, 5, "62000000A", "Coche", "4444AAA", "B2");
		Rider ejemplo2= new Rider("Antonio","Tomás","Corral@gmail.com", "wazaasdasdasdasdasd1A", "wazaasdasdasdasdasd1A", true, 5, "62000000A", "Coche", "4444AAA", "B2");		
		assertEquals(ejemplo.contraseniaSegura(ejemplo.getPassword()),ejemplo2.contraseniaSegura(ejemplo2.getPassword()));
	}

}
