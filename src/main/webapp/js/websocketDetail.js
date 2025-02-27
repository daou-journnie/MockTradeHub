var highestPrice = 0;

// WebSocket 연결
var socket = new WebSocket("ws://ops.koreainvestment.com:21000/tryitout/H0STCNT0");

socket.onopen = function() {
    var requestMessage = JSON.stringify({
            header: {
                approval_key: approvalKey,
                custtype: "P",
                tr_type: "1",
                "content-type": "utf-8"
            },
            body: {
                input: {
                    tr_id: "H0STCNT0",
                    tr_key: stockCode
                }
            }
        });
        socket.send(requestMessage);
        console.log("요청 메시지 전송: " + requestMessage);
};

socket.onmessage = function(event) {
    var message = event.data;

    // 메시지 파싱
    var fieldNames = [
        "MKSC_SHRN_ISCD", // 유가증권 단축 종목코드
        "STCK_CNTG_HOUR", // 주식 체결 시간
        "STCK_PRPR", // 주식 현재가
        "PRDY_VRSS_SIGN", // 전일 대비 부호 (1:상한, 2:상승, 3:보합, 4:하한, 5:하락)
        "PRDY_VRSS", // 전일 대비
        "PRDY_CTRT", // 전일 대비율
        "WGHN_AVRG_STCK_PRC", // 가중 평균 주식 가격
        "STCK_OPRC", // 주식 시가
        "STCK_HGPR", // 주식 최고가
        "STCK_LWPR", // 주식 최저가
        "ASKP1", // 매도 호가1
        "BIDP1", // 매수 호가1
        "CNTG_VOL", // 체결 거래량
        "ACML_VOL", // 누적 거래량
        "ACML_TR_PBMN", // 누적 거래 대금
        "SELN_CNTG_CSNU", // 매도 체결 건수
        "SHNU_CNTG_CSNU", // 매수 체결 건수
        "NTBY_CNTG_CSNU", // 순매수 체결 건수
        "CTTR", // 체결강도
        "SELN_CNTG_SMTN", // 총 매도 수량
        "SHNU_CNTG_SMTN", // 총 매수 수량
        "CCLD_DVSN", // 체결구분 (1:매수(+), 3:장전, 5:매도(-))
        "SHNU_RATE", // 매수 비율
        "PRDY_VOL_VRSS_ACML_VOL_RATE", // 전일 거래량 대비 등락율
        "OPRC_HOUR", // 시가 시간
        "OPRC_VRSS_PRPR_SIGN", // 시가 대비 구분 (1:상한, 2:상승, 3:보합, 4:하한, 5:하락)
        "OPRC_VRSS_PRPR", // 시가 대비
        "HGPR_HOUR", // 최고가 시간
        "HGPR_VRSS_PRPR_SIGN", // 고가 대비 구분 (1:상한, 2:상승, 3:보합, 4:하한, 5:하락)
        "HGPR_VRSS_PRPR", // 고가대비
        "LWPR_HOUR", // 최저가 시간
        "LWPR_VRSS_PRPR_SIGN", // 저가 대비 구분 (1:상한, 2:상승, 3:보합, 4:하한, 5:하락)
        "LWPR_VRSS_PRPR", // 저가 대비
        "BSOP_DATE", // 영업 일자
        "NEW_MKOP_CLS_CODE", // 신 장운영 구분 코드
        "TRHT_YN", // 거래정지 여부 (Y:정지, N:정상거래)
        "ASKP_RSQN1", // 매도호가 잔량1
        "BIDP_RSQN1", // 매수호가 잔량1
        "TOTAL_ASKP_RSQN", // 총 매도호가 잔량
        "TOTAL_BIDP_RSQN", // 총 매수호가 잔량
        "VOL_TNRT", // 거래량 회전율
        "PRDY_SMNS_HOUR_ACML_VOL", // 전일 동시간 누적 거래량
        "PRDY_SMNS_HOUR_ACML_VOL_RATE", // 전일 동시간 누적 거래량 비율
        "HOUR_CLS_CODE", // 시간 구분 코드
        "MRKT_TRTM_CLS_CODE", // 임의종료구분코드
        "VI_STND_PRC" // 정적VI발동기준가
    ];

    var parts = message.split("|");

    if (parts.length >= 4) {
        var dataLines = parts[3].split("\n");
        if (dataLines.length > 0) {
            var values = dataLines[0].split("^");
            var stockData = {};

            for (var i = 0; i < fieldNames.length && i < values.length; i++) {
                stockData[fieldNames[i]] = values[i];
            }

            var stockCode = stockData["MKSC_SHRN_ISCD"];
            var currentPrice = parseFloat(stockData["STCK_PRPR"]);
            var prdyVrss = parseFloat(stockData["PRDY_VRSS"]);
            var prdyCtrt = stockData["PRDY_CTRT"];
            var sign = stockData["PRDY_VRSS_SIGN"];
            var accumulatedVolume = parseFloat(stockData["ACML_VOL"]);
            highestPrice = parseFloat(stockData["STCK_HGPR"]);

            if (stockCode && currentPrice && prdyCtrt) {
                console.log("종목코드: " + stockCode + " 현재가: " + currentPrice);
                // 실시간 가격 업데이트
                var priceElement = document.getElementById("price-" + stockCode);
                var prdyElement = document.getElementById("prdy-" + stockCode);
                var prdyText = prdyVrss.toLocaleString() + "원 (" + prdyCtrt + "%)";
                var amount = parseFloat(document.getElementById("buyingAmount").value);
                var expectedTotal = document.getElementById("expectedTotal");

                if (sign == 1 || sign == 2) {
                    prdyElement.classList.add("positive");
                    prdyText = "+" + prdyText;
                } else if (sign == 4 || sign == 5) {
                    prdyElement.classList.add("negative");
                }
                priceElement.innerText = currentPrice.toLocaleString() + "원";
                prdyElement.innerText = prdyText;
                var total = amount * highestPrice;
                expectedTotal.innerText = "최대 " + total.toLocaleString() + "원"

            }
        } else {
            console.log("데이터 파싱 실패: " + message);
        }
    }
};

socket.onclose = function() {
    console.log("WebSocket 연결 종료");
};

socket.onerror = function(error) {
    console.log("WebSocket 오류: " + error.message);
};

$("#buyingAmount").on("input", function() {
    var amount = parseFloat($(this).val());
    var total = amount * highestPrice;
    document.getElementById("expectedTotal").innerText = "최대 " + total.toLocaleString() + "원"
});