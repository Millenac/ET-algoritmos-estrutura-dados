import java.util.ArrayList;
import java.util.Scanner;

class Item {
	private String nome;
	private float preco;
	private int quantidade;

	public Item(String nome, float preco, int quantidade) {
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public String getNome() {
		return nome;
	}

	public float getPreco() {
		return preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	// Métodos set corrigidos para receber parâmetros
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public void exibir() {
		System.out.println("Nome: " + getNome());
		System.out.println("Preço: R$ " + getPreco());
		System.out.println("Quantidade: " + getQuantidade());
		System.out.println("------------------------");
	}
}
public class Ex_10{

	public static void main(String[] args) {
		ArrayList<Item> lista_estoque = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);

		int opcao;
		do {
			System.out.println("\n-- Estoque da loja --\n");
			System.out.println("[1] Adicionar item ao estoque");
			System.out.println("[2] Remover item do estoque");
			System.out.println("[3] Atualizar dados do item");
			System.out.println("[4] Exibir itens disponíveis no estoque");
			System.out.println("[5] Sair");
			System.out.print("\nO que deseja? ");

			opcao = scanner.nextInt();
			scanner.nextLine();

			switch (opcao) {
				case 1:
					System.out.print("\nDigite o nome do item: ");
					String nome = scanner.nextLine();
					System.out.print("Digite o preço: ");
					float preco = scanner.nextFloat();
					System.out.print("Digite a quantidade disponível no estoque: ");
					int quantidade = scanner.nextInt();
					scanner.nextLine();

					Item item = new Item(nome, preco, quantidade);
					lista_estoque.add(item);
					break;
				case 2:
					limparTela();
					if (lista_estoque.isEmpty()) {
						System.out.println("\nO estoque está vazio. Não é possível remover item!");
					} else {
						System.out.println("\n\n-- Itens disponíveis no estoque -- \n\n");
						for (Item itens : lista_estoque) {
							itens.exibir();
						}
					}

					System.out.println("Digite o nome do item que deseja remover do estoque: ");
					String nome_remove = scanner.nextLine();

					boolean existe = false;
					int indiceParaRemover = -1;

					for (int i = 0; i < lista_estoque.size(); i++) {
						if (lista_estoque.get(i).getNome().equalsIgnoreCase(nome_remove)) {
							existe = true;
							indiceParaRemover = i;
							break;
						}
					}

					if (existe) {
						lista_estoque.remove(indiceParaRemover);
						System.out.println("Item removido com sucesso.");
					} else {
						System.out.println("Item não encontrado.");
					}
					break;
				case 3:
					limparTela();
					if (lista_estoque.isEmpty()) {
						System.out.println("\nO estoque está vazio. Não é possível alterar itens!");
					} else {
						System.out.println("\n\n-- Itens disponíveis no estoque -- \n\n");
						for (Item itens : lista_estoque) {
							itens.exibir();
						}
					}

					System.out.println("Digite o nome do item que deseja alterar: ");
					String item_alterar = scanner.nextLine();

					existe = false;
					int indiceParaAlterar = -1;

					for (int i = 0; i < lista_estoque.size(); i++) {
						if (lista_estoque.get(i).getNome().equalsIgnoreCase(item_alterar)) {
							existe = true;
							indiceParaAlterar = i;
							break;
						}
					}

					if (existe) {
						Item itemParaAlterar = lista_estoque.get(indiceParaAlterar);  // Acessa o item correto

						System.out.print("Digite o novo nome do produto: ");
						String novo_nome = scanner.nextLine();
						itemParaAlterar.setNome(novo_nome);  

						System.out.print("Digite o novo preço do produto: ");
						float novo_preco = scanner.nextFloat();
						itemParaAlterar.setPreco(novo_preco);  

						System.out.print("Digite a nova quantidade do produto: ");
						int nova_qnt = scanner.nextInt();
						itemParaAlterar.setQuantidade(nova_qnt);  

						System.out.println("Item atualizado com sucesso.");
					} else {
						System.out.println("Item não encontrado.");
					}
					break;
				case 4:
					limparTela();
					if (lista_estoque.isEmpty()) {
						System.out.println("\nO estoque está vazio!");
					} else {
						System.out.println("\n\n-- Lista de itens disponíveis no estoque -- \n\n");
						for (Item itens : lista_estoque) {
							itens.exibir();
						}
					}
					System.out.println("Pressione Enter para continuar...");
					scanner.nextLine();
					break;
				case 5:
					System.out.println("Saindo...");
					break;
				default:
					System.out.println("\nDigite uma entrada válida!");
			}
		} while (opcao != 5);
	}

	public static void limparTela() {
		try {
			if (System.getProperty("os.name").contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}
		} catch (Exception e) {
			System.out.println("Erro ao limpar a tela.");
		}
	}
}
