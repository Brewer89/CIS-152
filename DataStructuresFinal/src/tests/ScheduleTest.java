package tests;
/** Testing for the scheduling class
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
import model.Scheduling;


 
class ScheduleTest {

	@Test
	public void testInputCheckWithEmptyFields() {
		Scheduling result = new Scheduling();
		assertEquals("All fields must be filled out", result.inputCheck("", "", "", "", true, false, false));
	}
	
	@Test
	public void testInputCheckWithInvalidYear() {
		Scheduling result = new Scheduling();
		assertEquals("Invalid input: Please enter a valid number for year.", result.inputCheck("Chevy", "Cruze", "twenty", "Isaac", true, false, false));
	}

	@Test
	public void testInputCheckWithNoServiceInput() {
		Scheduling result = new Scheduling();
		assertEquals("No service was selected", result.inputCheck("Chevy", "Cruze", "2014", "Isaac", false, false, false));
	}
	
	@Test
	public void testInputCheckWithOnlyOilInput() {
		Scheduling result = new Scheduling();
		assertEquals("Scheduled for quick lube", result.inputCheck("Chevy", "Cruze", "2014", "Isaac", true, false, false));
	}
	
	@Test
	public void testInputCheckWithAllServiceInput() {
		Scheduling result = new Scheduling();
		assertEquals("Scheduled for full service line", result.inputCheck("Chevy", "Cruze", "2014", "Isaac", true, true, true));
	}
	
	@Test
	public void testScheduleWithFullList() {
		//Update the MAX_CUSTOMERS variable in Scheduling to 2 for this test to pass
		//I didn't want to have to create 39 car objects in the testing file for 1 test
		Scheduling result = new Scheduling();
		Car c = new Car("Chevy", "Cruze", 2014, "Isaac");
		c.serviceSelection(1, 0, 0);
		Car c1 = new Car("Chevy", "Cruze", 2015, "Isaac");
		c1.serviceSelection(1, 0, 0);
		Car c2 = new Car("Chevy", "Cruze", 2016, "Isaac");
		c2.serviceSelection(1, 0, 0);
		
		result.scheduleService(c);
		result.scheduleService(c1);
		assertEquals("Scheduled at front of full service line", result.scheduleService(c2));
	}
	
	@Test
	public void testPollQuickLube() {
		Scheduling result = new Scheduling();
		Car c = new Car("Chevy", "Cruze", 2014, "Isaac");
		c.serviceSelection(1, 0, 0);
		Car c1 = new Car("Chevy", "Cruze", 2015, "Isaac");
		c1.serviceSelection(1, 0, 0);
		Car c2 = new Car("Chevy", "Cruze", 2016, "Isaac");
		c2.serviceSelection(1, 0, 0);
		result.scheduleService(c);
		result.scheduleService(c1);
		result.scheduleService(c2);
		assertEquals("Make: Chevy\nModel: Cruze\nYear: 2014\nCustomer: Isaac\nService to perform:  Oil ", result.nextQuickLube());
	}
	
	@Test
	public void testPollFullServiceLine() {
		Scheduling result = new Scheduling();
		Car c = new Car("Chevy", "Cruze", 2014, "Isaac");
		c.serviceSelection(1, 1, 0);
		Car c1 = new Car("Chevy", "Cruze", 2015, "Isaac");
		c1.serviceSelection(1, 0, 1);
		Car c2 = new Car("Chevy", "Cruze", 2016, "Isaac");
		c2.serviceSelection(1, 0, 1);
		result.scheduleService(c);
		result.scheduleService(c1);
		result.scheduleService(c2);
		result.nextFullService();
		assertEquals("Make: Chevy\nModel: Cruze\nYear: 2015\nCustomer: Isaac\nService to perform:  Oil  Tires ", result.nextFullService());
	}
	
	@Test
	public void testEmptyList() {
		Scheduling result = new Scheduling();
		assertEquals("No more customers.", result.nextFullService());
		assertEquals("No more customers.", result.nextQuickLube());
	}
	@Test
	public void testAllSpotsFull() {
		Scheduling result = new Scheduling();
		Car c = new Car("Chevy", "Cruze", 2014, "Isaac");
		c.serviceSelection(1, 0, 0);
		Car c1 = new Car("Chevy", "Cruze", 2015, "Isaac");
		c1.serviceSelection(1, 0, 0);
		Car c2 = new Car("Chevy", "Cruze", 2016, "Isaac");
		c2.serviceSelection(1, 0, 0);
		Car c3 = new Car("Chevy", "Cruze", 2014, "Isaac");
		c3.serviceSelection(1, 0, 0);
		Car c4 = new Car("Chevy", "Cruze", 2015, "Isaac");
		c4.serviceSelection(1, 0, 0);
		Car c5 = new Car("Chevy", "Cruze", 2016, "Isaac");
		c5.serviceSelection(1, 0, 0);
		Car c6 = new Car("Chevy", "Cruze", 2014, "Isaac");
		c6.serviceSelection(1, 0, 0);
		result.scheduleService(c);
		result.scheduleService(c1);
		result.scheduleService(c2);
		result.scheduleService(c3);
		result.scheduleService(c4);
		result.scheduleService(c5);
		assertEquals("No more spots left.", result.scheduleService(c6));
	}
}
	

