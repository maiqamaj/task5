package jo.secondstep.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Employee implements InfoEmployee{
	
		private int employeeId;
		private String firstName;
		private String lastName;
		private String email;
		private String phoneNumber;
		private String hireDate;
		private double salary;
		private Job job;
		private int managerId = 0;
		public String dbURL = "jdbc:sqlserver://192.168.1.27:49170;databaseName=data1";
		public String user = "mai";
		public String pass = "123456";
        
		public Employee() {}
		public Employee(int employeeId, String firstName, String lastName, String email, String phoneNumber,
				String hireDate, double salary, int managerId) {
			this.employeeId = employeeId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.phoneNumber = phoneNumber;
			this.hireDate = hireDate;
			this.salary = salary;
			this.managerId = managerId;
		}

		public int getEmployeeId() {
			return this.employeeId;
		}

		public void setEmployeeId(int id) {
			this.employeeId = id;
		}

		public String getfirstName() {
			return this.firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getlast_name() {
			return this.lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return this.email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhoneNumber() {
			return this.phoneNumber;
		}

		public void setPhoneNumber(String Phone) {
			this.phoneNumber = Phone;
		}

		public String getHireDate() {
			return this.hireDate;
		}

		public void setHireDate(String Date) {
			this.hireDate = Date;
		}

		public double getSalary() {
			return this.salary;
		}

		public void setSalary(double salary) {
			this.salary = salary;
		}

		public int getManagerId() {
			return managerId;
		}

		public void setManagerId(int managerId) {
			this.managerId = managerId;
		}

		public Job getJob() {
			return job;
		}

		public void setJob(Job job) {
			this.job = job;
		}

	

	@Override
	public List<Employee> informationEmployeeinCountry(String value) {
	
				try {
					Connection conn = DriverManager.getConnection(dbURL, user, pass);
					// System.out.print("DB Connected..\n");
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery("select e.first_name,e.last_name,e.phone_number\r\n" + 
							"from  locations l \r\n" + 
							"inner join departments d on d.location_id=l.location_id\r\n" + 
							"inner join employees e on d.department_id=e.department_id\r\n" + 
							"inner join countries c on c.country_name='"+value+"';");
					
					List<Employee> employees = new ArrayList<>();
					while (rs.next()) {
						Employee employee = new Employee();
						employee.setFirstName(rs.getString(1));
						employee.setLastName(rs.getString(2));
						employee.setPhoneNumber(rs.getString(3));
						employees.add(employee);
						
					}
					conn.close();
					return employees;
				} catch (SQLException e) {
					System.out.print("Error");
					e.printStackTrace();
				}
				return null;

	}
	@Override
	public List<Employee> informationEmployeeWithSpecificYear(String value, String year) {
		
				try {
					Connection conn = DriverManager.getConnection(dbURL, user, pass);
					// System.out.print("DB Connected..\n");
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery("select e.employee_id,e.first_name,e.last_name,e.email,e.phone_number,"
							+ "e.hire_date,e.salary,e.manager_id from  locations l \r\n" + 
							"inner join departments d on d.location_id=l.location_id\r\n" + 
							"inner join employees e on d.department_id=e.department_id\r\n" + 
							"inner join countries c on c.country_name='"+value+"'where year(hire_date)='"+1994+"';");
					
					List<Employee> employees = new ArrayList<>();
					while (rs.next()) {
						
						Employee employee = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),
								rs.getString(6),rs.getDouble(7),rs.getInt(8));
						
						employees.add(employee);
						
					}
					conn.close();
					return employees;
				} catch (SQLException e) {
					System.out.print("Error");
					e.printStackTrace();
				}
				return null;

	}
	@Override
	public List<Employee> informationEmployeeInSpacificJob(String value, double salary) {
		
			try {
				Connection conn = DriverManager.getConnection(dbURL, user, pass);
				// System.out.print("DB Connected..\n");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select e.first_name,e.last_name,e.email,e.phone_number,e.salary from jobs j \r\n" + 
						"inner join employees e on e.job_id=j.job_id \r\n" + 
						"where j.job_title='"+value+"' and e.salary>"+salary);
				
				List<Employee> employees = new ArrayList<>();
				while (rs.next()) {
					
					Employee employee = new Employee();
					employee.setFirstName(rs.getString(1));
					employee.setLastName(rs.getString(2));
					employee.setEmail(rs.getString(3));
					employee.setPhoneNumber(rs.getString(4));
					employee.setSalary(rs.getDouble(5));
					employees.add(employee);
					
				}
				conn.close();
				return employees;
			} catch (SQLException e) {
				System.out.print("Error");
				e.printStackTrace();
			}
			return null;
	}
	@Override
	public List<Employee> informationEmployeeForManager(String firstName,String lastName) {
	
				try {
					Connection conn = DriverManager.getConnection(dbURL, user, pass);
					// System.out.print("DB Connected..\n");
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery("select e1.first_name,e1.last_name,e1.email from employees e \r\n" + 
							"inner join employees e1 on e1.manager_id=e.employee_id \r\n" + 
							"where e.first_name='"+firstName+"' and  e.last_name='"+lastName+"'");
					
					List<Employee> employees = new ArrayList<>();
					while (rs.next()) {
						Employee employee = new Employee();
						employee.setFirstName(rs.getString(1));
						employee.setLastName(rs.getString(2));
						employee.setEmail(rs.getString(3));
						employees.add(employee);
						
					}
					conn.close();
					return employees;
				} catch (SQLException e) {
					System.out.print("Error");
					e.printStackTrace();
				}
				return null;
	}
}
