package dmacc.edu;
/** Node class for BinaryTree class
 * @author Isaac Coddington-idcoddington@dmacc.edu 
 * @version 1.0
 * @since 1.0
 *Oct 15, 2024 
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
* 
* Code for the program taken from: 
* Lafore, R. (2003). Data structures and algorithms in Java (2nd ed.). Sams Publishing.
*/


public class Node {

	public String sData;
	public int iData;
	public Node leftChild;
	public Node rightChild;
	
	/**
	 * @return the data stored in the node as a string
	 */
	public String displayNode() {
;		return ("{" + sData + ", " + iData + "}");
	}
}
