package jo.secondstep.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class Country implements Salary {
	private String countryId;
	private String countryName;
	private Region region;
	public String dbURL = "jdbc:sqlserver://192.168.1.27:49170;databaseName=data1";
	public String user = "mai";
	public String pass = "123456";

	public Country() {
	}

	public Country(String countryId, String countryName) {
		this.countryName = countryName;
		this.countryId = countryId;

	}

	public String getCountryId() {
		return this.countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getcountry_name() {
		return this.countryName;
	}

	public void setcountry_name(String countryName) {
		this.countryName = countryName;
	}

	public Region getregion_id() {
		return this.region;
	}

	public void setregion_id(Region region) {
		this.region = region;
	}

	@Override
	public HashMap<String, Double> totalSalaryEmployess(String value) {

		try {
			Connection conn = DriverManager.getConnection(dbURL, user, pass);
			// System.out.print("DB Connected..\n");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select c.country_name,sum(e.salary) as \"Total Salary\"\r\n"
					+ "from  locations l \r\n" + "inner join departments d on d.location_id=l.location_id\r\n"
					+ "inner join employees e on d.department_id=e.department_id\r\n"
					+ "inner join countries c on c.country_id=l.country_id\r\n" + "group by c.country_name;");

			HashMap<String, Double> totalSalary = new HashMap<String, Double>();
			while (rs.next()) {
				totalSalary.put(rs.getString(1), rs.getDouble(2));

			}
			conn.close();
			return totalSalary;
		} catch (SQLException e) {
			System.out.print("Error");
			e.printStackTrace();
		}
		return null;

	}

	public HashMap<String, Integer> numberOfEmployee() {
		
		try {
			Connection conn = DriverManager.getConnection(dbURL, user, pass);
			// System.out.print("DB Connected..\n");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select c.country_name,count(e.employee_id) as \"Number of Employee\"\r\n" + 
					"from  locations l \r\n" + 
					"inner join departments d on d.location_id=l.location_id\r\n" + 
					"inner join employees e on d.department_id=e.department_id\r\n" + 
					"inner join countries c on c.country_id=l.country_id\r\n" + 
					"group by c.country_name;");

			HashMap<String, Integer> NumberOfEmployee = new HashMap<String, Integer>();
			while (rs.next()) {
				NumberOfEmployee.put(rs.getString(1), rs.getInt(2));

			}
			conn.close();
			return NumberOfEmployee;
		} catch (SQLException e) {
			System.out.print("Error");
			e.printStackTrace();
		}
		return null;

	}

}