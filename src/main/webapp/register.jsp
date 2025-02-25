<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>회원가입</title>
</head>
<body>
<h1>회원가입</h1>
<form action="register" method="post">
  <label>아이디: <input type="text" name="id" required /></label><br/>
  <label>비밀번호: <input type="password" name="password" required /></label><br/>
  <label>이름: <input type="text" name="name" required /></label><br/>
  <label>닉네임: <input type="text" name="nickname" required /></label><br/>
  <input type="submit" value="회원가입" />
</form>
<c:if test="${not empty error}">
  <p style="color:red;">${error}</p>
</c:if>
<p><a href="login.jsp">로그인 페이지로 이동</a></p>
</body>
</html>
