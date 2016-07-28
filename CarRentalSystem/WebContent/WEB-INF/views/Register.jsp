<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Being Java Guys | Registration Form</title>
</head>
<body>
<center>
<br><br><br><br><br><br>
<div style="color: teal;font-size: 30px">Being Java Guys | Registration Form</div>
<br><br>
<c:url var="userRegistration" value="saveUser.html"/>
<form:form id="registerForm" modelAttribute="user" method="post" action="${userRegistration}">
<table width="400px" height="150px">
<tr>
<td><form:label path="name">Name</form:label></td>
<td><form:input  path="name"/></td>
</tr>
<tr>
<td><form:label path="phoneNumber">phone Number</form:label></td>
<td><form:input  path="phoneNumber"/></td>
</tr>
<tr>
<td><form:label path="email">E-mail</form:label></td>
<td><form:radiobuttons path="email"/></td>
</tr>
<tr>
<td><form:label path="password">password</form:label></td>
<td><form:select path="password"></form:select></td>
</tr>
<tr>
<td><form:label path="address">Address</form:label></td>
<td><form:input  path="address"/></td>
</tr>
<tr><td></td><td>
<input type="submit" value="Register" />
</td></tr>
</table>
</form:form>
<br>
<a href="userList.html" >Click Here to see User List</a>
</center>
</body>
</html>