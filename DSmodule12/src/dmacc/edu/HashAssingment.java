/** This is a program the demonstrates the use of hashmaps
 * @author Isaac Coddington-idcoddington@dmacc.edu 
 * @version 1.0
 * @since 1.0
 *Nov 5, 2024 
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
package dmacc.edu;

import java.util.HashMap;
import java.util.Map;


public class HashAssingment {
	
	
	public static void main(String[] args) {
		
		Map<Integer, String> employeeRoster = new HashMap<>();
		/*
		 * I used an integer for employee ID as most places I've worked use a number for your ID. 
		 * Also the old, not really a joke you're just a number to the company.
		 */
		employeeRoster.put(1, "bobroberts@businessx.com");
		employeeRoster.put(2, "tomroose@businessx.com");
		employeeRoster.put(3, "jerrychase@businessx.com");
		/*
		 * The following code searches first for a value in the hashmap then a value not in the hashmap
		 * No exception handling needed as it only returns true or false, no exception is thrown
		 */
		System.out.println(employeeRoster.containsValue("tomroose@businessx.com"));
		System.out.println(employeeRoster.containsValue("jerryroose@businessx.com"));
		/*
		 * The following code searches first for a key in the hashmap then a key not in the hashmap
		 * No exception handling needed as it only returns true or false, no exception is throw
		 */
		System.out.println(employeeRoster.containsKey(1));
		System.out.println(employeeRoster.containsKey(4));
		/*
		 * When you use .put with a key that already exists it overwrites the current value in the hashmap
		 * You could check if the hashmap already has the key assigned to a value and if it does ask if the user wants to overwrite the current value
		 */
		employeeRoster.put(1, "larrysmith@businessx.com");
		/*
		 * When you use .remove with the key it returns the value the key was assigned to and it is returned
		 * If the key doesn't have a value assigned to it it will return null, and if you use key, value in the .remove it will return false if that doesn't exist in the map. 
		 * You could handle this with an if statement to check if that key, value pair exist in the map before trying the remove operation.
		 */
		System.out.println(employeeRoster.remove(1));
		System.out.println(employeeRoster.remove(4, "sam@businessx.com"));
	}

}
