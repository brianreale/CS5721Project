package parking;

import java.util.ArrayList;

import observer_pattern.Observer;
import observer_pattern.Subject;
import utilities.Item;
import utilities.WarehouseRequest;

//public class requestObserver implements Observer {
public class requestObserver {

	//List of all the request objects created by every truck in the observed parking.
	private final ArrayList<WarehouseRequest> requests;

	public requestObserver()
	{
		this.requests = new ArrayList<>();
	}

	public void update(Subject subject)
	{
		for (Truck truck : ((Parking) subject).getTrucks()) {
			this.requests.add(truck.getRequest());
			((Parking) subject).removeTruck(truck);
		}
	}

	
	 // Method that merges every request in the requests List into a single WarehouseRequest object
	 
	public WarehouseRequest getRequest()
	{
		ArrayList<Item> unloadRequest = new ArrayList<>();
		ArrayList<Item> loadRequest = new ArrayList<>();
		
		
		for (WarehouseRequest warehouseRequest : this.requests) {
			if (!warehouseRequest.getLoadRequest().isEmpty()) {
				loadRequest.addAll(warehouseRequest.getLoadRequest());
			}

			if (!warehouseRequest.getUnloadRequest().isEmpty()) {
				loadRequest.addAll(warehouseRequest.getUnloadRequest());
			}
		}

		return new WarehouseRequest(unloadRequest, loadRequest);
	}

//	@Override
	public void update(Parking subject) {
		// TODO Auto-generated method stub
		
	}
}