<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
<link rel="stylesheet" href="/re/css/club_add.css" />
<link rel="stylesheet" href="/re/css/bootstrap.css" />
<script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>
<!-- 이벤트 처리 -->
<script type="text/javascript" src="/re/js/register.js"></script>
<!-- 유효성검사 -->
<script type="text/javascript" src="/re/js/studyValidation.js"></script>
</head>
<body>	
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>

	<div class="container">
		<h3 style="margin-top: 30px;">정기 모임 만들기</h3>
		<hr />
		<form role="form" id="registerForm" action="/club/add" method="post" enctype="multipart/form-data">

			<div class="form-group">
				<label for="representation"><strong>작성자:</strong></label> ${user.name}
			</div>
			<input type="hidden" name="id" value="${user.id}" />
			<div class="form-group">
				<label for="name"><strong>모임사진첨부</strong></label> <input type="file"
					name="image" id="image" multiple />
			</div>
			<div class="form-group">
				<label for="name"><strong>모임명</strong></label> <input type="text"
					class="form-control" id="name" name="name" required>
			</div>
			<div class="form-group">
				<label for="name"><strong>모임 요약</strong></label> <input type="text"
					class="form-control" id="intro" name="intro" required>
			</div>
			<div class="form-group" style="width: 33%; float: left">
				<label for="startDate"><strong>시작일자</strong></label> <input
					type="date" class="form-control" id="startDate" name="startDate"
					required>
			</div>
			<div class="form-group" style="width: 33%; float: left;">
				<label for="startTime"><strong>시작시간</strong></label> <input
					type="time" class="form-control" id="startTime" name="startTime"
					required>
			</div>
			<div class="form-group" style="width: 33%; float: left;">
				<label for="endTime"><strong>종료시간</strong></label> <input
					type="time" class="form-control" id="endTime" name="endTime"
					required>
			</div>
			<div class="form-group">
				<input type="checkbox" id="repeat" onclick="repeatFunction()">정기
				모임
			</div>
			<div class="form-group" id="formEndDate" hidden="true"
				style="width: 33%; float: left">
				<label for="endDate"><strong>종료일자</strong></label> <input
					type="date" class="form-control" id="endDate" name="endDate">
			</div>
			<div class="form-group" id="formRepeatCycle" hidden="true" style="width: 33%; float: left">
            <label for="repeatCycle"><strong>반복주기</strong></label>
            <select class="form-control" id="repeatCycle" name="repeatCycle">
                <option>(선택)</option>
                <option value="매주">매주</option>
                
            </select>
        </div>
        
        <div class="form-group" id="formRepeatDay" hidden="true" style="width: 33%; float: left">
            <label for="repeatDay"><strong>반복요일</strong></label>
            <select class="form-control" id="repeatDay" name="repeatDay">
                <option>(선택)</option>
                <option value="월요일">월</option>
                <option value="화요일">화</option>
                <option value="수요일">수</option>
                <option value="목요일">목</option>
                <option value="금요일">금</option>
                <option value="토요일">토</option>
                <option value="일요일">일</option>
            </select>
        </div>

        <div class="form-group" style="clear: both">
            <label for="information"><strong>상세 정보</strong></label>
            <textarea class="form-control" rows="5" id="content" name="content" required></textarea>
        </div>

        <div class="form-group" id="formPlace" style="margin-bottom: 0px">
            <label for="placeId"><strong>모임 장소 추가</strong></label>
            <input type="text" class="form-control" id="placeName" name="placeName" hidden="true" readonly/>
            <input type="text" class="form-control" id="placeFormatted" name="placeFormatted" hidden="true" readonly/>
            <input type="text" class="form-control" id="placeId" name="placeId" hidden="true" required readonly/>
        </div>

        <div style="display: none">
            <input
                    id="pac-input"
                    class="controls"
                    type="text"
                    placeholder="장소를 입력해주세요"
            />
        </div>
        <div id="map"></div>

        <div class="form-group" style="margin-top: 16px;">
            <label for="price"><strong>모임회비</strong></label>
            <input type="number" class="form-control" id="price" name="price" placeholder="원 단위로 숫자만 입력해주세요." >
        </div>
        <div class="form-group">
            <label for="membernum"><strong>모집 인원</strong></label>
            <input type="number" class="form-control" id="membernum" name="membernum" placeholder="최소 3명" required>
        </div>

        <button type="submit" class="btn btn-primary">등록</button>
   
	</form>
	
	</div>
	
