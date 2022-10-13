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
		<div class = "flex column" id="item" data-code="${item.code}" >
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
							<p class = "mftfont mb-20">리뷰 작성자:${item.id} 님</p>
							<p class = "namefont mb-10">${item.name}</p>
						</div>
						
						
						
						<hr class = "hrstyle mt-20">
						<p>${item.content}</p>
						
						
						
						<div id="map"></div>
						<hr class = "hrstyle mt-20">
					
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


</body>
</html>