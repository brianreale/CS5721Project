package parking;

import utilities.WarehouseRequest;

public class InputTruck extends Truck {

	public InputTruck(String licensePlate) {
		super(licensePlate);
	}


	public WarehouseRequest getRequest() {
		return new WarehouseRequest(null, this.cargo);
	}
	
	
	 // Method that checks if the cargo is empty on truck
	 
	public boolean isEmpty() {
		return this.cargo.isEmpty();
	}
	
	
	 // Method that unloads a certain number of items from the cargo
	 
	public boolean unloadItems(int count) {
		return false;
	}

}
