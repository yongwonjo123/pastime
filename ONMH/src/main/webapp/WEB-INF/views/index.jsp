<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
<!-- index 페이지 css Link -->
<link rel="stylesheet" href="/re/css/index.css">  
<!-- Swiper CSS -->
<link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css"/>
<!-- Swiper JS -->
<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
<!-- bootstrap css -->
<!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous"> -->
<!-- bootstrap js -->
<!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script> -->
<link rel="stylesheet" href="/re/css/review.css">
<link rel="stylesheet" href="/re/css/shopping.css">
<script>
	const path = '/club';
	const pa = '/thunder';
</script>
<script src="/re/js/block_link.js"></script>
<script src="/re/js/index.js"></script>
</head>

<body>
	
	<div class="container">
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>

<!-- 스와이퍼 -->
		<div class="swiper-container">
			<div class="swiper mainSwiper">
				<div class="swiper-wrapper boxsetting">
					<div class="swiper-slide bgrimg flex justify-center">
						<div class="boxsize flex items-center">
							<div class="flex justify-between">
								<div class="org40 flex justify-center column"></div>
								<div class="org60 flex items-center justify-center">
									<div class="imgsize img-border"></div>
								</div>
							</div>
						</div>

					</div>
					<div class="swiper-slide">
						<img alt="" src="/re/img/swap2.png">
					</div>
					<div class="swiper-slide">
						<img alt="" src="/re/img/swap3.png">
					</div>
				</div>
			</div>
			<div class="btn-wrapper mb-20">
				<button class="prev"></button>
				<button class="next"></button>
			</div>
		</div>
		
<!-- 모임 목록 스와이퍼 -->
		<div class="review wrapper">
			<div class="flex items-center justify-center">
				<div class="review-box flex items-left justify-center column mt-10">
				</div>
			</div>
			<div class="flex justify-center">
				<div
					class="flex plussize plusflex font-size-laguler font-weight-medium items-center">
					<h2 class="reviewfont-size">지금 모임에 가입해 보세요!</h2>
					<a class="lightcolor" href="club/list">더보기</a>
				</div>
			</div>

			<div class="mb-120">
				<div class="review-div">
					<div class="swiper mySwiper review-size flex">
						<c:forEach items="${list}" var="item" varStatus="status" begin="0"
							end="8">
							<div class="swiper-wrapper flex">
								<div class="swiper-slide">
									<div class="shopping-item mb-60 block-link" data-code="${item.code}">
						<div class="shopping-img-border">
							<img src="${item.thumbnail}" alt="${item.thumbnail}" />
						</div>
						<div class="info">
							<div class="flex justify-between px-5">
							<h2>${item.name}</h2>
							</div>
							<div class="flex justify-between px-5 mt-10 mb-10">
							${item.intro}
							</div>
							<div class="flex justify-between px-5 mb-10">
							<span class="name">${item.placeName}</span>
								
							</div>
							
							<div class="flex justify-between px-5">
								<span class="name">첫 모임일 <fmt:formatDate value="${item.date}" pattern="MM/dd(일)"/></span>
								
								<span class="price">${item.startTime} ~ ${item.endTime} </span>
							</div>
						</div>
					</div>
								</div>
							</div>
						</c:forEach>
						<div class="swiper-button-next"></div>
						<div class="swiper-button-prev"></div>
						
					</div>

				</div>
			</div>
		</div>

<!-- 3단계 설명 영역 -->
		<div class="flex items-center justify-center mt-30">
			<div class="tstep wrapper">
				<div class="tstep_div">
					<p class="tstep_p">3step으로 가입해보세요 👌</p>
					<h3 class="tstep_h3">이용 절차가 궁금하신가요?</h3>
				</div>
			</div>
		</div>
<div class="flex items-center justify-center mt-40">
					<div class="tstep-box">
			<img src="/re/img/tstep_img.png">
			</div>
		</div>
		
		<!-- 리뷰 목록 스와이퍼 -->
		<div class="review wrapper">
			<div class="flex items-center justify-center">
				<div class="review-box flex items-center justify-center column mt-40">
						<h2 class="reviewfont-size">생생한 후기를 경험하세요</h2>
				</div>
			</div>
			<div class="flex justify-center">
				<div
					class="flex plussize plusflexright font-size-laguler font-weight-medium items-center">
					<a class="lightcolor" href="review/list">더보기</a>
				</div>
			</div>

			<div class="mb-120">
				<div class="review-div">
					<div class="swiper mySwiper review-size flex">
						<c:forEach items="${tlist}" var="item" varStatus="status" begin="0"
							end="8">
							<div class="swiper-wrapper flex">
								<div class="swiper-slide">
									<div class="review-item block-link2" data-code="${item.code}">
										<div class="review-img-border">
											<c:if test="${item.images.size() > 0}">
												<img src="${item.thumbnail}"
													alt="${item.images.get(0).filename}" />
											</c:if>
										</div>
										<div class="info">
											<div class="flex justify-between px-5">
												<h2>${item.id}</h2>
											</div>
											<div class="flex justify-between px-5 mt-10 mb-10">
												${item.content}</div>
											<div class="flex justify-between px-5 mb-10">

											</div>

											<div class="flex justify-between px-5">
												<span class="name">날짜<fmt:formatDate
														value="${item.date}" pattern="MM/dd" /></span> 
											</div>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
						<div class="swiper-button-next"></div>
						<div class="swiper-button-prev"></div>

					</div>

				</div>
			</div>
		</div>

		<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
	</div>

	

</body>
</html>
