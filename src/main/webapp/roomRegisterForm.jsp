<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="css/roomRegisterForm.css">
<section class="content-section">
    <div class="room-form-container">
        <header class="form-header">
            <h2 class="form-title">방 생성</h2>
            <div class="title-underline"></div>
            <hr class="form-divider" />
        </header>

        <form class="room-form" action="room/register" method="post" >
            <div class="form-row">
                <div class="form-group">
                    <label for="roomName">TradeRoom 이름</label>
                    <input type="text" id="roomName" name="roomName" class="form-input" placeholder="daou" />
                </div>
                <div class="form-group">
                    <label for="initialSeed">초기 금액(단위: 만원)</label>
                    <input
                            type="text"
                            id="initialSeed"
                            class="form-input"
                            placeholder="100"
                            name="roomInitialSeed"
                    />
                </div>
            </div>

            <div class="form-row">
                <div class="form-group">
                    <label for="description">TradeRoom 상세 설명</label>
                    <input
                            type="text"
                            id="description"
                            class="form-input"
                            placeholder="이 방은 초보만 오세요"
                            name="roomDescription"
                    />
                </div>
                <div class="form-group">
                    <label for="inviteCode">비밀번호</label>
                    <input
                            type="password"
                            id="inviteCode"
                            class="form-input"
                            placeholder="**********"
                    />
                </div>
            </div>

            <div class="form-row">
                <div class="form-group">
                    <label for="startDate">시작 날짜</label>
                    <div id="startDate" class="date-input">
                        <input type="date" id="startDateDisplay" name="roomStartDate" class="date-picker" onchange="updateDateDisplay('startDateDisplay', this.value)">
                    </div>
                </div>
                <div class="form-group">
                    <label for="endDate">종료 날짜</label>
                    <div id="endDate" class="date-input">
                        <input type="date" id="endDateDisplay" name="roomEndDate" class="date-picker" onchange="updateDateDisplay('endDateDisplay', this.value)">
                    </div>


                </div>


            </div>
            <div class="form-row">
                <div class="form-group">
                    <label for="maxMembers">최대 인원</label>
                    <input
                            type="text"
                            id="maxMembers"
                            class="form-input"
                            placeholder="5"
                            name="roomMaxMembers"
                    />
                </div>
                <div class="form-group">
                        <label>공개 여부</label>
                        <select name="roomIsPublic" id="privacySelect" class="privacy-dropdown" onchange="updatePrivacyStatus()">
                            <option value="0">비공개</option>
                            <option value="1">공개</option>
                        </select>

                </div>
                <div class="form-group">
                    <button type="submit" class="save-button">저장</button>
                </div>
            </div>
        </form>
    </div>
</section>