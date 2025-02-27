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

    <header class="flex flex-wrap gap-5 justify-between px-16 py-0.5 w-full bg-white max-md:px-5 max-md:max-w-full">
        <div class="flex gap-2.5 my-auto text-2xl font-black whitespace-nowrap text-slate-700">
            <img src="https://cdn.builder.io/api/v1/image/assets/TEMP/d63245a00b59f9e324876521c8dacd55526a616a0845d613143f797a4c6d0d15?placeholderIfAbsent=true&apiKey=74d6b347f88a4ec9b2441d4daff1986f" alt="BankDash Logo" class="object-contain shrink-0 w-9 aspect-square" />
            <h1 class="basis-auto">MockTradeHub</h1>
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
                            src="assets/search.png"
                            alt="검색"
                            class="absolute w-[100%] h-[100%] object-contain"
                            loading="lazy"
                    />
                </button>
            </form>
            <form action="/logout" method="post" class="max-w-24">
                <button
                        type="submit"
                        class="relative flex justify-center items-center w-[40px] h-[40px] rounded-full group cursor-pointer bg-red-100 hover:bg-red-200 transition-all"
                        aria-label="로그아웃"
                >
                    <img
                            src="assets/logout.png"
                            alt="로그아웃"
                            class="absolute w-[100%] h-[100%] object-contain"
                            loading="lazy"
                    />
                </button>
            </form>
        </div>
    </header>

    <hr class="flex shrink-0 self-end max-w-full h-px bg-slate-200 w-[1190px]" />

    <div class="flex flex-wrap gap-10 w-full max-md:max-w-full">
        <!-- Include Sidebar -->


        <nav class="self-start mt-3.5 text-lg font-medium">
            <ul class="flex flex-col items-start gap-7 mt-6 w-full max-md:pl-5">
                <!-- 대시보드 -->
                <li class="relative flex text-blue-600 w-full">
                    <!-- 왼쪽 파란색 바 -->
                    <div class="absolute left-0 h-full w-1.5 bg-blue-600"></div>
                    <a href="mainDashboard.jsp" class="flex items-center gap-5 pl-6 w-full hover:text-blue-500 transition-all">
                        <img src="https://cdn.builder.io/api/v1/image/assets/TEMP/d07aeb6d6cd5df7a0942ba5b083c212017387bc2c6f0e6bb1287e3c200954188?placeholderIfAbsent=true&apiKey=74d6b347f88a4ec9b2441d4daff1986f"
                             alt="Dashboard Icon" class="object-contain shrink-0 aspect-square w-[25px]" />
                        <span>대시보드</span>
                    </a>
                </li>
                <li class="flex text-zinc-400">
                    <a href="roomRegister.jsp" class="flex items-center gap-5 pl-6 w-full">
                        <img src="https://cdn.builder.io/api/v1/image/assets/TEMP/2d2ac9bea5f4d02cc41a098f4515ca5b68a42dcfd02dd8160c52ebe47f86868e?placeholderIfAbsent=true&apiKey=74d6b347f88a4ec9b2441d4daff1986f" alt="Create Room" class="object-contain shrink-0 aspect-square w-[25px]" />
                        <span>방 생성</span>
                    </a>
                </li>
                <li class="flex text-zinc-400">
                    <a href="#" class="flex items-center gap-5 pl-6 w-full">
                        <img src="https://cdn.builder.io/api/v1/image/assets/TEMP/60ba399886b79b584e871694a2f62b0a9b4ebbaa4ef291cbed07ef3ded30a088?placeholderIfAbsent=true&apiKey=74d6b347f88a4ec9b2441d4daff1986f" alt="Mock Investment" class="object-contain shrink-0 self-start aspect-square w-[25px]" />
                        <span>모의 투자</span>
                    </a>
                </li>
            </ul>
        </nav>

        <!-- Main Content -->
        <main class="flex flex-col grow shrink-0 pt-20 pb-10 basis-0 bg-slate-100 w-fit">
            <!-- Trending Rooms Section -->
            <section>
                <div class="flex flex-wrap gap-9 justify-between items-start whitespace-nowrap">
                    <div
                            class="flex gap-2.5 justify-center text-2xl font-semibold leading-6 min-h-[981px] min-w-[240px] text-slate-700 w-[683px] max-md:max-w-full"
                    >
                        <div class="flex flex-col min-w-[240px] w-[683px]">
                            <h2 class="max-md:max-w-full">Feed</h2>

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
                                String memberId = (String) session.getAttribute("id");
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
                    <div class="flex flex-col rounded-none min-w-[240px] w-[381px]">
                        <div class="flex flex-col">
                            <h2 class="text-2xl font-semibold text-slate-700">ranking</h2>
                            <div
                                    class="flex flex-col items-start px-5 pt-5 pb-11 mt-2.5 w-full bg-white rounded-3xl max-w-[381px] min-h-[274px]"
                            >
                                <div class="flex justify-between items-center w-full max-w-[328px]">
                                    <div
                                            class="flex flex-1 shrink gap-10 justify-between items-center self-stretch my-auto w-full basis-0 min-w-[240px]"
                                    >
                                        <div
                                                class="flex gap-5 items-center self-stretch my-auto w-52 text-2xl"
                                        >
                                            <div
                                                    class="flex gap-2.5 items-center self-stretch my-auto font-extrabold leading-none text-red-500"
                                            >
                                                <div class="self-stretch my-auto">1</div>
                                                <img
                                                        loading="lazy"
                                                        src="https://cdn.builder.io/api/v1/image/assets/95d2139536c34adaae3b31dfe70e821f/6646a82f5f00007e85bd7d2b208518cf9476f1f20721e59586845f3e185bec1e?apiKey=95d2139536c34adaae3b31dfe70e821f&"
                                                        alt="Ranking avatar for 김다우"
                                                        class="object-contain shrink-0 self-stretch my-auto aspect-[0.94] w-[60px]"
                                                />
                                            </div>
                                            <div class="self-stretch my-auto font-semibold text-neutral-800">
                                                김다우
                                            </div>
                                        </div>
                                        <div
                                                class="flex flex-col justify-center items-end self-stretch my-auto min-h-[51px] w-[58px]"
                                        >
                                            <div class="text-lg font-medium text-right text-neutral-800">
                                                +28.9%
                                            </div>
                                            <div class="mt-2 text-base font-semibold text-slate-400">
                                                1,000,000원
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div
                                        class="flex justify-between items-center mt-2.5 w-full max-w-[328px]"
                                >
                                    <div
                                            class="flex flex-1 shrink gap-10 justify-between items-center self-stretch my-auto w-full basis-0 min-w-[240px]"
                                    >
                                        <div
                                                class="flex gap-5 items-center self-stretch my-auto w-52 text-2xl"
                                        >
                                            <div
                                                    class="flex gap-2.5 items-center self-stretch my-auto font-extrabold leading-none text-red-500"
                                            >
                                                <div class="self-stretch my-auto">2</div>
                                                <img
                                                        loading="lazy"
                                                        src="https://cdn.builder.io/api/v1/image/assets/95d2139536c34adaae3b31dfe70e821f/a24c794bb0d83268a0a4e1e2f83a86bcdcdbe18719b31c052b393db0bb94a58e?apiKey=95d2139536c34adaae3b31dfe70e821f&"
                                                        alt="Ranking avatar for 김다우"
                                                        class="object-contain shrink-0 self-stretch my-auto aspect-[0.94] w-[60px]"
                                                />
                                            </div>
                                            <div class="self-stretch my-auto font-semibold text-neutral-800">
                                                김다우
                                            </div>
                                        </div>
                                        <div
                                                class="flex flex-col justify-center items-end self-stretch my-auto min-h-[51px] w-[58px]"
                                        >
                                            <div class="text-lg font-medium text-right text-neutral-800">
                                                +28.9%
                                            </div>
                                            <div class="mt-2 text-base font-semibold text-slate-400">
                                                1,000,000원
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div
                                        class="flex justify-between items-center mt-2.5 w-full max-w-[328px]"
                                >
                                    <div
                                            class="flex flex-1 shrink gap-10 justify-between items-center self-stretch my-auto w-full basis-0 min-w-[240px]"
                                    >
                                        <div
                                                class="flex gap-5 items-center self-stretch my-auto w-52 text-2xl"
                                        >
                                            <div
                                                    class="flex gap-2.5 items-center self-stretch my-auto font-extrabold leading-none text-red-500"
                                            >
                                                <div class="self-stretch my-auto">3</div>
                                                <img
                                                        loading="lazy"
                                                        src="https://cdn.builder.io/api/v1/image/assets/95d2139536c34adaae3b31dfe70e821f/ef4cb514c5f77ee33e7d99015d6615ed6d2becdfed1ea58fdee2e8cc7b37bd43?apiKey=95d2139536c34adaae3b31dfe70e821f&"
                                                        alt="Ranking avatar for 김다우"
                                                        class="object-contain shrink-0 self-stretch my-auto aspect-[0.94] w-[60px]"
                                                />
                                            </div>
                                            <div class="self-stretch my-auto font-semibold text-neutral-800">
                                                김다우
                                            </div>
                                        </div>
                                        <div
                                                class="flex flex-col justify-center items-end self-stretch my-auto min-h-[51px] w-[58px]"
                                        >
                                            <div class="text-lg font-medium text-right text-neutral-800">
                                                +28.9%
                                            </div>
                                            <div class="mt-2 text-base font-semibold text-slate-400">
                                                1,000,000원
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <h2
                                class="self-start mt-5 ml-6 text-2xl font-semibold text-slate-700 max-md:ml-2.5"
                        >
                            Chat
                        </h2>
                        <img
                                loading="lazy"
                                src="https://cdn.builder.io/api/v1/image/assets/95d2139536c34adaae3b31dfe70e821f/dcf05a402e5ae2a84964e506996c23e67105e6f3d9b324adb6325fd96ac1e658?apiKey=95d2139536c34adaae3b31dfe70e821f&"
                                alt="Chat interface"
                                class="object-contain mt-2 w-full rounded-none aspect-[0.63]"
                        />
                    </div>
                </div>
            </section>
        </main>
    </div>
</div>
</body>
</html>