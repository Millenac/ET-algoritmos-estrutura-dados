import java.util.HashMap;
import java.util.Map;

public class Ex_09 {
    public static void main(String[] args) {
        HashMap<String, Integer> mapa1 = new HashMap<>();
        mapa1.put("timeA", 10);  
        mapa1.put("timeB", 20);  
        mapa1.put("timeC", 15); 
        mapa1.put("timeD", 12);  

        HashMap<String, Integer> mapa2 = new HashMap<>();
        mapa2.put("timeB", 30);  
        mapa2.put("timeC", 10);  
        mapa2.put("timeD", 25);

        System.out.println("Mapa 1: " + mapa1);
        System.out.println("Mapa 2: " + mapa2);
        
        mescla_mapas(mapa1, mapa2);

        System.out.println("\nMapa mesclado: " + mapa1);
    }
    
    //Percorre todas as entradas do mapa2 usando o entrySet() para cada entrada, obtemos a chave e o valor.
    public static void mescla_mapas(HashMap<String, Integer> mapa1, HashMap<String, Integer> mapa2) {
        for (Map.Entry<String, Integer> entry : mapa2.entrySet()) {
            String chave = entry.getKey();
            Integer valor = entry.getValue();

            // Se a chave já existir, soma os valores
            mapa1.merge(chave, valor, Integer::sum);
        }
    }
}

