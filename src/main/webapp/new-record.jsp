<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action = "createNewRecordServlet" method = "post">
	Record Name: <input type = "text" name = "recordName"><br />
	Checked Out Date: <input type = "text" name = "month" placeholder="mm" size="4">
	<input type = "text" name = "day" placeholder = "dd" size ="4">
	<input type = "text" name = "year" placeholder = "yyyy" size ="4">
	Library Name: <input type = "text" name = "libraryName"><br />
	
	Available Books:<br />
	<select name = "allBooksToAdd" multiple size = "6">
	<c:forEach items = "${requestScope.allBooks}" var = "currentbook">
	<option value = "${currentbook.bookId}"> ${currentbook.bookTitle} | ${currentbook.publishDate}</option>
	</c:forEach>
	</select>
	<br />
	<input type = "submit" value = "Create Record and Add Books">
	</form>
	<a href = "index.html">Go add new books instead.</a>
</body>
</html>