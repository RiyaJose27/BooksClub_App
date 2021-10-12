<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page isErrorPage="true" %>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9kGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
</head>
<body>

      
 <p><a href ="/dashboard">back to the shelves</a>
<h1>${book.title}</h1>
<p>${user.fname} read ${book.title} by ${book.author}</p>
<p>Here are ${user.fname} thoughts</p>
<p>How I felt about this book?</p>

<c:choose>
<c:when test="${book.user.id == user.id}">
    <a href="/editBook/${book.id }">Edit</a>
<a href="/destroy/${id}">Delete</a>
</c:when>
<c:otherwise>
<p style="color:red;">This is not your book</p>
</c:otherwise>
</c:choose>
</body>
</html>