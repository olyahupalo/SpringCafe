<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="custom" uri="/WEB-INF/tags/implicit.tld"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
<title>All Cafes</title>
</head>
<body>
	<h2>All Cafes</h2>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<form:form action="/cafe" method="GET" modelAttribute="cafeFilter">
					<div class="form-group row">
						<div class="col-6">
							<form:input path="name" class="form-control" placeholder="Name"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-6">
							<form:input path="minRate" class="form-control" placeholder="Min rate"/>
						</div>
						<div class="col-6">
							<form:input path="maxRate" class="form-control" placeholder="Max rate"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-6">
							<form:input path="minCount" class="form-control" placeholder="Min Count"/>
						</div>
						<div class="col-6">
							<form:input path="maxCount" class="form-control" placeholder="Max Count"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-12">
							<div>
								<label>Pub <form:checkbox path="types" value="PUB"/></label>
								<label>Sushy <form:checkbox path="types" value="SUSHY"/></label>
								<label>Bar <form:checkbox path="types" value="BAR"/></label>
								<label>Cafe <form:checkbox path="types" value="CAFE"/></label>
								<label>Restaurant <form:checkbox path="types" value="RESTAURANT"/></label>
							</div>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-6">
							<form:input path="minOpen" class="form-control" placeholder="Min open"/>
						</div>
						<div class="col-6">
							<form:input path="maxOpen" class="form-control" placeholder="Max open"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-12">
							<form:checkboxes items="${meals}" path="mealsIds" element="div" itemLabel="title" itemValue="id"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-12">
        					<button type="submit" class="btn btn-outline-success btn-sm">Search</button>
      					</div>
					</div>
				</form:form>
			</div>
		<div class="row">
			<div class="col-9">
				<table class="table table-bordered">
					<tr>
						<th class="text-center">Rate</th>
						<th class="text-center">Name</th>
						<th class="text-center">PhotoUrl</th>
						<th class="text-center">Address</th>
						<th class="text-center">Short Description</th>
						<th class="text-center">Type</th>
					</tr>
					<c:forEach var="cafe" items="${allcafes.content}">
							<tr onMouseOver="this.style.backgroundColor='#ECECEE';" onMouseOut="this.style.backgroundColor='white'" onclick="location.href='cafe/${cafe.id}'">
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
			<div class="col-3">
				<div class="row">
					<div class="col-6 text-center">
							<button class="dropdown-toggle btn btn-outline-primary btn-sm" type="button" data-toggle="dropdown">Sort</button>
							<div class="dropdown-menu">
								<custom:sort innerHtml="Name asc" paramValue="name"/>
								<custom:sort innerHtml="Name desc" paramValue="name,desc"/>
							</div>
					</div>
					<div class="col-6 text-center">
						<custom:size posibleSizes="1,2,5,10" size="${allcafes.size}"/>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-12 text-center">
				<custom:pageable page="${allcafes}"/>
			</div>
		</div>
		</div>
	</div>
</body>
</html>