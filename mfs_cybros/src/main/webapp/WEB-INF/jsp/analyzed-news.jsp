<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>


<div class="container">
	<br>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3>List of Analyzed News</h3>
		</div>
		<div class="panel-body">
			<table class="table table-striped">
				<thead>
					<tr>
						<th width="20%">Title</th>
						<th width="20%">Reliability Index</th>
						<th width="15%">Source</th>
						<th width="20%">Publication Date</th>
						<th width="30%">Link</th>
						<th width="20%"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${news}" var="news">
						<tr>
							<td>${news.title}</td>
							<td>${news.reliability}%</td>
							<td>${news.source}</td>
							<td>${news.publicationDate}</td>
							<td>${news.link}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</div>



<%@ include file="common/footer.jspf"%>




