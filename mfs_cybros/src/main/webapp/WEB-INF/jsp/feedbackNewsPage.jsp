<%@ include file="common/header.jspf"%>
<%@ include file="common/navigationMod.jspf" %>
<div class="container">
	<br>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3>List News feedback </h3>
		</div>
		<div class="panel-body">
			<table class="table table-striped">
				<thead>
					<tr>
						<th width="40%">LinkNews</th>
						<th width="40%">User</th>
						<th width="20%">Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${feedbackNewsList}" var="feedbackNews">
						<tr>
							<td>${feedbackNews.linkNews}</td>
							<td>${feedbackNews.user}</td>
							<td>
								<div class="row">
									<div class="col-md-3">
										<form action="/deleteNewsFeedback" method="POST">
											<input type="hidden" name="idFbNews" value="${feedbackNews.idFbNews}">
											<button type="submit" class="btn btn-danger btn-sm">Delete</button>
										</form>
									</div>
									<div class="col-md-3">
										<form action="/lowerReliability" method="POST">
											<input type="hidden" name="link" value="${feedbackNews.linkNews}">
											<button type="submit" class="btn btn-warning btn-sm ">lower reliability</button>
										</form>
									</div>
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
<%@ include file="common/footer.jspf"%>
