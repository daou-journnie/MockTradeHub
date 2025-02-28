<%@ page import="org.example.mocktradehub.model.Post" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="css/roomFeed.css" />

<section class="feed-section">
    <h2 class="feed-header">Feed</h2>
<%--    <%--%>
<%--        // 예시: request에 "posts"라는 이름의 List가 있다고 가정--%>
<%--        List<Post> posts = (List<Post>) request.getAttribute("posts");--%>
<%--        if(posts != null && !posts.isEmpty()){--%>
<%--            for(Object obj : posts){--%>
<%--                Post post = (Post) obj;--%>
<%--    %>--%>
    <div class="feed-container">
        <article class="feed-card">
            <div class="feed-content">
                <header class="feed-top">
<%--                    <h3 class="user-name"><%=post.getMemberNickname()%></h3>--%>
                    <h3 class="user-name">테스트 닉네임</h3>
                    <time class="time-ago">29분전</time>
                </header>
<%--                <p class="feed-text"><%=post.getPostContent()%></p>--%>
                <p class="feed-text">테스트 콘텐츠</p>
                <footer class="feed-stats">
                    <div>
                        <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg" class="comment-icon">
                            <path d="M1.75098 10C1.75098 5.58 5.33498 2 9.75598 2H14.122C18.612 2 22.251 5.64 22.251 10.13C22.251 13.09 20.644 15.81 18.055 17.24L10.001 21.7V18.01H9.93398C5.44398 18.11 1.75098 14.5 1.75098 10ZM9.75598 4C6.43898 4 3.75098 6.69 3.75098 10C3.75098 13.37 6.52098 16.08 9.88898 16.01L10.24 16H12.001V18.3L17.088 15.49C19.039 14.41 20.251 12.36 20.251 10.13C20.251 6.74 17.507 4 14.122 4H9.75598Z" fill="#536471"></path>
                        </svg>
                    </div>
                    <span class="comment-count">댓글 수</span>
                </footer>
            </div>
        </article>
    </div>
<%--    <%--%>
<%--        } // end for--%>
<%--    } else {--%>
<%--    %>--%>
<%--    <p>No posts available.</p>--%>
<%--    <% } %>--%>
</section>


<%--<div class="dashboard-left">--%>
<%--    <div class="feed-container">--%>
<%--        <div class="text-wrapper">Feed</div>--%>
<%--        <div class="group">--%>
<%--            <%--%>
<%--                // 예시: request에 "posts"라는 이름의 List가 있다고 가정--%>
<%--                List<Post> posts = (List<Post>) request.getAttribute("posts");--%>
<%--                if(posts != null && !posts.isEmpty()){--%>
<%--                    for(Object obj : posts){--%>
<%--                        Post post = (Post) obj;--%>

<%--                        // 실제 객체에 맞게 캐스팅하여 사용하세요.--%>
<%--                        // 예를 들어: Post post = (Post) obj;--%>
<%--                        // 여기서는 더미 데이터를 출력합니다.--%>
<%--            %>--%>
<%--            <div class="post-list">--%>

<%--                <div class="large-post">--%>

<%--                    <div class="frame">--%>
<%--                        <div class="title-bar">--%>
<%--                            <div class="left-tools">--%>
<%--                                <div class="text">--%>
<%--                                    <div class="div-wrapper"><div class="div"><%=post.getMemberNickname()%></div></div>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <div class="left-tools">--%>
<%--                                <div class="text">--%>
<%--                                    <div class="div-wrapper"><div class="text-wrapper-2">29분 전</div></div>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <div class="bottom">--%>
<%--                            <div class="text-2"><%=post.getPostContent()%></div>--%>
<%--                            <div class="toolbar">--%>
<%--                                <div class="thread">--%>
<%--                                    <img class="img" src="https://c.animaapp.com/8XNQhQzb/img/thread.svg" />--%>
<%--                                    <div class="text-wrapper-3">댓글 수 할 건가</div>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <%--%>
<%--                        } // end for--%>
<%--                    } else {--%>
<%--                    %>--%>
<%--                    <p>No posts available.</p>--%>
<%--                    <% } %>--%>
<%--                </div>--%>




<%--            </div>--%>

<%--            <!-- 포스트 작성 폼 -->--%>
<%--            <%--%>
<%--                // roomId는 request나 session에서 가져온다고 가정합니다.--%>
<%--                int roomId = (int) request.getAttribute("roomId");--%>
<%--                // memberId도 session에서 가져온다고 가정--%>
<%--                String memberId = (String) session.getAttribute("memberId");--%>
<%--            %>--%>
<%--            <form action="<%= request.getContextPath() %>/room/post/insert" method="post" class="post-form">--%>
<%--                <textarea name="postContent" placeholder="포스트 내용을 입력하세요..." required></textarea>--%>
<%--                <!-- 새로운 포스트인 경우 postParentId는 비워둡니다 -->--%>
<%--                <input type="hidden" name="postParentId" value="" />--%>
<%--                <input type="hidden" name="memberId" value="<%= memberId %>" />--%>
<%--                <input type="hidden" name="roomId" value="<%= roomId %>" />--%>

<%--                <button type="submit">작성하기</button>--%>
<%--            </form>--%>

<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
