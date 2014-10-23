/*
* Copyright 2014 Giuliano Bertoti 
* Released under the MIT license 
* github.com/giulianobertoti
*/

public enum Brand {

	Samsung, Apple, Sony, Nokia;
	
	public static Brand getValueByString(String value){
		for(Brand brand: Brand.values() ){
			if(value.equalsIgnoreCase(brand.toString())){
				return brand;
			}
		}
		return null;
	}
	
}
