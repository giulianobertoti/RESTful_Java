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


import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import static spark.Spark.*;
import spark.*;


public class controllerGet implements OS{
	
	private Store store;
	private View view;
	
	public controllerGet(Store store, View view){
		this.store = store;
		this.view = view;
	}
	
	public void makeRoute(){
		
		get(new Route("/phones/:os") {
	         @Override
	         public Object handle(Request request, Response response) {
	        	
	            
	        	 
	     	    store.searchPhoneByOS(request.params(":os"));
	     		
	     	    try {
	     	    	JSONArray jsonResult = view.generateJSON();
	     	    	return jsonResult;
				} catch (JSONException e) {
					
					e.printStackTrace();
				}
	     	    
	     	    
	     	    
	     	    return null;
	     	    
	     	    
	         }
	      });
	         
	}
		
}
