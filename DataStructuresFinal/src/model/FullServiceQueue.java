package model;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/** class for the full service queue line
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


public class FullServiceQueue {

	LinkedList<Car> fullService;
	private int frontOfLine = 0;
	
	public FullServiceQueue() {
		this.fullService = new LinkedList<Car>();
	}
	
	/**
	 * @param c Car element to add to Queue
	 */
	public void push(Car c) {
		fullService.add(c);
	}
	
	/**
	 * @param c Car element to add to the front of the Queue
	 * @return true if it was successfully added
	 */
	public boolean priorityPush(Car c) {
		if (frontOfLine >= 4) {
			return false;
		} else {
			fullService.add(frontOfLine, c);
			frontOfLine++;
			return true;
		}
	}
		
	/**
	 * @return the element at the head of the queue and removes that element
	 */
	public Car poll() {
		if (frontOfLine > 0)
			frontOfLine--;
		return fullService.poll();
	}
	
	/**
	 * @return the size of the queue
	 */
	public int size() {
		return fullService.size();
	}
	
	/**
	 * @return the next element in the queue, doesn't remove it
	 */
	public Car peek() {
		return fullService.peek();
	}
	
}
