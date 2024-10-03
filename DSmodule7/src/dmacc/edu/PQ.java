/** Priority Queue built with a linked list class
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

import java.util.LinkedList;

public class PQ {

	private LinkedList<Job> pq;
	private Job first;
	private int size;

	public PQ() {
		this.pq = new LinkedList<Job>();
		first = null;
		size = 0;
	}

	/**
	 * @return true if list is empty
	 */
	public boolean isEmpty() {
		return pq.isEmpty();
	}

	/**
	 * @return number of elements in the list
	 */
	public int size() {
		// i was unable to use the pq.size() since I wasn't using pq.add() 
		//the .size method wasn't working correctly
		return size;
	}

	/**
	 * @param input the job priority as a string
	 * 
	 * this function inserts the new job by searching the linked list
	 * to find its place at the back of its appropriate priority group
	 */
	public void offer(String input) {
		size++;
		Job newJob = new Job(input.toUpperCase());
		if (pq.isEmpty() == true) {
			pq.addFirst(newJob);
			first = newJob;
		} else {
			Job current = first;
			Job previous = null;
			while (current != null && newJob.compareTo(current) >= 0) {
				previous = current;
				current = current.next;
			}
			if (previous == null) {
				newJob.next = first;
				first = newJob;
			} else {
				previous.next = newJob;
				newJob.next = current;
			}
		}
	}

	/**
	 * @return the head of the list
	 */
	public String peek() {
		String data = new String();
		data = (first.job + ", " + first.priority);
		return data;
	}

	/**
	 * @return the head of the list then removes that object
	 */
	public String poll() {
		String data = new String();
		data = (first.job + ", " + first.priority);
		first = first.next;
		size--;
		return data;
	}

	/**
	 * @param in the priority of the job you are searching for
	 * @param jobNum the three digit job number you are searching for
	 * @return true if the job was found and removed from the list, else false
	 */
	public boolean remove(String in, int jobNum) {
		String priority = in.toUpperCase();
		Job current = first;
		Job previous = null;
		while (current != null && !(current.job == jobNum && current.priority.equals(priority))) {
			previous = current;
			current = current.next;
		}
		if (current == null) {
			return false;
		}
		if (current == first) {
			first = first.next;
		} else {
			previous.next = current.next;
		}
		size--;
		return true;
	}

	/**
	 * @return the entire list in sorted priority
	 */
	public String print() {
		String displayString = new String();
		Job current = first;
		while (current != null) {
			displayString += (current.job + ", " + current.priority + "\n");
			current = current.next;
		}
		return displayString;
	}

}
