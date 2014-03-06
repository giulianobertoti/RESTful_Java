
public class Espec {
	
	private Marca marca;
	private String modelo;
	
	public Espec(Marca mar, String mod){
		marca = mar;
		modelo = mod;
	}
	
	public Marca getMarca(){
		return marca;
	}
	
	public String getModelo(){
		return modelo;
	}
	
	public boolean comparar(Espec espCliente){
		if(marca.equals(espCliente.marca) && modelo.equals(espCliente.modelo)) return true;
		return false;
	}
	
	public String toString(){
		return marca+" "+modelo;
	}

}
