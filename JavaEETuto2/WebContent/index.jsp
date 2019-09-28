<!-- 
Working JSP Files
1. Right click -> New -> JSP File
2. Create ProcessInfo.java Servlet to handle this
--> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Testing JSP</title>
</head>
<body>
 
<!-- NEW Declare the taglib directive specifying the JSTL library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<h3>Enter some Info</h3>
 
<form action="ProcessInfo" method="post">
<label>First Name : </label>
 
<!-- NEW Add values that will hold data customer previously entered 
and additional data -->
<input type="text" name="fname" value="${cust.fName }"><br><br>
<label>Last Name : </label>
<input type="text" name="lname" value="${cust.lName }"><br><br>
<label>Street : </label>
<input type="text" name="street" value="${cust.street }"><br><br>
<label>City : </label>
<input type="text" name="city" value="${cust.city }"><br><br>
<label>State : </label>
<input type="text" name="state" value="${cust.state }"><br><br>
<label>Zip Code : </label>
<input type="text" name="zipcode" value="${cust.zipcode }"><br><br>
<label>Email : </label>
<input type="text" name="email" value="${cust.email }"><br><br>
<label>Password : </label>
<input type="text" name="password" value="${cust.password }"><br><br>
<label>Phone : </label>
<input type="text" name="phone" value="${cust.phone }"><br><br>
<input type="submit" value="Send">
</form>
 
<!-- Get passed parameter value -->
<%= request.getParameter("passedParam") %><br>
 
</body>
</html>