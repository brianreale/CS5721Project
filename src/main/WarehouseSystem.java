package main;

import java.util.ArrayList;
import java.util.Iterator;

import parking.inputTruck;
import parking.requestObserver;
import parking.Parking;
import parking.Truck;
import parking.TruckRepository;
import utilities.Item;
import utilities.WarehouseRequest;
import Warehouse.Agent;
import Warehouse.Warehouse;
import observer_pattern.Observer;


public class WarehouseSystem {
	public static int MAX_GRID_X_COORDINATE_LENGTH = 3;
	public static int MAX_GRID_Y_COORDINATE_LENGTH = 6;
	//private static System system = null;
	private final Warehouse Warehouse;
	private final requestObserver requests;
	private final ArrayList<Agent> agents;
	//private boolean isLoggedInAsAgent = false;
	//private String currentLoggedInAgentName = null;


	public WarehouseSystem() {
		this.agents = new ArrayList<>();
		this.requests = new requestObserver();
		this.Warehouse = new Warehouse();
//		this.Warehouse = new Warehouse(this.requests);

		//CREATE AGENTS
		this.loadSystemAgentsDataFromFile();
	}

	private void loadSystemAgentsDataFromFile()
	{
		this.agents.add(new Agent("sarah"));
		this.agents.add(new Agent("john"));
		this.agents.add(new Agent("isaac"));
		this.agents.add(new Agent("ada"));
	}

	
	public requestObserver getRequests() {return this.requests;}

	public Warehouse getWarehouse() {return this.Warehouse;}

//	public System init() {
//		if (system == null){
//			system = new System();
//		}
//		return system;
//	}

	
	 //Method that will run the whole simulation
	 
	public void simulate()
	{
    	System.out.println("Starting simulation...");
    	System.out.print("Setting up the outputTruck...");
    	System.out.print("setting up the inputTruck...");
    	System.out.print("setting up the inputTruck...");
    	System.out.print("setting up the Repository...");

		Truck inputTruck_1 = new inputTruck("ABC");
		Truck inputTruck_2 = new inputTruck("DEF");
		Truck inputTruck_3 = new inputTruck("GHI");
		Truck inputTruck_4 = new inputTruck("JKL");
		Truck inputTruck_5 = new inputTruck("MNO");
		Truck inputTruck_6 = new inputTruck("PQR");
		Truck inputTruck_7 = new inputTruck("STU");
		Truck inputTruck_8 = new inputTruck("VWX");
		Truck inputTruck_9 = new inputTruck("YZ0");
		
    	System.out.print("Adding Item...");

		Item item = new Item("Maggi", 2, 3);
		inputTruck_1.addItem(item);
		
    	System.out.print("Setting up parking...");

		Parking parking = this.Warehouse.getParking();
		Observer o = new Observer();
		parking.attach(o);
		parking.addTruck(inputTruck_1);
		
		parking.addTruck(inputTruck_2);
		parking.addTruck(inputTruck_3);
		parking.addTruck(inputTruck_4);
		parking.addTruck(inputTruck_5);
		parking.addTruck(inputTruck_6);
		parking.addTruck(inputTruck_7);
		parking.addTruck(inputTruck_8);
		parking.addTruck(inputTruck_9);
		
		parking.notifyObservers();
		
//		returning the current list of trucks from the observer to make sure that the observer is getting updated
//		correctly when the parking object gets new trucks added to it. We can see that it returns the trucks that
//		we added to the parking object 
		
		ArrayList<Truck> trucks = o.getTrucks();
		
//		setting up the truck repository which is a Container subclass and handles iterating through a truck arraylist
		TruckRepository truck_repo = new TruckRepository();
		
//		setting the trucks in the truck repository to the trucks that our observer class returned back to us 
		truck_repo.trucks = trucks;
		
//		getting the iterator from the track repository 
		Iterator<Truck> truck_iterator = truck_repo.getIterator();
		
//		iterating through the trucks inside the truck repo and printing out "truck" while the truck repo still has trucks that we haven't iterated though yet
		while(truck_iterator.hasNext()) { 
			Truck current_truck = truck_iterator.next();
			String license_plate = current_truck.getLicensePlate();
			System.out.println("The license plate of the current truck is: " + license_plate);
		}
		
		
		//this.Warehouse.getParking().addTruck(inputTruck);
		
		//this.Warehouse.getParking().notifyObservers();
		

		//WarehouseRequest warehouseRequest = this.requests.getRequest();

		//java.lang.System.out.println(this.requests.getRequest().getUnloadRequest());
	}


}

