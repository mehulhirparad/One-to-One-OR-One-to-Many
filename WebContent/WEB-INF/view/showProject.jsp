<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
		<link type="text/css" rel="stylesheet" 
			  href="${pageContext.request.contextPath}/resources/css/style.css" />	
		<link type="text/css" rel="stylesheet"
			  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />	
</head>
	<body>
	<div id="wrapper">
			<div id="header">
				<h2>Employee Data Management System</h2>
			</div>
		</div>
		<div id="container">
		<form:form action="projectForm" method="POST" modelAttribute="employeeProjectEdit">
		<form:hidden path="project_id" />
			<table>							
					<tbody><h4>Show project form</h4>
					<tr>
						<td><label>Project Name:</label></td>
						<td><form:input path="project_handle" />
											
					</tr>					
					<tr>
						<td><label>Start Date :</label></td>
						<td><form:input type="date" path="date_start" />
						<form:errors path="date_start" /></td>
					</tr>	
					<tr>
						<td><label>End Date :</label></td>
						<td><form:input type="date" path="date_end" />
						<form:errors path="date_end" /></td>
					</tr>					
					<tr>
						<td><label> Status :</label></td>
						<td><form:input path="status" />
						<form:errors path="status" /></td>
					</tr>	
					<tr>
						<td><label> NOtes :</label></td>
						<td><form:textarea path="notes" rows="10" cols="50"/>
						<form:errors path="notes" /></td>
					</tr>				
				</tbody>
				</table>				
			<br>
			<input type="submit" name="save" />	
			</form:form>
		<div style="clear"; both;"></div>
		<p>
			<a href="welcome">Home Page </a>
			<br>
			<a href="list">Employee Detail </a>
		</p>
		</div>		
	</body>
</html>