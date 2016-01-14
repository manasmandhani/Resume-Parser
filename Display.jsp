<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body {
	background-color: #148A38
}

h1 {
	color: brown
}

p {
	color: peachpuff
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DATA ANAYLSER</title>
</head>
<body style="height: 146px; width: 956px;">
	<h2><center>Query Results :</center></h2>
	<table border="3" align="center" >
            <tr>
                <th>Resumes</th>
                
            </tr>
			<c:forEach items="${list}" var="resume">
                <tr>
                    <td><c:out value="${resume}" /></td>
                </tr>
            </c:forEach>
       </table>
	
	
	
</body>
</html>