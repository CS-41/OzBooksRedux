<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Library Book List</title>
</head>
<body>
	<form method = "post" action = "recordNavigationServlet">
	<table>
	<c:forEach items = "${requestScope.allRecords}" var="currentrecord">
	<tr>
		<td><input type = "radio" name = "id" value = "${currentrecord.id}"></td>
		<td><h2>${currentrecord.recordName}</h2></td>
	</tr>
	<tr>
		<td colspan = "3">Date Checked Out: ${currentrecord.dateCheckedOut}</td></tr>
		
	<tr>
		<td colspan = "3">Library: ${currentrecord.library.libraryName}</td>
	</tr>
	
	<c:forEach var = "bookVal" items = "${currentrecord.listOfBooks}">
			<tr><td></td>
			<td colspan="3">
			${bookVal.bookTitle}, ${bookVal.publishDate} 
		</td>
		</tr>
		</c:forEach>
	</c:forEach>
	</table>
	<input type = "submit" value = "edit" name = "doThisToRecord">
	<input type = "submit" value = "delete" name = "doThisToRecord">
	<input type = "submit" value = "add" name = "doThisToRecord">
	</form>
	<a href = "addBookForRecordServlet">Create a new record</a><br />
	<a href = "index.html">Insert a new book</a>
</body>
</html>