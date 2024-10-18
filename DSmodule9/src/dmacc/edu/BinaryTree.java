package dmacc.edu;
/** Binary tree data structure
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
* this code was taken from 
* 
* Code for the program taken from: 
* Lafore, R. (2003). Data structures and algorithms in Java (2nd ed.). Sams Publishing.
*/
import java.util.Stack;

public class BinaryTree {
	
	private Node root;
	
	public BinaryTree() {
		root = null;
	}
	
	/**
	 * @param key integer you are searching for
	 * @return memory address of node if found, or null if not found
	 */
	public Node find(int key) {
		Node current = root;
		while(current.iData != key) {
			if (key < current.iData) {
				current = current.leftChild;
			} else {
				current = current.rightChild;
			}
			if(current == null) {
				return null;
			}
		}
		return current;
	}
	
	/**
	 * @param sd String to be added to the node
	 * @param dd integer to be added to the node used as a key 
	 */
	public void insert(String sd, int dd) {
		Node newNode = new Node();
		newNode.sData = sd;
		newNode.iData = dd;
		if(root == null) {
			root = newNode;
		} else {
			Node current = root;
			Node parent;
			boolean done = false;
			while(!done) {
				parent = current;
				if(dd < current.iData) {
					current = current.leftChild;
					if(current == null) {
						parent.leftChild = newNode;
						return;
					}
				} else {
					current = current.rightChild;
					if(current == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}
	
	/**
	 * @param key integer of node you want to delete
	 * @return true if item was found and removed
	 */
	public boolean delete(int key) {
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true;
		while(current.iData != key) {
			parent = current;
			if(key < current.iData) {
				isLeftChild = true;
				current = current.leftChild;
			} else {
				isLeftChild = false;
				current = current.rightChild;
			}
			if(current == null)
				return false;
			}
			if(current.leftChild == null && current.rightChild == null) {
				if(current == root)
					root = null;
				else if(isLeftChild)
					parent.leftChild = null;
				else
					parent.rightChild = null;
			}
			else if(current.rightChild == null)
				if(current == root)
					root = current.leftChild;
				else if(isLeftChild)
					parent.leftChild = current.leftChild;
				else
					parent.rightChild = current.leftChild;
			
			else if(current.leftChild == null)
				if(current == root)
					root = current.rightChild;
				else if(isLeftChild)
					parent.leftChild = current.rightChild;
				else
					parent.rightChild = current.rightChild;
			else {
				Node successor = getSuccessor(current);
				if (current == root)
					root = successor;
				else if(isLeftChild)
					parent.leftChild = successor;
				else
					parent.rightChild = successor;
				successor.leftChild = current.leftChild;
			}
			return true;
	}
	
	/**
	 * @param delNode the node you want to delete
	 * @return the parent of the node you want to delete
	 */
	private Node getSuccessor(Node delNode) {
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.rightChild;
		while(current != null) {
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}
		if(successor != delNode.rightChild) {
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}
		return successor;
	}
	
	/**
	 * @param traverseType 1 = preOrder, 2 = inOrder, 3 = postOrder
	 */
	public void traverse(int traverseType) {
		String printString = "";
		switch(traverseType) {
			case 1: System.out.print("\nPreorder traversal:" );
				System.out.print(preOrder(root));
				break;
			case 2: System.out.print("\nInorder traversal:  ");
				System.out.print(inOrder(root));
				break;
			case 3: System.out.print("\nPostorder traversal: ");
				System.out.print(postOrder(root));
				break;
		}
	}
	
	/**
	 * @param localRoot starting Node for tree traversal
	 * @return all nodes in the tree from root -> left -> right
	 */
	private String preOrder(Node localRoot) {
		String printString = "";
		if(localRoot != null) {
			printString = (localRoot.sData + " ");
			printString += preOrder(localRoot.leftChild);
			printString += preOrder(localRoot.rightChild);
		}
		return printString;
	}
	
	/**
	 * @param localRoot starting Node for tree traversal
	 * @return all nodes in the tree from left -> root -> right
	 */
	private String inOrder(Node localRoot) {
		String printString = "";
		if(localRoot != null) {
			printString = inOrder(localRoot.leftChild);
			printString += (localRoot.sData + " ");
			printString += inOrder(localRoot.rightChild);
		}
		return printString;
	}
	
	/**
	 * @param localRoot starting Node for tree traversal
	 * @return all nodes in the tree from left -> right -> root
	 */
	private String postOrder(Node localRoot) {
		String printString = "";
		if(localRoot != null) {
			printString = postOrder(localRoot.leftChild);
			printString += postOrder(localRoot.rightChild);
			printString += (localRoot.sData + " ");
		}
		return printString;
	}
	
	/**
	 * prints the string item in all nodes displayed to resemble a tree 
	 */
	public void displayTree() {
		Stack globalStack = new Stack();
		globalStack.push(root);
		int leftSpace = 32;
		boolean isRowEmpty = false;
		System.out.println("............................................");
		while(!isRowEmpty) {
			Stack localStack = new Stack();
			isRowEmpty = true;
			
			for(int i = 0; i < leftSpace; i++)
				System.out.print(" ");
			
			while(!globalStack.isEmpty()) {
				Node temp = (Node)globalStack.pop();
				if(temp != null) {
					System.out.print(temp.sData);
					localStack.push(temp.leftChild);
					localStack.push(temp.rightChild);
					if(temp.leftChild != null || temp.rightChild != null)
						isRowEmpty = false;
				} else {
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
				for(int i = 0; i < leftSpace*2-2; i++)
					System.out.print(" ");
			}
			System.out.println();
			leftSpace /= 2;
			while(!localStack.isEmpty())
				globalStack.push(localStack.pop());
		}
		System.out.println("............................................");
	}
}