</body>

<script>
    $(document).ready(function() {
        let formObj = $('#registerForm');

        $('button[type="submit"]').on("click", function(e) {
            e.preventDefault();

            // 유효성 검사
            if(!validation()) {
                return;
            }

            formObj.submit();
        })
    })
</script>

<!-- 날짜 -->
<script type="text/javascript">

    // 오늘 날짜와 시간
    let today = new Date();

    // 오늘 년도
    let year = today.getFullYear();

    // 오늘 월
    let month = today.getMonth();
    if(month < 10) month = "0" + (month+1);

    // 오늘 날짜
    let date = today.getDate();
    if(date < 10) date = "0" + date;

    // 오늘 시간
    let hours = today.getHours();

    // 시작일자 초기화
    $('#startDate').val(year + "-" + month + "-" + date);
    $('#startDate').attr("min", year + "-" + month + "-" + date);

    // 시작시간 초기화
    hours += 1;
    hours = hours == 24 ? "00" : hours;
    hours = hours < 10 ? "0" + hours : hours;

    $('#startTime').val(hours + ":00");

    // 종료시간 초기화
    $('#endTime').val(hours + ":00");

</script>

<!-- 구글맵 -->
<script>

    function initMap() {
        // 지도 설정
        const map = new google.maps.Map(document.getElementById("map"), {
            center: { lat: 37.5704121, lng: 126.9853267 },
            zoom: 13,
        });

        // 검색창
        const input = document.getElementById("pac-input");
        const autocomplete = new google.maps.places.Autocomplete(input);
        autocomplete.bindTo("bounds", map);

        // Specify just the place data fields that you need.
        autocomplete.setFields(["place_id", "geometry", "name", "formatted_address", "url"]);
        map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);

        // 말풍선 정보
        const infowindow = new google.maps.InfoWindow();
        const infowindowContent = document.getElementById("infowindow-content");
        infowindow.setContent(infowindowContent);

        // 마커
        const marker = new google.maps.Marker({ map: map });
        marker.addListener("click", () => { // 마커 클릭시
            infowindow.open(map, marker);
        });
        autocomplete.addListener("place_changed", () => { // 장소 선택시
            infowindow.close();
            const place = autocomplete.getPlace(); // 장소 세부정보 받아오기

            if (!place.geometry || !place.geometry.location) {
                return;
            }

            if (place.geometry.viewport) {
                map.fitBounds(place.geometry.viewport);
            } else {
                map.setCenter(place.geometry.location);
                map.setZoom(17);
            }
            // Set the position of the marker using the place ID and location.
            // 장소 세팅
            marker.setPlace({
                placeId: place.place_id,
                location: place.geometry.location,
            });

            marker.setVisible(true);

            infowindow.setContent(
                "<div>" +
                "<strong><span id='place-name'>" + place.name + "</span></strong><br>" +
                "<span id='place-id' hidden='true'>" + place.place_id +"</span>" +
                "<strong>주소: </strong><span id='place-formatted'>" + place.formatted_address + "</span><br>" +
                "<strong>URL: </strong><a href='" + place.url + "'>구글맵 바로가기</a><br>" +
                "<div style='float:right'><input type='button' onclick='placeSelected()' id='placeSelect' value='선택'></input></div>" +
                "</div>"
            )

            infowindow.open(map, marker);
        });
    }
</script>


<!-- 월 10만건 이상 유료 -->
<!-- Async script executes immediately and must be after any DOM elements used in callback. -->
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDyzBKXuryxzEeXDYTzXOBNRIClCv6FuUo&callback=initMap&libraries=places&v=weekly" async></script>

</html>