package dmacc.edu;
/** level order traversal method and in order traversal
 * @author Isaac Coddington-idcoddington@dmacc.edu 
 * @version 1.0
 * @since 1.0
 *Oct 17, 2024 
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

import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversal {

	/**
	 * @param root Node where level order traversal will start
	 * 
	 * this method traverses the tree level by level starting at the
	 * root by using a loop and queue. It polls root, prints the data in
	 * root then adds the left and right children to the queue. On the
	 * next iteration of the loop it polls the left and right children
	 * prints the data of those children then adds the children of the
	 * polled nodes to the queue.
	 * 
	 * This would be considered BFS Breadth First Search traversal
	 * 
	 * the levelOrderTraversal method is taken from the following website:
	 * https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/#level-order-traversal
	 */
	static void levelOrderTraversal(Node root) {
		if (root == null)
			return;

		Queue<Node> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			Node curr = q.poll();
			System.out.print(curr.sData + " ");

			if (curr.leftChild != null)
				q.add(curr.leftChild);
			if (curr.rightChild != null)
				q.add(curr.rightChild);
		}
	}

	/**
	 * @param node the starting node for the tree traversal
	 * 
	 * This method uses recursion to visit all nodes in a tree the order
	 * goes from left -> root -> right so it will visit all nodes in the
	 * left subtree, then root, then all nodes in the right subtree.
	 * 
	 * this would be considered DFS Depth First Search traversal
	 * 
	 * code for inOrderTraversal method taken from 
	 * Lafore, R. (2003). Data structures and algorithms in Java (2nd ed.). Sams Publishing.
	 */
	static void inOrderTraversal(Node node) {
		if (node == null)
			return;

		inOrderTraversal(node.leftChild);
		System.out.print(node.sData + " ");
		inOrderTraversal(node.rightChild);
	}
}
