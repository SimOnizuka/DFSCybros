
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="container">
	
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3>Analysis</h3>
		</div>
		<div class="panel-body">
				<h3>Results</h3>
				<table class="table table-striped">
					<tbody>
						<tr>
						<td>source: ${news.source}</td>
					</tr>
					<tr>
						<td>link: ${news.link}</td>
					</tr>
					<tr>
						<td>reliability: ${news.reliability}</td>
					</tr>
					<tr>
						<td>publicationDate: ${news.publicationDate}</td>
					</tr>
					<tr>
						<td>title: ${news.title}</td>
					</tr>
					</tbody>
				</table>

			<br>
		</div>
		</div>
		
			<div class="panel-body">
			<a href="/viewanalysis">Give a Report</a>⚠️
			</div>

</div>



<%@ include file="common/footer.jspf"%>