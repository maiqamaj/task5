package jo.secondstep.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Department implements Salary{
	private int departmentId;
	private String departmentName;
	private Location location;
	public String dbURL = "jdbc:sqlserver://192.168.1.27:49170;databaseName=data1";
	public String user = "mai";
	public String pass = "123456";
    
    
    public Department() {}
	public Department(int departmentId, String departmentName) {
		this.departmentId = departmentId;
		this.departmentName = departmentName;

	}

	public int getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	@Override
	public HashMap<String, Double> totalSalaryEmployess(String value) {
		
			try {
				Connection conn = DriverManager.getConnection(dbURL, user, pass);
				// System.out.print("DB Connected..\n");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select departments.department_name,sum(salary) as \"Total Salary for "+value+" \"from departments inner join employees on department_name='IT' group by department_name;\r\n" + 
						"");
				
				HashMap<String, Double> totalSalary = new HashMap<String, Double>();
				while (rs.next()) {
					totalSalary.put(rs.getString(1),rs.getDouble(2));
					
				}
				conn.close();
				return totalSalary;
			} catch (SQLException e) {
				System.out.print("Error");
				e.printStackTrace();
			}
			return null;

		}
		

	
	

    
  

}