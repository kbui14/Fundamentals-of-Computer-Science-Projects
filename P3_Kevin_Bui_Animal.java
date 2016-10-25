package cs225;



public class P3_Kevin_Bui_Animal {
		
	
	protected int numberOfFeedings; 
	private int numberOfRequiredFeedings; 
	
	
	P3_Kevin_Bui_Animal(int feedingsRequired){
		numberOfRequiredFeedings = feedingsRequired;
		numberOfFeedings = 0;
	}
	
	public int numOFFeedings(){
		return numberOfFeedings;
	}
	
	public void feed(FoodType ft){
		System.err.println("err");
	}
	public String speak(){
		
		return "err";
		
	}
	public boolean isStillHungry(){
		if(numberOfFeedings < numberOfRequiredFeedings)
			return false;
		return true;
	}
	
	
}
