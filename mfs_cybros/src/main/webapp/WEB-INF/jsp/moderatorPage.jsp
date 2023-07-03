<%@ include file="common/header.jspf" %>
<%@ include file="common/navigationMod.jspf" %>
<div class="container">

    <div class="panel panel-primary">
        <div class="panel-heading">ModeratorPAGE: ${name}</div>
       		 <div class="panel-body">
            Welcome to MODERATOPAGE !!&emsp;<a href="/profilePage">Manage your Profile</a>
            <table class="table">
                <tr>
                    <td>
                        <a href="/listSystemFeedbackMod">List System Feedback</a>
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="/FeedbackNewsMod">News Feedback</a>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>
<%@ include file="common/footer.jspf" %>

