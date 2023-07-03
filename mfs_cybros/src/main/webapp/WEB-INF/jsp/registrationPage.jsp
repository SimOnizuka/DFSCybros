<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3 ">
			<div class="panel panel-primary">
				<div class="panel-heading">Registration</div>
				<div class="panel-body">
					<form:form method="post" modelAttribute="moderator">
							
						<fieldset class="form-group">
						<legend>Registration</legend>
							<form:label path="emailString">email</form:label>
							<form:input path="emailString" type="text" class="form-control"
								required="required" />
							<form:errors path="emailString" cssClass="text-warning" />
						</fieldset>

						<fieldset class="form-group">
							<form:label path="passwordString">password</form:label>
							<form:input path="passwordString" type="text" class="form-control"
								required="required" />
							<form:errors path="passwordString" cssClass="text-warning" />
						</fieldset>
						
						<fieldset class="form-group">
							<form:label path="nameString">name</form:label>
							<form:input path="nameString" type="text" class="form-control"
								required="required" />
							<form:errors path="nameString" cssClass="text-warning" />
						</fieldset>
						
						<fieldset class="form-group">
							<form:label path="surnameString">surname</form:label>
							<form:input path="surnameString" type="text" class="form-control"
								required="required" />
							<form:errors path="surnameString" cssClass="text-warning" />
						</fieldset>
						
						<fieldset class="form-group">
							<form:label path="cityOfBirth">city of birth</form:label>
							<form:input path="cityOfBirth" type="text" class="form-control"
								required="required" />
							<form:errors path="cityOfBirth" cssClass="text-warning" />
						</fieldset>
						
						<fieldset class="form-group">
							<form:label path="dateOfBirth">date of birth (yyyy-MM-dd)</form:label>
							<form:input path="dateOfBirth" type="text" class="form-control"
								required="required" />
							<form:errors path="dateOfBirth" cssClass="text-warning" />
						</fieldset>

						<button type="submit" class="btn btn-success">Save</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="common/footer.jspf"%>