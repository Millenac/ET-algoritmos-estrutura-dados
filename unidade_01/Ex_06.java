public class Ex_06
{
	public static void main(String[] args){
	    boolean ePrimo;
	
	    for(int num = 2; num <= 100; num ++){
	        if (num < 2){
	            continue;
	        }
	        ePrimo = true; // Assume que o número é primo
	        
	         // Verifica divisibilidade de 2 até a raiz quadrada de num
	        for(int i = 2; i <= Math.sqrt(num); i++){
	            if(num%i == 0){ //Verifica se ele é divisivel por outros números verificando o resto
	                ePrimo = false; //se for divisivel recebe 'false' pois ele não é primo
	                break;
	            }
	        }if (ePrimo == true){ //Faz a verificação para printar os valores que são primos
	            System.out.print(num + " - ");
	        }
	    }
	}
}
