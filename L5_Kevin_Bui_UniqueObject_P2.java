package cs225;
/* CS 225 -  Fundamentals of Computer Science
 * File Name: L5_Lastname1_Lastname2_UniqueObject_P2.java
 * Java Programming
 * Lab 5 - Due 2/23/15
 * Instructor: Dan Grissom
 * 
 * Name 1: Kevin Bui
 *
 * Description:  Create a inherited class structure
 */
import java.text.DecimalFormat;
public class L5_Kevin_Bui_UniqueObject_P2 {
	private static long nextUniqueId = 0;
	private long uniqueId;
	
	public DecimalFormat df = new DecimalFormat("0000");
	public DecimalFormat dff = new DecimalFormat("$##.00");
	public static void main(String[] args){
	System.out.println("Kevin Bui");
	System.out.println("Lab 5, Problem # 2");
	System.out.println("");
	}
	
	L5_Kevin_Bui_UniqueObject_P2() {
		
		this.uniqueId = uniqueId;
		uniqueId = nextUniqueId++;
		
	}

	protected long getUniqueId() {
		return uniqueId;
	}

	protected String getUniqueIdString() {
		return df.format(uniqueId);
		
	}
	
	
}
