package jo.secondstep.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Dependent {

	
		private int dependentId;
		private String firstName;
		private String lastName;
		private String relationship;
		private Employee employee;
		public String dbURL = "jdbc:sqlserver://192.168.1.27:49170;databaseName=data1";
		public String user = "mai";
		public String pass = "123456";
		public Dependent() {}
		public Dependent(int dependentId,String firstName,String lastName,String relationship)
		{
			this.dependentId = dependentId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.relationship = relationship;
	
		}
		public int getDependentId()
		{
			return this.dependentId;
		}
		public void setDependentId(int dependentId)
		{
			this.dependentId = dependentId;
		}

		public String getFirstName()
		{
			return this.firstName;
		}
		public void setFirstName(String firstName)
		{
			this.firstName = firstName;
		}

		public String getLastName()
		{
			return this.lastName;
		}
		public void setLastName(String lastName)
		{
			this.lastName = lastName;
		}

		public String getRelationship()
		{
			return this.relationship;
		}
		public void setRelationship(String relationship)
		{
			this.relationship = relationship;
		}

		public Employee getEmployee()
		{
			return this.employee;
		}
		public void setEmployee(Employee employee)
		{
			this.employee = employee;
		}

		public List<Dependent> informationDependentsForEmployee(String first,String last)
      {
			
			try {
				Connection conn = DriverManager.getConnection(dbURL, user, pass);
				// System.out.print("DB Connected..\n");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select  d.dependent_id,d.first_name,d.last_name,d.relationship from employees e \r\n" + 
						"inner join dependents d on d.employee_id=e.employee_id \r\n" + 
						"where e.first_name='"+first+"' and e.last_name='"+last+"'");
				List<Dependent> dependents = new ArrayList<>();

				while (rs.next()) {
					Dependent dependent = new Dependent(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
					
					dependents.add(dependent);

				}

				conn.close();
				return dependents;
			} catch (SQLException e) {
				System.out.print("Error");
				e.printStackTrace();
			}
			return null;
      }
		
	
}
