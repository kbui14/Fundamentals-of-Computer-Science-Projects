package cs225;

import java.util.ArrayList;

public class L5_Kevin_Bui_ManagerClass_P2 extends L5_Kevin_Bui_EmployeeClass_P2 {
	
	private ArrayList<L5_Kevin_Bui_EmployeeClass_P2> managedEmployees;
	
	L5_Kevin_Bui_ManagerClass_P2(){
		managedEmployees = new ArrayList<L5_Kevin_Bui_EmployeeClass_P2>();
		
	}

	L5_Kevin_Bui_ManagerClass_P2(String fn, String ln, double hr, double y){
		super(fn, ln, hr, y);
		managedEmployees = new ArrayList<L5_Kevin_Bui_EmployeeClass_P2>();
		
	}
	
	public void addEmployee(L5_Kevin_Bui_EmployeeClass_P2 e){
		managedEmployees.add(e);
	}
	public void removeEmployee(long id){
		for(int i=0; i<managedEmployees.size(); i++)
			if (managedEmployees.get(i).getUniqueId()==id){
				managedEmployees.remove(i);
				break;
			}
	}
	
	protected void promote(){
		years++;
		hourlyRate = hourlyRate * 1.05 + (managedEmployees.size() * .25);
	}
}
