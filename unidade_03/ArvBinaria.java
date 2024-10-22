class Node {
    int valor;
    Node esq, dir;

    public Node(int valor) {
        this.valor = valor;
        esq = dir = null;
    }
}

public class ArvBinaria{
    Node raiz;

    public ArvBinaria() {
        raiz = null;
    }

   public void add(int valor) {
        raiz = addRecursive(raiz, valor);
    }

    // MAdiciona nós recursivamente
    private Node addRecursive(Node atual, int valor) {
        if (atual == null) {
            return new Node(valor); // Se o nó é nulo, cria um novo nó
        }

        if (valor < atual.valor) {
            atual.esq = addRecursive(atual.esq, valor); 
        } else if (valor > atual.valor) {
            atual.dir = addRecursive(atual.dir, valor); 
        }
        return atual;
    }

    // Percorre a árvore em ordem 
    public void in_order(Node node) {
        if (node != null) {
            in_order(node.esq); 
            System.out.print(node.valor + " "); 
            in_order(node.dir); 
        }
    }

    // Percorre a árvore em pré-ordem 
    public void pre_order(Node node) {
        if (node != null) {
            System.out.print(node.valor + " "); 
            pre_order(node.esq); 
            pre_order(node.dir); 
        }
    }

    // Percorre a árvore em pós-ordem 
    public void post_order(Node node) {
        if (node != null) {
            post_order(node.esq); 
            post_order(node.dir); 
            System.out.print(node.valor + " "); 
        }
    }

    public static void main(String[] args) {
        ArvBinaria bt = new ArvBinaria();
        
        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);

        // Percorre em ordem
        System.out.print("Percorrendo a árvore em ordem:");
        bt.in_order(bt.raiz);
        System.out.println();

        // Percorre em pré-ordem
        System.out.print("Percorrendo a árvore em pré-ordem:");
        bt.pre_order(bt.raiz);
        System.out.println();

        // Percorre em pós-ordem
        System.out.print("Percorrendo a árvore em pós-ordem:");
        bt.post_order(bt.raiz);
        
    }
}