public class BuscaBinaria
{
    int BuscaBinaria(int[] vetor, int elemento){
        int inicio = 0, meio, fim = vetor.length -1; 
        while(inicio <= fim){
            meio = (inicio + fim)/2;
            if(vetor[meio] == elemento){
                return meio;
            }
            if(vetor[meio] < elemento){
                inicio = meio + 1;
            }else{
                fim = meio -1;
            }
        }
        return - 1;
    }
	public static void main(String[] args) {
	    int [] vetor_inteiros = {1,2,3,4,5,6,7,8,9,10};
	    int elemento = 3;
	    int elemento2 = 8;
	    
	    BuscaBinaria bb = new BuscaBinaria();
	    
		System.out.println(bb.BuscaBinaria(vetor_inteiros, elemento));
		System.out.println(bb.BuscaBinaria(vetor_inteiros, elemento2));
	}
}
