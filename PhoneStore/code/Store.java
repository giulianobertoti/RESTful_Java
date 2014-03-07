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

public class Store {
	
	ObjectContainer phones = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "./bd.db4o");
	
	
	public void addPhone(Phone cel){
		phones.store(cel);
	}
	
	public ObjectSet searchPhone(Specification specification){
		
		Query query=phones.query();
		query.descend("spec").constrain(specification);
	    ObjectSet result = query.execute();
		return result;
		
	}
	
	public ObjectSet searchPhoneByOS(String system){
		
		Query query=phones.query();
		query.descend("os").constrain(system);
	    ObjectSet result = query.execute();
		return result;
		
	}
	
	
	public void delPhone(Specification spec){
		ObjectSet list = searchPhone(spec);
		if(!list.isEmpty()){
			Phone cel = (Phone) list.next();
			phones.delete(cel);
		}
			
	}

}
