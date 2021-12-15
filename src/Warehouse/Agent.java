package Warehouse;

import java.util.ArrayList;

import utilities.Item;
import utilities.WarehouseRequest;

public abstract class Agent{
	protected ArrayList<Item> cargo;
	private String agentName;

	
	Agent(String agentName) {
		this.cargo = new ArrayList<>();
		this.agentName = agentName; 
	}
	
	
	public String getAgentName() { 
		return this.agentName;
	}
	
	
	 // Method that returns a WarehouseRequest object for a truck
	 
	public abstract WarehouseRequest getRequest();

	
	 // Method that checks if the cargo is empty
	 
	public boolean isEmpty() {
		return this.cargo.isEmpty();
	}

	public Agent retriveItem(Item item)
	{
		this.cargo.add(item);
		return this;
	}

	public Agent deliverItem(Item item)
	{
		this.cargo.add(item);
		return this;
	}
}
