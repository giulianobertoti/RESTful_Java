/*
* Copyright 2014 Giuliano Bertoti 
* Released under the MIT license 
* github.com/giulianobertoti
*/

import static spark.Spark.get;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import spark.Request;
import spark.Response;
import spark.Route;

import com.db4o.ObjectSet;


public class Rest {
	
	private Store store;
	
	public Rest(){
		store = new Store();
	}
	
	
	public void getPhone() throws JSONException{
		
		get(new Route("/phones/:os") {
	         @Override
	         public Object handle(Request request, Response response) {
	        	
	        	//allows everyone to access the resource
	            response.header("Access-Control-Allow-Origin", "*");
	        	
	            
	        	 
	     	    ObjectSet result = store.searchPhoneByOS(request.params(":os"));
	     		
	     	    JSONArray jsonResult = new JSONArray();
	     	    
	     	    
	     	    for(Object i: result){
	     	    	Phone cel = (Phone)i;
	     	    	JSONObject jsonObj = new JSONObject();
	     	    	try {
						jsonObj.put("price", cel.getPrice());
						jsonObj.put("color", cel.getColor());
		     	    	jsonObj.put("OS", cel.getOS());
		     	    	jsonObj.put("brand", cel.getSpec().getBrand());
		     	    	jsonObj.put("model", cel.getSpec().getModel());
		     	    	jsonResult.put(jsonObj);
					} catch (JSONException e) {
						
						e.printStackTrace();
					}
	     	    	
	     	    }
	     	    
	     	    return jsonResult;
	     	    
	         }
	      });
		
	}
	
	
	
	public void initializeStore(){
		store.addPhone(new Phone(2000.0, "Silver", "ios", new Specification(Brand.Apple, "iPhone4")));
  		store.addPhone(new Phone(1400.0, "Silver", "android", new Specification(Brand.Samsung, "Galaxy")));
  		store.addPhone(new Phone(1400.0, "Silver", "android", new Specification(Brand.Samsung, "Galaxy")));
  		store.addPhone(new Phone(2000.0, "Silver", "ios", new Specification(Brand.Apple, "iPhone4")));
  		store.addPhone(new Phone(1400.0, "Silver", "android", new Specification(Brand.Samsung, "Galaxy")));
  		store.addPhone(new Phone(1400.0, "Silver", "android", new Specification(Brand.Samsung, "Galaxy")));
	}

}
