/*
* Copyright 2014 Giuliano Bertoti 
* Released under the MIT license 
* github.com/giulianobertoti
*/

import org.json.JSONException;

public class Test {
	
	public static void main(String[] args) throws JSONException{
		
		final Rest rest = new Rest();
		
		rest.initializeStore();
		
		rest.getPhone();
  		
	}
	
}
