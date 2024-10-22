class Node {
    int valor;
    Node esq, dir;

    public Node(int valor) {
        this.valor = valor;
        esq = dir = null;
    }
}

public class BST {
    Node raiz;

    public BST() {
        raiz = null;
    }

    public void add(int valor) {
        raiz = addRecursive(raiz, valor);
    }

    // Método recursivo para adicionar nós
    private Node addRecursive(Node atual, int valor) {
        if (atual == null) {
            return new Node(valor); // Se o nó é nulo, cria um novo nó
        }

        if (valor < atual.valor) {
            atual.esq = addRecursive(atual.esq, valor); // Vai para a esquerda
        } else if (valor > atual.valor) {
            atual.dir = addRecursive(atual.dir, valor); // Vai para a direita
        }
        return atual;
    }

    int buscaMenor() {
        if (raiz == null) {
            throw new RuntimeException("A árvore está vazia");
        }

        Node atual = raiz;
        while (atual.esq != null) {
            atual = atual.esq; 
        }
        return atual.valor; 
    }

    public static void main(String[] args) {
        BST bt = new BST();
        
        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(0);
        bt.add(7);
        bt.add(9);
        
        System.out.println("Menor valor é: " + bt.buscaMenor());
    }
}