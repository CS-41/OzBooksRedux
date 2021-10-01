<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Books</title>
</head>
<body>
	<form action = "editBookServlet" method="post">
	Title: <input type ="text" name = "title" value= "${bookToEdit.bookTitle}">
	Publication Year: <input type = "text" name = "date"  value= "${bookToEdit.publishDate}">
	<input type = "hidden" name = "id" value="${bookToEdit.bookId}">
	<input type = "submit" value="Save Edited Book">
	</form>
</body>
</html>