<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="css/roomListMember.css">
<!-- jQuery CDN 추가 -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- JavaScript 파일 불러오기 -->
<script src="<c:url value="/js/roomListMember.js"/>"></script>

<%
    String memberId = (String) session.getAttribute("id");
%>

<!-- hidden input을 이용해 JavaScript로 member_id 전달 -->
<input type="hidden" id="member-id" value="<%= memberId %>">


<section class="room-list-section">

    <h2 class="room-list-title">
        참여중인 TradeRoom
    </h2>

    <div class="room-list-container">
        <!-- Table Header -->
        <div class="room-list-header">
            <div class="header-left">
                <span>방 이름</span>
                <span>방 CODE</span>
                <span>방 설명</span>
                <span>잔액</span>
                <span>수익율</span>
                <span>참가</span>
            </div>
        </div>
        <hr class="room-list-divider" />
        <!-- Room Entries -->
        <div class="room-entries"></div>
    </div>
</section>