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

public class JobQueueDriver {

	public static void main(String[] args) {
		JobQueue jq = new JobQueue();
		//
		jq.add("NN");
		jq.add("OO");
		jq.add("OO");
		jq.add("OO");
		//
		System.out.println(jq.printQueue());
		
		jq.add("MM");
		jq.add("MM");
		System.out.println(jq.printQueue());
		//
		System.out.println(jq.poll());
		System.out.println(jq.poll() + "\n");
		System.out.println(jq.printQueue());
		

	}

}
