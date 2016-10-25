package cs225;
/////////////////////////////////////////////////
//This is a special class needed to be able to 
//countdown from 10 while waiting for user input.
//DO NOT EDIT OR TURN THIS CLASS IN.
/////////////////////////////////////////////////
import java.util.Scanner;

public class NonBlockingHasNext extends Thread {

Scanner scan = new Scanner(System.in);
private boolean hasNext = false;
private int nextInt;

public void run()
{
if (!hasNext)
{				
if (scan.hasNext())
{
hasNext = true;
nextInt = scan.nextInt();

// Only accept if is 1, 2 or 3
if (nextInt < 1 || nextInt > 3)
{
hasNext = false;
run();
}
}
}
}

public boolean hasNext()
{
return hasNext;
}

public int nextInt()
{
return nextInt;
}	
}
