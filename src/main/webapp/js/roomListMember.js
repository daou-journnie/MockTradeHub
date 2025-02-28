$(document).ready(function() {
    fetchRoomList();
});

// AJAX를 이용해 방 목록을 가져옴 (jQuery `$.ajax()` 사용)
function fetchRoomList() {
    let memberId = $("#member-id").val();  // hidden input에서 `member_id` 가져오기

    $.ajax({
        url: "room/myRooms",
        type: "GET",
        data: { member_id: memberId },  // `member_id` 전달
        dataType: "json",
        success: function(data) {
            let roomEntries = $(".room-entries");
            roomEntries.empty(); // 기존 내용 초기화

            data.forEach(room => {
                let roomElement = `
                    <article class="room-entry">
                        <span class="room-info">
                            <span class="room-name">${room.roomName}</span>
                            <span class="room-id">${room.roomCode}</span>
                            <span class="room-description">${room.roomDescription}</span>
                            <span class="room-balance">${room.roomMemberBalance}</span>
                            <span class="room-profit">20%</span>
                            <span class="room-button" onclick="enterRoom('${room.roomId}')">들어가기</span>
                        </span>
                        <hr class="entry-divider" />
                    </article>
                `;
                // <div className="room-actions">
                //     <span className="profit-rate ${room.isPublic}">${room.isPublic}</span>
                //     <button className="action-button">${room.actionText}</button>
                // </div>
                roomEntries.append(roomElement);  // 새로운 방 추가
            });
        },
        error: function (xhr, status, error) {
            console.error("Error fetching room list:", error);
        }
    });
}

function enterRoom(roomId) {
    if (!roomId) {
        console.error("유효한 roomId가 없습니다.");
        return;
    }
    window.location.href = "http://localhost:8080/MockTradeHub_war_exploded/room/dashboard?roomId=" + roomId;

}
