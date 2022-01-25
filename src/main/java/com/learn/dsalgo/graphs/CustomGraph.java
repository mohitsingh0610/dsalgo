package com.learn.dsalgo.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class CustomGraph<T> {

    private Map<T, List<T>> adj;

    private int vertices;

    public CustomGraph(int v) {
        adj = new HashMap<>(v);
        this.vertices = v;
    }

    public void addEdge(T source, T destination) {

        List<T> sourceLs = adj.get(source);
        List<T> destinationLs = adj.get(destination);

        // Put destionation node in the adjacency map for source key
        if (sourceLs == null) {
            sourceLs = new LinkedList<>();
        }
        sourceLs.add(destination);
        adj.put(source, sourceLs);

        // In case of undirected graph, if there is a connection from A to B then there
        // will be connection from B to A as well.
        // Hence , put source node in the adjacency map for destination key
        if (destinationLs == null) {
            destinationLs = new LinkedList<>();
        }
        destinationLs.add(source);
        adj.put(destination, destinationLs);
    }

    public void print() {
        if (adj != null) {
            adj.entrySet().stream()
                    .forEach(e -> {
                        System.out.print(e.getKey() + " -> ");
                        e.getValue().forEach(v -> System.out.print(v + " "));
                        System.out.println();
                    });
        } else {
            System.out.println("Graph is empty");
        }
    }

    /**
     * BFS is implemented using queque. O(V+E) where V is a number of vertices in
     * the graph and E is a number of edges in the graph.
     */
    public int bfs(T source, T destination) {
        List<T> visited = new ArrayList<>(vertices);
        Map<T, T> nodeToParentMap = new HashMap<>();
        // Mark the source node as visited because it is starting point.
        visited.add(source);
        nodeToParentMap.put(source, source);
        Queue<T> q = new LinkedList<>();
        q.offer(source);

        // Iterate till the queque is empty means till all the nodes are visited.
        while (!q.isEmpty()) {
            T cur = q.poll();

            // If current is equal to destination then stop and come out of the loop
            if (cur.equals(destination)) {
                break;
            }
            // Add all the adjacent node of current node to queque if its not visited.
            adj.get(cur).forEach(e -> {
                if (!visited.contains(e)) {
                    visited.add(e);
                    q.offer(e);
                    nodeToParentMap.put(e, cur);
                }
            });
        }
        T cur = destination;
        int distance = 0;
        while (nodeToParentMap.get(cur) != cur) {
            System.out.print(cur + " -> ");
            cur = nodeToParentMap.get(cur);
            distance++;
        }
        System.out.print(source);
        System.out.println();
        return distance;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of vertices and edges");
        int v = sc.nextInt();
        int e = sc.nextInt();
        /**
         * CustomGraph<Integer> graph = new CustomGraph<>(v);
         * 
         * System.out.println("Enter " + e + " edges");
         * for(int i= 0; i<e; i++){
         * Integer source = sc.nextInt();
         * Integer destination = sc.nextInt();
         * graph.addEdge(source, destination);
         * }
         */
        CustomGraph<String> graph = new CustomGraph<>(v);

        System.out.println("Enter " + e + " edges");
        for (int i = 0; i < e; i++) {
            String source = sc.next();
            String destination = sc.next();
            graph.addEdge(source, destination);
        }
        // graph.print();
        System.out.println("Shortest distance is " + graph.bfs("A", "E"));
        sc.close();
    }

}
