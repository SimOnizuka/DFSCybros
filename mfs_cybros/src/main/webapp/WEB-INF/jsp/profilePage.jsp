<%@ include file="common/header.jspf" %>
<%@ include file="common/navigationMod.jspf" %>
<div class="container">

    <div class="panel panel-primary">
        <div class="panel-heading">Hi ${name}, Manage your account</div>
       		 <div class="panel-body">
         	<table class="table table-striped">
         		<tbody>
         			<tr>
         			<td>Email: ${moderator.emailString}</td>
         			<td>Name: ${moderator.nameString}</td>
         			<td>Surname: ${moderator.surnameString}</td>
         			<td>city of birth: ${moderator.cityOfBirth}</td>
         			<td>date of Birth: ${moderator.dateOfBirth}</td>
         			
         			<td><a type="button" class="btn btn-success"
								href="/updateProfile">Update</a>
         			</tr>
         		</tbody>
       		</table>
        </div>
    </div>
</div>
<%@ include file="common/footer.jspf" %>

