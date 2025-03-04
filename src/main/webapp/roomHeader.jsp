<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- jQuery CDN 추가 -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="<c:url value="/js/roomHeader.js"/>"></script>

<%
    String memberId = (String) session.getAttribute("id");
    String contextPath = request.getContextPath();
%>

<!-- hidden input을 이용해 JavaScript로 member_id 전달 -->
<input type="hidden" id="member-id" value="<%= memberId %>">
<input type="hidden" id="room-id" value=${roomId}>
<input type="hidden" id="contextPath" value=<%=contextPath%>>


<header class="flex flex-wrap gap-5 justify-between px-16 py-0.5 w-full bg-white max-md:px-5 max-md:max-w-full">
    <div class="flex gap-2.5 my-auto text-2xl font-black whitespace-nowrap text-slate-700">
        <img src="https://cdn.builder.io/api/v1/image/assets/TEMP/d63245a00b59f9e324876521c8dacd55526a616a0845d613143f797a4c6d0d15?placeholderIfAbsent=true&apiKey=74d6b347f88a4ec9b2441d4daff1986f" alt="BankDash Logo" class="object-contain shrink-0 w-9 aspect-square" />
        <h1 class="basis-auto">MoMo</h1>
        <!-- 드롭다운으로 방 목록 표시 -->
        <select id="roomSelect" class="ml-4 px-2 py-1 text-xl font-semibold text-gray-600 bg-white border border-gray-300 rounded-md" onchange="changeRoom()">
        </select>
    </div>

    <div class="flex items-center gap-2 text-base text-slate-400">
        <form action="/search" method="get" class="flex items-center gap-2">
            <div class="flex flex-auto gap-4 px-6 py-4 my-auto bg-slate-100 rounded-[40px] max-md:px-5">
                <img src="https://cdn.builder.io/api/v1/image/assets/TEMP/986d95aa352a2c956987853ad96149c08498bb48158a7de39aadef96edc66d24?placeholderIfAbsent=true&apiKey=74d6b347f88a4ec9b2441d4daff1986f" alt="Search" class="object-contain shrink-0 w-5 aspect-square" />
                <input name="searchKeyword" type="search" placeholder="종목 검색" class="bg-transparent outline-none" />
            </div>
            <button
                    type="submit"
                    class="relative flex justify-center items-center w-[40px] h-[40px] rounded-full group cursor-pointer bg-blue-100 hover:bg-blue-200 transition-all"
                    aria-label="검색"
            >
                <img
                        src="${pageContext.request.contextPath}/assets/search.png"
                        alt="검색"
                        class="absolute w-[100%] h-[100%] object-contain"
                        loading="lazy"
                />
            </button>
        </form>
        <a href="${pageContext.request.contextPath}/mainDashboard.jsp" class="max-w-24">
            <button
                    type="submit"
                    class="relative flex justify-center items-center w-[40px] h-[40px] rounded-full group cursor-pointer bg-red-100 hover:bg-red-200 transition-all"
                    aria-label="나가기"
            >
                <img
                        src="${pageContext.request.contextPath}/assets/logout.png"
                        alt="로그아웃"
                        class="absolute w-[100%] h-[100%] object-contain"
                        loading="lazy"
                />
            </button>
        </a>
    </div>
</header>