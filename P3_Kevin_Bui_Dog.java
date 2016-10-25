package cs225;

public class P3_Kevin_Bui_Dog extends P3_Kevin_Bui_Animal{
	P3_Kevin_Bui_Dog(int feedingsRequired) {
	super(feedingsRequired);
	}
	public void feed(FoodType ft){
		if (ft == FoodType.BONE){
			numberOfFeedings++;
		}
	}
	public String speak(){
		return "WOOF";
	}
}
