<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
        <li class="flex text-zinc-400">
            <a href="roomRegister.jsp" class="flex items-center gap-5 pl-6 w-full">
                <img src="https://cdn.builder.io/api/v1/image/assets/TEMP/2d2ac9bea5f4d02cc41a098f4515ca5b68a42dcfd02dd8160c52ebe47f86868e?placeholderIfAbsent=true&apiKey=74d6b347f88a4ec9b2441d4daff1986f" alt="Create Room" class="object-contain shrink-0 aspect-square w-[25px]" />
                <span>방 생성</span>
            </a>
        </li>

    </ul>
</nav>