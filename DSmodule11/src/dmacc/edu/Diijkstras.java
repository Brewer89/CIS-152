package dmacc.edu;
/** Diijkstras algorithm for finding the shortest distance
 * @author Isaac Coddington-idcoddington@dmacc.edu 
 * @version 1.0
 * @since 1.0
 *Oct 29, 2024 
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
* Code taken from https://www.geeksforgeeks.org/dijkstras-algorithm-for-adjacency-list-representation-greedy-algo-8/
* with some modifications
*/
import java.util.*;

class Diijkstras {
	static class AdjListNode {
		int vertex;
		int weight;

		AdjListNode(int v, int w)
		{
			vertex = v;
			weight = w;
		}
		int getVertex() { return vertex; }
		int getWeight() { return weight; }
	}

	// Function to find the shortest distance of all the
	// vertices from the source vertex S.
	public static int[] dijkstra(
		int V, ArrayList<ArrayList<AdjListNode> > graph,
		int src)
	{
		int[] distance = new int[V];
		for (int i = 0; i < V; i++)
			distance[i] = Integer.MAX_VALUE;
		distance[src] = 0;

		PriorityQueue<AdjListNode> pq = new PriorityQueue<>(
			(v1, v2) -> v1.getWeight() - v2.getWeight());
		pq.add(new AdjListNode(src, 0));

		while (pq.size() > 0) {
			AdjListNode current = pq.poll();

			for (AdjListNode n :
				graph.get(current.getVertex())) {
				if (distance[current.getVertex()]
						+ n.getWeight()
					< distance[n.getVertex()]) {
					distance[n.getVertex()]
						= n.getWeight()
						+ distance[current.getVertex()];
					pq.add(new AdjListNode(
						n.getVertex(),
						distance[n.getVertex()]));
				}
			}
		}
		// If you want to calculate distance from source to
		// a particular target, you can return
		// distance[target]
		return distance;
	}

	public static void main(String[] args)
	{
		int V = 10;
		Map<Integer, String> stringMap = new HashMap<>();
		stringMap.put(0, "N");
		stringMap.put(1, "C");
		stringMap.put(2, "R");
		stringMap.put(3, "P");
		stringMap.put(4, "G");
		stringMap.put(5, "T");
		stringMap.put(6, "Q");
		stringMap.put(7, "H");
		stringMap.put(8, "A");
		stringMap.put(9, "F");
		ArrayList<ArrayList<AdjListNode> > graph
			= new ArrayList<>();
		for (int i = 0; i < V; i++) {
			graph.add(new ArrayList<>());
		}
		int source = 0;
		graph.get(0).add(new AdjListNode(1, 2));
		graph.get(0).add(new AdjListNode(2, 2));
		graph.get(0).add(new AdjListNode(3, 4));
		graph.get(1).add(new AdjListNode(5, 7));
		graph.get(1).add(new AdjListNode(0, 2));
		graph.get(2).add(new AdjListNode(7, 6));
		graph.get(2).add(new AdjListNode(0, 2));
		graph.get(3).add(new AdjListNode(4, 2));
		graph.get(3).add(new AdjListNode(7, 3));
		graph.get(3).add(new AdjListNode(0, 4));
		graph.get(4).add(new AdjListNode(3, 2));
		graph.get(4).add(new AdjListNode(6, 2));
		graph.get(5).add(new AdjListNode(9, 4));
		graph.get(5).add(new AdjListNode(1, 7));
		graph.get(5).add(new AdjListNode(6, 3));
		graph.get(6).add(new AdjListNode(7, 3));
		graph.get(6).add(new AdjListNode(4, 2));
		graph.get(6).add(new AdjListNode(5, 3));
		graph.get(6).add(new AdjListNode(8, 2));
		graph.get(7).add(new AdjListNode(2, 6));
		graph.get(7).add(new AdjListNode(6, 3));
		graph.get(7).add(new AdjListNode(8, 3));
		graph.get(8).add(new AdjListNode(6, 2));
		graph.get(8).add(new AdjListNode(7, 3));
		
		

		int[] distance = dijkstra(V, graph, source);
		// Printing the Output
		System.out.println("Vertex "
						+ " Distance from Source");
		for (int i = 0; i < V; i++) {
			System.out.println(stringMap.get(i) + "			 "
							+ distance[i]);
		}
	}
}

