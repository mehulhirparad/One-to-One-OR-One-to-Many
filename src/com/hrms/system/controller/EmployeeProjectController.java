package com.hrms.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.hrms.system.Entity.EmployeeDetail;
import com.hrms.system.Entity.EmployeeProject;
import com.hrms.system.controller.Service.EmployeeService;

@Controller
@ComponentScan("com.hrms.system")
public class EmployeeProjectController
{
	//This is controller class collect only employee detail and perform some operation
	
	@Autowired
	private EmployeeService employeeServices1;
	
	// Get the employee data object and add in the model 
	@GetMapping("/getEmployeeProjectList")
	public String getEmployeeProjectList(@RequestParam("EmployeeId") int theId, Model theModel)
	{
		
		theModel.addAttribute("employeeProject",employeeServices1.getEmployeeDetail(theId));
		
		return "project-list";
	}
	
	// Base on ID retrieve single employee and add project detail as null value
	@GetMapping("/projectUpdate")
	public String projectUpdate(@RequestParam("projectId") int theId,Model theModel)
	{
		EmployeeDetail employeeDetail = new EmployeeDetail();
		employeeDetail=employeeServices1.getEmployeeDetail(theId);		
		employeeServices1.saveEmployee(employeeDetail);		
		return "redirect:/list";
	}	
	
	// Get the single project detail and send for editing 
	@GetMapping("/updateProject")
	public String UpdateProject(@RequestParam("projectId") int theId, Model theModel)
	{
		// set customer as a model attributes to pre-populate the form
				System.out.println("number" +theId );
				theModel.addAttribute("employeeProjectEdit", employeeServices1.getProjectDetail(theId));
							
				// send over to our form
				return "showProject";
	}	
	
	//Delete the project detail
	@GetMapping("/deleteProject")
	public String deleteCustomer(@RequestParam("projectId") int projectId, Model theModel)
	{		
		System.out.println("id "+projectId);
		employeeServices1.deleteProject(projectId);
		
		return "redirect:/list";
	}
	
	// After the edit project detail store the data.  
	@PostMapping("/projectForm")
	public String processForm(@ModelAttribute("employeeProjectEdit") EmployeeProject theEmployeeProject) 
	{	
		employeeServices1.saveProject(theEmployeeProject);	
			
		return "redirect:/list";
	}
	
}