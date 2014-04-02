
/*
* Copyright 2014 Giuliano Bertoti 
* Released under the MIT license 
* github.com/giulianobertoti
*/

public class Phone {

	private double price;
	private String color;
	private String os;
	private Specification spec;
	
	public Phone(double pri, String co, String o, Specification sp){
		price = pri;
		color = co;
		os = o;
		spec = sp;
	}
	
	public double getPrice(){
		return price;
	}
	
	public String getColor(){
		return color;
	}
	
	public String getOS(){
		return os;
	}
	
	public Specification getSpec(){
		return spec;
	}
	
	
	
}
