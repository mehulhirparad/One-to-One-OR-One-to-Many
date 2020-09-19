package com.hrms.system.DAO;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.hrms.system.Entity.EmployeeDetail;
import com.hrms.system.Entity.EmployeeProject;

@Repository
public class EmployessDAOImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;	
	
	@Override	
	public void saveEmployee(EmployeeDetail employeeDetail) {
	
		// get current the hibernate session
			Session currentSession = sessionFactory.getCurrentSession();			
			employeeDetail.addProject(new EmployeeProject("null", "null", "null", "null", "null"));
			employeeDetail.getEmployeeProject();
			System.out.println("save employee "+employeeDetail);
			currentSession.saveOrUpdate(employeeDetail);		
		}
	@Override
	public List<EmployeeDetail> getEmployeeDetail() {
		// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				
				// create a query
				Query<EmployeeDetail> theQuery = 
						currentSession.createQuery("from EmployeeDetail",  EmployeeDetail.class);				
				
				// execute query and get result list
				List<EmployeeDetail> employeeDetaillist = theQuery.getResultList();
				// return the results		
				System.out.println("final list "+ employeeDetaillist);
				
				return employeeDetaillist;
	}

	@Override
	public void deleteEmployee(int theId) {
	
		Session currentSession = sessionFactory.getCurrentSession();
		
		EmployeeDetail theEmployeeDetail = currentSession.get(EmployeeDetail.class,theId);
		
		currentSession.delete(theEmployeeDetail);		
	}

	@Override
	public EmployeeDetail getEmployeeDetail(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();		
		
		// now retrive / read from database using the primary key
		EmployeeDetail theEmployeeDetail = currentSession.get(EmployeeDetail.class,theId);		
				
		System.out.println("save employee "+theEmployeeDetail.getEmployeeProject());
		return theEmployeeDetail;
		
	}
	public EmployeeProject getProjectDetail(int theId)
	{
		Session currentSession = sessionFactory.getCurrentSession();		
		
		EmployeeProject theEmployeeProject = currentSession.get(EmployeeProject.class,theId);
		
		currentSession.saveOrUpdate(theEmployeeProject);
		
		return theEmployeeProject;
	}

	@Override
	public void deleteProject(int projectId) {	
		
		 System.out.println("id "+projectId);
			Session currentSession = sessionFactory.getCurrentSession();
		
			EmployeeProject theEmployeeProject = currentSession.get(EmployeeProject.class,projectId);				
						
			currentSession.delete(theEmployeeProject);	
	}
	@Override	
	public void saveProject(EmployeeProject employeeProject) {
	
		// get current the hibernate session
			Session currentSession = sessionFactory.getCurrentSession();			
			
			currentSession.saveOrUpdate(employeeProject);		
		}
}

