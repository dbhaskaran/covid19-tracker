<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<title>Vaccine Tracker💉</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-8 col-sm-8 col-xs-12">
				<h2>
					<a href="https://github.com/dbhaskaran/covid19-tracker"
						target="_blank">Vaccine Worldwide Data</a>
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
					<div class="col-md-4 col-sm-4 col-xs-12" style="padding-top: 50px;">
					<script type="text/javascript" id="clstr_globe" src="//cdn.clustrmaps.com/globe.js?d=CO6oEw3RaHKtpDqbEsnyI5wIIiyiPQg4cazaWIqyLUs"></script>
					</div>
			</div>

		</div>
		<p>
			Powered by: <a href="https://github.com/BloombergGraphics/covid-vaccine-tracker-data"
				target="_blank"> Bloomberg Covid-19 Vaccine Tracker Open Data </a>
		</p>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Country</th>
					<th>Population</th>
					<th>Doses Administered</th>
					<th>People Vaccinated</th>
					<th>Completed Vaccination</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${vax}" var="vax">
					<tr>
						<td>${vax.country}</td>
						<td>${vax.population}</td>
						<td>${vax.dosesAdministered}</td>
						<td>${vax.peopleVaccinated}</td>
						<td>${vax.completedVaccination}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>