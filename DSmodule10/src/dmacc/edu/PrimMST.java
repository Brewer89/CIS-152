package dmacc.edu;
/** Program for finding the MST using prims algorithm
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
* taken from https://www.geeksforgeeks.org/prims-minimum-spanning-tree-mst-greedy-algo-5/
*/


//A Java program for Prim's Minimum Spanning Tree (MST)
//algorithm. The program is for adjacency list
//representation of the graph

import java.util.*;

//Class to form pair
class Pair implements Comparable<Pair> {
 int v;
 int wt;

 Pair(int v, int wt) {
     this.v = v;
     this.wt = wt;
 }

 public int compareTo(Pair that) {
     return this.wt - that.wt;
 }
}

public class PrimMST {
 static Map<String, Integer> vertexMap = new HashMap<>();
 static int vertexCount = 0;

 // Function to map string vertices to integer indices
 static int getVertexIndex(String vertex) {
     if (!vertexMap.containsKey(vertex)) {
         vertexMap.put(vertex, vertexCount++);
     }
     return vertexMap.get(vertex);
 }

 // Function of spanning tree
 static int spanningTree(int V, List<Edge> edges) {
     ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
     for (int i = 0; i < V; i++) {
         adj.add(new ArrayList<Pair>());
     }

     for (Edge edge : edges) {
         int u = getVertexIndex(edge.src);
         int v = getVertexIndex(edge.dest);
         int wt = edge.weight;
         adj.get(u).add(new Pair(v, wt));
         adj.get(v).add(new Pair(u, wt));
     }

     PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
     pq.add(new Pair(0, 0));
     int[] vis = new int[V];
     int s = 0;
     while (!pq.isEmpty()) {
         Pair node = pq.poll();
         int v = node.v;
         int wt = node.wt;
         if (vis[v] == 1)
             continue;

         s += wt;
         vis[v] = 1;
         for (Pair it : adj.get(v)) {
             if (vis[it.v] == 0) {
                 pq.add(new Pair(it.v, it.wt));
             }
         }
     }
     return s;
 }

 // Driver code
 public static void main(String[] args) {
     List<Edge> graph = new ArrayList<Edge>(
             List.of(new Edge("N", "C", 2), new Edge("C", "T", 7),
                     new Edge("T", "F", 4), new Edge("N", "P", 4),
                     new Edge("N", "R", 2), new Edge("P", "G", 2),
                     new Edge("G", "Q", 2), new Edge("Q", "T", 3),
                     new Edge("Q", "A", 2), new Edge("A", "H", 3),
                     new Edge("Q", "H", 3), new Edge("P", "H", 3),
                     new Edge("R", "H", 6)));

     // Total number of vertices
     int V = 10;
     // Call the spanning tree function and print the result
     System.out.println("Total cost of MST: " + spanningTree(V, graph));
 }
}

//Class representing an edge
class Edge {
 String src, dest;
 int weight;

 public Edge(String src, String dest, int weight) {
     this.src = src;
     this.dest = dest;
     this.weight = weight;
 }
}

