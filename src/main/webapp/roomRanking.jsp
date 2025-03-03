<%@ page import="org.example.mocktradehub.model.Post" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="css/roomRanking.css" />
<!-- jQuery CDN 추가 -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- JavaScript 파일 불러오기 -->
<script src="<c:url value="/js/roomRanking.js"/>"></script

<%
    String roomId = (String) session.getAttribute("roomId");
%>
<!-- hidden input을 이용해 JavaScript로 room_id 전달 -->
<input type="hidden" id="room-id" value="<%= roomId %>">

<section class="rank-section">
    <h2 class="rank-header">Ranking</h2>
    <div class="rank-container"></div>
</section>
