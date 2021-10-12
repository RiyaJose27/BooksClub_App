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

<h1>Add a Book to Your Shelf</h1>

<form:form action="/makeBook" method="post" modelAttribute="book">
<form:hidden path="user" value="${user}"/>

<p>
  
   <form:label path="title">Title</form:label>
   <form:errors path="title"/>
   <form:input path="title"/>
   </p>
   
   
   <p>
  
   <form:label path="author">Author</form:label>
   <form:errors path="author"/>
   <form:input path="author"/>
   </p>
   
  <p>
  
   <form:label path="thoughts">My thoughts</form:label>
   <form:errors path="thoughts"/>
   <form:input path="thoughts"/>
   </p>
   
      
      
  
   <input type="submit" value="submit">
 
</form:form>





</body>
</html>