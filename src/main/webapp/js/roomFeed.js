$(document).ready(function() {
    fetchFeedList();
});


// AJAX를 이용해 피드 목록을 가져옴 (jQuery `$.ajax()` 사용)
function fetchFeedList() {
    let roomId = $("#room-id").val();


    $.ajax({
        url: "room/dashboard",
        type: "GET",
        data: { roomId: roomId },
        dataType: "json",
        success: function(data) {
            let feedEntries = $(".feed-container");
            feedEntries.empty(); // 기존 내용 초기화

            data.forEach(post => {
                let dateToTimeAgo = timeAgo(post.createdAt)
                let colorClass = getColorClass(post.memberId);
                let comments = post.postComments;
                let feedElement = `
                    <article class="feed-card ${colorClass}">
                        <div class="feed-content">
                            <header class="feed-top">
                                <h3 class="user-name">${post.memberNickname}</h3>
                                <time class="time-ago">${dateToTimeAgo}</time>
                            </header>
                            <p class="feed-text">${post.postContent}</p>
                            <footer class="feed-stats">
                                <div onclick="toggleComments(${post.postId})">
                                    <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg" class="comment-icon">
                                        <path d="M1.75098 10C1.75098 5.58 5.33498 2 9.75598 2H14.122C18.612 2 22.251 5.64 22.251 10.13C22.251 13.09 20.644 15.81 18.055 17.24L10.001 21.7V18.01H9.93398C5.44398 18.11 1.75098 14.5 1.75098 10ZM9.75598 4C6.43898 4 3.75098 6.69 3.75098 10C3.75098 13.37 6.52098 16.08 9.88898 16.01L10.24 16H12.001V18.3L17.088 15.49C19.039 14.41 20.251 12.36 20.251 10.13C20.251 6.74 17.507 4 14.122 4H9.75598Z" fill="#536471"></path>
                                    </svg>
                                </div>
                                <span class="comment-count">${comments.length}</span>
                            </footer>
                        </div>
                         <!-- 댓글 표시 영역 (기본적으로 숨김) -->
                        <div id="comments-${post.postId}" class="comment-section hidden">
                            ${comments.map(comment => `
                                <div class="comment">
                                    <strong>${comment.memberNickname}</strong>: ${comment.postContent}
                                </div>
                            `).join("")}
                            
                            <!-- 댓글 입력 폼 -->
                        <div class="comment-form">
                            <textarea id="comment-text-${post.postId}" class="comment-textarea" placeholder="댓글 입력..." rows="2"></textarea>
                            <button type="button" onclick="insertComment(${post.postId})" class="comment-submit-btn">댓글 작성</button>
                        </div>
                        </div>
                        
                    </article>
                `;
                feedEntries.append(feedElement);
            });
        },
        error: function (xhr, status, error) {
            console.error("Error fetching room list:", error);
        }
    });
}

// 포스트 삽입 함수: 폼 데이터를 수집해 AJAX 요청으로 처리
function insertPost() {
    let roomId = $('input[name="roomId"]').val();
    let memberId = $('input[name="memberId"]').val();
    let postContent = $('#post-text').val();

    $.ajax({
        url: 'room/post/insert',
        type: 'POST',
        data: {
            roomId: roomId,
            memberId: memberId,
            postContent: postContent
        },
        dataType: 'json',
        success: function(newPost) {
            console.log("포스트 작성 성공:", newPost);
            let dateToTimeAgo = '방금 전';
            console.log(dateToTimeAgo);
            let colorClass = getColorClass(newPost.memberId);
            let comments = newPost.postComments || [];
            let feedElement = `
                  <article class="feed-card ${colorClass}">
                      <div class="feed-content">
                          <header class="feed-top">
                              <h3 class="user-name">${newPost.memberNickname}</h3>
                              <time class="time-ago">${dateToTimeAgo}</time>
                          </header>
                          <p class="feed-text">${newPost.postContent}</p>
                          <footer class="feed-stats">
                              <div onclick="toggleComments(${newPost.postId})">
                                  <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg" class="comment-icon">
                                      <path d="M1.75098 10C1.75098 5.58 5.33498 2 9.75598 2H14.122C18.612 2 22.251 5.64 22.251 10.13C22.251 13.09 20.644 15.81 18.055 17.24L10.001 21.7V18.01H9.93398C5.44398 18.11 1.75098 14.5 1.75098 10ZM9.75598 4C6.43898 4 3.75098 6.69 3.75098 10C3.75098 13.37 6.52098 16.08 9.88898 16.01L10.24 16H12.001V18.3L17.088 15.49C19.039 14.41 20.251 12.36 20.251 10.13C20.251 6.74 17.507 4 14.122 4H9.75598Z" fill="#536471"></path>
                                  </svg>
                              </div>
                              <span class="comment-count">${comments.length}</span>
                          </footer>
                      </div>
                      <!-- 댓글 표시 영역 (기본적으로 숨김) -->
                      <div id="comments-${newPost.postId}" class="comment-section hidden">
                          ${comments.map(comment => `
                              <div class="comment">
                                  <strong>${comment.memberNickname}</strong>: ${comment.postContent}
                              </div>
                          `).join("")}
                      </div>
                  </article>
              `;
            // 피드 컨테이너의 최상단에 새 포스트를 추가
            $('.feed-container').prepend(feedElement);
            // textarea 초기화
            $('#post-text').val('');
        },
        error: function(xhr, status, error) {
            console.error("포스트 작성 실패:", error);
        }
    });
}

