import java.util.Stack;

public class Ex_04 {
	public boolean verifica(String operacao) {
		Stack<Character> pilha = new Stack<>();
        
        // loop que itera sobre cada caractere da string operacao
		for (int i = 0; i < operacao.length(); i++) {
			char caractere = operacao.charAt(i); //Obtém o caractere na posição i da string operacao e o armazena na variável caractere

			if (caractere == '(') { // verifica se o caractere atual é um parêntese de abertura "("
				pilha.push(caractere); // Adiciona "(" a pilha
			} else if (caractere == ')') { //Verifica se o caractere atual é um parêntese de fechamento ")"
			
			    //Se a pilha não estiver vazia ou o item que está no topo da pilha não for um parêntese de abertura, a expressão é inválida
				if (pilha.isEmpty() || pilha.peek() != '(') { 
				} else {
					pilha.pop();
				}
			}
		}
		return pilha.isEmpty();
	}

	public static void main(String[] args) {
		Main main = new Main();  

		String operacao1 = "((4*9 * (7 + 8))";
		String operacao2 = "2 * (5+5 * (8*2))";
		String operacao3 = ") 3 + 4 )";

		System.out.println(main.verifica(operacao1));
		System.out.println(main.verifica(operacao2));
		System.out.println(main.verifica(operacao3));
	}
}
