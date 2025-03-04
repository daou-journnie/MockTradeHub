<%@ page import="org.example.mocktradehub.model.Post" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String roomId = request.getParameter("roomId");
    String memberId = (String) session.getAttribute("id");
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
    <br>
<%--    <form id="postForm" action="<%= request.getContextPath() %>/room/post/insert" method="post">--%>
        <!-- roomId와 memberId를 hidden input으로 전송 -->
        <input type="hidden" name="roomId" value="<%= roomId %>">
        <input type="hidden" name="memberId" value="<%= memberId %>">
        <!-- 포스트를 작성할 수 있는 textarea -->
        <div class="form-group">
            <textarea id="post-text" name="postContent" class="post-textarea" placeholder="포스트 내용을 입력하세요..." rows="5"></textarea>
        </div>
        <div class="form-group" style="text-align: right;">
            <button type="submit" class="post-submit-btn">포스트 작성</button>
        </div>
<%--    </form>--%>
</section>
