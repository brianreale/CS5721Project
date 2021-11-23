package parking;

import java.util.ArrayList;
import observer_pattern.Observer;
import observer_pattern.Subject;

public class Parking implements Subject {
	private final ArrayList<Truck> trucks;
	private final ArrayList<Observer> observers;

	public Parking()
	{
		this.trucks = new ArrayList<>();
		this.observers = new ArrayList<>();
	}

	public void attach(Observer o) {
		if (!this.observers.contains(o)) {
			this.observers.add(o);
			System.out.println("observer added succesfully");
		}
	}

	public void detach(Observer o) {
		observers.remove(o);
	}

	public void notifyObservers()
	{
		System.out.println("number of trucks we have: " + this.trucks.size());
		for (Observer observer : observers) {
			System.out.println("updating observers");
//			if you add some more fields to Parking (String name, String location, etc..) then make sure you pass them into the .update method
			observer.update(trucks);
		}
	}

	public ArrayList<Truck> getTrucks(){
		System.out.println("The number of trucks in parking currently are: " + this.trucks.size());
		return this.trucks;
	}
	//Method that adds a given truck to the object truck list
	public void addTruck(Truck truck) {
		System.out.println("adding new truck");
		this.trucks.add(truck);
	}
	 //Method that removes a given truck from the object truck list
	public boolean removeTruck(Truck truck) {
		 return this.trucks.remove(truck);
	}
}
	
	
	 
	
