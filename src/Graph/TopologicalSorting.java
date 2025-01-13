package Graph;

import javax.swing.*;
import java.util.*;

//vertex means nodes.
// Edge is line between two nodes.
public class TopologicalSorting<T> {

    public Deque<Vertex<T>> topSort(Graph<T> graph) {
        Deque<Vertex<T>> stack = new ArrayDeque<>();
        Set<Vertex<T>> visited = new HashSet<>();
        for(Vertex<T> vertex : graph.getAllVertex()) {
            if(visited.contains(vertex)) {
                continue;
            }
            topSortUtil( vertex, stack, visited);
        }
        return stack;
    }

    public void topSortUtil(Vertex<T> vertex, Deque<Vertex<T>> stack, Set<Vertex<T>> visited){
        visited.add(vertex);
        for(Vertex<T> adjust : vertex.getAdjacentVertexes()) {
            if(visited.contains(adjust)) {
                continue;
            }
            topSortUtil(adjust, stack, visited);
        }
        stack.offerFirst(vertex);
    }
    public static void main(String[] args){
        Graph<Integer> graph = new Graph<Integer>(true);
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(5, 6);
        graph.addEdge(6, 3);
        graph.addEdge(3, 8);
        graph.addEdge(8, 11);
        TopologicalSorting<Integer> ts = new TopologicalSorting<Integer>();
        Deque<Vertex<Integer>> result = ts.topSort(graph);
        while(!result.isEmpty()) {
            System.out.println(result.poll());
        }

    }

}
