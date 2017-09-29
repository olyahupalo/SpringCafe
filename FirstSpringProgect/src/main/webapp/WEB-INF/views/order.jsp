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
<title>Orders</title>
</head>
<body>
<div class="container">
		<div class="row">
			<div class="col-12">
				<form:form action="/cafe/${cafeId}/order" method="POST" modelAttribute="order">
					<div class="form-group row">
					<label class="col-2 col-form-label" for=table>Table:</label>
						<div class="col-10">
							<form:select path="table" items="${tables}" class="form-control" itemLabel="countOfPeople" itemValue="id"/>
						</div>
					</div>	
					<div class="form-group row">
						<label class="col-2 col-form-label" for="meals">Meals:</label>
						<div class="col-10">
							<form:select path="meals" items="${meals}" class="form-control" multiple="multiple" itemLable="title" itemValue="id"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-10 mr-left">
							<button class="btn btn-sm btn-outline-success">Save</button>
							<a href="/cafe/{id}/order/cancel" class="btn btn-sm btn-outline-warning">Cancel</a>
						</div>
					</div>
				</form:form>
				
				<c:forEach var="order" items="${orders}">
						<tr onMouseOver="this.style.backgroundColor='#ECECEE';" onMouseOut="this.style.backgroundColor='white'" onclick="location.href='cafe/${meal.cafeId}'">
							<td>${order.table}</td>
							<td>
								<c:forEach var="meal" items="${order.meals}">
									${meal} 
								</c:forEach>
							</td>
							<sec:authorize access="hasRole('ROLE_CAFE')">
								<td class="text-center">
<%-- 									<a href="/meal/update/${meal.id}" class="btn btn-outline-warning btn-sm">Update</a> --%>
<%-- 									<a href="/meal/delete/${meal.id}" class="btn btn-outline-danger btn-sm">Delete</a> --%>
								</td>
							</sec:authorize>
						</tr>
					</c:forEach>
			</div>
		</div>
	</div>	

</body>
</html>