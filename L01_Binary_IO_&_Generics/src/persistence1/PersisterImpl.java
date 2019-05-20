package persistence1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class PersisterImpl<T> implements Persister<T> {

	@Override
	public void saveObjectToFile(File f, T ob) {
		
		try (ObjectOutputStream objToFile = 
				new ObjectOutputStream (new FileOutputStream(f))) {
			
			objToFile.writeObject(ob);
			objToFile.writeChars("\n");
			objToFile.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void saveListToFile(File f, List<T> myList) {
		
		try (ObjectOutputStream listToFile = 
				new ObjectOutputStream (new FileOutputStream(f))) {
			
			listToFile.writeObject(myList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public T readObjectFromFile(File f) {
		T ob = null;
		try (ObjectInputStream objFromFile = 
				new ObjectInputStream (new FileInputStream(f))) {
		
				ob = (T) objFromFile.readObject();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ob;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> readListFromFile(File f) {
		List<T> ob = null;
		try (ObjectInputStream listFromFile = 
				new ObjectInputStream (new FileInputStream(f))) {
			
			ob = (List<T>) listFromFile.readObject();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ob;
	}
	
	
}