import java.util.ArrayList;
import java.util.Scanner;

public class Ex_04
{
	public static void main(String[] args) {
		ArrayList<Integer> lista_numero = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		int opcao, valor;
		
		do{
		    System.out.println("[1] Adicionar número a lista");
		    System.out.println("[2] Remover número da lista");
		    System.out.println("[3] Exibir lista");
		    System.out.println("[4] Sair");
		    System.out.println("Digite o que deseja:");
		    
		    opcao = scanner.nextInt();
		    
		    switch (opcao){
		        case 1:
		            limparTela();
		            System.out.println("\n\nDigite o número a ser adicionado a lista");
		            valor = scanner.nextInt();
		            lista_numero.add(valor);
		            break;
		        case 2:
		            limparTela();
		            System.out.println(lista_numero);
		            System.out.println("Digite o indice do número que deseja remover");
		            valor = scanner.nextInt();
		            lista_numero.remove(valor);
		            break;
		        case 3:
		            limparTela();
		            System.out.println(lista_numero);
		            break;
		        case 4:
		            limparTela();
		            System.out.println("\nSaindo...");
		            break;
		        default:
		            System.out.println("\nDigite uma entrada valida!");
		    }
		    
		}while(opcao != 4);
		
		
	}
	public static void limparTela() {
        try {
                if (System.getProperty("os.name").contains("Windows")) {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                } else {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                }
            }catch (Exception e){
                System.out.println("Erro ao limpar a tela.");
            }
	    
	}
}
