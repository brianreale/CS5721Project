package Warehouse;

import java.util.ArrayList;

import utilities.Item;

public class GridElement {

	private final ArrayList<Item> content;

	/*The capacity of a grid element indicates how much weight it can hold. Since every tile is a grid element, 
	we say that a non shelf tile has a capacity of -1*/
	private final int capacity;

	public GridElement(int capacity)
	{
		this.content = new ArrayList<>();
		this.capacity = capacity;
	}
	
	public ArrayList<Item> getContent() {
		return content;
	}
	
	
	
	 // Method that adds an item to the GridElement, if its current capacity is higher than the item's weight
	 
	public boolean addItem(Item item) {
		int currentTotalItemWeight = 0;

		for(Item i: content) currentTotalItemWeight += i.getWeight();

		if((item.getWeight() + currentTotalItemWeight) > this.capacity ) return false;

		return this.content.add(item);
	}

	public boolean removeItem(Item item) {
		return this.content.remove(item);
	}

	public boolean hasItem(Item item) {
		return this.content.contains(item);
	}
}
