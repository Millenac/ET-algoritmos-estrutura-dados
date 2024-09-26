import java.util.ArrayList;
import java.util.Scanner;

public class Ex_08
{
	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a quantidade de números que deseja adicionar na lista: \n\n");
        
        int qnt = scanner.nextInt(); 
        int[] lista_numeros = new int[qnt];
        int[] frequencias = new int[qnt];

        
        for (int i = 0; i < qnt; i++) {
            System.out.print("Digite o "+(i+1)+ " número: ");
            lista_numeros[i] = scanner.nextInt();
        }
        
        // Contar a frequência de cada número
        for (int i = 0; i < qnt; i++) {
            for (int j = 0; j < qnt; j++) {
                if (lista_numeros[i] == lista_numeros[j]) {
                    frequencias[i]++;
                }
            }
        }
        // Verifica qual número tem mais frequencia na lista 
        int maxFrequencia = frequencias[0];
        for (int i = 1; i < qnt; i++) {
            if (frequencias[i] > maxFrequencia) {
                maxFrequencia = frequencias[i];
            }
        }

        // Exibir todos os números com a maior frequência
        System.out.println("\nO(s) numero(s) que mais se repete(m) é(são): \n");
        for (int i = 0; i < qnt; i++) {
            // Verificar se esse número já foi exibido antes
            boolean jaExibido = false;
            for (int j = 0; j < i; j++) {
                if (lista_numeros[i] == lista_numeros[j]) {
                    jaExibido = true;
                    break;
                }
            }
            if (frequencias[i] == maxFrequencia && !jaExibido) {
                System.out.println("O número " + lista_numeros[i] + " aparece " + frequencias[i] +" vezes");
            }
        }

	}
}
