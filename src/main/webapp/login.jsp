<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
<form action="login" method="post">
    <label>Email: <input type="text" name="email" /></label><br/>
    <label>Password: <input type="password" name="password" /></label><br/>
    <input type="submit" value="Login" />
</form>
<%
    String error = (String) request.getAttribute("error");
    if (error != null) {
%>
<p style="color:red;"><%= error %></p>
<%
    }
%>
</body>
</html>
