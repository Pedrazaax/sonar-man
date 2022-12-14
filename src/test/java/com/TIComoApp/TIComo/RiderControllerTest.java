package com.TIComoApp.TIComo;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.TIComoApp.TIComo.controller.RiderController;
import com.TIComoApp.TIComo.model.Rider;
import com.TIComoApp.TIComo.repository.RiderRepository;

@SpringBootTest
public class RiderControllerTest {
   @Autowired
   private RiderRepository riderRepository;
   @Autowired
   private RiderController ridercontroller;
   
  
   Rider res= new Rider("Antonio","Tomás","aaa@gmail.com", "wazaasdasdasdasdasd1A", "wazaasdasdasdasdasd1A", true, 5, "62000000A", "Coche", "4444AAA", "B2");
   Rider res2= new Rider("Antonio","Tomás","bbb@gmail.com", "wazaasdasdasdasdasd1A", "wazaasdasdasdasdasd1A", true, 5, "62000000A", "Moto", "4444SAB", "B2");
   Rider res3= new Rider("Antonio","Tomás","www@gmail.com", "wazaasdasdasdasdasd1A", "wazaasdasdasdasdasd1A", true, 5, "62000000A", "Moto", "4444BBBB", "B2");
   Rider res4= new Rider("Antonio","Tomás","www@gmail.com", "wazaasdasdasdasdasd1A", "wazaasdasdasdasdasd1A", true, 5, "62000000A", "Moto", "4444BBB", "B2");
   Rider res5= new Rider("Antonio","Tomás","www@gmail.com", "waza", "wazaasdasdasdasdasd1A", true, 5, "62000000A", "Moto", "4444BBB", "B2");
   
   @Rule
   public ExpectedException exception = ExpectedException.none();
  
   @Test
   void testCrearRider() {
       ridercontroller.create(res);
	   ridercontroller.create(res2);
	   ridercontroller.create(res3);
	   ridercontroller.create(res4);
	   ridercontroller.create(res5);
       
      
      }
   
	@Test
	 void testObtnerRider(){
		   ridercontroller.obtenerRider("11111");

	}
	
	@Test
	void testDesactivarActivarRider() {
		Rider rid =ridercontroller.desactivarActivarRider(res);
		assertEquals(true,rid.isCuentaActiva());
	}
	
	
	@Test
	void testIndex() {
		List<Rider> list=ridercontroller.index();
		assertNotEquals(0,list.size());
	}
		
}
