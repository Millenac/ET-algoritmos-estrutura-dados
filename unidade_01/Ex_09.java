import java.util.ArrayList;
import java.util.Scanner;

// Classe Pessoa
class Pessoa {
    private String nome;
    private int idade;
    private String endereco;

    // Construtor
    public Pessoa(String nome, int idade, String endereco) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    // Métodos get
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getEndereco() {
        return endereco;
    }

    // Função para imprimir os dados das pessoas 
    public void exibe() {
        System.out.println("Nome: " + getNome());
        System.out.println("Idade: " + getIdade());
        System.out.println("Endereço: " + getEndereco());
        System.out.println("------------------------");
    }
}
public class Ex_09{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Pessoa> lista_pessoa = new ArrayList<>();
        
        int opcao;

        do {
            limparTela();
            System.out.println("[1] Adicionar pessoa a lista");
            System.out.println("[2] Remover uma pessoa da lista");
            System.out.println("[3] Exibir lista de pessoas");
            System.out.println("[4] Sair");
            System.out.println("Digite o que deseja");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    //limparTela();
                    System.out.println("Digite o nome da pessoa: ");
                    String nome = scanner.nextLine();
                    System.out.println("Digite a idade da pessoa: ");
                    int idade = scanner.nextInt();
                    scanner.nextLine();  
                    System.out.println("Digite o Endereço: ");
                    String endereco = scanner.nextLine();
                    
                    // Inicialização de um objeto da classe Pessoa
                    Pessoa pessoa = new Pessoa(nome, idade, endereco);
                    lista_pessoa.add(pessoa); // Adicionando a pessoa na lista
                    break;

                case 2:
                    limparTela();
                    String nome_remove;
                    if (lista_pessoa.isEmpty()) { // Verificando se a lista de pessoa está vazia
                        System.out.println("\nLista está vazia! Não tem como remover!");
                    } else {
                        System.out.println("\n\n-- Lista de Pessoas -- \n\n");
                        for (Pessoa pessoas : lista_pessoa) {
                            pessoas.exibe();
                        }
                    }
                    System.out.println("Digite o nome da pessoa a ser removida da lista: ");
                    nome_remove = scanner.nextLine();
                    
                    boolean existe = false;
                    int indiceParaRemover = -1; // Variável para armazenar o índice da pessoa a ser removida

                    for (int i = 0; i < lista_pessoa.size(); i++) {
                        // Acessando o objeto Pessoa e chamando o método getNome()
                        if (lista_pessoa.get(i).getNome() != null && lista_pessoa.get(i).getNome().equalsIgnoreCase(nome_remove)) {
                            existe = true;
                            indiceParaRemover = i; // Armazena o índice da pessoa encontrada
                            break; // Para de iterar assim que encontrar a pessoa
                        }
                    }

                    if (existe) {
                        lista_pessoa.remove(indiceParaRemover); // Remove a pessoa pelo índice
                        System.out.println("Pessoa removida com sucesso.");
                    } else {
                        System.out.println("Digite o nome correto da pessoa");
                    }
                    break;

                case 3:
                    limparTela();
                    if (lista_pessoa.isEmpty()) { // Verificando se a lista de pessoa está vazia
                        System.out.println("\nLista está vazia!");
                    } else {
                        System.out.println("\n\n-- Lista de Pessoas -- \n\n");
                        for (Pessoa pessoas : lista_pessoa) {
                            pessoas.exibe();
                        }
                    }
                    System.out.println("Pressione Enter para continuar..."); 
                    scanner.nextLine(); // Espera que o usuário pressione Enter
                    break;

                case 4:
                    limparTela();
                    System.out.println("\nSaindo...");
                    break;

                default:
                    System.out.println("\nDigite uma entrada válida!");
            }
        } while (opcao != 4);
    }

    // Função para limpar a tela de acordo com o sistema operacional
    public static void limparTela() {
        try {
            // Para sistemas operacionais Unix/Linux/MacOS
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

