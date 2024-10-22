import java.util.*;

public class SimpleGrafo {
    static class Grafo {
        private Map<Integer, Map<Integer, Integer>> adjacencias; // Grafo representado como um mapa de vértices e pesos

        public Grafo() {
            adjacencias = new HashMap<>();
        }

        // Adiciona um vértice ao grafo
        public void adicionarVertice(int vertice) {
            adjacencias.putIfAbsent(vertice, new HashMap<>());
        }

        // Adiciona uma aresta com peso entre dois vértices
        public void adicionarAresta(int origem, int destino, int peso) {
            adjacencias.get(origem).put(destino, peso);
            adjacencias.get(destino).put(origem, peso); // Grafo não direcionado
        }

        // Busca o caminho mais curto utilizando o Algoritmo de Dijkstra
        public List<Integer> caminhoMaisCurto(int origem, int destino) {
            Map<Integer, Integer> distancia = new HashMap<>();
            Map<Integer, Integer> predecessores = new HashMap<>();
            PriorityQueue<Integer> filaPrioridade = new PriorityQueue<>(Comparator.comparingInt(distancia::get));

            // Inicializa todas as distâncias como infinito e predecessores como -1
            for (int vertice : adjacencias.keySet()) {
                distancia.put(vertice, Integer.MAX_VALUE);
                predecessores.put(vertice, -1);
            }

            distancia.put(origem, 0);
            filaPrioridade.add(origem);

            // Processa os nós
            while (!filaPrioridade.isEmpty()) {
                int atual = filaPrioridade.poll();

                // Para cada vizinho do nó atual
                for (Map.Entry<Integer, Integer> vizinho : adjacencias.get(atual).entrySet()) {
                    int v = vizinho.getKey();
                    int pesoAresta = vizinho.getValue();
                    int novaDistancia = distancia.get(atual) + pesoAresta;

                    if (novaDistancia < distancia.get(v)) {
                        distancia.put(v, novaDistancia);
                        predecessores.put(v, atual);
                        filaPrioridade.add(v);
                    }
                }
            }

            // Se não encontrou caminho, retorna lista vazia
            if (distancia.get(destino) == Integer.MAX_VALUE) {
                return new ArrayList<>();
            }

            // Reconstroi o caminho a partir dos predecessores
            List<Integer> caminho = new ArrayList<>();
            for (int no = destino; no != -1; no = predecessores.get(no)) {
                caminho.add(no);
            }

            Collections.reverse(caminho);
            return caminho;
        }
    }

    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        // Adiciona vértices
        for (int i = 1; i <= 6; i++) {
            grafo.adicionarVertice(i);
        }

        // Adiciona arestas com pesos
        grafo.adicionarAresta(1, 2, 4);
        grafo.adicionarAresta(1, 3, 2);
        grafo.adicionarAresta(2, 4, 5);
        grafo.adicionarAresta(3, 5, 1);
        grafo.adicionarAresta(4, 6, 3);
        grafo.adicionarAresta(5, 6, 7);

        int origem = 1;
        int destino = 6;

        // Busca o caminho mais curto
        List<Integer> caminho = grafo.caminhoMaisCurto(origem, destino);

        if (caminho.isEmpty()) {
            System.out.println("Não há caminho entre os vértices " + origem + " e " + destino);
        } else {
            System.out.println("Caminho mais curto entre " + origem + " e " + destino + ": " + caminho);
        }
    }
}
