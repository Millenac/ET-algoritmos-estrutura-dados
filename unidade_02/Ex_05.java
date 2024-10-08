import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Deque;

public class Ex_05
{
	public static void main(String[] args) {
		Deque<Integer> pilha = new ArrayDeque<>();
		ArrayList<Integer> lista = new ArrayList<>();
		
		lista.add(1);
		lista.add(2);
		lista.add(3);
		lista.add(4);
		
		System.out.println("Lista incial:" + lista);
		
		//Adicionando os valores da lista na pilha
		for(int i = 0; i < lista.size(); i++){
		    pilha.push(lista.get(i));
		}
		System.out.println("Pilha:" + pilha);
		
		//Limpando a lista 
		lista.clear(); 
		
		//Vai rodar enquanto tiver elementos dentro da pilha
		while(!pilha.isEmpty()){
		    lista.add(pilha.pop());
		}
		System.out.println("Lista Invertida:" + lista);
	}
}
