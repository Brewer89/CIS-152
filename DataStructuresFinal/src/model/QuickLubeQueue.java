package model;

import java.util.LinkedList;
import java.util.Queue;

/** class for the quick lube queue
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


public class QuickLubeQueue {
	
	private Queue<Car> quickLube;
	
	public QuickLubeQueue() {
		this.quickLube = new LinkedList<Car>();
	}
	
	/**
	 * @param c element to add to the tail of the queue
	 */
	public void push(Car c) {
		quickLube.add(c);
	}
	
	/**
	 * @return element at the head of the queue, and removes it
	 */
	public Car poll() {
		return quickLube.poll();
	}
	
	/**
	 * @return element at the head of the queue, doesn't remove it
	 */
	public Car peek() {
		return quickLube.peek();
	}
	
	/**
	 * @return number of the elements in the queue
	 */
	public int size() {
		return quickLube.size();	
	}
	
}
