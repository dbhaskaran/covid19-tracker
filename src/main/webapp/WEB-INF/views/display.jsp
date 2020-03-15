<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>COVID-19 Tracker🦠</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-8 col-sm-8 col-xs-12">
				<h2>
					<a href="https://github.com/dbhaskaran/covid19-tracker"
						target="_blank">COVID-19 Worldwide Data</a>
				</h2>
			</div>

			<div class="col-md-4 col-sm-4 col-xs-12" style="padding-top: 30px;">
				<form action="search" method="POST" class="form-main">
					<div class="col-md-8 col-sm-8 col-xs-12">
						<label class="sr-only" for="search">Search</label>
						<div class="input-group">
							<input type="text" class="form-control input-search"
								name="country" id="search" placeholder="Search">
						</div>
					</div>
			</div>

		</div>

		<p>
			Powered by: <a href="https://github.com/CSSEGISandData/COVID-19"
				target="_blank"> Johns Hopkins CSSE </a>
		</p>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>State</th>
					<th>Country</th>
					<th>Confirmed</th>
					<th>Deaths</th>
					<th>Recovered</th>
					<th>Active Cases</th>
					<th>Recovery Percentage</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${covids}" var="covid">
					<tr>
						<td>${covid.state}</td>
						<td>${covid.country}</td>
						<td>${covid.confirmed}</td>
						<td>${covid.deaths}</td>
						<td>${covid.recovered}</td>
						<td>${covid.confirmed - (covid.deaths + covid.recovered)}</td>
						<td>${(covid.recovered/covid.confirmed)*100}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>