package jo.secondstep.jdbc;

import java.util.HashMap;
import java.util.List;

public interface JobSalary {
	public List<Job> jobSalaryMorethan(double value);
	public HashMap<String,List> totalSalarywithNofEmployee();
}
