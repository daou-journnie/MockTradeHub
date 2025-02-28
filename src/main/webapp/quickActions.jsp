<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="css/quickActions.css">
<script src="<c:url value="/js/quickAction.js"/>"></script>

<section>
    <h2 class="quick-actions-title">
        빠른 참가
    </h2>
    <aside class="quick-actions">
        <div class="quick-actions-container">
            <div class="actions-grid">
                <!-- Link Action -->
                <div class="action-item">
                    <button class="action-content" aria-label="초대 코드로 방 참여">
                        <img src="https://cdn.builder.io/api/v1/image/assets/TEMP/d6b33e32291e3f23adfab78ceb8b22743ebc96b971ed4988cea34d5c1f6017d2?placeholderIfAbsent=true&apiKey=74d6b347f88a4ec9b2441d4daff1986f" alt="Link" class="action-icon" />
                        <span class="action-text" onclick="enterRoomWithCode()">코드</span>
                    </button>
                </div>

                <!-- Create Room Action -->
                <div class="action-item">
                    <button class="action-content" aria-label="새로운 방 생성">
                        <img src="https://cdn.builder.io/api/v1/image/assets/TEMP/1b0adf6f511b4cf699c0df6a91644b83d12ef05a37b6b36e51add73a25f983f6?placeholderIfAbsent=true&apiKey=74d6b347f88a4ec9b2441d4daff1986f" alt="Create Room" class="action-icon" />
                        <span class="action-text" onclick="roomRegister()">방 생성</span>
                    </button>
                </div>
            </div>
        </div>
    </aside>
</section>