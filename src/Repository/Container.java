package Repository;

import java.util.Iterator;

public interface Container {
	@SuppressWarnings("rawtypes")
//	tells the classes that implement Container to implement the method getIterator() and return an Iterator object
	public Iterator getIterator();

}
