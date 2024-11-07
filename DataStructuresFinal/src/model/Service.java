package model;
/** Service class to help the car class
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

public class Service {
	
	private int oil;
	private int brakes;
	private int tires;
	
	public Service() {
		oil = 0;
		brakes = 0;
		tires = 0;
	}
	/*
	 * Getters and setters for all variables in the Service class 
	 */
	public int getOil() {
		return oil;
	}

	public void setOil(int oil) {
		this.oil = oil;
	}

	public int getBrakes() {
		return brakes;
	}

	public void setBrakes(int brakes) {
		this.brakes = brakes;
	}

	public int getTires() {
		return tires;
	}

	public void setTires(int tires) {
		this.tires = tires;
	}
	
	
	
	

}
