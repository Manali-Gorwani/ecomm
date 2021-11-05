<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="ISO-8859-1">
    <title>Registration Success</title>
    <link rel="stylesheet" type="text/css" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
<div class="container text-center">
    <h3>Username and password length should be greater than 4</h3>
    <% "${message}" %>
    <% ${message} %>
    <% out.print("test"); %>
</div>
</body>
</html>