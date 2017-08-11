package org.yathiraja.ds.graph;

import java.util.HashSet;

/**
 * Created by rkrishnamoorthy on 08/08/17.
 */
public class DFS {

    public boolean hasNodeDFS(Graph<Integer> sourceNode, Graph<Integer> destinationNode) {
//        Graph<Integer> sourceNode = new Graph<Integer>(source);
//        Graph<Integer> destinationNode = new Graph<Integer>(destination);
        HashSet<Integer> visited = new HashSet<Integer>();
        return hasNodeDFS(sourceNode, destinationNode, visited);
    }

    private boolean hasNodeDFS(Graph<Integer> sourceNode, Graph<Integer> destinationNode, HashSet<Integer> visited) {
        if(visited.contains(sourceNode.identifier)) {
            return false;
        }
        visited.add(sourceNode.identifier);
        if(sourceNode == destinationNode) {
            return true;
        }
        for(Graph child:sourceNode.adjacent) {
            if(hasNodeDFS( child, destinationNode, visited)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Graph<Integer> root = new Graph<Integer>(5);
        Graph<Integer> child1 = new Graph<Integer>(2);
        Graph<Integer> child2 = new Graph<Integer>(21);
        Graph<Integer> child3 = new Graph<Integer>(7);
        Graph<Integer> child4 = new Graph<Integer>(12);
        Graph<Integer> child5 = new Graph<Integer>(4);
        Graph<Integer> child6 = new Graph<Integer>(19);
        Graph<Integer> child7 = new Graph<Integer>(1);
        Graph<Integer> child8 = new Graph<Integer>(25);
        root.adjacent.add(child1);
        root.adjacent.add(child2);
        root.adjacent.add(child3);
        child1.adjacent.add(child4);
        child2.adjacent.add(child5);
        child2.adjacent.add(child6);
        child3.adjacent.add(child7);
        child3.adjacent.add(child8);
        System.out.println(new DFS().hasNodeDFS(root,new Graph<Integer>(19)));
        System.out.println(new DFS().hasNodeDFS(root,new Graph<Integer>(33)));

    }
}
