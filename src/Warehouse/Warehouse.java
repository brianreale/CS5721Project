package Warehouse;

import java.util.ArrayList;


import parking.Parking;


public class Warehouse {
	private final ArrayList<Parking> parkings;

	public Warehouse()

	{
		Parking parking = new Parking();
		this.parkings = new ArrayList<>();
		this.parkings.add(parking);
	}


	public Parking getParking()
	{
		return this.parkings.get(0);
	}
	
	
}