<%@page import="com.te.empwebapp.beans.Products"%>
<%@page import="com.te.empwebapp.beans.EmployeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
String errMsg = (String) request.getAttribute("errMsg");
Products product = (Products) request.getAttribute("id");
%>

<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Employee</title>
</head>
<body>

	<fieldset>
		<legend>Search Employee</legend>
		<form action="./search">
			<table>
				<tr>
					<td>Product id</td>
					<td>:</td>
					<td><input type="number" name="id" required="required"></td>
				</tr>
				<tr>
					<td><input type="submit" value="search product"></td>
				</tr>
			</table>
		</form>
	</fieldset>

	<%
	if (product != null) {
	%>
	<h3>
		Pid :
		<%=product.getPid()%></h3>
	<h3>
		Pname :
		<%=product.getPname()%></h3>
	<h3>
		MgDate :
		<%=product.getMgDate()%></h3>

	<h3>
		ExDate :
		<%=product.getExDate()%></h3>

	<h3>
		Price :
		<%=product.getPrice()%></h3>
	<h3>
		Quantity :
		<%=product.getQuantity()%></h3>


	<%
	}
	%>

	<%
	if (errMsg != null && !errMsg.isEmpty()) {
	%>
	<h2>
		<%=errMsg%></h2>
	<%
	}
	%>

</body>
</html>