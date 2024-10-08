import java.util.ArrayList;
import java.util.Collections;

public class Ex_10
{
    public static void selectionSort(ArrayList<Integer> lista){
        int tamanho = lista.size();
        
        for(int i = 0; i < tamanho -1 ; i++){
            int valorMax = i; //Supondo que o maior valor está na primeira posição
            for(int j = i +1; j < tamanho; j++){
                if(lista.get(j) > lista.get(valorMax)){ //Faz a verificação de qual valor é maior
                    valorMax = j; //Se o j for maior a variavel "valorMax" recebe j
                }
            }
            int aux = lista.get(valorMax); //Uma auxiliar que guarda temporariamente o maior valor
            lista.set(valorMax, lista.get(i)); //O valor que está na posição i (índice atual do loop) será colocado na posição valorMax
            lista.set(i, aux); //O valor que foi guardado na auxiar (maior valor) é movido para a posição i
        }
        
    }
    public static void exibirLista(ArrayList<Integer> lista) {
        System.out.print("\n");
        for (Integer numero : lista) {
            System.out.print(numero + " ");
        }
    }
	public static void main(String[] args) {
		ArrayList<Integer> lista = new ArrayList<>();
		Collections.addAll(lista, 24,54,8,22,16,59,444,93,542,31);
		
		System.out.println("Lista fora de ordem");
		exibirLista(lista);
		
		selectionSort(lista);
		System.out.println("\n\nLista em ordem descrecente");
		exibirLista(lista);
	}
}
