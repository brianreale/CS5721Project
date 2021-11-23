package utilities;

import java.util.ArrayList;

public class WarehouseRequest {
	private final ArrayList<Item> unloadRequest;
	private final ArrayList<Item> loadRequest;
	
	public WarehouseRequest(ArrayList<Item> unloadRequest, ArrayList<Item> loadRequest) {
		this.unloadRequest = unloadRequest;
		this.loadRequest = loadRequest;
	}
	
	
	public ArrayList<Item> getUnloadRequest() {
		return unloadRequest;
	}

	public ArrayList<Item> getLoadRequest() {
		return loadRequest;
	}

}
