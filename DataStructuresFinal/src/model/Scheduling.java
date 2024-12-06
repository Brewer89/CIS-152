package model;
/** Class to handle all the scheduling of services
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


public class Scheduling {

	private final int MAX_CUSTOMERS = 2;
	private QuickLubeQueue qlQueue = new QuickLubeQueue();
	private FullServiceQueue fsQueue = new FullServiceQueue();
	
	/**
	 * @param make Car details
	 * @param model Car details
	 * @param year Car details
	 * @param customer Car details
	 * @param oil true is service is selected
	 * @param brakes true if service is selected
	 * @param tires true if service is selected
	 * @return a String if input is accepted or if there was input errors
	 */
	public String inputCheck(String make, String model, String year, String customer, boolean oil, boolean brakes, boolean tires) {
		int numYear = 0;
		int oilChecked = 0;
		int tiresChecked = 0;
		int brakesChecked = 0;
		if (oil == false && brakes == false && tires == false) {
			return("No service was selected");
		}
	    if (make.isEmpty() || model.isEmpty() || year.isEmpty() || customer.isEmpty()) {
	        return("All fields must be filled out");
	    }
	    try {
	        numYear = Integer.parseInt(year);
	    } catch (NumberFormatException x) {
	        return("Invalid input: Please enter a valid number for year.");
	    }	
		Car newCar = new Car(make, model, numYear, customer);
		if (oil) {
			oilChecked = 1;
		}
		if (brakes) {
			brakesChecked = 1;
		}
		if (tires) {
			tiresChecked = 1;
		}
		newCar.serviceSelection(oilChecked, brakesChecked, tiresChecked);
		return(scheduleService(newCar));
	}
	
	/**
	 * @param c The Car that was created if all input was valid
	 * @return a string stating if the car was scheduled for the service and what service line it was scheduled in
	 */
	public String scheduleService(Car c) {
		int oilSelect = c.getService().getOil();
		int tiresSelect = c.getService().getTires();
		int brakesSelect = c.getService().getBrakes();
		if(oilSelect == 1 && tiresSelect == 0 && brakesSelect == 0) {
			if (qlQueue.size() >= MAX_CUSTOMERS) {
				if (fsQueue.priorityPush(c) == true) {
					return("Scheduled at front of full service line");
				} else {
					return("No more spots left.");
				}
			}
			qlQueue.push(c);
			return("Scheduled for quick lube");
		}
		else {
			fsQueue.push(c);
			return("Scheduled for full service line");
		}
	}
	
	/**
	 * @return the next customer in line for the quick lube line
	 */
	public String nextQuickLube() {
		if (qlQueue.peek() == null)
			return("No more customers.");
		Car nextCustomer = qlQueue.poll();
		return nextCustomer.getInfo();
	}
	
	/**
	 * @return the next customer in line for the full service line
	 */
	public String nextFullService() {
		if (fsQueue.peek() == null)
			return("No more customers.");
		Car nextCustomer = fsQueue.poll();
		return nextCustomer.getInfo();
	}
}
