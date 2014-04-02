import com.db4o.ObjectSet;


public interface Subject {

	public void notifyObservers(ObjectSet result);
	
}
