<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<title>Table</title>
</head>
<body>
	<div class="container">
		<div class="row">
		<div class="col-12">
				<form:form action="/profile/table" method="POST" modelAttribute="table">
					<div class="form-group row">
						<label class="col-2 col-form-label" for="countOfPeople">Count Of People:</label>
						<div class="col-10">
							<form:input class="form-control" id="countOfPeople" path="countOfPeople"/>
						</div>
					</div>
<!--
					<div class="form-group row">
						<label class="col-2 col-form-label" for="isFree">isFree:</label>
						<div class="col-10">
							<form:input class="form-control" id="isFree" path="isFree"/>
						</div>
					</div>
-->
					<div class="form-group row">
						<label class="col-2 col-form-label" for="cafe">Cafe:</label>
						<div class="col-10">
							<form:select path="cafe" items="${cafes}" class="form-control" itemLabel="name" itemValue="id"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-10 mr-left">
							<button class="btn btn-sm btn-outline-success">Save</button>
							<a href="/profile/table/cancel" class="btn btn-sm btn-outline-warning">Cancel</a>
						</div>
					</div>
				</form:form>
			</div>
			<div class="col-12">
				<table class="table table-bordered">
					<tr>
						<th class="text-center">Count of people</th>
						<th class="text-center">Options</th>
						<th class="text-center">Cafe</th>
					</tr>
					<c:forEach var="table" items="${tables}">
						<tr>
							<td>${table.countOfPeople}</td>
							<td>${table.isFree}</td>
							<td>${table.cafe.name}</td>
							<td class="text-center">
								<a href="/profile/table/update/${table.id}" class="btn btn-outline-warning btn-sm">Update</a>
								<a href="/profile/table/delete/${table.id}" class="btn btn-outline-danger btn-sm">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>