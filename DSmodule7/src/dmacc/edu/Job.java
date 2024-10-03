/** Program description
 * @author Isaac Coddington-idcoddington@dmacc.edu 
 * @version 1.0
 * @since 1.0
 *Oct 1, 2024 
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

import java.util.Random;

public class Job implements Comparable<Job> {
	//attributes
	int job;
	String priority;
	Job next;
	//constructors
	public Job(String input) {
		this.job = jobNumberGenerator();
		this.priority = input;
		this.next = null;
	}
	
	public Job(String input, int jobNum) {
		this.job = jobNum;
		this.priority = input;
		this.next = null;
	}
	
	/**
	 * @return the job number
	 */
	public int getJob() {
		return this.job;
	}
	
	/**
	 * @return the priority
	 */
	public String getPriority() {
		return this.priority;
	}
	
	/**
	 * @return 1 if this object has lower priority then the parameter, 
	 * 0 if this object has equal priority, 
	 * -1 if this object has higher priority
	 * 
	 * @param the object you want to compare to
	 */
	public int compareTo(Job other) {
		return this.getPriority().compareTo(other.getPriority());
	}
	
	/**
	 * @return a random three digit number as the job number
	 */
	private int jobNumberGenerator() {
		Random rand = new Random();
		final int MAX = 999;
		final int MIN = 100;
		return rand.nextInt((MAX - MIN + 1) + MIN);
	}
	
}
