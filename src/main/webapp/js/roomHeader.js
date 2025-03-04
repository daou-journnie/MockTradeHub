$(document).ready(function() {
    fetchRoomName();
});

// AJAX를 이용해 방 목록을 가져옴 (jQuery `$.ajax()` 사용)
function fetchRoomName() {
    let memberId = $("#member-id").val();  // hidden input에서 `member_id` 가져오기
    let roomId = $("#room-id").val();
    let contextPath = $("#contextPath").val();
    console.log(contextPath);
    console.log(roomId);


    $.ajax({
        url: `${contextPath}/room/myRooms`,
        type: "GET",
        data: { member_id: memberId },  // `member_id` 전달
        dataType: "json",
        success: function(data) {
            const roomSelect = document.getElementById("roomSelect");
            roomSelect.innerHTML = '<option disabled selected>방 선택</option>';
            data.forEach(room => {
                console.log(room)
                const option = document.createElement("option");
                option.value = room.roomId;
                option.textContent = room.roomName;
                if (room.roomId == roomId) {
                    option.defaultSelected = true;
                }
                roomSelect.appendChild(option);
// 새로운 방 추가
            });
        },
        error: function (xhr, status, error) {
            console.error("Error fetching room list:", error);
        }
    });
}

function changeRoom() {
    const roomId = document.getElementById("roomSelect").value;
    if (roomId) {
        window.location.href =  `http://localhost:8080/MockTradeHub_war_exploded/roomDashboard.jsp?roomId=${roomId}`;
    }
}
