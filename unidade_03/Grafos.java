import java.util.*;

public class Grafos {
    private int vertices; 
    private LinkedList<Integer>[] adj; 
    
    Grafos(int v) {
        vertices = v;
        adj = (LinkedList<Integer>[]) new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    // Adiciona uma aresta ao grafo
    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v); // Grafo não direcionado
    }

    // Método auxiliar para DFS recursiva
    private void DFSUtil(int v, boolean[] visitado) {
        // Marca o vértice atual como visitado e o imprime
        visitado[v] = true;
        System.out.print(v + " ");

        // Recorre para todos os vértices adjacentes a este vértice
        for (int adjacente : adj[v]) {
            if (!visitado[adjacente]) {
                DFSUtil(adjacente, visitado); // Chama DFS recursivamente
            }
        }
    }

    // Método principal para realizar DFS (iniciando de um vértice de origem)
    public void DFS(int inicio) {
        // vetor para marcar todos os vértices como não visitados (false)
        boolean[] visitado = new boolean[vertices];

        // Chama a função auxiliar DFSUtil para realizar a busca a partir do vértice 'inicio'
        DFSUtil(inicio, visitado);
    }

    public static void main(String[] args) {
        Grafos grafo = new Grafos(6);

        grafo.addEdge(0, 1);
        grafo.addEdge(0, 2);
        grafo.addEdge(1, 3);
        grafo.addEdge(2, 4);
        grafo.addEdge(3, 5);
        grafo.addEdge(4, 5);

        System.out.println("Vértices visitados na DFS a partir do nó 0:");
        grafo.DFS(0); // Realiza a DFS a partir do nó 0
    }
}
