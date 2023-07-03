<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<html>
<head>
    <title>Please Log In</title>
    <link rel="stylesheet" href="/webjars/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1>Please Log In</h1>
        <% if (request.getParameter("error") != null) { %>
            <div class="alert alert-danger">
                Invalid username and password.
            </div>
        <% } %>
        <% if (request.getParameter("logout") != null) { %>
            <div class="alert alert-info">
                You have been logged out.
            </div>
        <% } %>
        <form action="${pageContext.request.contextPath}/login" method="post">
            <div class="form-group">
                <label for="username">Username</label>
                <input type="text" name="username" id="username" class="form-control" placeholder="Username">
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" name="password" id="password" class="form-control" placeholder="Password">
            </div>
            <button type="submit" class="btn btn-primary">Log in</button>

             <a href="/registration" class="btn btn-primary">Registrati!</a>
        </form>
    </div>
    
    <script src="/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
<%@ include file="common/footer.jspf"%>
</html>

