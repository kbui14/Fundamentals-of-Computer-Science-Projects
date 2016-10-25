package cs225;
/* CS 220 - Intro to Computer Science
 * File Name: P3_LastName1_LastName2_Client.java
 * Java Programming
 * Project 3 - Due 2/27/2015
 * Instructor: Dan Grissom
 * 
 * Name 1: Kevin Bui
 * 
 * Description: Feed animals because Ol'mc D is blind.
 */

// Imports
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

// Enum type for food
enum FoodType { BONE, SALMON, GRASS }


public class P3_Kevin_Bui_MacD_Client
{
	// Constants for food costs
	final static double grassCost = 1.0;
	final static double boneCost = 3.0;
	final static double salmonCost = 5.0;
	static int cow = 0, cat=0, dog=0; // count how many each animals are
	static int dogFeed, catFeed, cowFeed; // count how many times an animal has been fed
	static double totalGrass, totalSalmon, totalBone; //adds total cost for each Food

	public static void main(String[] args)
	{
		// Your program should always output your name and the lab/problem
		// number. DO NOT DELETE OR COMMENT OUT. Replace with relevant info.
		System.out.println("Kevin Bui");
		System.out.println("Project #3");
		System.out.println("");
		
		// Decimal format class for printing out any prices
		DecimalFormat df = new DecimalFormat("$0.00");		
		
		// Use this test case to reproduce the output in the Project writeup
		//ArrayList<P3_Kevin_Bui_Animal> stalls = generateDogCatCow5ServingArrangement();
		int numAnimals = 6;
	
		
		// Use this test case (comment out line above) to generate random test cases
		ArrayList<P3_Kevin_Bui_Animal> stalls = generateRandomStallArrangement(numAnimals);
		
		for(int i=0; i<stalls.size();i++){
			
			if (stalls.get(i).speak() == "MOO"){
				while( stalls.get(i).isStillHungry()==false){
					stalls.get(i).feed(FoodType.GRASS);
					stalls.get(i).isStillHungry();
				}
					System.out.println("Stall " + (i+1) + " of " + stalls.size() + " contains a Cow who had " + stalls.get(i).numberOfFeedings + " feedings, which cost " + df.format(stalls.get(i).numberOfFeedings * grassCost));
					totalGrass += stalls.get(i).numberOfFeedings * grassCost;
					cowFeed += stalls.get(i).numberOfFeedings;
				cow++;
			}
			if (stalls.get(i).speak() == "WOOF"){
				while( stalls.get(i).isStillHungry()==false){
					stalls.get(i).feed(FoodType.BONE);
					stalls.get(i).isStillHungry();
				}
					System.out.println("Stall " + (i+1) + " of " + stalls.size() + " contains a Dog who had " + stalls.get(i).numberOfFeedings + " feedings, which cost " + df.format(stalls.get(i).numberOfFeedings * boneCost));
					totalBone += stalls.get(i).numberOfFeedings * boneCost;
					dogFeed += stalls.get(i).numberOfFeedings;
				dog++;
			}
			if (stalls.get(i).speak() == "MEOW"){
				while( stalls.get(i).isStillHungry()==false){
					stalls.get(i).feed(FoodType.SALMON);
					stalls.get(i).isStillHungry();
				}
					System.out.println("Stall " + (i+1) + " of " + stalls.size() + " contains a Cat who had " + stalls.get(i).numberOfFeedings + " feedings, which cost " + df.format(stalls.get(i).numberOfFeedings * salmonCost));
					totalSalmon += stalls.get(i).numberOfFeedings * salmonCost;
					catFeed += stalls.get(i).numberOfFeedings;
				cat++;
			}
			
		}
		System.out.println();
		System.out.println("Old McDonald's total expense:");
		System.out.println( df.format(totalGrass) + " spent feeding " + cow + " cow(s) " + cowFeed + " total feedings");
		System.out.println( df.format(totalSalmon) + " spent feeding " + cat + " cat(s) " + catFeed + " total feedings");
		System.out.println( df.format(totalBone) + " spent feeding " + dog + " dog(s) " + dogFeed + " total feedings");
		System.out.println("\tTotal Cost: " + df.format(totalGrass + totalSalmon + totalBone));
	

		// TODO: Insert your code here which causes Old MacDonald (this client code) to
		// visit each of the stalls. Old MacDonald should speak to each animal to determine
		// what type of food to feed it. All along the way, he keeps track of what types 
		// of animals and how much of each type of food he is using. See the project
		// PDF for specific output expectations.

		
		// Exiting program
		System.out.println("E-I-E-I-O!");		
	}
	
	/////////////////////////////////////////////////////////////////////////////////
	// DO NOT EDIT
	// This method generates a stall with numAnimals which are generated randomly.
	// In addition, the number of feedings required per animal are set randomly as
	// a number between 1 and 10.
	/////////////////////////////////////////////////////////////////////////////////
	private static ArrayList<P3_Kevin_Bui_Animal> generateRandomStallArrangement(int numAnimals)
	{
		// Create new stall (ArrayList) of animals
		ArrayList<P3_Kevin_Bui_Animal> newStallArrangement = new ArrayList<P3_Kevin_Bui_Animal>();
		 
		// Generate random animal  numbers of feedings required
		// AND random number of feedings required per animal
		Random r = new Random();
		
		// Generate numAnimals new animals
		for (int i = 0; i < numAnimals; i++)
		{
			int randAnimal = r.nextInt(3); // (Dog = 0, Cat = 1, Dog = 2)
			int numFeedings = r.nextInt(10)+1; // 1-10 feedings required per animal
			
			if (randAnimal == 0)
				newStallArrangement.add(new P3_Kevin_Bui_Dog(numFeedings));
			else if (randAnimal == 1)
				newStallArrangement.add(new P3_Kevin_Bui_Cat(numFeedings));
			else
				newStallArrangement.add(new P3_Kevin_Bui_Cow(numFeedings));
		}
		
		return newStallArrangement;
	}
	
	/////////////////////////////////////////////////////////////////////////////////
	// DO NOT EDIT
	// This method generates a stall with a dog, cat and cow, which each need five
	// servings of food.
	/////////////////////////////////////////////////////////////////////////////////
	private static ArrayList<P3_Kevin_Bui_Animal> generateDogCatCow5ServingArrangement()
	{
		// Create new stall (ArrayList) of animals containing a Dog, Cat & Cow, each with a requirement of 5 servings
		ArrayList<P3_Kevin_Bui_Animal> newStallArrangement = new ArrayList<P3_Kevin_Bui_Animal>();
		newStallArrangement.add(new P3_Kevin_Bui_Dog(5));
		newStallArrangement.add(new P3_Kevin_Bui_Cat(5));
		newStallArrangement.add(new P3_Kevin_Bui_Cow(5));
		return newStallArrangement;
	}
}
