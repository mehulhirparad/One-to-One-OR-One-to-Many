package com.hrms.system.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="hrms_emp_detail")
public class EmployeeDetail
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="employee_id")
	private int id;
	
	@NotNull(message="is required")	
	@Size(min=3,max=10,message="Minimum 3 character is requred")
	@Pattern(regexp = "([a-zA-Z',.-]+( [a-zA-Z',.-]+)*){2,30}",message="Special Sysmbol doesn't allow")
	@Column(name="first_name")
	private String firstName;	
	
	@NotNull(message="is required")	
	@Size(min=3,max=10,message="Minimum 3 character is requred")
	@Pattern(regexp = "([a-zA-Z',.-]+( [a-zA-Z',.-]+)*){2,30}",message="Special Sysmbol doesn't allow")
	@Column(name="last_name")
	private String lastName;
	
	@NotNull(message="is required")
	@Column(name="birth")
	private String birth;
	
	@NotNull(message="is required")
	@Column(name="sex")
	private char sex='M';
	
	@NotNull(message="is required")
	@Size(min=8,max=45,message="Please check your email")
	@Pattern(regexp="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",message="Please enter valid email address" )
	@Column(name="email")
	private String email;
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	@Pattern(regexp = "^[789]\\d{9}$",message = "please enter valid number")
	@Column(name="contact")
	private String contact;
	
	@Valid
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="address_id")
	private EmployeeAddress employeeAddress;
	
	@Valid
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="department_id")
	private EmployeeDepartment employeeDepartment;
	
	@Valid
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="id_ref_inx")
	private List<EmployeeProject> employeeProject;
	
	// Default constructor
	public EmployeeDetail() {
		
	}
	// Parameterise constructor	
	
	public EmployeeDetail(String firstName, String lastName,String birth,char sex,String email,
			String contact, EmployeeAddress employeeAddress,EmployeeDepartment employeeDepartment,
			List<EmployeeProject> employeeProject) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birth = birth;
		this.sex = sex;
		this.email = email;
		this.contact = contact;
		this.employeeAddress = employeeAddress;
		this.employeeDepartment = employeeDepartment;
		this.employeeProject = employeeProject;
	}
	
	// Getter / Setter
		public String getFirstName() {
				return firstName;
			}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EmployeeAddress getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(EmployeeAddress employeeAddress) {
		this.employeeAddress = employeeAddress;
	}	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public EmployeeDepartment getEmployeeDepartment() {
		return employeeDepartment;
	}
	public void setEmployeeDepartment(EmployeeDepartment employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}		
	
	public List<EmployeeProject> getEmployeeProject() {
		return employeeProject;
	}


	public void setEmployeeProject(List<EmployeeProject> employeeProject) {
		this.employeeProject = employeeProject;
	}


	// toString method
	@Override
	public String toString() {
		return "EmployeeDetail [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birth=" + birth
				+ ", sex=" + sex + ", email=" + email + ", contact=" + contact + ", employeeAddress=" + employeeAddress
				+ ", employeeDepartment=" + employeeDepartment + ", employeeProject=" + employeeProject + "]";
	}		
	
	public void addProject(EmployeeProject theEmployeeProject)
	{
		if(employeeProject == null)
		{
			employeeProject = new ArrayList<>();
		}
		employeeProject.add(theEmployeeProject);
	}
}
