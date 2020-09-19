package com.hrms.system.controller.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hrms.system.DAO.EmployeeDAO;
import com.hrms.system.Entity.EmployeeDetail;
import com.hrms.system.Entity.EmployeeProject;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Override
	@Transactional
	public void saveEmployee(EmployeeDetail employeeDetail) {
		employeeDAO.saveEmployee(employeeDetail);
	}

	@Override
	@Transactional
	public List<EmployeeDetail> getEmployee() {			
		return employeeDAO.getEmployeeDetail();
	}

	@Override
	@Transactional
	public void deleteEmployee(int theId) {
		employeeDAO.deleteEmployee(theId);
	}

	@Override
	@Transactional
	public EmployeeDetail getEmployeeDetail(int theId) {
		return employeeDAO.getEmployeeDetail(theId);
	}

	@Override
	@Transactional
	public EmployeeProject getProjectDetail(int theId) {
		
		return employeeDAO.getProjectDetail(theId);
	}

	@Override
	@Transactional
	public void deleteProject(int projectId) {
		employeeDAO.deleteProject(projectId);
		
	}
	@Override
	@Transactional
	public void saveProject(EmployeeProject employeeProject) {
		employeeDAO.saveProject(employeeProject);
	}

}
