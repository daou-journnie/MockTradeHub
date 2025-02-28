<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="self-start mt-3.5 text-lg font-medium">
    <ul class="flex flex-col items-start gap-7 mt-6 w-full max-md:pl-5">
        <!-- 대시보드 -->
        <li class="relative flex w-full ${currentPage.endsWith('mainDashboard.jsp') ? 'text-blue-600' : 'text-zinc-400'}">
            <!-- 왼쪽 파란색 바 -->
            <c:if test="${currentPage.endsWith('mainDashboard.jsp')}">
            <div class="absolute left-0 h-full w-1.5 bg-blue-600"></div>
            </c:if>
            <a href="mainDashboard.jsp" class="flex items-center gap-5 pl-6 w-full hover:text-blue-500 transition-all">
                <svg class="object-contain shrink-0 self-start aspect-square w-[25px] ${currentPage.endsWith('mainDashboard.jsp') ? 'fill-blue-600' : 'fill-zinc-400'}" viewBox="0 0 25 25"  xmlns="http://www.w3.org/2000/svg">
                    <g clip-path="url(#clip0_14_918)">
                        <path d="M24.3254 10.8738C24.3248 10.8732 24.3243 10.8727 24.3237 10.8721L14.1257 0.674438C13.691 0.239563 13.1131 0 12.4983 0C11.8836 0 11.3057 0.239372 10.8708 0.674248L0.678111 10.8667C0.674678 10.8702 0.671244 10.8738 0.667811 10.8772C-0.224828 11.775 -0.223302 13.2317 0.672198 14.1272C1.08132 14.5365 1.62168 14.7736 2.19941 14.7984C2.22287 14.8006 2.24652 14.8018 2.27037 14.8018H2.67682V22.3066C2.67682 23.7917 3.88513 25 5.37057 25H9.36036C9.76472 25 10.0928 24.6721 10.0928 24.2676V18.3838C10.0928 17.7061 10.644 17.1549 11.3217 17.1549H13.675C14.3527 17.1549 14.9039 17.7061 14.9039 18.3838V24.2676C14.9039 24.6721 15.2318 25 15.6363 25H19.6261C21.1115 25 22.3198 23.7917 22.3198 22.3066V14.8018H22.6967C23.3113 14.8018 23.8892 14.5624 24.3243 14.1275C25.2207 13.2305 25.2211 11.7714 24.3254 10.8738Z" fill="currentColor"/>
                    </g>
                    <defs>
                        <clipPath id="clip0_14_918">
                            <rect width="25" height="25" fill="white"/>
                        </clipPath>
                    </defs>
                </svg>

                <span>대시보드</span>
            </a>
        </li>
        <li class="relative flex w-full ${currentPage.endsWith('roomRegister.jsp') ? 'text-blue-600' : 'text-zinc-400'}">

            <c:if test="${currentPage.endsWith('roomRegister.jsp')}">
            <div class="absolute left-0 h-full w-1.5 bg-blue-600"></div>
            </c:if>
            <a href="roomRegister.jsp" class="flex items-center gap-5 pl-6 w-full hover:text-blue-500 transition-all">
                <svg class="object-contain shrink-0 self-start aspect-square w-[25px] ${currentPage.endsWith('roomRegister.jsp') ? 'fill-blue-600' : 'fill-zinc-400'}" viewBox="0 0 25 25"  xmlns="http://www.w3.org/2000/svg">
                    <g clip-path="url(#clip0_14_914)">
                        <path d="M12.3219 12.0426C13.9763 12.0426 15.4089 11.4492 16.5794 10.2785C17.75 9.10793 18.3434 7.67571 18.3434 6.02109C18.3434 4.36705 17.75 2.93463 16.5792 1.76372C15.4085 0.593374 13.9761 0 12.3219 0C10.6672 0 9.235 0.593374 8.06446 1.76391C6.89392 2.93444 6.30035 4.36686 6.30035 6.02109C6.30035 7.67571 6.89392 9.10813 8.06465 10.2787C9.23538 11.449 10.6678 12.0426 12.3219 12.0426Z" fill="currentColor"/>
                        <path d="M22.8579 19.2237C22.8241 18.7366 22.7558 18.2052 22.6553 17.644C22.5538 17.0787 22.4232 16.5443 22.2668 16.0558C22.1052 15.5509 21.8855 15.0523 21.6139 14.5745C21.332 14.0786 21.0009 13.6468 20.6293 13.2915C20.2408 12.9197 19.7651 12.6209 19.215 12.4028C18.6668 12.186 18.0593 12.0761 17.4095 12.0761C17.1543 12.0761 16.9075 12.1808 16.4309 12.4912C16.1375 12.6825 15.7944 12.9037 15.4114 13.1484C15.0839 13.3571 14.6402 13.5526 14.0923 13.7296C13.5576 13.9026 13.0148 13.9903 12.479 13.9903C11.9432 13.9903 11.4006 13.9026 10.8654 13.7296C10.318 13.5528 9.87434 13.3573 9.54723 13.1486C9.16786 12.9062 8.82454 12.6849 8.5268 12.491C8.05073 12.1806 7.80373 12.0759 7.54852 12.0759C6.8985 12.0759 6.2912 12.186 5.74322 12.403C5.19352 12.6207 4.71764 12.9195 4.32873 13.2917C3.95737 13.6472 3.62606 14.0788 3.34454 14.5745C3.07312 15.0523 2.85339 15.5507 2.69165 16.056C2.53544 16.5444 2.40479 17.0787 2.30331 17.644C2.2028 18.2044 2.13451 18.736 2.10075 19.2243C2.06757 19.7026 2.05078 20.1991 2.05078 20.7005C2.05078 22.0055 2.46563 23.062 3.28369 23.8412C4.09164 24.61 5.16071 25.0001 6.46076 25.0001H18.4984C19.7985 25.0001 20.8672 24.6102 21.6753 23.8412C22.4936 23.0626 22.9084 22.0059 22.9084 20.7003C22.9082 20.1966 22.8912 19.6998 22.8579 19.2237Z" fill="currentColor"/>
                    </g>
                    <defs>
                        <clipPath id="clip0_14_914">
                            <rect width="25" height="25" fill="currentColor"/>
                        </clipPath>
                    </defs>
                </svg>
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