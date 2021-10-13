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
	href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
<script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>


<h1>Book Club</h1>
<p>A place for friends to share thoughts on books</p>
<div class="row justify-content-around">
<div class="col-4">
<form:form action="/register" method="post" modelAttribute="newUser">
        <div class="form-group">
            <label>First Name:</label>
            <form:input path="fname" class="form-control" />
            <form:errors path="fname" class="text-danger" />
        </div>
        
        <div class="form-group">
            <label>Last Name:</label>
            <form:input path="lname" class="form-control" />
            <form:errors path="lname" class="text-danger" />
        </div>

        <div class="form-group">
            <label>Email:</label>
            <form:input path="email" class="form-control" />
            <form:errors path="email" class="text-danger" />
        </div>
        
        <div class="form-group">
            <label>Password:</label>
            <form:password path="password" class="form-control" />
            <form:errors path="password" class="text-danger" />
        </div>
        
        <div class="form-group">
            <label>Confirm Password:</label>
            <form:password path="confirm" class="form-control" />
            <form:errors path="confirm" class="text-danger" />
        </div>
        
        <input type="submit" value="Submit" class="btn btn-primary" />
    </form:form>
    </div>
    
    <div class="col-4 order-last">
    <form:form action="/login" method="post" modelAttribute="newLogin">
        <div class="form-group">
            <label>Email:</label>
            <form:input path="email" class="form-control" />
            <form:errors path="email" class="text-danger" />
        </div>
        
        <div class="form-group">
            <label>Password:</label>
            <form:password path="password" class="form-control" />
            <form:errors path="password" class="text-danger" />
        </div>
        <input type="submit" value="Login" class="btn btn-success" />
    </form:form>
    </div>
    </div>
    
  
</body>
</html>
