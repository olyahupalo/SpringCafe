<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
				<form action="/admin/cafe" method="POST">
					<div class="form-group row">
						<label class="col-2 col-form-label" for="rate">Rate:</label>
						<div class="col-10">
							<input class="form-control" id="rate" name="rate">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="name">Name:</label>
						<div class="col-10">
							<input class="form-control" id="name" name="name">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="photoUrl">PhotoUrl:</label>
						<div class="col-10">
							<input class="form-control" id="photoUrl" name="photoUrl">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="address">Address:</label>
						<div class="col-10">
							<input class="form-control" id="address" name="address">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="fullDescription">Full Description:</label>
						<div class="col-10">
							<textarea class="form-control" id="fullDescription" name="fullDescription" rows="5"></textarea>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="type">Type:</label>
						<div class="col-10">
							<textarea class="form-control" id="type" name="type" rows="5"></textarea>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="phone">Phone:</label>
						<div class="col-10">
							<input class="form-control" id="phone" name="phone">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="email">Email:</label>
						<div class="col-10">
							<input class="form-control" id="email" name="email">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="open">Open:</label>
						<div class="col-10">
							<input class="form-control" id="open" name="open">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="close">Close:</label>
						<div class="col-10">
							<input class="form-control" id="close" name="close">
						</div>
					</div>
					<div class="form-group row">
						<div class="col-10 mr-left">
							<button class="btn btn-sm btn-outline-success">Save</button>
						</div>
					</div>
				</form>
			</div>
		</div>
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
					</tr>
					<c:forEach var="cafes" items="${cafes}">
						<tr>
							<td>${cafes.rate}</td>
							<td>${cafes.name}</td>
							<td>${cafes.type}</td>
							<td>${cafes.photoUrl}</td>
							<td>${cafes.address}</td>
							<td>${cafes.fullDescription}</td>
							<td>${cafes.phone}</td>
							<td>${cafes.email}</td>
							<td>${cafes.open}</td>
							<td>${cafes.close}</td>
							<td class="text-center">
								<a href="/admin/cafe/update/${cafe.id}" class="btn btn-outline-warning btn-sm">Update</a>
								<a href="/admin/cafe/delete/${cafe.id}" class="btn btn-outline-danger btn-sm">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>