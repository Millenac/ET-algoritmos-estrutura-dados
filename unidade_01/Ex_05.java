public class Ex_05
{
	public static void main(String[] args) {
	    int maior;
	    
	    int [][] matriz = {{71,69,3},{44,12,22},{67,88,9}};
	    
	    maior = matriz[0][0]; //Supondo que o maior valor esteja na primeira posição
	    
	    for(int i = 0; i < matriz.length; i++){
	        for(int j = 0; j < matriz[i].length; j++){
	            if(matriz[i][j] > maior){
	                maior = matriz[i][j];
	            }
	        }
	    }
	    System.out.println(maior);
	}
}
