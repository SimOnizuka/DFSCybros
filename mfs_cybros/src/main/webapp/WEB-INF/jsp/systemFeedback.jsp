<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3 ">
			<div class="panel panel-primary">
				<div class="panel-heading">Add FEEDBACK</div>
				<div class="panel-body">
					<form:form method="post" modelAttribute="systemFeedback">
						<form:hidden path="id" />
						<fieldset class="form-group">
							<form:label path="userString">e-mail</form:label>
							<form:input path="userString" type="text" class="form-control"
								required="required" />
							<form:errors path="userString" cssClass="text-warning" />
						</fieldset>

						<fieldset class="form-group">
							<form:label path="feedback">feedback</form:label>
							<form:input path="feedback" type="text" class="form-control"
								required="required" />
							<form:errors path="feedback" cssClass="text-warning" />
						</fieldset>

						<button type="submit" class="btn btn-success">Send</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="common/footer.jspf"%>