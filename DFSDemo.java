package Button;
import java.io.*;
import java.util.*;


class DFSDemo {
 private int V; 

//Mảng Các điểm từ 1 điểm đi đến
 private LinkedList<Integer> adj[];

 // Constructor
 @SuppressWarnings("unchecked")
   DFSDemo(int v)
 {
     V = v;
     adj = new LinkedList[v];
     for (int i = 0; i < v; ++i)
         adj[i] = new LinkedList();
 }

 
 void addEdge(int v, int w)
 {
     adj[v].add(w); 
 }

 //Hàm tìm đường đi
 void DFSUtil(int v, boolean visited[])
 {
     // Mark the current node as visited and print it
     visited[v] = true;
     System.out.print(v + " ");

     // Đường đi nếu tồn tại thì check ko thì quay lui
     Iterator<Integer> i = adj[v].listIterator();
     while (i.hasNext())
     {
         int n = i.next();
         if (!visited[n])
             DFSUtil(n, visited);
     }
 }

 
 void DFS(int v)
 {
     
     boolean visited[] = new boolean[V];

     //Thăm 
     DFSUtil(v, visited);
 }

// Run
 public static void main(String args[])
 {
     DFSDemo g = new DFSDemo(5);

     g.addEdge(0, 1);
     g.addEdge(0, 2);
     g.addEdge(1, 2);
     g.addEdge(2, 0);
     g.addEdge(2, 3);
     g.addEdge(3, 3);

     System.out.println(
         "Following is Depth First Traversal "
         + "(starting from vertex 2)");

     g.DFS(2);
 }
}
