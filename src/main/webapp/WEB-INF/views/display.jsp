<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.12/css/dataTables.bootstrap.min.css"
	rel="stylesheet" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.12/js/jquery.dataTables.min.js"></script>

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
					<div class="col-md-4 col-sm-4 col-xs-12" style="padding-top: 50px;">
						<script type="text/javascript" id="clstr_globe"
							src="//cdn.clustrmaps.com/globe.js"></script>
					</div>
			</div>

		</div>
		<p>
			Powered by: <a href="https://github.com/CSSEGISandData/COVID-19"
				target="_blank"> Johns Hopkins CSSE </a>
			<div class="api blink">REST API</div>: <a href="https://covid-dashboard.herokuapp.com/api/countries/"
				target="_blank"> GET All </a>
				<a href="https://covid-dashboard.herokuapp.com/api/countries/india"
				target="_blank"> GET Country </a>
		</p>

		<table id="datatab"
			class="table table-striped table-bordered table-hover"
			cellspacing="0" width="100%">
			<thead>
				<tr>
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
						<td>${covid.country}</td>
						<td>${covid.confirmed}</td>
						<td>${covid.deaths}</td>
						<td>${covid.recovered}</td>
						<td>${covid.confirmed - (covid.deaths + covid.recovered)}</td>
						<td><fmt:formatNumber type="number" maxFractionDigits="2"
								minFractionDigits="2"
								value="${(covid.recovered/covid.confirmed)*100}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script>
		$(document).ready( function () {
			  $('#datatab').dataTable( {
			    "bFilter": false,
			    "paging": false
			  } );
			} );
	</script>
	<script>
	function blink_text() {
	    $('.blink').fadeOut(500);
	    $('.blink').fadeIn(500);
	}
	setInterval(blink_text, 1000);
	</script>
</body>
</html>