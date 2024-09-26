import java.util.Scanner;

class Jogo_velha
{
	private char[][] tabuleiro;
	private char jogador;

	public Jogo_velha() {
		tabuleiro = new char[3][3];
		Scanner input = new Scanner(System.in);
		
		//Iniciando o tabuleiro
		for(int i = 0; i < 3; i++) {
			for(int j  = 0; j < 3; j++) {
				tabuleiro[i][j] = ' ';
			}
		}
		//Perguntando se o usuario deseja começar sendo X ou O
		System.out.print("\nDeseja ser X ou O? ");
		jogador = input.next().charAt(0);
	}
	
	public void imprime_tabuleiro(){
	    System.out.println("\n");
	    for(int i = 0; i < 3; i++) {
	        System.out.println(" " + tabuleiro[i][0] + "  |  " + tabuleiro[i][1] + "  |  " + tabuleiro[i][2]);
			if(i < 2){
				System.out.println("----|-----|----");
			}
			
		}
	}
	public boolean verifica_vitoria(){
	    for(int i = 0; i < 3; i++){
	        if(((tabuleiro[i][0]) == jogador && tabuleiro[i][1] == jogador && tabuleiro[i][2] == jogador) || 
	            (tabuleiro[0][i] == jogador && tabuleiro[1][0] == jogador && tabuleiro[2][i] == jogador)){
	                return true;
	        }
	    }
	    //Verificando as diagonais
	    if(((tabuleiro[0][0]) == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][2] == jogador) ||
	        (tabuleiro[0][2] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][0] == jogador)){
	           return true;
	    }
	    return false;
	    
	}
	
	public boolean verifica_empate(){
	    //Verificando se ainda existe espaço vazio no tabuleiro
	    for(int i = 0; i < 3; i++){
	        for(int j = 0; j < 3; j++){
	            if(tabuleiro[i][j] == ' '){
	                return false; //como ainda tem espaço vazio o jogo nao terminou
	            }
	        }
	    }
	    return true;
	}
	public void jogar(){
	    Scanner scanner = new Scanner(System.in);
	    
	    while(true){    
	        imprime_tabuleiro();
	        System.out.println("\nQual posição o jogador " +jogador+ " deseja jogar?");
	        
	        System.out.print("Digite a linha, primeira linha[0] - ultima linha[2]: ");
	        int linha = scanner.nextInt();
	        System.out.print("Digite a coluna, primeira linha[0] - ultima linha[2]: ");
            int coluna = scanner.nextInt();
        
            if (linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3 && tabuleiro[linha][coluna] == ' ') {
                tabuleiro[linha][coluna] = jogador;
        
                //Verificando se ocorreu vitoria se sim o jogo termina
                if (verifica_vitoria()) {
                    imprime_tabuleiro();
                    System.out.println("Jogador " + jogador + " venceu!");
                    return; 
                }
            
                // Verificando se houve empate se sim o jogo termina
                if (verifica_empate()) {
                    imprime_tabuleiro();
                    System.out.println("O jogo terminou empatado!");
                    return; 
                }
                // Alterna para o próximo jogador ('X' se for 'O', ou 'O' se for 'X')
                jogador = (jogador == 'x') ? 'o' : 'x';
            }else {
                System.out.println("\n\nJogada inválida, posição já foi escolhida.\n\n");
            }
	    }
        
	}
}
public class Ex_07{
        
	public static void main(String[] args) {
	    
	    Jogo_velha jogo = new Jogo_velha();
	    jogo.jogar();

	}
}
