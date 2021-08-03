package jo.secondstep.jdbc;

import java.awt.List;

public class Main {

	public static void main(String[] args) {

		Job job = new Job();

		System.out.println("Query 1 \nAll job title that minimum salary is more that 5000\n");
		for (int i = 0; i < job.jobSalaryMorethan(5000).size(); i++) {
			System.out.println(job.jobSalaryMorethan(5000).get(i).getJobTitle() + "   "
					+ job.jobSalaryMorethan(5000).get(i).getMinSalary());
		}

		System.out.println("\n-----------------------\n\nQuery 2 \nTotal salary for IT employess\n");

		Department department = new Department();

		for (Object i : department.totalSalaryEmployess("IT").keySet()) {
			System.out.println(
					"Total Salary for " + i + " department is : " + department.totalSalaryEmployess("IT").get(i));

		}
		System.out.println("\n-----------------------\n\nQuery 3 \nTotal salary for each department in country\n");
		Country country = new Country();

		for (Object i : country.totalSalaryEmployess("").keySet()) {
			System.out.println("Total Salary for " + i + " is : " + country.totalSalaryEmployess("").get(i));

		}
		
		
		Employee employee = new Employee();
		
		System.out.println("\n-----------------------\n\nQuery 4 \nName and Phone of each employee in United States of America\r\n" );

		for (int i = 0; i < employee.informationEmployeeinCountry("United States of America").size(); i++) {
			System.out.println(employee.informationEmployeeinCountry("United States of America").get(i).getfirstName() + "   "
					+ employee.informationEmployeeinCountry("United States of America").get(i).getlast_name()+ 
					"   "+employee.informationEmployeeinCountry("United States of America").get(i).getPhoneNumber());
		}
		
		
Employee employee1 = new Employee();

		System.out.println("\n-----------------------\n\nQuery 5 \nAll Information of each employee in job Programmer and salary > 5000\r\n" );

		for (int i = 0; i < employee1.informationEmployeeWithSpecificYear("Japan","1994").size(); i++) {
			System.out.println(employee1.informationEmployeeWithSpecificYear("Japan","1994").get(i).getfirstName() + "   "
					+ employee1.informationEmployeeWithSpecificYear("Japan","1994").get(i).getlast_name()+ "   "+
					employee1.informationEmployeeWithSpecificYear("Japan","1994").get(i).getPhoneNumber()
					+"    "+employee1.informationEmployeeWithSpecificYear("Japan","1994").get(i).getEmail()+"    "+
					employee1.informationEmployeeWithSpecificYear("Japan","1994").get(i).getHireDate()+"    "+
					employee1.informationEmployeeWithSpecificYear("Japan","1994").get(i).getSalary()
					);
		}
		
		
		Employee employee2 = new Employee();

		System.out.println("\n-----------------------\n\nQuery 6 \nAll Information of each employee that hire year is 1994 in Japan \r\n" );

		for (int i = 0; i < employee2.informationEmployeeInSpacificJob("Programmer",5000).size(); i++) {
			System.out.println(employee2.informationEmployeeInSpacificJob("Programmer",5000).get(i).getfirstName() + "   "
					+ employee2.informationEmployeeInSpacificJob("Programmer",5000).get(i).getlast_name()+ "   "+
					employee2.informationEmployeeInSpacificJob("Programmer",5000).get(i).getPhoneNumber()
					+"    "+employee2.informationEmployeeInSpacificJob("Programmer",5000).get(i).getEmail()+"    "+
					
					employee2.informationEmployeeInSpacificJob("Programmer",5000).get(i).getSalary()
					);
		}
		
		Dependent dependent = new Dependent();
		
		System.out.println("\n-----------------------\n\nQuery 8 \nAll information dependents for employee 'Steven King'\r\n" );

		for (int i = 0; i < dependent.informationDependentsForEmployee("Steven", "King").size(); i++) {
			System.out.println(dependent.informationDependentsForEmployee("Steven", "King").get(i).getFirstName() + "   "
					+ dependent.informationDependentsForEmployee("Steven", "King").get(i).getLastName()+ "   "+
					dependent.informationDependentsForEmployee("Steven", "King").get(i).getRelationship());
		}
		
Employee employee3 = new Employee();
		
		System.out.println("\n-----------------------\n\nQuery 8 \nNames of employee there manager is 'Dan Raphaely'\r\n" );

		for (int i = 0; i < employee3.informationEmployeeForManager("Den", "Raphaely").size(); i++) {
			System.out.println(employee3.informationEmployeeForManager("Den", "Raphaely").get(i).getfirstName() + "   "
					+ employee3.informationEmployeeForManager("Den", "Raphaely").get(i).getlast_name()+ 
					"   "+employee3.informationEmployeeForManager("Den", "Raphaely").get(i).getEmail());
		}
		
		System.out.println("\n-----------------------\n\nQuery 9 \nNumber of employee in each country\n");
		Country country1 = new Country();

		for (Object i : country.numberOfEmployee().keySet()) {
			System.out.println("Number of employee in  " + i + " is : " + country.numberOfEmployee().get(i));

		}
		
		
		System.out.println("\n-----------------------\n\nQuery 9 \nNumber of employee and total salay  for each job \n");
		Job job2 = new Job();

		for (Object i : job2.totalSalarywithNofEmployee().keySet()) {
			System.out.println( i + "  Number of Employee is : " + job.totalSalarywithNofEmployee().get(i).get(0)
					
					+  "    Total Salary is : "  +job.totalSalarywithNofEmployee().get(i).get(1));
			
			

		}
		
		
		
	}

}
