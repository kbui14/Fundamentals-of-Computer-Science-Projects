package cs225;

public class P3_Kevin_Bui_Cat extends P3_Kevin_Bui_Animal{
	P3_Kevin_Bui_Cat(int feedingsRequired) {
	super(feedingsRequired);
	}
	public void feed(FoodType ft){
		if (ft == FoodType.SALMON){
			numberOfFeedings++;
		}
	}
	public String speak(){
		return "MEOW";
	}
}