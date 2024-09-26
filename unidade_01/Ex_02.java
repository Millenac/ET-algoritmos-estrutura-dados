public class Ex_02
{
    private int numero;
    
    public Ex_02(int numero){
        this.numero = numero;
    }
    
    public void verifica(){
        if(numero%2 == 0){
            System.out.println("O número " +numero+ " é par!");
        }
        else{
            System.out.println("O número " +numero+ " é impar!");
        }
    }
	public static void main(String[] args) {
	    
		Ex_02 numero1 = new Ex_02(10);
		Ex_02 numero2 = new Ex_02(99);
		Ex_02 numero3 = new Ex_02(13);
		
		numero1.verifica();
		numero2.verifica();
		numero3.verifica();
	}
}
