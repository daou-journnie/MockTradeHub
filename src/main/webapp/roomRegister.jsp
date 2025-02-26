<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>방 생성</title>
</head>
<body>
<h1>방 생성</h1>
<form action="${pageContext.request.contextPath}/room/register" method="post">
    <label>방 이름:
        <input type="text" name="roomName" required />
    </label><br/>

    <label>공개 여부:</label>
    <input type="radio" name="roomIsPublic" value="1" checked /> 공개
    <input type="radio" name="roomIsPublic" value="0" /> 비공개<br/>

    <label>최대 인원:
        <input type="number" name="roomMaxMembers" value="10" required />
    </label><br/>

    <label>시작일:
        <input type="date" name="roomStartDate" />
    </label><br/>

    <label>종료일:
        <input type="date" name="roomEndDate" />
    </label><br/>

    <label>초기 자금:
        <input type="number" name="roomInitialSeed" required /> 만원
    </label><br/>

    <label>방 설명:
        <textarea name="roomDescription"></textarea>
    </label><br/>

    <label>생성자 (ID):
        <input type="text" name="roomCreatedBy" required />
    </label><br/>

    <input type="submit" value="방 생성" />
</form>

<%
    Object error = request.getAttribute("error");
    if (error != null) {
%>
<p style="color:red;"><%= error %></p>
<%
    }
%>


<p><a href="roomList.jsp">방 목록으로 이동</a></p>
</body>
</html>
