public class Ex_01
{
    private int num;
    private float num2;
    private String frase;
        
    //Construtor 
    public Ex_01(int num, float num2, String frase){
        this.num = num;
        this.num2 = num2;
        this.frase = frase;
    }
    public void exibir(){
        System.out.println("Número: "+ num);
        System.out.println("Número flutuante: " + num2);
        System.out.println("String: " + frase);
    }
	public static void main(String[] args) {
	    
	    Ex_01 dados = new Ex_01(2, 2.5f, "oi");
		dados.exibir();
	}
}