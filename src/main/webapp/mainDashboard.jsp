<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>BankDash Dashboard</title>
  <script src="https://cdn.tailwindcss.com"></script>
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="css/mainDashboard.css">
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
    <main class="flex flex-col grow shrink-0 pt-20 pb-10 basis-0 bg-slate-100 w-fit max-md:max-w-full">
      <!-- Trending Rooms Section -->
      <section>
        <h2 class="self-start ml-16 text-2xl font-semibold text-slate-700 max-md:ml-2.5">
          지금 뜨는 TradeRoom
        </h2>

        <div class="flex flex-col px-2.5 mt-6 w-full max-md:max-w-full">
          <div class="flex gap-5 max-md:flex-col">
            <!-- Room Cards -->
            <div class="w-[62%] max-md:ml-0 max-md:w-full">
              <div class="flex flex-col pb-20 w-full max-md:mt-9 max-md:max-w-full">
                <div class="flex flex-wrap gap-2 items-center px-3 py-12 text-xs bg-white rounded-lg min-h-[218px] max-md:max-w-full">
                  <c:forEach var="room" items="${trendingRooms}">
                    <article class="flex flex-col justify-center items-center self-stretch px-3 py-7 my-auto ${room.bgColor} rounded-lg min-h-[116px]">
                      <div class="flex gap-10 items-center font-medium whitespace-nowrap text-zinc-800">
                        <div class="flex gap-1.5 items-center self-stretch my-auto w-[62px]">
                          <img src="${room.iconUrl}" alt="${room.name}" class="object-contain shrink-0 self-stretch my-auto w-6 aspect-square" />
                          <h3>${room.name}</h3>
                        </div>
                      </div>
                      <p class="flex gap-9 items-center mt-4 text-zinc-500">${room.description}</p>
                    </article>
                  </c:forEach>
                </div>

                <button class="flex z-10 gap-2.5 justify-center items-center self-end px-2.5 mt-0 w-11 h-11 bg-violet-600 rounded-lg shadow-[0px_4px_17px_rgba(0,0,0,0.12)] max-md:mr-1.5">
                  <img src="https://cdn.builder.io/api/v1/image/assets/TEMP/3dd673ed4a17ddc3b4f8075e290e6a4e264c2557a0d64fb9bcf6e2e277d52acb?placeholderIfAbsent=true&apiKey=74d6b347f88a4ec9b2441d4daff1986f" alt="Add" class="object-contain self-stretch my-auto w-6 aspect-square" />
                </button>
              </div>
            </div>

            <!-- Quick Actions -->
            <aside class="ml-5 w-[38%] max-md:ml-0 max-md:w-full">
              <div class="grow px-20 py-16 mt-4 w-full bg-white rounded-3xl max-md:px-5 max-md:mt-10 max-md:max-w-full">
                <div class="flex gap-5 max-md:flex-col">
                  <div class="w-6/12 max-md:ml-0 max-md:w-full">
                    <div class="flex flex-col grow text-lg font-semibold whitespace-nowrap text-slate-700 max-md:mt-10">
                      <img src="https://cdn.builder.io/api/v1/image/assets/TEMP/d6b33e32291e3f23adfab78ceb8b22743ebc96b971ed4988cea34d5c1f6017d2?placeholderIfAbsent=true&apiKey=74d6b347f88a4ec9b2441d4daff1986f" alt="Link" class="object-contain aspect-[1.22] w-[71px]" />
                      <span class="self-center mt-4">링크</span>
                    </div>
                  </div>
                  <div class="ml-5 w-6/12 max-md:ml-0 max-md:w-full">
                    <div class="flex flex-col grow text-lg font-semibold text-slate-700 max-md:mt-10">
                      <img src="https://cdn.builder.io/api/v1/image/assets/TEMP/1b0adf6f511b4cf699c0df6a91644b83d12ef05a37b6b36e51add73a25f983f6?placeholderIfAbsent=true&apiKey=74d6b347f88a4ec9b2441d4daff1986f" alt="Create Room" class="object-contain aspect-[1.21] w-[70px]" />
                      <span class="self-start mt-4">방 생성</span>
                    </div>
                  </div>
                </div>
              </div>
            </aside>
          </div>
        </div>

        <!-- Include Room List -->
<%--        <jsp:include page="roomList.jsp" />--%>
      </section>
    </main>
  </div>
</div>
</body>
</html>