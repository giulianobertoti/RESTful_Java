/*
* Copyright 2014 Giuliano Bertoti 
* Released under the MIT license 
* github.com/giulianobertoti
*/

import org.json.JSONException;

public class Test {
	
	static Store store = new Store();
	
	public static void main(String[] args) throws JSONException{
		
		
		
		initializeStore();
		
		View view = new View();
		
		controllerGet controller = new controllerGet(store, view); //connection "Controller-> Model" and "Controller -> View" 
		controllerDelete controller2 = new controllerDelete(store, view); //connection "Controller-> Model" and "Controller -> View" 
		
		//you can exchange to "controlle2" if you want to delete by OS
		view.setOS(controller2); // connection "View -> Controller"
		
		store.registerObserver(view); // connection "Model -> View
		
		//you can exchange to "controlle2" if you want to delete by OS
		controller2.makeRoute();
		
  		
		
	}
	
	public static void initializeStore(){
		store.addPhone(new Phone(2000.0, "Silver", "ios", new Specification(Brand.Apple, "iPhone4")));
  		store.addPhone(new Phone(1400.0, "Silver", "android", new Specification(Brand.Samsung, "Galaxy")));
  		store.addPhone(new Phone(1400.0, "Silver", "android", new Specification(Brand.Samsung, "Galaxy")));
	}
	
}
