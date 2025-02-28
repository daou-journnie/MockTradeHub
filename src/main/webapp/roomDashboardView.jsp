<%@ page import="org.example.mocktradehub.model.Post" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/globals.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styleguide.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />
</head>
<body>
<div class="trade-room">
    <div class="overlap-wrapper">
        <div class="overlap">
            <div class="overlap-group">
                <div class="dashboard">
                    <div class="dashboard-left">
                        <div class="feed-container">
                            <div class="text-wrapper">Feed</div>
                            <div class="group">
                                <%
                                    // 예시: request에 "posts"라는 이름의 List가 있다고 가정
                                    java.util.List posts = (java.util.List) request.getAttribute("posts");
                                    if(posts != null && !posts.isEmpty()){
                                        for(Object obj : posts){
                                            Post post = (Post) obj;

                                            // 실제 객체에 맞게 캐스팅하여 사용하세요.
                                            // 예를 들어: Post post = (Post) obj;
                                            // 여기서는 더미 데이터를 출력합니다.
                                %>
                                <div class="post-list">

                                    <div class="large-post">

                                        <div class="frame">
                                            <div class="title-bar">
                                                <div class="left-tools">
                                                    <div class="text">
                                                        <div class="div-wrapper"><div class="div"><%=post.getMemberNickname()%></div></div>
                                                    </div>
                                                </div>
                                                <div class="left-tools">
                                                    <div class="text">
                                                        <div class="div-wrapper"><div class="text-wrapper-2">29분 전</div></div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="bottom">
                                                <div class="text-2"><%=post.getPostContent()%></div>
                                                <div class="toolbar">
                                                    <div class="thread">
                                                        <img class="img" src="https://c.animaapp.com/8XNQhQzb/img/thread.svg" />
                                                        <div class="text-wrapper-3">댓글 수 할 건가</div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <%
                                            } // end for
                                        } else {
                                        %>
                                        <p>No posts available.</p>
                                        <% } %>
                                    </div>




                                </div>

                                <!-- 포스트 작성 폼 -->
                                <%
                                    // roomId는 request나 session에서 가져온다고 가정합니다.
                                    int roomId = (int) request.getAttribute("roomId");
                                    // memberId도 session에서 가져온다고 가정
                                    String memberId = (String) session.getAttribute("memberId");
                                %>
                                <form action="<%= request.getContextPath() %>/room/post/insert" method="post" class="post-form">
                                    <textarea name="postContent" placeholder="포스트 내용을 입력하세요..." required></textarea>
                                    <!-- 새로운 포스트인 경우 postParentId는 비워둡니다 -->
                                    <input type="hidden" name="postParentId" value="" />
                                    <input type="hidden" name="memberId" value="<%= memberId %>" />
                                    <input type="hidden" name="roomId" value="<%= roomId %>" />

                                    <button type="submit">작성하기</button>
                                </form>

                            </div>
                        </div>
                    </div>
                    <div class="dashboard-right">
                        <div class="rank-container">
                            <div class="text-wrapper-4">ranking</div>
                            <div class="rank-list">
                                <div class="rank-box">
                                    <div class="frame-2">
                                        <div class="frame-3">
                                            <div class="frame-4">
                                                <div class="text-wrapper-5">1</div>
                                                <div class="iconfinder-business-wrapper">
                                                    <img
                                                            class="iconfinder-business"
                                                            src="https://c.animaapp.com/8XNQhQzb/img/iconfinder-business-finance-money-13-2784281-1.svg"
                                                    />
                                                </div>
                                            </div>
                                            <div class="frame-5"><div class="text-wrapper-6">김다우</div></div>
                                        </div>
                                        <div class="frame-6">
                                            <div class="text-wrapper-7">+28.9%</div>
                                            <div class="text-wrapper-8">1,000,000원</div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="overlap-2">
                <header class="header">
                    <div class="group-wrapper">
                        <div class="group-2">
                            <div class="group-3">
                                <div class="overlap-3">
                                    <div class="img-2">
                                        <div class="overlap-group-2">
                                            <div class="ellipse"></div>
                                            <img class="img-2" src="https://c.animaapp.com/8XNQhQzb/img/search.svg" />
                                        </div>
                                    </div>
                                    <div class="overlap-group-wrapper">
                                        <div class="overlap-group-2">
                                            <div class="ellipse"></div>
                                            <img class="img-2" src="https://c.animaapp.com/8XNQhQzb/img/logout.svg" />
                                        </div>
                                    </div>
                                </div>
                                <div class="group-4">
                                    <div class="overlap-4">
                                        <div class="rectangle"></div>
                                        <img
                                                class="magnifying-glass"
                                                src="https://c.animaapp.com/8XNQhQzb/img/magnifying-glass-1.svg"
                                        />
                                        <div class="text-wrapper-9">주식 검색</div>
                                    </div>
                                </div>
                            </div>
                            <div class="logo">
                                <div class="iconfinder-vector"></div>
                                <div class="text-wrapper-10">BankDash.</div>
                            </div>
                            <div class="text-wrapper-11">TradeRoom</div>
                        </div>
                    </div>
                    <div class="rectangle-2"></div>
                </header>
                <div class="sidebar-menu">
                    <div class="group-5">
                        <div class="text-wrapper-12">거래 내역</div>
                        <div class="text-wrapper-13">모의 투자</div>
                        <div class="text-wrapper-14">설정</div>
                        <img class="settings-solid" src="https://c.animaapp.com/8XNQhQzb/img/settings-solid-3.svg" />
                        <div class="text-wrapper-15">멤버</div>
                        <img class="service" src="https://c.animaapp.com/8XNQhQzb/img/service-1.svg" />
                        <img class="economic-investment" src="https://c.animaapp.com/8XNQhQzb/img/economic-investment-2.svg" />
                        <img class="user" src="https://c.animaapp.com/8XNQhQzb/img/user-3-1.svg" />
                        <div class="group-6">
                            <img class="home" src="https://c.animaapp.com/8XNQhQzb/img/home-2.svg" />
                            <div class="text-wrapper-16">대시 보드</div>
                            <div class="rectangle-3"></div>
                        </div>
                    </div>
                    <div class="rectangle-4"></div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
