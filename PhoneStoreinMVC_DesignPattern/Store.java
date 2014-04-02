/*
* Copyright 2014 Giuliano Bertoti 
* Released under the MIT license 
* github.com/giulianobertoti
*/

import java.util.List;
import java.util.LinkedList;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

public class Store implements Subject{
	
	private List<Observer> observers = new LinkedList<Observer>();
	ObjectContainer phones = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "c:/lab3/mvcREST.db4o");
	
	
	public void registerObserver(Observer o){
		observers.add(o);
	}
	
	public void notifyObservers(ObjectSet result){
		for(Observer o : observers){
			o.update(result);
		}
	}
	
	public void addPhone(Phone cel){
		phones.store(cel);
	}
	
	
	public void searchPhoneByOS(String system){
		
		Query query=phones.query();
		query.descend("os").constrain(system);
	    ObjectSet result = query.execute();
		notifyObservers(result);
		
	}
	
	
	public void delPhone(String system){
		Query query=phones.query();
		query.descend("os").constrain(system);
	    ObjectSet result = query.execute();
		if(!result.isEmpty()){
			Phone cel = (Phone) result.next();
			phones.delete(cel);
		}
		notifyObservers(result);
			
	}

}
