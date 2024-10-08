import java.util.LinkedList;
import java.util.Queue;

public class Ex_07
{
	public static void main(String[] args) {
		Queue<Integer> fila = new LinkedList<>();
		
		fila.offer(10);
		fila.offer(20);
		fila.offer(30);
		fila.offer(40);
		
		System.out.println("Ordem de chegada da fila: " + fila);
		
		int posicao = 1;
        System.out.print("Ordem de saida da fila \n");
        while (!fila.isEmpty()) {
            System.out.println(posicao + " a sair: " + fila.poll());
            posicao++;
        }
	}
}
