
/*
* Copyright 2014 Giuliano Bertoti 
* Released under the MIT license 
* github.com/giulianobertoti
*/

public class Specification {
	
	private Brand brand;
	private String model;
	
	public Specification(Brand br, String mod){
		brand = br;
		model = mod;
	}
	
	public Brand getBrand(){
		return brand;
	}
	
	public String getModel(){
		return model;
	}

}
