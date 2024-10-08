import java.util.ArrayList;

public class Ex_03
{
	public static void main(String[] args) {
	    ArrayList<Integer> num_impares = new ArrayList<>();
	    ArrayList<Integer> num_pares = new ArrayList<>();
	    ArrayList<Integer> lista_numeros = new ArrayList<>();
	
	    num_impares.add(1);
	    num_impares.add(3);
	    num_impares.add(5);
	
	    num_pares.add(2);
	    num_pares.add(4);
	    num_pares.add(6);
	    
	    //Adicionando os valores de duas listas diferente de for alternada
	    for(int i = 0; i <= 2; i++){
	        lista_numeros.add(num_impares.get(i));
	        lista_numeros.add(num_pares.get(i));
	    }
	    System.out.print(lista_numeros);
	}
}
