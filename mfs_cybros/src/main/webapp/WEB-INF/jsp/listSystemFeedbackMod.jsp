<%@ include file="common/header.jspf"%>
<%@ include file="common/navigationMod.jspf" %>
<div class="container">
	<br>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3>List system feedback </h3>
		</div>
		<div class="panel-body">
			<table class="table table-striped">
				<thead>
					<tr>
						<th width="40%">User</th>
						<th width="40%">FeedbackSystem</th>
						<th width="20%">Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${feedbackList}" var="feedback">
						<tr>
							<td>${feedback.userString}</td>
               			    <td>${feedback.feedback}</td>						
							<td>
    							<form action="/delete-systemFeedback" method="POST">
     						   		<input type="hidden" name="id" value="${feedback.id}">
        							<button type="submit" class="btn btn-danger btn-sm">Delete</button>
    							</form>
						</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</div>
<%@ include file="common/footer.jspf"%>