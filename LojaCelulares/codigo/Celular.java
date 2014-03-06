
public class Celular {

	private double preco;
	private String cor;
	private String so;
	private Espec esp;
	
	public Celular(double pre, String co, String s, Espec es){
		preco = pre;
		cor = co;
		so = s;
		esp = es;
	}
	
	public double getPreco(){
		return preco;
	}
	
	public String getCor(){
		return cor;
	}
	
	public String getSo(){
		return so;
	}
	
	public Espec getEsp(){
		return esp;
	}
	
	
	
}
