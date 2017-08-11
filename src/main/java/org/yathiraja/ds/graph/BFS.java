package org.yathiraja.ds.graph;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by rkrishnamoorthy on 08/08/17.
 */
public class BFS {

    public boolean hasNodeBFS(Graph<Integer> sourceNode, Integer destination) {
        Graph<Integer> destinationNode = new Graph<Integer>(destination);

        return hasNodeBFS(sourceNode, destinationNode);
    }

    private boolean hasNodeBFS(Graph<Integer> sourceNode, Graph<Integer> destinationNode) {
        HashSet<Integer> visited = new HashSet<Integer>();
        LinkedList<Graph<Integer>> nextToVisit = new LinkedList<Graph<Integer>>();

        nextToVisit.add(sourceNode);
        while(!nextToVisit.isEmpty()) {
            Graph<Integer> node = nextToVisit.remove();
            System.out.println(node.identifier);
            if(node == destinationNode) {
                return true;
            }
            if(visited.contains(node.identifier)) {
                continue;
            }
            visited.add(node.identifier);

            nextToVisit.addAll(node.adjacent);

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
        System.out.println(new BFS().hasNodeBFS(root,1));
        System.out.println(new BFS().hasNodeBFS(root,33));

    }
}
