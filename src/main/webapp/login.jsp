<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>로그인</title>
    <style>
        /* 전체 레이아웃 및 배경 */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Noto Sans KR', sans-serif;
        }

        body {
            min-height: 100vh;
            display: flex;
            flex-direction: column;
            /* 밝은 그라데이션 배경 */
            background: linear-gradient(135deg, #ffffff 0%, #f2f2f2 50%, #e0e0e0 100%);
            color: #333;
        }

        /* 상단 로고 영역 */
        .header {
            position: relative;
            width: 100%;
            padding: 1rem 2rem;
            display: flex;
            align-items: center;
            justify-content: space-between;
        }

        .header .logo {
            display: flex;
            align-items: center;
            gap: 8px;
            font-size: 1.2rem;
            font-weight: 600;
            color: #333;
        }

        .header .close-btn {
            cursor: pointer;
            font-size: 1.1rem;
            background: transparent;
            border: none;
            color: #666;
        }
        .header .close-btn:hover {
            color: #333;
        }

        /* 메인 컨테이너: 중앙 정렬 */
        .login-container {
            flex: 1;
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 2rem;
        }

        /* 로그인 박스(모달) */
        .login-box {
            width: 400px;
            background-color: #fff;
            border-radius: 10px;
            padding: 2rem;
            box-shadow: 0 8px 24px rgba(0,0,0,0.1);
        }

        .login-box h2 {
            text-align: center;
            margin-bottom: 1.5rem;
            font-size: 1.4rem;
            color: #333;
        }

        /* 탭 영역 */
        .tabs {
            display: flex;
            border-bottom: 1px solid #ddd;
            margin-bottom: 1.5rem;
        }

        .tab {
            flex: 1;
            text-align: center;
            padding: 0.8rem;
            cursor: pointer;
            color: #888;
            transition: background-color 0.3s;
        }
        .tab:hover {
            background-color: rgba(0,0,0,0.05);
        }
        .tab.active {
            color: #333;
            font-weight: 600;
            border-bottom: 2px solid #4F8FFF;
        }

        /* 폼 */
        .form-group {
            margin-bottom: 1rem;
        }

        .form-group label {
            display: block;
            margin-bottom: 0.3rem;
            font-size: 0.9rem;
            color: #555;
        }

        .form-group input {
            width: 100%;
            padding: 0.75rem;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #fff;
            color: #333;
            font-size: 0.95rem;
        }

        .form-group input::placeholder {
            color: #999;
        }

        /* 체크박스 영역 */
        .checkbox-group {
            display: flex;
            align-items: center;
            margin-bottom: 0.8rem;
        }

        .checkbox-group input[type="checkbox"] {
            margin-right: 0.4rem;
            transform: scale(1.1);
            cursor: pointer;
        }

        .checkbox-group label {
            font-size: 0.85rem;
            color: #555;
            cursor: pointer;
        }

        /* 로그인 버튼 */
        .login-btn {
            width: 100%;
            padding: 0.9rem;
            font-size: 1rem;
            font-weight: 600;
            background-color: #4F8FFF;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 1rem;
            transition: background-color 0.3s;
        }
        .login-btn:hover {
            background-color: #3a74cc;
        }

        /* 하단 링크 */
        .bottom-text {
            text-align: center;
            margin-top: 1rem;
            font-size: 0.85rem;
            color: #666;
        }
        .bottom-text a {
            color: #4F8FFF;
            text-decoration: none;
            font-weight: 500;
            margin-left: 0.3rem;
        }
        .bottom-text a:hover {
            text-decoration: underline;
        }

        /* 반응형 */
        @media (max-width: 480px) {
            .login-box {
                width: 90%;
                padding: 1.5rem;
            }
            .header {
                padding: 1rem;
            }
        }
    </style>
</head>
<body>
<!-- 헤더 영역 -->
<div class="header">
    <div class="logo">
        <!-- 실제 로고 이미지가 있다면 <img src="로고.png" alt="토스증권"> 사용 가능 -->
        <span>모모</span>
    </div>
    <button class="close-btn">X</button>
</div>

<!-- 메인 컨테이너 -->
<div class="login-container">
    <!-- 로그인 박스 -->
    <div class="login-box">
        <h2>로그인</h2>

        <!-- 폼 -->
        <form action="login" method="post">
        <div class="form-group">
                <label for="id">아이디</label>
                <input type="text" id="id" name="id" placeholder="예) daoudaou" required>
            </div>
            <div class="form-group">
                <label for="password">비밀번호</label>
                <input type="password" id="password" name="password" required>
            </div>

            <button type="submit" class="login-btn">로그인</button>
        </form>

        <div class="bottom-text">
            아직 회원이 아니신가요?
            <a href="register">회원가입 하기</a>
        </div>
    </div>
</div>
<% if (request.getAttribute("error") != null) { %>
<script>
    alert("<%= request.getAttribute("error") %>");
</script>
<% } %>

</body>
</html>
