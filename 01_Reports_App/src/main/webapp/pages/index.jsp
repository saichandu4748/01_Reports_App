<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewpoint" content="width=device-width, initial-scale=1">
<title>MINI-proj01</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h3 class="pb-3 pt-3">Report Application</h3>
		<form:form action="search" modelAttribute="search" method="POST">
			<table class="table table-striped table-hover">
				<tr>
					<td>Plan Name :</td>
					<td><form:select path="planName">
							<form:option value="">-Select-</form:option>
							<form:options items="${names}"></form:options>
						</form:select></td>
					<td>Plan Status :</td>
					<td><form:select path="planStatus">
							<form:option value="">-Select-</form:option>
							<form:options items="${status}"></form:options>
						</form:select></td>
					<td>Gender :</td>
					<td><form:select path="gender">
							<form:option value="">-Select-</form:option>
							<form:option value="Male">Male</form:option>
							<form:option value="Fe-Male">Fe-Male</form:option>
						</form:select></td>
				</tr>
				<tr>
					<td>Start Date :</td>
					<td><form:input path="startDate" type="date"
							 data-date-format="yyyy-mm-dd" /></td>
					<td>End Date :</td>
					<td><form:input path="endDate" type="date" 
							data-date-format="yyyy-mm-dd" /></td>
				</tr>
				<tr>
					<td><a href="./" class="btn btn-secondary">Reset</a></td>					
					<td><input type="submit" value="Search"
						class="btn btn-primary" /></td>
				</tr>
			</table>
		</form:form>
		<hr />
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<td>Id</td>
					<td>Holder Name</td>
					<td>Gender</td>
					<td>Plan Name</td>
					<td>Plan Status</td>
					<td>Start Date</td>
					<td>End Date</td>
					<td>Benefit Amount</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${plans}" var="plan">
					<tr>
						<td>${plan.citizenId}</td>
						<td>${plan.citizenName}</td>
						<td>${plan.citizenGender}</td>
						<td>${plan.planName}</td>
						<td>${plan.planStatus}</td>
						<td>${plan.planStartDate}</td>
						<td>${plan.planEndDate}</td>
						<td>${plan.benifitAmt}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<c:if test="${empty plans}">
					<h5 style="color:red;text-align:center">No records found</h5>
		</c:if>
		<hr />
		Export : <a href="excel">Excel</a> <a href="pdf">PDF</a>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>














