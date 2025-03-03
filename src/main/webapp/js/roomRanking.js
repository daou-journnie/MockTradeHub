$(document).ready(function() {
    fetchRankList();
});

// AJAX를 이용해 피드 목록을 가져옴 (jQuery `$.ajax()` 사용)
function fetchRankList() {
    let roomId = $("#room-id").val();
    $.ajax({
        url: "room/roomProfit",
        type: "GET",
        data: { roomId: roomId },
        dataType: "json",
        success: function(data) {
            let rankEntries = $(".rank-container");
            rankEntries.empty(); // 기존 내용 초기화

            data.forEach((roomMember, idx) => {
                let rankElement = `
                    <article class="rank-box">
                        <div class="rank-content">
                            <div class="user-info">
                                <div class="rank-position">
                                    <span class="position-number">${idx + 1}</span>
                                    <figure class="profile-image">
                                        <img
                                                src="https://cdn.builder.io/api/v1/image/assets/TEMP/6646a82f5f00007e85bd7d2b208518cf9476f1f20721e59586845f3e185bec1e?placeholderIfAbsent=true&apiKey=74d6b347f88a4ec9b2441d4daff1986f"
                                                alt="Profile picture"
                                                class="profile-picture"
                                        />
                                    </figure>
                                </div>
                                <span class="user-name">${roomMember.memberNickname}</span>
                            </div>
                            <div class="performance-metrics">
                                <p class="percentage-change" data-value="${roomMember.totalProfitRate}">${roomMember.totalProfitRate}%</p>
                                <p class="amount">${roomMember.balance}원</p>
                            </div>
                        </div>
                    </article>
                `;
                rankEntries.append(rankElement);
            });
        },
        error: function (xhr, status, error) {
            console.error("Error fetching room list:", error);
        }
    });
}


// // 사용 가능한 색상 리스트
// const colors = ["bg-blue", "bg-green", "bg-yellow", "bg-purple", "bg-red"];
//
// // 이미 할당된 색상을 추적할 객체
// let assignedColors = {};
//
// function getColorClass(memberId) {
//     console.log(memberId)
//     // 이미 색이 할당된 경우 그대로 반환
//     if (assignedColors[memberId]) {
//         return assignedColors[memberId];
//     }
//
//     // 사용되지 않은 색상 필터링
//     let availableColors = colors.filter(color => !Object.values(assignedColors).includes(color));
//
//     // 만약 모든 색상이 사용되었다면 다시 초기화 (순환)
//     if (availableColors.length === 0) {
//         assignedColors = {};  // 기존 할당된 색상 초기화
//         availableColors = [...colors]; // 모든 색상을 다시 사용 가능하게 설정
//     }
//
//     // 새로운 색상 배정 (가장 앞의 색을 선택)
//     let assignedColor = availableColors[0];
//     assignedColors[memberId] = assignedColor; // 해당 memberId에 색상 할당
//
//     return assignedColor;
// }