import java.util.*;

public class OrdenacaoTopologica {

    // Função para realizar a ordenação topológica
    public static List<String> ordenacaoTopologica(Map<String, List<String>> grafo) throws Exception {
        // Mapa para armazenar o grau de entrada de cada vértice
        Map<String, Integer> grauEntrada = new HashMap<>();
        
        // Inicializando o grau de entrada dos vertices
        for (String vertice : grafo.keySet()) {
            grauEntrada.put(vertice, 0);
        }
        
        // Preenche o grau de entrada de cada vértice
        for (String vertice : grafo.keySet()) {
            for (String vizinho : grafo.get(vertice)) {
                grauEntrada.put(vizinho, grauEntrada.get(vizinho) + 1);
            }
        }

        // Fila para os vértices com grau de entrada igual a 0
        Queue<String> fila = new LinkedList<>();
        for (String vertice : grauEntrada.keySet()) {
            if (grauEntrada.get(vertice) == 0) {
                fila.add(vertice);
            }
        }

        // armazena a ordenação topológica
        List<String> ordenacao = new ArrayList<>();
        
        while (!fila.isEmpty()) {
            String vertice = fila.poll();  // Remove um vértice com grau de entrada 0
            ordenacao.add(vertice);        // Adiciona na lista de ordenação
            
            // Para cada vizinho, diminui o grau de entrada
            for (String vizinho : grafo.get(vertice)) {
                grauEntrada.put(vizinho, grauEntrada.get(vizinho) - 1);
                // Se o grau de entrada se torna 0, adiciona à fila
                if (grauEntrada.get(vizinho) == 0) {
                    fila.add(vizinho);
                }
            }
        }

        // Verifica se foi possível ordenar todos os vértices (se não há ciclos)
        if (ordenacao.size() == grafo.size()) {
            return ordenacao;
        } else {
            throw new Exception("O grafo contém ciclos e não pode ser ordenado topologicamente.");
        }
    }

    public static void main(String[] args) {
        // Definindo um grafo direcionado acíclico (DAG)
        Map<String, List<String>> grafo = new HashMap<>();
        grafo.put("A", Arrays.asList("C"));
        grafo.put("B", Arrays.asList("C", "D"));
        grafo.put("C", Arrays.asList("E"));
        grafo.put("D", Arrays.asList("F"));
        grafo.put("E", Arrays.asList("F"));
        grafo.put("F", new ArrayList<>());

        try {
            List<String> resultado = ordenacaoTopologica(grafo);
            System.out.println("Ordenação Topológica: " + resultado);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
