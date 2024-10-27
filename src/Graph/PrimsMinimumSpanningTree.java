package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrimsMinimumSpanningTree {

    public List<Edge<Integer>> findMinimumSpanningTree(Graph<Integer> graph) {
        List<Edge<Integer>> result = new ArrayList<>();

        BinaryMinHeap<Vertex<Integer>> minHeap = new BinaryMinHeap<Vertex<Integer>>();
        Map<Vertex<Integer>, Edge<Integer>> spanningTree = new HashMap<Vertex<Integer>, Edge<Integer>>();

        for(Vertex<Integer> vertex : graph.getAllVertex()) {
            minHeap.add(Integer.MAX_VALUE,vertex);
        }

        Vertex<Integer> sourceVertex = graph.getAllVertex().iterator().next();
        minHeap.decrease(sourceVertex, 0);
        while(!minHeap.empty()) {
            Vertex<Integer> current = minHeap.extractMin();
            if(spanningTree.containsKey(current)) {
                result.add(spanningTree.get(current));
            }
            /*Edge<Integer> spanningTreeEdge = spanningTree.get(current);
            if(spanningTreeEdge != null) {
                result.add(spanningTreeEdge);
            }*/

            for (Edge<Integer> edge : current.getEdges()) {
                Vertex<Integer> adjacent = getAdjacentVertex(current, edge);
                if(minHeap.containsData(adjacent) && edge.getWeight() < minHeap.getWeight(adjacent)) {
                    minHeap.decrease(adjacent, edge.getWeight());
                    spanningTree.put(adjacent, edge);
                }
            }
        }
        return result;
    }

    public Vertex<Integer>  getAdjacentVertex(Vertex<Integer> source, Edge<Integer> edge) {
        return edge.getVertex1().equals(source) ?  edge.getVertex2() : edge.getVertex1();
    }


    public static void main(String[] args){
        Graph<Integer> graph = new Graph<Integer>(false);
        graph.addEdge(0, 1, 4);
        graph.addEdge(1, 2, 8);
        graph.addEdge(2, 3, 7);
        graph.addEdge(3, 4, 9);
        graph.addEdge(4, 5, 10);
        graph.addEdge(2, 5, 4);
        graph.addEdge(1, 7, 11);
        graph.addEdge(0, 7, 8);
        graph.addEdge(2, 8, 2);
        graph.addEdge(3, 5, 14);
        graph.addEdge(5, 6, 2);
        graph.addEdge(6, 8, 6);
        graph.addEdge(6, 7, 1);
        graph.addEdge(7, 8, 7);

        /*graph.addEdge(1, 2, 3);
        graph.addEdge(2, 3, 1);
        graph.addEdge(3, 1, 1);
        graph.addEdge(1, 4, 1);
        graph.addEdge(2, 4, 3);
        graph.addEdge(4, 5, 6);
        graph.addEdge(5, 6, 2);
        graph.addEdge(3, 5, 5);
        graph.addEdge(3, 6, 4);*/
        PrimsMinimumSpanningTree prims = new PrimsMinimumSpanningTree();
        List<Edge<Integer>> edges = prims.findMinimumSpanningTree(graph);
        for (Edge<Integer> edge : edges ) {
            System.out.println(edge);
        }


    }
}
