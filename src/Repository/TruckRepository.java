package Repository;
import java.util.ArrayList;
import java.util.Iterator;

import parking.Truck;

public class TruckRepository implements Container { 
	public ArrayList<Truck> trucks; 
	
	@SuppressWarnings("unchecked")
	public Iterator<Truck> getIterator() {
		return new TruckIterator();
	} 
	
	private class TruckIterator implements Iterator { 
		
		int index; 
//		iterating over the number of trucks we have
//		calling has next while iterating to check where we are at the iteration process to make sure that we don't go beyond the length of our arraylist
		public boolean hasNext() { 
			
			if(index < trucks.size()) { 
				return true;	
			}
			
			return false; 
		}
		
//		returns the next truck in the list
		public Object next() { 
			if (this.hasNext()) { 
				return trucks.get(index++);
			}
			return null;
		}
	}
	
	
}