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

public class Rest {
	
	private Loja loja;
	
	public Rest(){
		loja = new Loja();
	}
	
	
	public void getCelular() throws JSONException{
		
		get(new Route("/celulares/:so") {
	         @Override
	         public Object handle(Request request, Response response) {
	        	
	        	
	        	 
	     	    ObjectSet result = loja.buscarCelularSo(request.params(":so"));
	     		
	     	    JSONArray jsonResult = new JSONArray();
	     	    
	     	    for(Object i: result){
	     	    	Celular cel = (Celular)i;
	     	    	JSONObject jsonObj = new JSONObject();
	     	    	
	     	    	try {
						jsonObj.put("preco", cel.getPreco());
						jsonObj.put("cor", cel.getCor());
		     	    	jsonObj.put("so", cel.getSo());
		     	    	jsonObj.put("marca", cel.getEsp().getMarca());
		     	    	jsonObj.put("modelo", cel.getEsp().getModelo());
		     	    	jsonResult.put(jsonObj);
					} catch (JSONException e) {
						
						e.printStackTrace();
					}
	     	    	
	     	    }
	     	    
	     	    return jsonResult;
	     	    
	         }
	      });
		
	}
	
	
	public void inicializarEstoque(){
		loja.adicionarCelular(new Celular(2000.0, "Prata", "ios", new Espec(Marca.Apple, "iPhone4")));
  		loja.adicionarCelular(new Celular(1400.0, "Prata", "android", new Espec(Marca.Samsung, "Galaxy")));
  		loja.adicionarCelular(new Celular(1400.0, "Prata", "android", new Espec(Marca.Samsung, "Galaxy")));
	}

}
