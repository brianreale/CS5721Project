package model;

import java.util.ArrayList;
import java.util.Iterator;

import Repository.AgentRepository;
import Repository.TruckRepository;
import parking.InputTruck;
import parking.RequestObserver;
import parking.Parking;
import parking.Truck;
import utilities.Item;
import Warehouse.Agent;
import Warehouse.IncomingAgent;
import Warehouse.Warehouse;
import observer_pattern.Observer;


public class WarehouseSystem {
	private final Warehouse Warehouse;
	private final RequestObserver requests;
	private final ArrayList<Agent> agents;


	public WarehouseSystem() {
		this.agents = new ArrayList<>();
		this.requests = new RequestObserver();
		this.Warehouse = new Warehouse();
//		this.Warehouse = new Warehouse(this.requests)
	
	}

	public RequestObserver getRequests() {return this.requests;}

	public Warehouse getWarehouse() {return this.Warehouse;}


	 //Method that will run the whole simulation
	 
	public void simulate()
	{
    	System.out.println("Starting simulation...");
    	System.out.print("Setting up the outputTruck...");
    	System.out.print("setting up the inputTruck...");
    	System.out.print("setting up the agents...");
    	System.out.print("setting up the Repository...");

		Truck inputTruck_1 = new InputTruck("ABC");
		Truck inputTruck_2 = new InputTruck("DEF");
		Truck inputTruck_3 = new InputTruck("GHI");
		Truck inputTruck_4 = new InputTruck("JKL");
		Truck inputTruck_5 = new InputTruck("MNO");
		Truck inputTruck_6 = new InputTruck("PQR");
		Truck inputTruck_7 = new InputTruck("STU");
		Truck inputTruck_8 = new InputTruck("VWX");
		Truck inputTruck_9 = new InputTruck("Y&Z");
		Truck inputTruck_10 = new InputTruck("000");
		
    	System.out.print("Adding Item...");

		Item item = new Item("Maggi", 2, 3);
		inputTruck_1.addItem(item);
		
    	System.out.println("Setting up parking...");
    	System.out.println("");
    	
		Parking parking = this.Warehouse.getParking();
		Observer a = new Observer();
		parking.attach(a);
		
		//Utilizes method that adds a given truck to the object truck list
		parking.addTruck(inputTruck_1);
		parking.addTruck(inputTruck_2);
		parking.addTruck(inputTruck_3);
		parking.addTruck(inputTruck_4);
		parking.addTruck(inputTruck_5);
		parking.addTruck(inputTruck_6);
		parking.addTruck(inputTruck_7);
		parking.addTruck(inputTruck_8);
		parking.addTruck(inputTruck_9);
		parking.addTruck(inputTruck_10);
		
		//Utilizes method that removes a given truck from the truck list
		parking.removeTruck(inputTruck_8);
		parking.removeTruck(inputTruck_10);
		parking.removeTruck(inputTruck_1);
		parking.removeTruck(inputTruck_9);
		
		parking.notifyObservers();
//		returning the current list of trucks from the observer to make sure that the observer is getting updated
//		correctly when the parking object gets new trucks added to it. We can see that it returns the trucks that
//		we added to the parking object 
		ArrayList<Truck> trucks = a.getTrucks();
		
		Agent IncomingAgent_1 = new IncomingAgent("Sarah");
		Agent IncomingAgent_2 = new IncomingAgent("John");
		Agent IncomingAgent_3 = new IncomingAgent("Tim");
		Agent IncomingAgent_4 = new IncomingAgent("Brian");
		Agent IncomingAgent_5 = new IncomingAgent("Jim");
		Agent IncomingAgent_6 = new IncomingAgent("Ron");
		Agent IncomingAgent_7 = new IncomingAgent("Peter");
		Agent IncomingAgent_8 = new IncomingAgent("Harry");
		Agent IncomingAgent_9 = new IncomingAgent("Rick");
		Agent IncomingAgent_10 = new IncomingAgent("Sam");
		
		
		Parking parkingg = this.Warehouse.getParking();
		Observer o = new Observer();
		parkingg.attachAgent(o);
		
		//Utilizes method that adds a given agent to the object agent list
		parkingg.addAgent(IncomingAgent_1);
		parkingg.addAgent(IncomingAgent_2);
		parkingg.addAgent(IncomingAgent_3);
		parkingg.addAgent(IncomingAgent_4);
		parkingg.addAgent(IncomingAgent_5);
		parkingg.addAgent(IncomingAgent_6);
		parkingg.addAgent(IncomingAgent_7);
		parkingg.addAgent(IncomingAgent_8);
		parkingg.addAgent(IncomingAgent_9);
		parkingg.addAgent(IncomingAgent_10);
		
		//Utilizes method that removes a given agent from the agent list
		parkingg.removeAgent(IncomingAgent_4);
		parkingg.removeAgent(IncomingAgent_6);
		parkingg.removeAgent(IncomingAgent_8);
		
		parkingg.notifyAgentObservers();
//		returning the current list of agents from the observer to make sure that the observer is getting updated
//		correctly when the parking object gets new agents added to it. We can see that it returns the agents that
//		we added to the parking object 
		ArrayList<Agent> agents = o.getAgents();
		
//		setting up the truck and agent repositories which is a Container subclass and handles iterating through a truck and Agent arraylist
		TruckRepository truck_repo = new TruckRepository();
		AgentRepository agent_repo = new AgentRepository();
		
//		setting up the trucks and agents in their repositories to the trucks and agents that our observer class returned back to us 
		truck_repo.trucks = trucks;
		agent_repo.agents = agents;
		
//		getting the iterator from the truck and agent repository 
		Iterator<Truck> truck_iterator = truck_repo.getIterator();
		Iterator<Agent> agent_iterator = agent_repo.getIterator();
		
//		iterating through the trucks inside the truck repo and printing out "truck" while the truck repo still has trucks that we haven't iterated though yet
		while(truck_iterator.hasNext()) { 
			Truck current_truck = truck_iterator.next();
			String license_plate = current_truck.getLicensePlate();
			System.out.print("");
			System.out.println("The license plate of the current truck is: " + license_plate);
		}
//		iterating through the agents inside the agent repo and printing out "agent" while the agent repo still has agents that we haven't iterated though yet
		while(agent_iterator.hasNext()) { 
			Agent current_agent = agent_iterator.next();
			String agentName = current_agent.getAgentName();
			System.out.println("");
			System.out.print("The name of the agents currently working is: " + agentName);
		}
		
		
	}


}

