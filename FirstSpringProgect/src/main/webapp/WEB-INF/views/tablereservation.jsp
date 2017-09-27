<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<title>Reserv Table</title>
</head>
<body>
<form:form action="/tablereservation" method="POST" modelAttribute="tablereservation">
					<div class="form-group row">
						<label class="col-2 col-form-label" for="email">Email</label>
						<div class="col-10">
							<form:input class="form-control" id="email" path="email"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="name">Name:</label>
						<div class="col-10">
							<form:input class="form-control" id="name" path="name"/>
						</div>
					</div>
					<div class="form-group row">
					<label class="col-2 col-form-label" for="phone">Phone:</label>
						<div class="col-10">
							<form:input class="form-control" id="phone" path="phone"/>
					</div>
					</div>
					
					<div class="form-group row">
					<label class="col-2 col-form-label" for="table">Cuisine:</label>
						<div class="col-10">
							<form:select path="table" items="${tables}" class="form-control"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-10 mr-left">
							<button class="btn btn-sm btn-outline-success">Save</button>
							<a href="/cafe" class="btn btn-sm btn-outline-warning">Cancel</a>
						</div>
					</div>
				</form:form>
</body>
</html>