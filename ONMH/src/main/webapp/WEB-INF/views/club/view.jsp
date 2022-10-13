<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>

<link rel="stylesheet" href="/re/css/cart.css">
<link rel="stylesheet" href="/re/css/item.css">
<script src="/re/js/cart_button.js"></script>
<script src="/re/js/shopping_item.js"></script>
<script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>

<link rel="stylesheet" href="https://unpkg.com/swiper@8/swiper-bundle.min.css"/>
	<script src="https://unpkg.com/swiper@8/swiper-bundle.min.js"></script>
	<script>
		$(function(){
			const swiper = new Swiper('.swiper', {
			  // Optional parameters
				slidesPerView: 1,
			});
		});
	</script>
</head>
<body>
<div class = "container">
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
	<div class = "wrapper mb-60">
		<div class = "flex column" id="item" data-code="${item.code}" data-price="${item.price}">
			<div class = "my-50"><h1 class = "productfont">모임 상세 정보</h1></div>
			<div class = "flex justify-between">
				<div class = "swiper">
						<div class="swiper-wrapper">
							<c:forEach items="${item.images}" var="image">
								<div class="swiper-slide">
									<div class = "subbox img-border">
										<img src="${image.fullpath}" alt="${image.filename}" />
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				<div class = "flex items-center">
					<div class = "subtextbox">
						<div class = "mb-30">
							<p class = "namefont mb-10">${item.name}</p>
						</div>
						<div>
							<p class = "textfont mb-10">${item.intro}</p>
						</div>
						
						<div>
							<p class = "textfont mb-10">위치: ${item.placeName}</p>
						</div>
						<div>
							<p class = "textfont mb-10">${item.placeFormatted} | 매주 ${item.repeatDay}</p>
						</div>
						<div>
							<p class = "textfont mb-10">첫 모임일 ${item.startDate} ${item.startTime} ~ ${item.endTime}</p>
						</div>
						<div>
						<p>회비 : <fmt:formatNumber value="${item.price}" pattern="###,###,###원"/></p>
						</div>
						
						
						<hr class = "hrstyle mt-20">
					    <div id="cartMsg">관심 모임에 담겼습니다.<a href="/orders/cart">관심 모임으로 가기</a></div>
						<p>${item.content}</p>
						<div class = "flex mt-20 flex-end" hidden="true">
							<p class = "subpricetext mr-20" hidden="true">개수</p>
							<button class="cart-btn amount-minus" hidden="true"></button>
							<input id="amount" type="number" value="1" hidden="true"/>
							<button class="cart-btn amount-plus" hidden="true"></button>
						</div>
						
						
						<div id="map"></div>
						<hr class = "hrstyle mt-20">
					
						<div class = "my-30 flex justify-between">
							<c:choose>
							<c:when test="${item.id != sessionScope.user.id}">
							<button id="cart-btn" class = "cartbtn">찜하기</button>
							<div><button id="order-btn" class = "paybtn">회비 결제</button></div>
							</c:when>
							</c:choose>
						</div>
							<c:choose>
								<c:when test="${item.id == sessionScope.user.id}">
									<div class="flex justify-between item-center">
										<div>
											<a class="btn mid round whitebtn" href="update/${item.code}">수정</a>
											<a class="btn mid round whitebtn" href="delete/${item.code}">삭제</a>
										</div>
										<a class="btn mid buttoncolor" href="list">돌아가기</a>
									</div>
								</c:when>
								<c:otherwise>
									<div class="text-right">
										<a class="btn mid buttoncolor" href="list">돌아가기</a>
									</div>
								</c:otherwise>
							</c:choose>
							<div id="map"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</div>

<script>
    window.onload = function() {
        if("${item.placeId}" !== "") { // placeId가 null이 아니면 지도 출력
            initMap();
        }
    }
</script>

<script>
    function initMap() {

        const request = {
            placeId: "${item.placeId}",
            fields: ["name", "formatted_address", "place_id", "geometry", "url"],
        };

        // 말풍선
        const infowindow = new google.maps.InfoWindow();
        const service = new google.maps.places.PlacesService(map);

        service.getDetails(request, (place, status) => { // 세부정보 가져오기
            if (
                status === google.maps.places.PlacesServiceStatus.OK &&
                place &&
                place.geometry &&
                place.geometry.location
            ) {

                // 지도
                const map = new google.maps.Map(document.getElementById("map"), {
                    center: place.geometry.location,
                    zoom: 15,
                });

                const marker = new google.maps.Marker({ // 마커 위치 설정
                    map,
                    position: place.geometry.location,
                });

                marker.setVisible(true);

                infowindow.setContent(
                    "<div><strong style='font-weight: bold;'>" + place.name + "</strong><br>" +
                        "<strong style='font-weight: bold;'>주소: </strong><span>" + place.formatted_address + "</span><br>" +
                        "<strong style='font-weight: bold;'>URL: </strong><a href='" + place.url + "'>구글맵 바로가기</a><br>" +
                    "</div>"
                )

                infowindow.open(map, marker);
            }
        });
    }
</script>
<!-- 월 10만건 이상 유료 -->
<!-- Async script executes immediately and must be after any DOM elements used in callback. -->

<script async
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDyzBKXuryxzEeXDYTzXOBNRIClCv6FuUo&libraries=geometry,places&callback=initMap">
</script>

</body>
</html>