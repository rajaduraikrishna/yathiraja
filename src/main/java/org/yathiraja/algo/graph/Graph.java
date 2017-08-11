package org.yathiraja.algo.graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by rkrishnamoorthy on 07/08/17.
 */
public class Graph {
    private int V;
    private LinkedList<Integer> adj[];
    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for(int i=0;i<v;i++) {
            adj[i] =  new LinkedList<Integer>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public void DFS(int x) {
        boolean[] visited = new boolean[V];
        DFS(x, visited);
    }

    private void DFS(int x, boolean[] visited) {
        visited[x] = true;
        System.out.println(x +" ");
        Iterator<Integer> iter = adj[x].listIterator();
        while(iter.hasNext()) {
            int r = iter.next();
            if(!visited[r])
                DFS(r,visited);
        }
    }
    
    public void BFS(int x) {
        boolean[] visited = new boolean[V];
        BFS(x, visited);
    }

    private void BFS(int x, boolean[] visited) {
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(x);

        while(queue.size() != 0) {
            int v = queue.poll();
            visited[v] = true;
            System.out.println(v + " ");
            Iterator<Integer> iter = adj[v].listIterator();
            while(iter.hasNext()) {
                int r = iter.next();
                if(!visited[r]) {
                    visited[r] = true;
                    queue.add(r);
                }
            }
        }
    }



    public static void main(String []args) {
        Graph g = new Graph(4);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,1);
        g.addEdge(2,0);
        g.addEdge(2,3);
        g.addEdge(3,3);
        //g.DFS(3);
        g.DFS(2);

        g.BFS(2);
    }
}
