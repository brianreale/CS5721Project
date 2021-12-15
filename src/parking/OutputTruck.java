package parking;

import java.util.ArrayList;
import java.util.Iterator;

import utilities.Item;
import utilities.WarehouseRequest;


public class OutputTruck extends Truck{
	public OutputTruck(String licensePlate) {
		super(licensePlate);
	}


	private ArrayList<Item> target;
	
	public WarehouseRequest getRequest() {
		return new WarehouseRequest(this.target, null);
	}
	

	  //Method that checks if the target has been reached (cargo and target contains the same items, not necessarily in the same order)
	
	public boolean targetReached() {

		boolean isReached = true;

		Iterator<Item> iterator = this.target.iterator();

		while (iterator.hasNext() && isReached) {
			Item item = iterator.next();
			if(! this.cargo.contains(item)) isReached = false;
		}

		return isReached;
	}
	
	 // Method that adds an item to the cargo
	
	public boolean loadItems() {
		return false;
	}
	
}





