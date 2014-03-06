import java.util.List;
import java.util.LinkedList;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

public class Loja {
	
	ObjectContainer celulares = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "./bd.db4o");
	
	
	public void adicionarCelular(Celular cel){
		celulares.store(cel);
	}
	
	public ObjectSet buscarCelular(Espec espc){
		
		Query query=celulares.query();
		query.descend("esp").constrain(espc);
	    ObjectSet result = query.execute();
		return result;
		
	}
	
	public ObjectSet buscarCelularSo(String so){
		
		Query query=celulares.query();
		query.descend("so").constrain(so);
	    ObjectSet result = query.execute();
		return result;
		
	}
	
	
	public void deletar(Espec espec){
		ObjectSet lista = buscarCelular(espec); //usar delegacao - evitar a duplicacao do codigo da busca
		if(!lista.isEmpty()){
			Celular cel = (Celular) lista.next();
			celulares.delete(cel);
		}
			
	}

}
