package com.hrms.system.controller;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.hrms.system.Entity.EmployeeDetail;
import com.hrms.system.controller.Service.EmployeeService;

// This is just form controller which is use for one to one mapping technique
@Controller
@ComponentScan("com.hrms.system")
public class HrmsController
{
	
		// Create service layer class object
		@Autowired
		private EmployeeService employeeService;
		
		// Get the value of department from the resource and display
		@Value("#{DepartmentOptions}") 
		private Map<String, String> DepartmentOptions;
		
		// Use initbinder for check validation either null value or white space
		@InitBinder
		public void initBinder(WebDataBinder dataBinder)
		{
			StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
					
					dataBinder.registerCustomEditor(String.class,stringTrimmerEditor );
		}
		
		// Landing page navigation from main page
		@GetMapping("/welcome")
		public String home()
		{
			return "welcome";
		}
	
		// Create the employee detail object and add to the model
		@GetMapping("/showForm")
		public String showForm(Model theModel)
		{
			
			EmployeeDetail theEmployeeDetail=new EmployeeDetail();
			theModel.addAttribute("employeeDetail",theEmployeeDetail);	
			theModel.addAttribute("theDepartmentOption",DepartmentOptions);
			
			return "show-form";
		}
		
		// Collect the employee detail class information and store in the database
		@PostMapping("/processForm")
		public String processForm(@Valid @ModelAttribute("employeeDetail") EmployeeDetail theEmployeeDetail, BindingResult theBindingResult) 
		{	
			// check for error validation 
			if(theBindingResult.hasErrors())
			{
				return "show-form";
			}
			else {
				// no-error then store the data in the database
				employeeService.saveEmployee(theEmployeeDetail);				
				return "redirect:/list";
			}
		}
		
		// Get the list of the employeeDetail 
		@GetMapping("/list")
		public String listEmployee(Model theModel)
		{
			System.out.println("process has been started");
			  List<EmployeeDetail> theEmployeeDetail = employeeService.getEmployee();	
			  
			  theModel.addAttribute("employeeDetail",theEmployeeDetail);
			 
			return "list-employee";
		}
		
		// Delete the employee record from the database
		@GetMapping("/deleteEmployee")
		public String deleteCustomer(@RequestParam("EmployeeId") int theId, Model theModel)
		{
			
			employeeService.deleteEmployee(theId);
			
			return "redirect:/list";
		}
		
		// Update employee detail 
		@GetMapping("/showFormForUpdate")
		public String showFormForUpdate(@RequestParam("EmployeeId") int theId, Model theModel)
		{
			// set customer as a model attributes to pre-populate the form
			theModel.addAttribute("employeeDetail", employeeService.getEmployeeDetail(theId));
			theModel.addAttribute("theDepartmentOption",DepartmentOptions);
			
			// send over to our form
			return "show-form";
		}					
}