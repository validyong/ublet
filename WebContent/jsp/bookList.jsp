<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="ublet.bean.UserInfo"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%
		UserInfo currentUser = (UserInfo) session.getAttribute("currentSessionUser");
	%>

	Welcome
	<%=currentUser.getUserId()%>

	<h1>Books Management</h1>

	<div align="center">
		<table border="1">
			<caption>
				<h2>List of Books</h2>
			</caption>
			<tr>
				<th>ISBN</th>
				<th>Book Name</th>
				<th>Company</th>
				<th>Price</th>
				<th>Genre Code</th>
				<th>Genre Name</th>
			</tr>
			<c:forEach var="view" items="${listView}">
				<tr>
					<td><c:out value="${view.isbn}" /></td>
					<td><c:out value="${view.bookName}" /></td>
					<td><c:out value="${view.company}" /></td>
					<td><c:out value="${view.price}" /></td>
					<td><c:out value="${view.genreCode}" /></td>
					<td><c:out value="${view.genreName}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div align="center">
		<form action="add" method="post">

			<table border="1" cellpadding="5">
				<caption>
					<h2>Add New Book</h2>
				</caption>
				<tr>
					<th>ISBN:</th>
					<td><input type="text" name="isbn" size="5"
						value="<c:out value='${book.isbn}' />" /></td>
				</tr>
				<tr>
					<th>Book Name:</th>
					<td><input type="text" name="bookName" size="45"
						value="<c:out value='${book.bookName}' />" /></td>
				</tr>
				<tr>
					<th>Company:</th>
					<td><input type="text" name="company" size="45"
						value="<c:out value='${book.company}' />" /></td>
				</tr>
				<tr>
					<th>Price:</th>
					<td><input type="text" name="price" size="5"
						value="<c:out value='${book.price}' />" /></td>
				</tr>
				<tr>
					<th>Genre Code:</th>
					<td><input type="text" name="genreCode" size="5"
						value="<c:out value='${book.genreCode}' />" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="Save" /></td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>