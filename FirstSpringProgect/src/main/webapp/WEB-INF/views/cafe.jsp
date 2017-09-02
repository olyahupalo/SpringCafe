<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<title>Cafe</title>
</head>
<body>
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
						<tr>
							<td>${cafe.rate}</td>
							<td>${cafe.name}</td>
							<td>${cafe.type}</td>
							<td>${cafe.photoUrl}</td>
							<td>${cafe.address}</td>
							<td>${cafe.fullDescription}</td>
							<td>${cafe.phone}</td>
							<td>${cafe.email}</td>
							<td>${cafe.open.time}</td>
							<td>${cafe.close.time}</td>
							<td class="text-center">
								<a href="/profile/cafe/update/${cafe.id}" class="btn btn-outline-warning btn-sm">Update</a>
								<a href="/profile/cafe/delete/${cafe.id}" class="btn btn-outline-danger btn-sm">Delete</a>
							</td>
						</tr>
				</table>
</body>
</html>