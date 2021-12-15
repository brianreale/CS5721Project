package parking;

import java.util.ArrayList;

import Warehouse.Agent;
import observer_pattern.Observer;
import observer_pattern.Subject;


public class Parking implements Subject {
	private final ArrayList<Truck> trucks;
	private final ArrayList<Observer> observers;
	private final ArrayList<Observer> AgentObservers;
	private final ArrayList<Agent> agents;

	public Parking()
	{
		this.trucks = new ArrayList<>();
		this.observers = new ArrayList<>();
		this.AgentObservers = new ArrayList<>();
		this.agents = new ArrayList<>();
	}

	public void attach(Observer a) {
		if (!this.observers.contains(a)) {
			this.observers.add(a);
			System.out.println("observers added succesfully");
		}
	}

	public void detach(Observer a) {
		observers.remove(a);
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
	
	public void attachAgent(Observer o) {
		if (!this.AgentObservers.contains(o)) {
			this.AgentObservers.add(o);
			System.out.println("observer added succesfully");
			System.out.println("");
		}
	}

	public void detachAgent(Observer o) {
		AgentObservers.remove(o);
	}


	public void notifyAgentObservers()
	{
		System.out.println("number of agents currently working is: " + this.agents.size());
		for (Observer observer : AgentObservers) {
			System.out.println("updating observers");
			System.out.println("");
//			if you add some more fields to Parking (String name, String location, etc..) then make sure you pass them into the .update method
			observer.updateAgent(agents);
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

	public ArrayList<Agent> getAgents(){
		System.out.println("The number of agents in parking currently are: " + this.agents.size());
		return this.agents;
	}
	
	//Method that adds a given agent to the object agent list
	public void addAgent(Agent agent) {
		System.out.println("adding new agent");
		this.agents.add(agent);
	}
	
	 //Method that removes a given agent from the object agent list
	public boolean removeAgent(Agent agent) {
		 return this.agents.remove(agent);
	}
	
}
	
	
	 
	
