import java.util.ArrayList;

public class Ex_01
{
	public static void main(String[] args) {
	    
		ArrayList<Integer> lista_numeros = new ArrayList<>();
		ArrayList<Integer> lista_invertida = new ArrayList<>();
		
		lista_numeros.add(1);
		lista_numeros.add(2);
		lista_numeros.add(3);
		lista_numeros.add(4);
		lista_numeros.add(5);
		
		System.out.print(lista_numeros);
		//For que percorre de trás pra frente
		for(int i = 4; i >= 0; i--){
		     lista_invertida.add(lista_numeros.get(i)); //Adiciona na lista_invertida os valores da lista_numeros usando get
		}
		System.out.print("\n" + lista_invertida);
	}
}
