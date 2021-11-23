package observer_pattern;

import java.util.ArrayList;

import parking.Truck;

public class Observer {
	
	private ArrayList<Truck> trucks = new ArrayList<>(); 
	
	 // Method that updates the observer state on subject update
	
	public void update(ArrayList<Truck> trucks) { 
		this.trucks = trucks;
	};
	
	public ArrayList<Truck> getTrucks() { 
		return this.trucks;
	}
	
	

//	public void update(Parking subject);
}

