<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>대시보드</title>
  <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/styles.css">
</head>
<body>
<div class="dashboard">
  <!-- 왼쪽: 피드 영역 -->
  <div class="dashboard-left">
    <div class="feed-container">
      <h2 class="feed-title">Feed</h2>
<%--      <%--%>
<%--        // 예시: request에 "posts"라는 이름의 List가 있다고 가정--%>
<%--        java.util.List posts = (java.util.List) request.getAttribute("posts");--%>
<%--        if(posts != null && !posts.isEmpty()){--%>
<%--          for(Object obj : posts){--%>
<%--            // 실제 객체에 맞게 캐스팅하여 사용하세요.--%>
<%--            // 예를 들어: Post post = (Post) obj;--%>
<%--            // 여기서는 더미 데이터를 출력합니다.--%>
<%--      %>--%>
      <div class="post-card">
        <img loading="lazy" src="https://example.com/profile.jpg" class="profile-image" alt="Profile of DummyUser" />
        <div class="post-content">
          <div class="post-header">
            <div class="user-info">
              <div class="username">DummyUser</div>
            </div>
            <div class="timestamp">5분 전</div>
          </div>
          <div class="post-body">
            <div class="stock-info">
              <div class="post-text">Sample post text...</div>
            </div>
            <div class="post-actions">
              <div class="action-item">
                <div class="action-icon" aria-hidden="true"></div>
                <span aria-label="comments">1,240</span>
              </div>
            </div>
          </div>
        </div>
      </div>
<%--      <%--%>
<%--        } // end for--%>
<%--      } else {--%>
<%--      %>--%>
<%--      <p>No posts available.</p>--%>
<%--      <% } %>--%>
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
</body>
</html>
