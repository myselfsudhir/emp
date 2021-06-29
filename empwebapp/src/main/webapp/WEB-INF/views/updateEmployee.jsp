<%@page import="com.te.empwebapp.beans.Products"%>
<%@page import="org.jboss.jandex.TypeTarget.Usage"%>
<%@page import="com.te.empwebapp.beans.EmployeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String msg = (String) request.getAttribute("msg");
/* Products product = (Products) request.getAttribute("id"); */
%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Data</title>
</head>
<body>
	<%-- <fieldset>
		<legend>Add Details </legend>
		<form action="./update" method="post">
			<table>
				<tr>
					<td>Product ID</td>
					<td>:</td>
					<td><%=product.getPid()%></td>
					<td><input type="hidden" name="pid" value=<%=product.getPid()%>></td>
				</tr>
				<tr>
					<td>Product Name</td>
					<td>:</td>
					<td><input type="text" name="pname"
						value=<%=product.getPname()%>></td>
				</tr>
				<tr>
					<td>mgDate</td>
					<td>:</td>
					<td><input type="date" name="mgDate"
						value=<%=product.getMgDate()%>></td>
				</tr>
				
				<tr>
					<td>exDate</td>
					<td>:</td>
					<td><input type="date" name="exDate"
						value=<%=product.getExDate()%>></td>
				</tr>
				
				<tr>
					<td>Price</td>
					<td>:</td>
					<td><input type="number" name="price"
						value=<%=product.getPrice()%>></td>
				</tr>
				
				<tr>
					<td>Quantity</td>
					<td>:</td>
					<td><input type="number" name="quantity"
						value=<%=product.getQuantity()%>></td>
				</tr>
				
					<td><input type="submit" value="Register"></td>
				</tr>
			</table>
		</form>
	</fieldset> --%>
	
	<fieldset>
		<legend>Add Details </legend>
		<form action="./update" method="post">
			<table>
				<tr>
					<td>Product ID</td>
					<td>:</td>
					<td><input type="number" name="pid"></td>
				</tr>
				<tr>
					<td>Product Name</td>
					<td>:</td>
					<td><input type="text" name="pname"></td>
				</tr>
				<tr>
					<td>MgDate</td>
					<td>:</td>
					<td><input type="date" name="mgDate"></td>
				</tr>
				<tr>
					<td>exDate</td>
					<td>:</td>
					<td><input type="date" name="exDate"></td>
				</tr>
				
				<tr>
					<td>Price</td>
					<td>:</td>
					<td><input type="number" name="price"></td>
				</tr>
				
				<tr>
					<td>Qunatity</td>
					<td>:</td>
					<td><input type="number" name="quantity"></td>
				</tr>
				
				<tr>
					<td><input type="submit" value="Update Product"></td>
				</tr>
			</table>
		</form>
	</fieldset>

	<%
		if (msg != null && !msg.isEmpty()) {
	%>
	<h1 style="color: magenta;"><%=msg%>
	</h1>
	<%
		}
	%>

</body>
</html>