/** Program description
 * @author Isaac Coddington-idcoddington@dmacc.edu 
 * @version 1.0
 * @since 1.0
 *Oct 2, 2024 
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

import java.util.Scanner;

public class PQDriver {

	public static void main(String[] args) {
		//create priority queue
		PQ job = new PQ();
		job.offer("NN");
		job.offer("OO");
		job.offer("OO");
		job.offer("OO");
		job.offer("MM");
		job.offer("MM");
		System.out.println(job.peek() + "\n");
		System.out.println(job.size());
		System.out.println(job.print());
		//This block is to check the remove function it will need user input to run. 
		 /*
		Scanner in = new Scanner(System.in);
		System.out.println("Input job priority to remove");
		String priority = in.next();
		System.out.println("Input job number to remove");
		int jobNum = in.nextInt();
		System.out.println(job.remove(priority, jobNum));
		in.close();
		*/
		System.out.println(job.poll() + "\n");
		System.out.println(job.size() + "\n");
		System.out.println(job.print());
		
	}

}
