<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>방 대시보드</title>
    <!-- Bootstrap CSS (CDN 이용) -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        /* 헤더 스타일 */
        .header {
            background-color: #007bff;
            color: white;
            padding: 15px;
        }
        /* 왼쪽 네비게이션 바 */
        .sidebar {
            background-color: #f8f9fa;
            min-height: 100vh;
            padding-top: 20px;
        }
        .sidebar .nav-link {
            color: #333;
        }
        .sidebar .nav-link:hover {
            background-color: #e2e6ea;
        }
        /* 메인 콘텐츠 영역 */
        .feed-section {
            border-right: 1px solid #dee2e6;
            padding: 20px;
            height: calc(100vh - 70px); /* 헤더 높이를 빼고 */
            overflow-y: auto;
        }
        .ranking-section {
            border-bottom: 1px solid #dee2e6;
            padding: 20px;
            height: 50%;
            overflow-y: auto;
        }
        .chat-section {
            padding: 20px;
            height: 50%;
            overflow-y: auto;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <!-- 헤더 -->
    <div class="row">
        <div class="col-12 header">
            <h1>방 페이지</h1>
        </div>
    </div>
    <!-- 본문: 왼쪽 네비게이션 + 메인 콘텐츠 -->
    <div class="row">
        <!-- 왼쪽 네비게이션 바 -->
        <div class="col-md-2 sidebar">
            <ul class="nav flex-column">
                <li class="nav-item">
                    <a class="nav-link" href="dashboard.jsp">대시보드</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="tradeHistory.jsp">거래내역</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="mockInvestment.jsp">모의투자</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="members.jsp">멤버</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="settings.jsp">설정</a>
                </li>
            </ul>
        </div>
        <!-- 메인 콘텐츠 영역 -->
        <div class="col-md-10">
            <div class="row">
                <!-- 왼쪽: 피드 영역 -->
                <div class="col-md-6 feed-section">
                    <h3>피드</h3>
                    <!-- 여기에 트위터나 스레드처럼 피드를 위한 콘텐츠를 추가 -->
                </div>
                <!-- 오른쪽: 상단 랭킹, 하단 채팅 영역 -->
                <div class="col-md-6">
                    <div class="ranking-section">
                        <h3>멤버 수익률 순위</h3>
                        <!-- 여기에 멤버 순위 관련 콘텐츠를 추가 -->
                    </div>
                    <div class="chat-section">
                        <h3>채팅방</h3>
                        <!-- 여기에 채팅 관련 콘텐츠를 추가 -->
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS, Popper.js (CDN 이용) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
