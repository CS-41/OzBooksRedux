<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Record</title>
</head>
<body>
	<form action = "editRecordServlet" method = "post">
	<input type = "hidden" name = "id" value = "${recordToEdit.id}">
	Record Name: <input type ="text" name = "recordName" value= "${recordToEdit.recordName}"><br />
	Check Out Date: <input type ="text" name = "month" placeholder="mm" size="4" value= "${month}"> <input 
	type ="text" name = "day" placeholder="dd" size="4" value= "${date}">, <input type ="text" 
	name = "year" placeholder="yyyy" size="4" value= "${year}">
	Library Name: <input type = "text" name = "libraryName" value= "${recordToEdit.library.libraryName}"><br />
	<br />		
	Available Books:<br />
	<select name = "allBooksToAdd" multiple size = "6">
	<c:forEach items = "${requestScope.allBooks}" var ="currentbook">
	<option value = "${currentbook.bookId}">${currentbook.bookTitle} | ${currentbook.publishDate}</option>
	</c:forEach>
	</select>
	<br />
	<input type = "submit" value = "Edit Record and Add Books">
	</form>
	<a href = "index.html">Go add new books instead.</a>
</body>
</html>