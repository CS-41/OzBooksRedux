<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Oz Book List</title>
</head>
<body>
	<form method = "post" action = "navigationServlet">
	<table>
	<c:forEach items="${requestScope.allBooks}" var="currentbook">
	<tr>
		<td><input type="radio" name="id" value="${currentbook.bookId}"></td>
		<td>${currentbook.bookTitle}</td>
		<td>${currentbook.publishDate}</td>
	</tr>
	</c:forEach>
	</table>
	<input type = "submit" value = "edit" name = "doThisToBook">
	<input type = "submit" value = "delete" name = "doThisToBook">
	<input type = "submit" value = "add" name = "doThisToBook">
	</form>
</body>
</html>