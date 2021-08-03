package jo.secondstep.jdbc;

import java.util.List;

public interface InfoEmployee {
	public List<Employee> informationEmployeeinCountry(String value);
	public List<Employee> informationEmployeeWithSpecificYear(String value,String year);
	public List<Employee> informationEmployeeInSpacificJob(String value,double salary);
	public List<Employee> informationEmployeeForManager(String firstName,String lastName);
	

}
