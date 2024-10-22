public class BuscaLinear
{
    static int BuscaLinear(int[] vetor, int elemento){
        for(int i = 0; i < vetor.length; i++){
            if(vetor[i] == elemento){
                return i;
            }
        }
        return -1;
    }
	public static void main(String[] args) {
		int [] vetor_inteiros = {1,34,33,2,7,8,5,66,43,82,12};
		int elemento = 7;
		int elemento2 = 66;
		int elemento3 = 67;
		
		BuscaLinear bl = new BuscaLinear();
		
		System.out.println(bl.BuscaLinear(vetor_inteiros, elemento));
		System.out.println(bl.BuscaLinear(vetor_inteiros, elemento2));
		System.out.println(bl.BuscaLinear(vetor_inteiros, elemento3));
	}
}
