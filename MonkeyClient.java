package cs225;

import java.util.Scanner;


public class MonkeyClient {
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("How many monkeys do you have? (insert integer)?");
		int numMonkeys = scan.nextInt();
		
		for(int i = 0; i < numMonkeys; i++)
		{
			System.out.println("Please enter details for monkey # " + (i+1));
			System.out.println("\tEnter the number of bananas: ");
			int numBan = scan.nextInt();
			
			System.out.println("\tEnter the weight in kg: ");
			double kgweight = scan.nextDouble();
			
			System.out.println("\t Is the Monkey male or female (enter 'M' or 'F') ");
			String mf = scan.next();
			boolean isMale;
			if(mf.toLowerCase().startsWith(mf, 'm'))
				isMale = true;
			else 
				isMale = false;
			
			
			Monkey m = new Monkey(numBan, isMale, kgweight);
			m.toString();
		}
		System.out.println("Goodbye.");
	}
}
