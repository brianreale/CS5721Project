package observer_pattern;

import java.util.ArrayList;

import Warehouse.Agent;
import parking.Truck;

public class Observer {
	
	private ArrayList<Truck> trucks = new ArrayList<>(); 
	private ArrayList<Agent> agents = new ArrayList<>();
	
	 // Methods that updates the observer state on subject update
	
	public void update(ArrayList<Truck> trucks) { 
		this.trucks = trucks;
	};
	
	public ArrayList<Truck> getTrucks() { 
		return this.trucks;
	}
	public void updateAgent(ArrayList<Agent> agents) { 
		this.agents = agents;
	};
	
	public ArrayList<Agent> getAgents() { 
		return this.agents;
	}
	

}

