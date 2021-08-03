package jo.secondstep.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Job implements JobSalary
{
	private int jobId;
	private String jobTitle;
	private double minSalary;
	private double maxSalary;
	public String dbURL = "jdbc:sqlserver://192.168.1.27:49170;databaseName=data1";
	public String user = "mai";
	public String pass = "123456";
	public Job()
	{}
	public Job(int jobId,String jobTitle,double minSalary,double maxSalary)
	{
		this.jobId = jobId;
		this.jobTitle = jobTitle;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
	}
	
	public int getJobId()
	{
		return this.jobId;
	}
	public void setJobId(int jobId)
	{
		this.jobId = jobId;
	}

	public String getJobTitle()
	{
		return this.jobTitle;
	}
	public void setJobTitle(String jobTitle)
	{
		this.jobTitle = jobTitle;
	}

	public double getMinSalary()
	{
		return this.minSalary;
	}
	public void setMinSalary(double minSalary)
	{
		this.minSalary = minSalary;
	}

	public double getmaxSalary()
	{
		return this.maxSalary;
	}
	public void setMaxSalary(double maxSalary)
	{
		this.maxSalary = maxSalary;
	}
	@Override
	public List<Job> jobSalaryMorethan(double value) {
		
		try {
			Connection conn = DriverManager.getConnection(dbURL, user, pass);
			// System.out.print("DB Connected..\n");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select job_title,min_salary from dbo.jobs where min_salary>5000");
			List<Job> jobs = new ArrayList<>();

			while (rs.next()) {
				Job job = new Job();
				job.setJobTitle(rs.getString(1));
				job.setMinSalary(rs.getDouble(2));
				jobs.add(job);

			}

			conn.close();
			return jobs;
		} catch (SQLException e) {
			System.out.print("Error");
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public HashMap<String, List> totalSalarywithNofEmployee() {
		
		try {
			Connection conn = DriverManager.getConnection(dbURL, user, pass);
			// System.out.print("DB Connected..\n");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select j.job_title,count(e.job_id) as \"Number of Employee\",sum(e.salary) as \"Total of Salary\" from jobs j \r\n" + 
					"inner join employees e on e.job_id=j.job_id \r\n" + 
					"group by j.job_title");
			HashMap<String, List> totalSalarywithNofEmployee = new HashMap<String, List>();

			while (rs.next()) {
				List<Integer> list=new ArrayList<Integer>();  
				list.add(rs.getInt(2));
				list.add(rs.getInt(3));
				totalSalarywithNofEmployee.put(rs.getString(1), list);

			}

			conn.close();
			return totalSalarywithNofEmployee;
		} catch (SQLException e) {
			System.out.print("Error");
			e.printStackTrace();
		}
		return null;
		
	}
    
	
}