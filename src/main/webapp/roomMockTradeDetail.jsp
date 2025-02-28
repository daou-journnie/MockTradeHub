<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setAttribute("currentPage", request.getRequestURI());

%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BankDash Dashboard</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/roomTransactionInvestment.css">
</head>
<body>
<div class="flex overflow-hidden flex-col bg-white">
    <!-- Include Header -->
    <jsp:include page="mainHeader.jsp" />

    <hr class="flex shrink-0 self-end max-w-full h-px bg-slate-200 w-[1190px]" />

    <div class="flex flex-wrap gap-10 w-full max-md:max-w-full">
        <!-- Include Sidebar -->
        <jsp:include page="roomSidebar.jsp" />

        <!-- Main Content -->
        <main class="flex flex-col grow shrink-0 pt-20 pb-10 basis-0 bg-slate-100 w-fit max-md:max-w-full">
            <div class="flex flex-row items-center justify-center gap-10 w-full">
                <!-- Include Room Feed -->
                <jsp:include page="stockDetail.jsp" />

            </div>


            <!-- Include Room List -->
            <%--            <jsp:include page="roomListMember.jsp" />--%>
        </main>
    </div>
</div>
</body>
</html>