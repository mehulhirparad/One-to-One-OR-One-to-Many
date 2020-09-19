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
												
							<!-- Show employee detail with project list -->	
												
						<table border="1">
							<tr>
								<th>Id</th>
								<th>First Name</th>
								<th>Last Name</th>																			
							</tr>																							
									<tr>
										<td>${employeeProject.id}</td>
										<td>${employeeProject.firstName}</td>
										<td>${employeeProject.lastName}</td>	
									</tr>	
							</table>
							<br></br>
							<table border="1">
							<tr>
								<th>Project Id</th>
								<th>Project Name</th>
								<th>Date_start</th>
								<th>Date_end</th>	
								<th>Status</th>	
								<th>Notes</th>																	
							</tr>		
							<!-- Print list of the project that employee allocate  -->		
							<c:forEach var="tempEmployeeDetail" items="${employeeProject.employeeProject}">				
 							 														
 							<c:url var="DeleteLink" value="/deleteProject">	
								<c:param name="projectId" value="${tempEmployeeDetail.project_id}" />								
 							</c:url> 
 							
 							<c:url var="UpdateLink" value="/updateProject">	
								<c:param name="projectId" value="${tempEmployeeDetail.project_id}" />								
 							</c:url> 																							
									<tr>
										<td>${tempEmployeeDetail.project_id}</td>
										<td>${tempEmployeeDetail.project_handle}</td>
										<td>${tempEmployeeDetail.date_start}</td>
										<td>${tempEmployeeDetail.date_end}</td>
										<td>${tempEmployeeDetail.status}</td>	
										<td style="min-width:120px">${tempEmployeeDetail.notes}</td>									
										<td><a href="${UpdateLink}">Update</a>
										|
									     <a href="${DeleteLink}">Delete</a>	</td>	
																		
									</tr>
							</c:forEach>	
							</table>
					</div>
		</div>
		<div style="clear"; both;"></div>
		<p>
			<a href="welcome">Home Page </a>
			<br>
			<a href="list">Previous </a>
		</p>
		</div>	
</body>
</html>