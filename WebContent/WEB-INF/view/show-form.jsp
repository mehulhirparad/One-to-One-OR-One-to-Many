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
		<!-- This is EmployeeDetail form where we can edit the record or create the new record -->
	<form:form action="processForm" method="POST" modelAttribute="employeeDetail">
				<form:hidden path="id" />
				<form:hidden path="employeeAddress.id" />	
			 	<form:hidden path="employeeDepartment.department_id" />		
		<table>
				<tbody><h4>Personal Information</h4>
					<tr>
						<td><label>first name:</label></td>
						<td><form:input path="firstName" />
						<form:errors path="firstName" /></td>
						
					</tr>
					<tr>
						<td><label>Last Name :</label></td>
						<td><form:input path="lastName" />
						<form:errors path="lastName" /></td>
					</tr>
					<tr>
						<td><label>Birth Date :</label></td>
						<td><form:input type="date" path="birth" />
						<form:errors path="birth" /></td>
					</tr>				
					<tr>
						<td><label>Sex :</label></td>
						<td>Male <form:radiobutton path="Sex" value="M"/>
							Female <form:radiobutton path="Sex" value="F"/>
							<form:errors path="Sex" /></td>
					</tr> 
					<tr>
						<td><label> Email :</label></td>
						<td><form:input path="email" />
						<form:errors path="email" /></td>
					</tr>
					<tr>
						<td><label> Contact :</label></td>
						<td><form:input path="contact" />
						<form:errors path="contact" /></td>
					</tr>
				</tbody>
				</table>
				<table>
				<!-- Collect the address detail -->
				<tbody><h4>Address Detail</h4>	
					<tr>
						<td><label>Street Name :</label></td>
						<td><form:input path="employeeAddress.street" />
						<form:errors path="employeeAddress.street" /></td>						
					</tr>
					<tr>
						<td><label>City :</label></td>
						<td><form:input path="employeeAddress.city" />
						<form:errors path="employeeAddress.city" /></td>
					</tr>
					<tr>
						<td><label> State :</label></td>
						<td><form:input path="employeeAddress.state" />
						<form:errors path="employeeAddress.state" /></td>
					</tr>
					<tr>
						<td><label>Country :</label></td>
						<td><form:input path="employeeAddress.country" />
						<form:errors path="employeeAddress.country" /></td>
					</tr>							
					<tr>
					
					<!-- choose the employee department from the list -->
				      <td><label>Department :</label></td>
					  <td><form:select path="employeeDepartment.department_name"> 
 						<form:options items="${theDepartmentOption}" /> 					
						</form:select>
						</td>	
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