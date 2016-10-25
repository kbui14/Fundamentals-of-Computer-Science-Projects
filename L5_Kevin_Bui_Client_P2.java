package cs225;

import java.util.ArrayList;

public class L5_Kevin_Bui_Client_P2 extends L5_Kevin_Bui_ManagerClass_P2 {
	public static void main(String[] args)
	{
		// Will hold an external (i.e., in the client) list of employees
		ArrayList<L5_Kevin_Bui_EmployeeClass_P2> externalEmployeeList = new ArrayList<L5_Kevin_Bui_EmployeeClass_P2>();
		
		
		// Create manager
		L5_Kevin_Bui_ManagerClass_P2 m = new L5_Kevin_Bui_ManagerClass_P2("Jer", "Matson", 20.0, 5);
		externalEmployeeList.add(m);

		// Name constants
		String [] firstNames = {"Bill", "Sue", "Jim", "Jon", "Katy", "Eddie", "Martha"};
		String [] lastNames = {"Smith", "Jones", "Brown", "Black", "Ortiz", "Ricks", "Kim"};
		
		// Add new employees to external list and to manager's personal list
		for (int i = 0; i < 7; i++)
		{
			L5_Kevin_Bui_EmployeeClass_P2 e = new L5_Kevin_Bui_EmployeeClass_P2(firstNames[i], lastNames[i], (10.0 + i), (i + 1));
			m.addEmployee(e);
			externalEmployeeList.add(e);
		}

		// Manager loses an employee with employee id 2 (although they aren't fired, so still in external list)
		m.removeEmployee(2);
		
		// Somewhat-random promotions
		externalEmployeeList.get(0).promote();
		externalEmployeeList.get(2).promote();
		externalEmployeeList.get(4).promote();
		externalEmployeeList.get(5).promote();
		
		// Print out all employee information in our external list
		for (L5_Kevin_Bui_EmployeeClass_P2 e : externalEmployeeList)
			System.out.println(e.toString());
		
		System.out.println("Thank you for visiting my company!");

	}

}



