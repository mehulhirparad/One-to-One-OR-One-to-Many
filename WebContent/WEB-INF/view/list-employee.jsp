<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
		<link type="text/css" rel="stylesheet" 
			  href="${pageContext.request.contextPath}/resources/css/style.css" />	
</head>
<body>
				<div id="wrapper">
					<div id="header">
						<h2>Employee Data Management System</h2>
					</div>
				</div>				
				<div id="container">
					<div id="content">
					
					<!-- put new button  -->
					<input type="button" value="Customer Form" 
							onclick="window.location.href='showForm'; return false; "
							class="add-button" />
							
						<!-- Display the whole employee detail  -->
						<table border="1">
							<tr>
								<th>Id</th>
								<th>First Name</th>
								<th>Last Name</th>
								<th>Birth</th>								
								<th>Sex</th>
								<th>Email</th>	
								<th>Contact</th>							
								<th>Street</th>
								<th>City</th>
								<th>State</th>
								<th>Country</th>	
								<th>Department</th>							
							</tr>				
								
						<c:forEach var="tempEmployeeDetail" items="${employeeDetail}">		
						
							<c:url var="updateLink" value="/showFormForUpdate">	
								<c:param name="EmployeeId" value="${tempEmployeeDetail.id}" />
 							</c:url>		
 							<c:url var="DeleteLink" value="/deleteEmployee">	
								<c:param name="EmployeeId" value="${tempEmployeeDetail.id}" />
 							</c:url>		
 							<c:url var="EditProject" value="/getEmployeeProjectList">	
								<c:param name="EmployeeId" value="${tempEmployeeDetail.id}" />
 							</c:url>			 	
 							<c:url var="AddLink" value="/projectUpdate">	
								<c:param name="projectId" value="${tempEmployeeDetail.id}" />								
 							</c:url> 											
									<tr>
										<td>${tempEmployeeDetail.id}</td>
										<td>${tempEmployeeDetail.firstName}</td>
										<td>${tempEmployeeDetail.lastName}</td>
										<td>${tempEmployeeDetail.birth}</td>
										<td>${tempEmployeeDetail.sex}</td>	
										<td>${tempEmployeeDetail.email}</td>
										<td>${tempEmployeeDetail.contact}</td>									
										<td>${tempEmployeeDetail.employeeAddress.street}</td>
										<td>${tempEmployeeDetail.employeeAddress.city}</td>
										<td>${tempEmployeeDetail.employeeAddress.state}</td>
										<td>${tempEmployeeDetail.employeeAddress.country}</td>
										<td>${tempEmployeeDetail.employeeDepartment.department_name}</td>
										<td><a href="${updateLink}">Update</a>
										|
										<a href="${DeleteLink}"
										onclick="if (!(Confirm('Are you sure you want to delete this customer ?'))) return false">Delete</a>
										|
										<a href="${EditProject}">Edit Project</a>									
										|
										<a href="${AddLink}">Add project</a></td>										
									</tr>
						</c:forEach>
						</table>
					</div>
		</div>
		<div style="clear"; both;"></div>
		<p>
			<a href="welcome">Home Page </a>
			<br>
			<a href="list">Employee Detail </a>
		</p>
		</div>	
</body>
</html>