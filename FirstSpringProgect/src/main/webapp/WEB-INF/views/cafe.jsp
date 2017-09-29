<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<title>Cafe</title>


</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<tr>
						<th class="text-center">Rate</th>
						<th class="text-center">Name</th>
						<th class="text-center">Type</th>
						<th class="text-center">PhotoUrl</th>
						<th class="text-center">Address</th>
						<th class="text-center">Full Description</th>
						<th class="text-center">Phone</th>
						<th class="text-center">Email</th>
						<th class="text-center">Open</th>
						<th class="text-center">Close</th>
						<th class="text-center">Meals</th>
						<th class="text-center">Tables</th>
						<sec:authorize access="hasRole('ROLE_CAFE')">
							<th class="text-center">Options</th>
						</sec:authorize>
					</tr>
						<tr >
							<td>${cafe.rate}</td>
							<td>${cafe.name}</td>
							<td>${cafe.type}</td>
							<td><img src="/img/${cafe.photoUrl}"></td>
							<td>${cafe.address}</td>
							<td>${cafe.fullDescription}</td>
							<td>${cafe.phone}</td>
							<td>${cafe.email}</td>
							<td>${cafe.open.time}</td>
							<td>${cafe.close.time}</td>
							<td>
								<c:forEach var="meal" items="${cafe.meals}">
									${meal.title} 
								</c:forEach>
							</td>
							<td>
								<c:forEach var="table" items="${cafe.tables}">
									${table.countOfPeople} 
								</c:forEach>
							</td>
							<sec:authorize access="hasRole('ROLE_CAFE')">
							<td class="text-center">
								<a href="/profile/cafe/delete/${cafe.id}" class="btn btn-outline-danger btn-sm">Delete</a>
								<a href="/profile/createcafe/update/${cafe.id}" class="btn btn-outline-warning btn-sm">Update</a>
							</td>
							</sec:authorize>
						</tr>
				</table>
			</div>
		</div>
		<a href="/tablereservation/${cafe.id}" class="btn btn-outline-success btn-sm">Reserv a table</a>
<%-- 		<sec:authorize access="hasRole('ROLE_CAFE')"> --%>
<!-- 		<div class="row"> -->
<!-- 			<div class="col-12"> -->
<%-- 				<form:form action="/cafe" method="POST" modelAttribute="cafe" enctype="multipart/form-data"> --%>
<!-- 					<div class="form-group row"> -->
<!-- 						<label class="col-2 col-form-label" for="rate">Rate:</label> -->
<!-- 						<div class="col-10"> -->
<%-- 							<form:input class="form-control" id="rate" path="rate"/> --%>
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="form-group row"> -->
<!-- 						<label class="col-2 col-form-label" for="name">Name:</label> -->
<!-- 						<div class="col-10"> -->
<%-- 							<form:input class="form-control" id="name" path="name"/> --%>
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<input name="file" type="file"> -->
<!-- 					<div class="form-group row"> -->
<!-- 						<label class="col-2 col-form-label" for="address">Address:</label> -->
<!-- 						<div class="col-10"> -->
<%-- 							<form:input class="form-control" id="address" path="address"/> --%>
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="form-group row"> -->
<!-- 						<label class="col-2 col-form-label" for="fullDescription">Full Description:</label> -->
<!-- 						<div class="col-10"> -->
<%-- 							<form:textarea class="form-control" id="fullDescription" path="fullDescription" rows="5"/> --%>
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="form-group row"> -->
<!-- 						<label class="col-2 col-form-label" for="shortDescription">Short Description:</label> -->
<!-- 						<div class="col-10"> -->
<%-- 							<form:textarea class="form-control" id="shortDescription" path="shortDescription" rows="5"/> --%>
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="form-group row"> -->
<!-- 						<label class="col-2 col-form-label" for="type">Type:</label> -->
<!-- 						<div class="col-10"> -->
<!-- 								<div> -->
	<%-- 							<form:input class="form-control" id="type" path="type"/> --%>
<%-- 									<label>Pub <form:radiobutton path="type" value="PUB"/></label><br> --%>
<%-- 									<label>Sushy <form:radiobutton path="type" value="SUSHY"/></label><br> --%>
<%-- 									<label>Bar <form:radiobutton path="type" value="BAR"/></label><br> --%>
<%-- 									<label>Cafe <form:radiobutton path="type" value="CAFE"/></label><br> --%>
<%-- 									<label>Restaurant <form:radiobutton path="type" value="RESTAURANT"/></label> --%>
<!-- 								</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="form-group row"> -->
<!-- 						<label class="col-2 col-form-label" for="phone">Phone:</label> -->
<!-- 						<div class="col-10"> -->
<%-- 							<form:input class="form-control" id="phone" path="phone"/> --%>
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="row"> -->
<!-- 						<div class="col-10 ml-auto" style="color:red;"> -->
<%-- 							<form:errors path="email"/> --%>
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="form-group row"> -->
<!-- 						<label class="col-2 col-form-label" for="email">Email:</label> -->
<!-- 						<div class="col-10"> -->
<%-- 							<form:input class="form-control" id="email" path="email"/> --%>
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="form-group row"> -->
<!-- 						<label class="col-2 col-form-label" for="open">Open:</label> -->
<!-- 						<div class="col-10"> -->
<%-- 							<form:select path="open" items="${times}" class="form-control"/> --%>
<!-- 							<select class="form-control" id="open" name="open"> -->
<%-- 								<c:forEach var="time" items="${times}"> --%>
<%-- 									<option value="${time}">${time}</option> --%>
<%-- 								</c:forEach> --%>
<!-- 							</select> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="form-group row"> -->
<!-- 						<label class="col-2 col-form-label" for="close">Close:</label> -->
<!-- 						<div class="col-10"> -->
<%-- 						<form:select path="close" items="${times}" class="form-control"/> --%>
<!-- 							<select class="form-control" id="close" name="close"> -->
<%-- 								<c:forEach var="time" items="${times}"> --%>
<%-- 									<option value="${time}">${time}</option> --%>
<%-- 								</c:forEach> --%>
<!-- 							</select> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="form-group row"> -->
<!-- 						<div class="col-10 mr-left"> -->
<!-- 							<button class="btn btn-sm btn-outline-success">Save</button> -->
<!-- 							<a href="/cafe/cancel" class="btn btn-sm btn-outline-warning">Cancel</a> -->
<!-- 						</div> -->
<!-- 					</div> -->
<%-- 					<form:hidden path="user" value=""/> --%>
<%-- 				</form:form> --%>
				
<!-- 			</div> -->
<!-- 		</div> -->
<%-- 	</sec:authorize>	 --%>
	<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<tr>
						<th class="text-center">Email</th>
						<th class="text-center">Comment</th>
						<th class="text-center">Time</th>
						<th class="text-center">Options</th>
					</tr>
					<c:forEach var="comment" items="${comments}">
					<tr >
							<td>${comment.email}</td>
							<td>${comment.commentTxt}</td>
							<td>${comment.time}</td>
							<td><a href="/commentreply/${comment.id}" class="btn btn-outline-success btn-sm">Add reply</a></td>
					</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	<div class="row">
		<div class="col-2">
			<a href="/comment/${cafe.id}" class="btn btn-outline-success btn-sm">Add comment</a>
		</div>
	</div>
	<sec:authorize access="hasRole('ROLE_CAFE')">
		<a href="/cafe/${cafe.id}/order" class="btn btn-outline-success btn-sm">ORDERS</a>					
	</sec:authorize>
	
	</div>
</body>
</html>