function insertComment(parentPostId) {
    let roomId = $('input[name="roomId"]').val();
    let memberId = $('input[name="memberId"]').val();
    let commentContent = $(`#comment-text-${parentPostId}`).val();

    $.ajax({
        url: 'room/post/insert',
        type: 'POST',
        data: {
            roomId: roomId,
            memberId: memberId,
            postContent: commentContent,
            postParentId: parentPostId  // 부모 포스트 ID 전달
        },
        dataType: 'json',
        success: function(newComment) {
            console.log("댓글 작성 성공:", newComment);
            // 댓글 요소 생성
            let commentElement = `
                <div class="comment">
                    <strong>${newComment.memberNickname}</strong>: ${newComment.postContent}
                </div>
            `;
            // 해당 부모 포스트의 댓글 영역에 댓글 추가
            $(`#comments-${parentPostId}`).append(commentElement);
            // 댓글 입력 필드 초기화
            $(`#comment-text-${parentPostId}`).val('');
        },
        error: function(xhr, status, error) {
            console.error("댓글 작성 실패:", error);
        }
    });
}


// 버튼 클릭 이벤트에 insertPost 함수 연결
$(document).on('click', '.post-submit-btn', function(e) {
    console.log("버튼 클릭됨");

    e.preventDefault();
    insertPost();
});


// 사용 가능한 색상 리스트
const colors = ["bg-blue", "bg-green", "bg-yellow", "bg-purple", "bg-red"];

// 이미 할당된 색상을 추적할 객체
let assignedColors = {};

function getColorClass(memberId) {
    // 이미 색이 할당된 경우 그대로 반환
    if (assignedColors[memberId]) {
        return assignedColors[memberId];
    }

    // 사용되지 않은 색상 필터링
    let availableColors = colors.filter(color => !Object.values(assignedColors).includes(color));

    // 만약 모든 색상이 사용되었다면 다시 초기화 (순환)
    if (availableColors.length === 0) {
        assignedColors = {};  // 기존 할당된 색상 초기화
        availableColors = [...colors]; // 모든 색상을 다시 사용 가능하게 설정
    }

    // 새로운 색상 배정 (가장 앞의 색을 선택)
    let assignedColor = availableColors[0];
    assignedColors[memberId] = assignedColor; // 해당 memberId에 색상 할당

    return assignedColor;
}


function toggleComments(postId) {
    let commentSection = document.getElementById(`comments-${postId}`);

    if (commentSection.classList.contains("hidden")) {
        commentSection.classList.remove("hidden");
    } else {
        commentSection.classList.add("hidden");
    }
}

function timeAgo(dateString) {
    let formattedDateString = dateString.replace("KST", "").trim();
    let date = new Date(formattedDateString); // 문자열을 Date 객체로 변환
    let now = new Date(); // 현재 시간
    let diffInSeconds = Math.floor((now - date) / 1000); // 초 단위 차이
    let diffInMinutes = Math.floor(diffInSeconds / 60); // 분 단위 차이
    let diffInHours = Math.floor(diffInMinutes / 60); // 시간 단위 차이
    let diffInDays = Math.floor(diffInHours / 24); // 일 단위 차이

    if (diffInDays > 0) {
        return `${diffInDays}일 전`; // 1일 이상이면 "n일 전"
    } else if (diffInHours > 0) {
        return `${diffInHours}시간 전`; // 1시간 이상이면 "n시간 전"
    } else if (diffInMinutes > 0) {
        return `${diffInMinutes}분 전`; // 1분 이상이면 "n분 전"
    } else {
        return "방금 전"; // 1분 미만이면 "방금 전"
    }
}