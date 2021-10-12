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
    <h1>Welcome, ${user.fname }</h1>
    <p>Books from everyone's shelves:
     <p><a href="/logout">Logout</a>
     <p><a href="/newBook">+ Add a to my shelf</a>
    
    <table class="table table-dark table-striped table-hover table-bordered">
			<thead >
				<tr >
					<th class="align-middle" >ID</th>
					<th class="align-middle" scope="col">Title</th>
					<th class="align-middle" scope="col">Author Name</th>
					<th class="align-middle" scope="col">Posted By</th>
						<th class="align-middle" scope="col">Actions</th>
				</tr>
			</thead>	
				<tbody>
					<c:forEach  var="i" items="${allBooks}" >
						<tr class=" table-secondary ">
						<td> <c:out value="${i.id}"></c:out> </td>
							<td> <a href="/oneBook/${i.id}">  <c:out value="${i.title}"></c:out></a> </td>
							<td> <c:out value="${i.author}"></c:out> </td>
							<td><c:out value="${i.user.fname}"></c:out></td>
							<td> 
							<c:choose>
									<c:when test="${i.user.id == user.id}">
									    <a href="/editBook/${i.id }">Edit</a>
									<a href="/destroy/${id}">Delete</a>
									</c:when>
									</c:choose>
																
							
							  </td>
							
						</tr>
					</c:forEach>
				</tbody>
		</table>

</body>
</html>