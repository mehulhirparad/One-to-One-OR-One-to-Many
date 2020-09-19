package com.hrms.system.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="emp_project")
public class EmployeeProject 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="project_id")
	private int project_id;
	
	@NotNull
	@Column(name="project_handle")
	private String project_handle;
	
	@NotNull
	@Column(name="date_start")
	private String date_start;
	
	@NotNull
	@Column(name="date_end")
	private String date_end;
	
	@NotNull
	@Column(name="status")
	private String status;
	
	@Column(name="notes")
	private String notes;
	
	
	// Default constructor
	public EmployeeProject() {
		// TODO Auto-generated constructor stub
	}
	// Paramterize constructor

	public EmployeeProject(String project_handle, String date_start, String date_end, String status, String notes) {
		super();
		this.project_handle = project_handle;
		this.date_start = date_start;
		this.date_end = date_end;
		this.status = status;
		this.notes=notes;
	}	
	// Getter / Setter

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

	public String getProject_handle() {
		return project_handle;
	}

	public void setProject_handle(String project_handle) {
		this.project_handle = project_handle;
	}

	public String getDate_start() {
		return date_start;
	}

	public void setDate_start(String date_start) {
		this.date_start = date_start;
	}

	public String getDate_end() {
		return date_end;
	}

	public void setDate_end(String date_end) {
		this.date_end = date_end;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}	
	
	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	// toString Method
	@Override
	public String toString() {
		return "EmployeeProject [project_id=" + project_id + ", project_handle=" + project_handle + ", date_start="
				+ date_start + ", date_end=" + date_end + ", status=" + status + ", notes=" + notes + "]";
	}
}
