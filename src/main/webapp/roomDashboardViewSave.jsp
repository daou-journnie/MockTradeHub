<%@ page import="org.example.mocktradehub.model.Post" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BankDash Dashboard</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <script src="https://cdn.tailwindcss.com"></script>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700&display=swap" rel="stylesheet">
</head>
<body>
<div class="flex overflow-hidden flex-col bg-white">
    <!-- Include Header -->
    <jsp:include page="mainHeader.jsp" />

    <hr class="flex shrink-0 self-end max-w-full h-px bg-slate-200 w-[1190px]" />

    <div class="flex flex-wrap gap-10 w-full max-md:max-w-full">
        <!-- Include Sidebar -->
        <jsp:include page="mainSidebar.jsp" />

        <!-- Main Content -->
        <main class="flex flex-col grow shrink-0 pt-20 pb-10 basis-0 bg-slate-100 w-fit">
            <!-- Trending Rooms Section -->
            <section>
                <div class="dashboard">
                    <!-- 왼쪽: 피드 영역 -->
                    <div class="dashboard-left">
                        <div class="feed-container">
                            <h2 class="feed-title">Feed</h2>
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
                            <div class="post-card">
                                <img loading="lazy" src="https://example.com/profile.jpg" class="profile-image" alt="Profile of DummyUser" />
                                <div class="post-content">
                                    <div class="post-header">
                                        <div class="user-info">
                                            <div class="username"><%=post.getMemberNickname()%></div>
                                        </div>
                                        <div class="timestamp">5분 전</div>
                                    </div>
                                    <div class="post-body">
                                        <div class="stock-info">
                                            <div class="post-text"><%=post.getPostContent()%></div>
                                        </div>
                                        <div class="post-actions">
                                            <div class="action-item">
                                                <div class="action-icon" aria-hidden="true"></div>
                                                <span aria-label="comments">댓글</span>
                                            </div>
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

                    <!-- 오른쪽: 랭킹 및 채팅 영역 -->
                    <div class="dashboard-right">
                        <!-- 랭킹 영역 -->
                        <div class="rank-container">
                            <h2 class="ranking-title">ranking</h2>
                            <div class="ranking-list">
                                <%
                                    // 예시: request에 "rankings"라는 이름의 List가 있다고 가정
                                    java.util.List rankings = (java.util.List) request.getAttribute("rankings");
                                    if(rankings != null && !rankings.isEmpty()){
                                        for(Object obj : rankings){
                                            // 실제 객체에 맞게 캐스팅하여 사용하세요.
                                            // 예를 들어: Ranking ranking = (Ranking) obj;
                                %>
                                <div class="ranking-item">
                                    <div class="ranking-info">
                                        <div class="user-info">
                                            <div class="rank-number">
                                                <span>1</span>
                                                <img loading="lazy" src="https://example.com/avatar.jpg" class="user-avatar" alt="User avatar" />
                                            </div>
                                            <span class="user-name">DummyUser</span>
                                        </div>
                                        <div class="user-stats">
                                            <span class="user-percentage">+15%</span>
                                            <span class="user-amount">$1,000</span>
                                        </div>
                                    </div>
                                </div>
                                <%
                                    }
                                } else {
                                %>
                                <p>No rankings available.</p>
                                <% } %>
                            </div>
                        </div>
                        <!-- 채팅 영역 -->
                        <h2 class="chat-title">채팅</h2>
                        <img loading="lazy" src="https://example.com/chat.jpg" class="chat-image" alt="Chat interface" />
                    </div>
                </div>
            </section>
        </main>
    </div>
</div>
</body>
</html>