package model;

/** Car class
 * @author Isaac Coddington-idcoddington@dmacc.edu 
 * @version 1.0
 * @since 1.0
 *Oct 22, 2024 
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


public class Car {
	
	private String make;
	private String model;
	private int year;
	private String customer;
	private Service serviceSelected;
	
	public Car() {
		make = "null";
		model = "null";
		year = 0;
		customer = "null";
	}

	public Car(String make, String model, int year, String customer) {
		this.make = make;
		this.model = model;
		this.year = year;
		this.customer = customer;
		serviceSelected = new Service();
	}
	
	/**
	 * @return make of the car as a string
	 */
	public String getMake() {
		return make;
	}

	/**
	 * @return model of the car as a string
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @return year of the car as a int
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @return name of the customer as a string
	 */
	public String getCustomer() {
		return customer;
	}

	/**
	 * @param oil 1 if oil is selected 0 if not
	 * @param brakes 1 if brakes is selected 0 if not
	 * @param tires 1 if tires is selected 0 if not
	 */
	public void serviceSelection(int oil, int brakes, int tires) {
		serviceSelected.setOil(oil);
		serviceSelected.setBrakes(brakes);
		serviceSelected.setTires(tires);
	}
	
	/**
	 * @return all the info for the current car as a formatted string
	 */
	public String getInfo() {
		String displayInfo = new String();
		displayInfo = ("Make: " + make + "\n"
						+ "Model: " + model + "\n"
						+ "Year: " + year + "\n"
						+ "Customer: " + customer + "\n"
						+ "Service to perform: " + serviceInfo());
		return displayInfo;
	}
	
	/**
	 * @return the service selections for the current car
	 */
	public Service getService() {
		return serviceSelected;
	}
	
	/**
	 * @return used in the getInfo method to help format the output string
	 */
	private String serviceInfo() {
		String str = new String();
		if (serviceSelected.getOil() == 1) {
			str += " Oil ";
		}
		if (serviceSelected.getBrakes() == 1) {
			str += " Brakes ";
		}
		if (serviceSelected.getTires() == 1) {
			str += " Tires ";
		}
		return str;
	}
	
	 
	
	
	

}
