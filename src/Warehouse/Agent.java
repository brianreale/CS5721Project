package Warehouse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

import utilities.Coordinates;
import utilities.Direction;
import utilities.Item;

public class Agent {
	private String name;
	private ArrayList<Item> load;

	private Coordinates coors;

	private int capacity;

	public Agent(String name)
	{
		this.name = name.toLowerCase();
	}

	public String getName(){ return this.name; }
	
	
	
	 //Method that moves an agent given a certain direction (using the Direction enum)
	
	public boolean move(Direction direction) {
		if(direction.equals(Direction.DOWN) && this.coors.getY() >= 1) {
			this.coors.setY(this.coors.getY() - 1);
			return true;
		}

		if(direction.equals(Direction.UP)) {
			this.coors.setY(this.coors.getY() + 1);
			return true;
		}

		if(direction.equals(Direction.LEFT) && this.coors.getX() >= 1) {
			this.coors.setX(this.coors.getX() - 1);
			return true;
		}

		if(direction.equals(Direction.RIGHT)) {
			this.coors.setX(this.coors.getX() + 1);
			return true;
		}

		return false;
	}
	
	
	
	 //Method that checks if the Agent holds a given list of items
	 
	public boolean hasItems(ArrayList<Item> items) {
		boolean hasItems = true;

		Iterator<Item> iterator = items.iterator();

		while (iterator.hasNext() && hasItems) {
			Item item = iterator.next();
			if(! this.load.contains(item)) hasItems = false;
		}

		return hasItems;
	}
	
	
	 //Method that adds an item to the Agent's load, if its current capacity is higher than the weight of the item
	
	public boolean addItem(Item item) {
		return this.load.add(item);
	}
	
	
	 // Method that removes an item from the Agent, if it has it
	 
	public boolean removeItem(Item item) {
		return this.load.remove(item);
	}
}
