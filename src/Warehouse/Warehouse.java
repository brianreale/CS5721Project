package Warehouse;

import java.util.ArrayList;

import main.WarehouseSystem;
import parking.Parking;
import parking.requestObserver;
import parking.requestObserver;
import utilities.Coordinates;
import utilities.Item;

public class Warehouse {
	private final ArrayList<ArrayList<GridElement>> grid;
	private final ArrayList<Parking> parkings;

//	public Warehouse(requestObserver requests)
	public Warehouse()

	{
		this.grid = new ArrayList<>();
		this.generateWarehouseSelfGrids();

		Parking parking = new Parking();
//		parking.attach(requests);
		this.parkings = new ArrayList<>();
		this.parkings.add(parking);
	}

	private void generateWarehouseSelfGrids()
	{
		// A{7} | B{7} | C{7} | D{7}
		for (int i = 0; i <= WarehouseSystem.MAX_GRID_X_COORDINATE_LENGTH; i++) {
			ArrayList<GridElement> xGrid = new ArrayList<>();

			for (int j = 0; j <= WarehouseSystem.MAX_GRID_Y_COORDINATE_LENGTH; j++) {
				GridElement yGrid = new GridElement(5);
				xGrid.add(yGrid);
			}
			this.grid.add(xGrid);
		}
	}

	public Parking getParking()
	{
		return this.parkings.get(0);
	}
	
	
	 // Method that gives the GridElement at specific coordinates
	 
	public GridElement at(Coordinates coords) {
		return this.grid.get(coords.getX()).get(coords.getY());
	}
	
	
	 // Method that finds every set of Coordinates that leads to a GridItem containing a specific item
	 
	public ArrayList<Coordinates> find(Item item)
	{
		ArrayList<Coordinates> coordinates = new ArrayList<>();

		// A{7} | B{7} | C{7} | D{7}
		for (int x = 0; x <= WarehouseSystem.MAX_GRID_X_COORDINATE_LENGTH; x++) {

			ArrayList<GridElement> xGrid = this.grid.get(x);

			for (int y = 0; y <= WarehouseSystem.MAX_GRID_Y_COORDINATE_LENGTH; y++) {
				GridElement gridElement = xGrid.get(y);

				if(gridElement.hasItem(item)){
					coordinates.add(new Coordinates(x, y));
				}
			}
		}

		return coordinates;
	}
}