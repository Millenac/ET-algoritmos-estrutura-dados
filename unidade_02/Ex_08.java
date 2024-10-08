import java.util.HashMap;
import java.util.Map;

public class Ex_08 {
    
    public static Map<String, Integer> contarFrequencia(String frase) {
        
        Map<String, Integer> frequencia = new HashMap<>();
        // Dividindo a frase em palavras usando o espaço como delimitador 
        String[] palavras = frase.split("\\s+"); 

        // Conta a frequencia de cada palavra
        for (String palavra : palavras) {
            // Remove caracteres especiais e converte para minúsculas
            palavra = palavra.replaceAll("[^a-zA-Z]", "").toLowerCase();
            if (!palavra.isEmpty()) { // ignora vazio
                // Atualiza a frequência da palavra no HashMap
                frequencia.put(palavra, frequencia.getOrDefault(palavra, 0) + 1);
            }
        }
        return frequencia; 
    }
    public static void main(String[] args) {
        
        String frase = "Exercicio para contar a frequencia de palvras em uma frase em java";
        Map<String, Integer> frequencia = contarFrequencia(frase);

        System.out.println("Frequência das palavras:");
        for (Map.Entry<String, Integer> entry : frequencia.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    
}
