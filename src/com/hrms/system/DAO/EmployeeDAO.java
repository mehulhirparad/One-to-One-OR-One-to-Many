package com.hrms.system.DAO;
import java.util.List;
import com.hrms.system.Entity.EmployeeDetail;
import com.hrms.system.Entity.EmployeeProject;

public interface EmployeeDAO
{
	public void saveEmployee(EmployeeDetail employeeDetail);
	
	public List<EmployeeDetail> getEmployeeDetail();

	public void deleteEmployee(int theId);

	public EmployeeDetail getEmployeeDetail(int theId);
	
	public EmployeeProject getProjectDetail(int theId);
	
	public void deleteProject(int projectId);
	
	public void saveProject(EmployeeProject employeeProject);
}
