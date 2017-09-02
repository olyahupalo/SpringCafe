<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<title>MyProfile</title>
</head>
<body>
	<h2>Cafes</h2>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<tr>
						<th class="text-center">Rate</th>
						<th class="text-center">Name</th>
						<th class="text-center">PhotoUrl</th>
						<th class="text-center">Address</th>
						<th class="text-center">Short Description</th>
						<th class="text-center">Type</th>
					</tr>
					<c:forEach var="cafe" items="${cafes}">
							<tr onMouseOver="this.style.backgroundColor='#ECECEE';" onMouseOut="this.style.backgroundColor='white'" onclick="location.href='profile/cafe/${cafe.id}'">
								<td>${cafe.rate}</td>
								<td>${cafe.name}</td>
								<td>${cafe.photoUrl}</td>
								<td>${cafe.address}</td>
								<td>${cafe.shortDescription}</td>
								<td>${cafe.type}</td>
							
							</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<a href="/profile/createcafe">Create new cafe</a>
		<a href="/profile/meal">Add Meal</a>
		<a href="/profile/table">Add Table</a>
	</div>
</body>
</html>