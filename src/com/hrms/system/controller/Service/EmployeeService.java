package com.hrms.system.controller.Service;

import java.util.List;

import com.hrms.system.Entity.EmployeeDetail;
import com.hrms.system.Entity.EmployeeProject;

public interface EmployeeService
{
	public void saveEmployee(EmployeeDetail employee);
	
	public List<EmployeeDetail> getEmployee();

	public void deleteEmployee(int theId);

	public EmployeeDetail getEmployeeDetail(int theId);
	
	public EmployeeProject getProjectDetail(int theId);
	
	public void deleteProject(int projectId);
	
	public void saveProject(EmployeeProject employeeProject);
}
