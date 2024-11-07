package tests;
/** testing for car creation
 * @author Isaac Coddington-idcoddington@dmacc.edu 
 * @version 1.0
 * @since 1.0
 *Nov 1, 2024 
*/
/*  
* OS: Win 11
* IDE: Eclipse 2024-06
* Copyright : This is my own original work 
* based on specifications issued by our instructor
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or
* unmodified, nor used generative AI as a final draft. 
* I have not given other fellow student(s) access to my program.
*/

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import model.Car;


class CarTest {

	@Test
	public void testCar() {
		Car c = new Car("Chevy", "Cruze", 2014, "Isaac");
		c.serviceSelection(0, 0, 0);
		assertEquals("Chevy", c.getMake());
		assertEquals("Cruze", c.getModel());
		assertEquals(2014, c.getYear());
		assertEquals("Isaac", c.getCustomer());
		assertEquals(0, c.getService().getOil());
		assertEquals(0, c.getService().getBrakes());
		assertEquals(0, c.getService().getTires());
	}
	@Test
	public void testOutput() {
		Car c = new Car("Chevy", "Cruze", 2014, "Isaac");
		c.serviceSelection(1, 1, 1);
		assertEquals("Make: Chevy\nModel: Cruze\nYear: 2014\nCustomer: Isaac\nService to perform:  Oil  Brakes  Tires ", c.getInfo());
	}
	

}
