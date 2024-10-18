package dmacc.edu;
/** Driver for binary tree class
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
*/

public class TreeDriver {

	public static void main(String[] args) {
		
		BinaryTree dataStructures153 = new BinaryTree();
		
		dataStructures153.insert("Array", 2);
		dataStructures153.insert("Stack", 3);
		dataStructures153.insert("Queue", 4);
		dataStructures153.insert("List", 5);
		dataStructures153.insert("Linked list", 6);
		dataStructures153.insert("Priority Queue", 7);
		dataStructures153.insert("Tree", 9);
		/*
		 * The height from root to the longest leaf is 6
		 * It is not a complete or balanced tree as only the 
		 * right most child nodes are populated since they are larger
		 * numbers then the parent nodes
		 * */
		dataStructures153.displayTree();
		
		int moduleToFind = 5;
		System.out.println("Memory address of Node: " + dataStructures153.find(moduleToFind));
		moduleToFind = 11;
		System.out.println("Memory address of Node: " + dataStructures153.find(moduleToFind));
		
		BinaryTree myFavorites = new BinaryTree();
		/*
		 * Linked list(6) is my favorite to work with as it has no
		 * size limit and its ease of use. Queue(4) is second because it follows the
		 * FIFO order which makes practical sense to me.
		 * The rest are in no particular order until tree(9), as that is my least
		 * favorite as it seems complex. I'm sure if I saw more practical
		 * applications and used it more it would become easier for me.
		 * */
		myFavorites.insert("Linked list", 6);
		myFavorites.insert("Queue", 4);
		myFavorites.insert("Array", 2);
		myFavorites.insert("List", 5);
		myFavorites.insert("Stack", 3);
		myFavorites.insert("Priority Queue", 7);
		myFavorites.insert("Tree", 9);
		/*
		 * The height from root to the longest leaf is 3
		 * It is not a complete tree as there is an empty node after priority queue
		 * it is a balanced tree as the difference in height from the left and right
		 * subtree is only 1
		 * 
		 * It is very different from dataStructures153 tree.
		 * The height is much smaller. It is a balanced tree.
		 * Less empty nodes when you print the tree.
		 * 
		 * */
		myFavorites.displayTree();
	}

}
