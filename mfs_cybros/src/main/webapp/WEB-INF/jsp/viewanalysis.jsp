<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>


<div class="container">
	
	<br>
	

			<div class="panel-heading">
				<h3>Report</h3>
			</div>
			<div>
				If you think the analysis of the news is wrong, you can report it here by leaving your email .
			</div>
	        <br>
	        <form:form method="post" modelAttribute="feedbacknews">
						<form:hidden path="idFbNews" />
						
						<fieldset class="form-group">
							<form:label path="user">Enter your email</form:label>
							<form:input path="user" type="text" class="form-control"
								required="required" />
							<form:errors path="user" cssClass="text-warning" />
						</fieldset>
						
			        <button type="submit" class="btn btn-success" >Send Report</button>
			</form:form>


</div>




<br>

<%@ include file="common/footer.jspf"%>