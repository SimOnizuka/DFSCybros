<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
<!-- 	<div> -->
<!-- 		<a type="button" class="btn btn-primary btn-md" href="/add-todo">Add News</a> -->
<!-- 	</div> -->
	<br>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3>Blacklist</h3>
		</div>
		<div class="panel-body">
			<table class="table table-striped">
				<thead>
					<tr>
						<th width="40%">Name</th>
						<th width="40%">Reliability Index</th>
						<th width="20%"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${sources}" var="source">
						<tr>
							<td>${source.name}</td>
							<td>${source.sourceConfidenceIndex}%</td>
<!-- 							<td><a type="button" class="btn btn-success" -->
<!-- 								href="/update-todo?id=${todo.id}">Update</a> -->
<!-- 							<a type="button" class="btn btn-warning" -->
<!-- 								href="/delete-todo?id=${todo.id}">Delete</a></td> -->
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</div>
<%@ include file="common/footer.jspf"%>