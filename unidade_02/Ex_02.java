import java.util.ArrayList;
import java.util.Collections;

public class Ex_02
{
	public static void main(String[] args) {
	    ArrayList<Integer> lista = new ArrayList<>();
	    
	    Collections.addAll(lista, 1, 1, 2, 3, 4, 4, 5, 6, 6, 9, 9);
	    System.out.println("Lista com elementos duplicados:" + lista);
	    
	    for(int i = 0; i < lista.size(); i++){
	        for(int j = i+ 1; j < lista.size(); j++){
	            if (lista.get(i).equals(lista.get(j))) {
                    lista.remove(j);
                    j--; // Ajustando o indice apos remover um elemento
	            }
	        }
	    }
	     System.out.println("Lista sem duplicados:" + lista);
	}
}
