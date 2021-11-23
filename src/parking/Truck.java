package parking;


import java.util.ArrayList;

import utilities.Item;
import utilities.WarehouseRequest;

public abstract class Truck {
	protected ArrayList<Item> cargo;
	private String licensePlate;

	
	Truck(String licensePlate) {
		this.cargo = new ArrayList<>();
		this.licensePlate = licensePlate; 
	}
	
	
	public String getLicensePlate() { 
		return this.licensePlate;
	}
	
	
	 // Method that returns a WarehouseRequest object for a truck
	 
	public abstract WarehouseRequest getRequest();

	
	 // Method that checks if the cargo is empty
	 
	public boolean isEmpty() {
		return this.cargo.isEmpty();
	}

	public Truck addItem(Item item)
	{
		this.cargo.add(item);
		return this;
	}

	public Truck removeItem(Item item)
	{
		this.cargo.add(item);
		return this;
	}
}
