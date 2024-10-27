package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DijkstraSP {

    public Map<Vertex<Integer>, Integer> findDSPMinimumSpanningTree(Graph<Integer> graph, Vertex<Integer> sourceVertex) {
        Map<Vertex<Integer>, Integer> distance = new HashMap<>();

        BinaryMinHeap<Vertex<Integer>> minHeap = new BinaryMinHeap<Vertex<Integer>>();
        Map<Vertex<Integer>, Vertex<Integer>> parent = new HashMap<Vertex<Integer>, Vertex<Integer>>();

        for(Vertex<Integer> vertex : graph.getAllVertex()) {
            minHeap.add(Integer.MAX_VALUE,vertex);
        }
        minHeap.decrease(sourceVertex, 0);
        parent.put(sourceVertex, null);
        distance.put(sourceVertex, 0);
        while(!minHeap.empty()) {
            BinaryMinHeap<Vertex<Integer>>.Node node = minHeap.extractMinNode();
            Vertex<Integer> current = node.key;
            distance.put(current, node.weight);

            /*Edge<Integer> spanningTreeEdge = parent.get(current);
            if(spanningTreeEdge != null) {
                distance.add(spanningTreeEdge);
            }*/

            for (Edge<Integer> edge : current.getEdges()) {
                Vertex<Integer> adjacent = getAdjacentVertex(current, edge);
                if(!minHeap.containsData(adjacent)) {
                    continue;
                }
                int newDistance = distance.get(current) + edge.getWeight();
                if(newDistance < minHeap.getWeight(adjacent)) {
                    minHeap.decrease(adjacent, newDistance);
                    parent.put(adjacent, current);
                }
            }
        }
        return distance;
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

        /*graph.addEdge(1, 2, 5);
        graph.addEdge(2, 3, 2);
        graph.addEdge(1, 4, 9);
        graph.addEdge(1, 5, 3);
        graph.addEdge(5, 6, 2);
        graph.addEdge(6, 4, 2);
        graph.addEdge(3, 4, 3);*/
        DijkstraSP dsp = new DijkstraSP();
        Vertex<Integer> sourceVertex = graph.getVertex(1);
        Map<Vertex<Integer>, Integer>  distance = dsp.findDSPMinimumSpanningTree(graph, sourceVertex);
        System.out.println(distance);


    }

}
