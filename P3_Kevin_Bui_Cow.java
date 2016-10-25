package cs225;

public class P3_Kevin_Bui_Cow extends P3_Kevin_Bui_Animal{
	P3_Kevin_Bui_Cow(int feedingsRequired) {
	super(feedingsRequired);
	}
	public void feed(FoodType ft){
		if (ft == FoodType.GRASS){
			numberOfFeedings++;
		}
	}
	public String speak(){
		return "MOO";
	}
}
