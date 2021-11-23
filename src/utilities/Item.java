package utilities;

public class Item {
	private String name;
	private int weight;
	private int demand;
	
	public Item(String name, int weight, int demand) {
		setName(name);
		setWeight(weight);
		setDemand(demand);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public int getDemand() {
		return demand;
	}
	
	public void setDemand(int demand) {
		this.demand = demand;
	}
}
