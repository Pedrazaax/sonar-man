package com.TIComoApp.TIComo;

import static org.junit.jupiter.api.Assertions.*;
import org.bson.json.JsonObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.TIComoApp.TIComo.model.Administrador;
import com.TIComoApp.TIComo.model.Cliente;
import com.TIComoApp.TIComo.controller.AuthenticationController;
import com.TIComoApp.TIComo.controller.ClienteController;

@SpringBootTest
class AuthenticationControllerTest {
	@Autowired
	private AuthenticationController autcontroller;
	@Autowired
	private ClienteController clicontroller;

	@Test
	void createTest() throws Exception {
		Cliente cliente = new Cliente("Paco", "PEPE", "paco@gmail.com", "8Caracteres", "8Caracteres", true, 5,
				"12345678A", "Dirección", "666666666");
		Cliente cliente2 = new Cliente("", "PEPE", "pacopepe@gmail.com", "8Caracteres", "8Caracteres", true, 5,
				"12345678A", "Dirección", "666666666");
		Cliente cliente3 = new Cliente("Paco", "PEPE", "pacopepe@gmail", "8Caracteres", "8Caracteres", true, 5,
				"12345678A", "Dirección", "666666666");
		Cliente cliente4 = new Cliente("Paco", "PEPE", "pacopepe@gmail.com", "8aracteres", "8aracteres", true, 5,
				"12345678A", "Dirección", "666666666");
		Cliente cliente5 = new Cliente("Paco", "PEPE", "pacopepe@gmail.com", "8Caracteres", "8Caractere", true, 5,
				"12345678A", "Dirección", "666666666");
		Cliente cliente6 = new Cliente("Paco", "PEPE", "pacopepe@gmail.com", "8Caracteres", "8Caractere", true, 5,
				"12345678A", "Dirección", "666666666");
		Cliente cliente7 = new Cliente("Paco", "PEPE", "pacopepe@gmail.com", "8Caracteres", "8Caracteres", true, 5,
				"12345678", "Dirección", "666666666");
		Cliente cliente8 = new Cliente("Paco", "PEPE", "pacopepe@gmail.com", "8Caracteres", "8Caracteres", true, 5,
				"12345678A", "Dirección", "166666666");

		try {
			autcontroller.create(cliente);
		} catch (Exception e) {
			System.out.println("Error");
		}
		try {
			autcontroller.create(cliente2);
			
		} catch (Exception e) {
			System.out.println("Error");
		}
		try {
			autcontroller.create(cliente3);
			
		} catch (Exception e) {
			System.out.println("Error");
		}
		try {
			autcontroller.create(cliente4);
			
		} catch (Exception e) {
			System.out.println("Error");
		}
		try {
			autcontroller.create(cliente5);
			
		} catch (Exception e) {
			System.out.println("Error");
		}
		try {
			autcontroller.create(cliente6);
			
		} catch (Exception e) {
			System.out.println("Error");
		}
		try {
			autcontroller.create(cliente7);
		} catch (Exception e) {
			System.out.println("Error");
		}
		try {
			autcontroller.create(cliente8);
		} catch (Exception e) {
			System.out.println("Error");
		}

	}

	@Test
	void loginTest() throws Exception {

		Cliente admin = new Cliente("", "", "admin@admin.com", "8Caracteres", "8Caracteres", true, 5, "", "", ""); //No es valido
		Cliente cliente = new Cliente("", "", "manolin@elgafotilla.com", "8Caracteres", "8Caracteres", true, 5, "", "",
				""); //No es valido
		Cliente rider = new Cliente("", "", "pruebitaridder@gmail.com", "8Caracteres", "8Caracteres", true, 5, "", "",
				"");
		Cliente asis = new Cliente("", "", "mario@mario.com", "8Caracteres", "8Caracteres", true, 5, "", "", "");

		Cliente admin2 = new Cliente("", "", "admin@admin.com", "8Caractere", "8Caracteres", true, 5, "", "", "");
		Cliente cliente2 = new Cliente("", "", "manolin@elgafotilla.com", "8Caractere", "8Caracteres", true, 5, "", "",
				"");
		Cliente rider2 = new Cliente("", "", "pruebitaridder@gmail.com", "8Caractere", "8Caracteres", true, 5, "", "",
				"");
		Cliente asis2 = new Cliente("", "", "mario@mario.com", "8Caractere", "8Caracteres", true, 5, "", "", "");
		
		try {
			String jadmin = autcontroller.loginUser(admin);
		} catch (Exception e) {
			System.out.println("Error");
		}
		try {
			String jcliente = autcontroller.loginUser(cliente);
		} catch (Exception e) {
			System.out.println("Error");
		}
		try {
			String jrider = autcontroller.loginUser(rider);
		} catch (Exception e) {
			System.out.println("Error");
		}
		try {
			String jasis = autcontroller.loginUser(asis);
		} catch (Exception e) {
			System.out.println("Error");
		}
		
		try {
			String jadmin2 = autcontroller.loginUser(admin2);
		} catch (Exception e) {
			System.out.println("Error");
		}
		try {
			String jcliente2 = autcontroller.loginUser(cliente2);
		} catch (Exception e) {
			System.out.println("Error");
		}
		try {
			String jrider2 = autcontroller.loginUser(rider2);
		} catch (Exception e) {
			System.out.println("Error");
		}
		try {
			String jasis2 = autcontroller.loginUser(asis2);
		} catch (Exception e) {
			System.out.println("Error");
		}

	}

}