<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3 ">
			<div class="panel panel-primary">
				<div class="panel-heading">Enter the news link</div>
				<div class="panel-body">
					<form:form method="post" modelAttribute="news">
						<form:hidden path="idNews" />
						
						<fieldset class="form-group">
							<form:label path="link">Link</form:label>
							<form:input path="link" type="text" class="form-control"
								required="required" />
							<form:errors path="link" cssClass="text-warning" />
						</fieldset>


						<button type="submit" class="btn btn-success">Analyze</button>
					</form:form>
					
					

					
				</div>
			</div>

		</div>
	</div>
</div>








<%@ include file="common/footer.jspf"%>