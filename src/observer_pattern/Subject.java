package observer_pattern;

public interface Subject {

	
	 //Method that attaches an observer to the subject
	 
	public void attach(Observer a);
	
	public void attachAgent(Observer o);
	
	
	 // Method that detaches an observer from the subject
	 
	public void detach(Observer a);
	
	public void detachAgent(Observer o);
	
	
	 // Method that notifies all attached observers 
	 
	public void notifyObservers();
	
	public void notifyAgentObservers();
}
