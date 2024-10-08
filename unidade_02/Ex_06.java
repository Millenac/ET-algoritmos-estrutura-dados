import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		Queue<String> fila_espera = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        
        int entrada;
        do {
            System.out.println("\n--Gerenciamento de fila de espera --\n");
            System.out.println("[1] - Entrar na fila");
            System.out.println("[2] - Chamar prox pessoa da fila");
            System.out.println("[3] - Exibir fila de espera");
            System.out.println("[4] - Sair");
            
            System.out.println("O que deseja?");
            entrada = scanner.nextInt();
            scanner.nextLine();
            
            switch (entrada){
                case 1:
                    System.out.print("Digite o nome da pessoa: ");
                    String nome = scanner.nextLine();
                    fila_espera.offer(nome);
                    break;
                case 2:
                    System.out.println(fila_espera.poll());
                    break;
                case 3:
                    if(fila_espera.isEmpty()){
                        System.out.println("A fila está vazia!");
                    }else{
                        System.out.println(fila_espera);
                    }
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("\nDigite uma entrada valida!");
                    break;
            }
   
        }while(entrada != 4);
	}
}
