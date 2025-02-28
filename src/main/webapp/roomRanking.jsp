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
    <div class="rank-container">
        <article class="rank-box">
            <div class="rank-content">
                <div class="user-info">
                    <div class="rank-position">
                        <span class="position-number">1</span>
                        <figure class="profile-image">
                            <img
                                    src="https://cdn.builder.io/api/v1/image/assets/TEMP/6646a82f5f00007e85bd7d2b208518cf9476f1f20721e59586845f3e185bec1e?placeholderIfAbsent=true&apiKey=74d6b347f88a4ec9b2441d4daff1986f"
                                    alt="Profile picture"
                                    class="profile-picture"
                            />
                        </figure>
                    </div>
                    <span class="user-name">김다우</span>
                </div>
                <div class="performance-metrics">
                    <p class="percentage-change">+28.9%</p>
                    <p class="amount">+100,000</p>
                </div>
            </div>
        </article>
    </div>
</section>
