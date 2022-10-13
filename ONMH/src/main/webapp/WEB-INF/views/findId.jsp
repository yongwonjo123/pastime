<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
		<link rel="stylesheet" href="/re/css/findUserInfo.css">
	</head>

	<body>
		<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
		<div class="mb-120">
			<div class="flex justify-center">
				<div class="signupbox text-center mt-120">
					<div>
						<h4 class="signupfont mt-60">아이디 찾기</h4>
						<div class="yellowline flex justify-center mt-40">
						<p class="sub-title">본인의 이메일을 통해 아이디를 확인하실 수 있습니다.<br>아래 이메일을 넣고 아이디를 확인하세요.</p></div>
					</div>
					<form class="signupForm mt-30">
						<div>
							<label for="email">이메일</label>
							<div class="flex item-center">
								<input type="email" name="email" id="email-id" placeholder="Email" maxlength="32"
									class="email-input">
							</div>
						</div>
						<button id="idBtn" class="signupbtn mt-30 mb-60" type="button">아이디 찾기</button>
						

						
						<input type="hidden" id="email-confirm-hidden" />

						<!-- Daum 우편번호 서비스 CDN-->
						<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
						<!-- Daum 우편번호 서비스 함수 파일-->
						<script src="/re/js/findUserInfo.js" type="text/javascript"></script>
				</div>
			</div>
			<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
	</body>

	</html>