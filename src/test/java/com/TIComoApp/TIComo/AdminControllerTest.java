package com.TIComoApp.TIComo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.TIComoApp.TIComo.controller.AdminController;
import com.TIComoApp.TIComo.model.Administrador;
import com.TIComoApp.TIComo.repository.AdministradorRepository;

@SpringBootTest
class AdminControllerTest {

	@Autowired
	private AdministradorRepository administradorRepository;
	@Autowired
	private AdminController admincontroller;

	Administrador res=new Administrador("Antonio","Tomás", "Toledo@gmail.com","8Caracteres","8Caracteres", true, 5, "casita");
	Administrador res2=new Administrador("Pepe","Tomása", "Toledo@gmail","8Caracteres","8Caracteres", true, 5, "casita");
	Administrador res3=new Administrador("Julian","Tomás", "Toledo@gmail.com","8caracteres","8caracteres", true, 5, "casita");
	Administrador res4=new Administrador("Rodri","Tomás", "Toledo@gmail.com","8Caracte","aracte", true, 5, "casita");

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	void testCrearAdmin() {
		Administrador res=new Administrador("Antonio","Tomás", "Toledo@gmail.com","8Caracteres","8Caracteres", true, 5, "casita");
		Administrador res2=new Administrador("Pepe","Tomása", "Toledo@gmail","8Caracteres","8Caracteres", true, 5, "casita");
		Administrador res3=new Administrador("Julian","Tomás", "Toledo@gmail.com","8caracteres","8caracteres", true, 5, "casita");
		Administrador res4=new Administrador("Rodri","Tomás", "Toledo@gmail.com","8Caracte","aracte", true, 5, "casita");

		admincontroller.create(res);
		admincontroller.create(res2);
		admincontroller.create(res3);
		admincontroller.create(res4);

	}

	@Test
	void testObtenerAdmin() {

		admincontroller.obtenerAdmin("1B");

	}

	@Test
	void testActualizarAdmin(){
		Administrador res=new Administrador("Antonio","Tomás", "Toledo@gmail.com","8Caracteres","8Caracteres", true, 5, "casita");
		Administrador res2=new Administrador("Pepe","Tomása", "Toledo@gmail","8Caracteres","8Caracteres", true, 5, "casita");
		Administrador res3=new Administrador("Julian","Tomás", "Toledo@gmail.com","8caracteres","8caracteres", true, 5, "casita");
		Administrador res4=new Administrador("Rodri","Tomás", "Toledo@gmail.com","8Caracte","aracte", true, 5, "casita");
	       
	   }

	@Test
	void testIndex() {
		List<Administrador> list = admincontroller.index();
		int size = list.size();
		assertEquals(size, list.size());
	}


}
