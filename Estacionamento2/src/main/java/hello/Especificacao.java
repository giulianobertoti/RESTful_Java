package hello;

public class Especificacao {

	
	private String modelo;
	private String marca;
	private String cor;
	
	
	public Especificacao(String modelo, String marca, String cor){
		this.modelo = modelo;
		this.marca = marca;
		this.cor = cor;
	}
	
	public String getModelo(){
		return modelo;
	}
	
	public String getMarca(){
		return marca;
	}
	
	public String getCor(){
		return cor;
	}
	
	//delegacao da comparacao de marca, modelo e cor do carro para a classe Especificacao, pois ela eh a dona dos atributos
	public boolean comparar(Especificacao esp){
		if(marca.equals(esp.marca) && modelo.equals(esp.modelo) && cor.equals(esp.cor)){
			return true;
		} else {
			return false;
		}
	}
	
}
