<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="for" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="doupdate" modelAttribute="my" >
		<table border=2>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Deg</th>
				<th>Salary</th>
				<th>Gender</th>
			</tr>

			<tr>
				<td><input name="empId" value="${edata.empId }" readonly="true"/></td>
				<td>${edata.empName}</td>
				<td>${edata.empDesignation}</td>
				<td>${edata.empSalary}</td>
				<td>${edata.empGender}</td>
			</tr>
			
		</table>
	
			<input type="submit" value="update Employee"></input>
			
	</form>

</body>
</html>