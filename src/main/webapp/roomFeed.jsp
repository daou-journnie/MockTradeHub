<%@ page import="org.example.mocktradehub.model.Post" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String roomId = request.getParameter("roomId");
%>
<link rel="stylesheet" href="css/roomFeed.css" />
<!-- jQuery CDN 추가 -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- JavaScript 파일 불러오기 -->
<script src="<c:url value="/js/roomFeed.js"/>"></script>

<!-- hidden input을 이용해 JavaScript로 room_id 전달 -->
<input type="hidden" id="room-id" value="<%= roomId %>">
<section class="feed-section">
    <h2 class="feed-header">Feed</h2>
    <div class="feed-container"></div>
</section>
