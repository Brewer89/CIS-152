package dmacc.edu;
/** example of kruskals solution to a minimum spanning tree
 * @author Isaac Coddington-idcoddington@dmacc.edu 
 * @version 1.0
 * @since 1.0
 *Oct 23, 2024 
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
* code taken from https://www.geeksforgeeks.org/kruskals-minimum-spanning-tree-algorithm-greedy-algo-2/
*/


//Java program for Kruskal's algorithm 

import java.util.ArrayList; 
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set; 

public class MinimumSpanningTree { 

	// Defines edge structure 
	static class Edge { 
		String src, dest; int weight; 

		public Edge(String src, String dest, int weight) 
		{ 
			this.src = src; 
			this.dest = dest; 
			this.weight = weight; 
		} 
	} 

	// Defines subset element structure 
	static class Subset { 
		String parent; 
		int rank; 

		public Subset(String parent, int rank) 
		{ 
			this.parent = parent; 
			this.rank = rank; 
		} 
	} 

	// Starting point of program execution 
	public static void main(String[] args) 
	{  
		List<Edge> graphEdges = new ArrayList<Edge>( 
			List.of(new Edge("N", "C", 2), new Edge("C", "T", 7), 
					new Edge("T", "F", 4), new Edge("N", "P", 4), 
					new Edge("N", "R", 2), new Edge("P", "G", 2), 
					new Edge("G", "Q", 2), new Edge("Q", "T", 3), 
					new Edge("Q", "A", 2), new Edge("A", "H", 3), 
					new Edge("Q", "H", 3), new Edge("P", "H", 3), 
					new Edge("R", "H", 6))); 

		// Sort the edges in non-decreasing order 
		// (increasing with repetition allowed) 
        // Sort the edges in non-decreasing order by weight
        graphEdges.sort(Comparator.comparingInt(o -> o.weight));

        // List of unique vertices
        Set<String> vertices = new HashSet<>();
        for (Edge edge : graphEdges) {
            vertices.add(edge.src);
            vertices.add(edge.dest);
        }

        kruskals(vertices, graphEdges);
    }

    // Kruskal's algorithm to find the MST
    private static void kruskals(Set<String> vertices, List<Edge> edges) {
        Map<String, Subset> subsets = new HashMap<>();
        List<Edge> result = new ArrayList<>();

        // Initialize subsets for each vertex
        for (String vertex : vertices) {
            subsets.put(vertex, new Subset(vertex, 0));
        }

        int noOfEdges = 0;
        int i = 0;

        // Number of edges in MST should be V-1 (where V is number of vertices)
        while (noOfEdges < vertices.size() - 1 && i < edges.size()) {
            Edge nextEdge = edges.get(i++);
            String rootX = findRoot(subsets, nextEdge.src);
            String rootY = findRoot(subsets, nextEdge.dest);

            // If they do not form a cycle, include this edge
            if (!rootX.equals(rootY)) {
                result.add(nextEdge);
                union(subsets, rootX, rootY);
                noOfEdges++;
            }
        }

        // Print the MST
        System.out.println("Following are the edges in the constructed MST:");
        int minCost = 0;
        for (Edge edge : result) {
            System.out.println(edge.src + " -- " + edge.dest + " == " + edge.weight);
            minCost += edge.weight;
        }
        System.out.println("Total cost of MST: " + minCost);
    }

    // Function to find the root of a vertex
    private static String findRoot(Map<String, Subset> subsets, String vertex) {
        if (!subsets.get(vertex).parent.equals(vertex)) {
            subsets.get(vertex).parent = findRoot(subsets, subsets.get(subsets.get(vertex).parent).parent);
        }
        return subsets.get(vertex).parent;
    }

    // Union by rank
    private static void union(Map<String, Subset> subsets, String rootX, String rootY) {
        Subset subsetX = subsets.get(rootX);
        Subset subsetY = subsets.get(rootY);

        if (subsetX.rank < subsetY.rank) {
            subsetX.parent = rootY;
        } else if (subsetX.rank > subsetY.rank) {
            subsetY.parent = rootX;
        } else {
            subsetY.parent = rootX;
            subsetX.rank++;
        }
    }
}
