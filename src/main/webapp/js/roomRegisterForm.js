function updateDateDisplay(elementId, dateValue) {
    if (dateValue) {
        // 날짜 포맷 변경 (YYYY-MM-DD → DD MMM YYYY)
        document.getElementById(elementId).textContent = dateValue;
        // document.getElementById(spanId).textContent = formattedDate;
    }
}

function togglePrivacyStatus() {
    let checkbox = document.getElementById("togglePrivacy");
    let statusText = document.getElementById("privacyStatus");

    if (checkbox.checked) {
        statusText.textContent = "공개";
    } else {
        statusText.textContent = "비공개";
    }
}