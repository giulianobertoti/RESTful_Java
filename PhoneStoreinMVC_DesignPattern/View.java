import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.db4o.ObjectSet;


public class View implements Observer{
	
	private OS os;
	private ObjectSet result;
	
	public void setOS(OS os){
		this.os = os;
	}
	
	public void routingOS(){
		os.makeRoute();
	}
	
	public void update(ObjectSet result){
		this.result = result;
	}

	public JSONArray generateJSON() throws JSONException{
		JSONArray jsonResult = new JSONArray();
 	    JSONObject jsonObj = new JSONObject();
 	    
 	    for(Object i: this.result){
 	    	Phone cel = (Phone)i;
 	    	
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

	
}
