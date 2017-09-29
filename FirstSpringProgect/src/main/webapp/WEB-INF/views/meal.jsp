<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="custom" uri="/WEB-INF/tags/implicit.tld"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<title>Meal</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<form:form action="/meal" method="GET" modelAttribute="mealFilter">
					<div class="form-group row">
						<div class="col-6">
							<form:input path="title" class="form-control" placeholder="Title "/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-6">
							<form:input path="minPrice" class="form-control" placeholder="Min price"/>
						</div>
						<div class="col-6">
							<form:input path="maxPrice" class="form-control" placeholder="Max price"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-6">
							<form:input path="minWeight" class="form-control" placeholder="Min Weight"/>
						</div>
						<div class="col-6">
							<form:input path="maxWeight" class="form-control" placeholder="Max Weight"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-12">
							<form:checkboxes items="${cuisines}" path="cuisinesIds" element="div" itemLabel="name" itemValue="id"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-12">
							<form:checkboxes items="${ingredients}" path="ingredientsIds" element="div" itemLabel="name" itemValue="id"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-12">
							<form:checkboxes items="${cafes}" path="cafesIds" element="div" itemLabel="name" itemValue="id"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-12">
        					<button type="submit" class="btn btn-outline-success btn-sm">Search</button>
      					</div>
					</div>
				</form:form>
			</div>
		
		
		
			<div class="col-9">
				<table class="table table-bordered">
					<tr>
						<th class="text-center">Title</th>
						<th class="text-center">Description</th>
						<th class="text-center">Price</th>
						<th class="text-center">Cuisine</th>
						<th class="text-center">Cafe</th>
						<th class="text-center">Weight</th>
						<th class="text-center">Ingredients</th>
						<sec:authorize access="hasRole('ROLE_CAFE')">
							<th class="text-center">Options</th>
						</sec:authorize>
					</tr>
					<c:forEach var="meal" items="${meals.content}">
<%-- 						<tr onMouseOver="this.style.backgroundColor='#ECECEE';" onMouseOut="this.style.backgroundColor='white'" onclick="location.href='cafe/${meal.cafeId}'"> --%>
							<td>${meal.title}</td>
							<td>${meal.description}</td>
							<td>${meal.price}</td>
							<td>${meal.cuisine}</td>
							<td>${meal.cafe}</td>
							<td>${meal.weight}</td>
							<td>
								<c:forEach var="ingredient" items="${meal.ingredients}">
									${ingredient} 
								</c:forEach>
							</td>
							<sec:authorize access="hasRole('ROLE_CAFE')">
								<td class="text-center">
									<a href="/meal/update/${meal.id}" class="btn btn-outline-warning btn-sm">Update</a>
									<a href="/meal/delete/${meal.id}" class="btn btn-outline-danger btn-sm">Delete</a>
								</td>
							</sec:authorize>
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
						<custom:size posibleSizes="1,2,5,10" size="${meals.size}"/>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-12 text-center">
				<custom:pageable page="${meals}"/>
			</div>
		</div>
		</div>
		<sec:authorize access="hasRole('ROLE_CAFE')">
		<div class="row">
			<div class="col-12">
				<form:form action="/meal" method="POST" modelAttribute="meal">
					<div class="row">
						<div class="col-10 ml-auto" style="color: red;">
							<form:errors path="title"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="title">Title:</label>
						<div class="col-10">
							<form:input class="form-control" id="title" path="title"/>
						</div>
					</div>
					<div class="row">
						<div class="col-10 ml-auto" style="color: red;">
							<form:errors path="description"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="description">Description:</label>
						<div class="col-10">
							<form:textarea class="form-control" id="description" path="description" rows="5"/>
						</div>
					</div>
					<div class="row">
						<div class="col-10 ml-auto" style="color: red;">
							<form:errors path="price"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="price">Price:</label>
						<div class="col-10">
							<form:input class="form-control" id="price" path="price"/>
						</div>
					</div>
					<div class="row">
						<div class="col-10 ml-auto" style="color: red;">
							<form:errors path="weight"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="weight">Weight:</label>
						<div class="col-10">
							<form:input class="form-control" id="weight" path="weight"/>
						</div>
					</div>
					
					<div class="form-group row">
						<label class="col-2 col-form-label" for="cuisine">Cuisine:</label>
						<div class="col-10">
							<form:select path="cuisine" items="${cuisines}" class="form-control"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="cafe">Cafe:</label>
						<div class="col-10">
							<form:select path="cafe" items="${cafes}" class="form-control" itemLabel="name" itemValue="id"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="ingredients">Ingredients:</label>
						<div class="col-10">
							<form:select path="ingredients" items="${ingredients}" class="form-control" multiple="multiple"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-10 mr-left">
							<button class="btn btn-sm btn-outline-success">Save</button>
							<a href="meal/cancel" class="btn btn-sm btn-outline-warning">Cancel</a>
						</div>
					</div>
				</form:form>
			</div>
		</div>
		</sec:authorize>
	</div>
</body>
</html>