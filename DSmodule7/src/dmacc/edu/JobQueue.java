/** Priority list of a job queue
 * @author Isaac Coddington-idcoddington@dmacc.edu 
 * @version 1.0
 * @since 1.0
 *Sep 30, 2024 
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

import java.util.PriorityQueue;
import java.util.Random;

public class JobQueue {
	//attributes
	private int data;
	private String priority;
	private PriorityQueue<String> pQueue;
	Random rand = new Random();
	final int MAX = 900;
	final int MIN = 100;
	//constructor
	public JobQueue() {
		this.pQueue = new PriorityQueue<String>();
	}

	/**
	 * @return true if the array is empty
	 */
	public boolean isEmpty() {
		return pQueue.isEmpty();
	}

	/**
	 * @return the size of the array
	 */
	public int size() {
		return pQueue.size();
	}

	/**
	 * @param input the job priority as a string adds that job to the array
	 */
	public void add(String input) {
		priority = input;
		data = rand.nextInt((MAX) + MIN);
		priority += (", " + Integer.toString(data));
		pQueue.add(priority);
	}

	/**
	 * @return the highest priority element in the array
	 */
	public String peek() {
		return pQueue.peek();
	}

	/**
	 * @return the highest priority element in the array and removes that element
	 */
	public String poll() {
		return pQueue.poll();
	}

	/**
	 * @return the entire queue unordered
	 */
	public String printQueue() {
		String print = new String();
		for (String element : pQueue) {
			print += element + "\n";
		}
		return print;
	}

}