<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
<link rel="stylesheet" href="/re/css/signup.css">
</head>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
	<div class="wrapper mb-120">
		<div class="flex justify-center">
			<div class="signupbox text-center mt-120">

				<div>
					<h4 class="signupfont mt-50">회원가입</h4>
				</div>
				<div>
					<p class="mt-20 mb-20">
						취미가 필요할 때, <strong>Pastime</strong><br>정확한 정보로 회원가입 부탁드립니다.
					</p>
				</div>


				<form method="post" action="signup" class="signupForm">
					<div>
						<label for="userId">아이디</label>
						<div class="flex item-center">

							<input type="text" name="id" id="userId" placeholder="ID"
								maxlength="32" class="addressinput">
							<button type="button" onclick="" class="addressbtn text-center">중복
								확인</button>
						</div>
					</div>

					<div class="mt-10">
						<label for="pwd">비밀번호</label> <input type="password"
							name="password" id="password"
							placeholder="비밀번호는 최소 8~15자, 하나 이상의 숫자와 문자, 특수기호를 포함"
							maxlength="15" class="inputsize">
					</div>

					<div class="mt-10">
						<label for="name">이름</label> <input type="text" name="name"
							id="userName" placeholder="Name" maxlength="8" class="inputsize">
					</div>

					<div class="mt-10">
						<label for="email">이메일</label> <input type="email" name="email"
							id="email" placeholder="email" class="inputsize">
					</div>

					<div class="mt-10">
						<label for="tel">전화번호</label> <input type="text" name="phone"
							id="tel" placeholder="Tel" maxlength="16" class="inputsize">
					</div>
					<div class="mt-10">
						<label for="addr">거주 주소</label>
						<div class="flex item-center">
							<input type="text" name="address" id="address"
								placeholder="Address" maxlength="64" class="addressinput">
							<button type="button" onclick="execDaumPostcode()"
								class="addressbtn text-center">주소 찾기</button>
						</div>

					</div>

					<div class="mt-10">
						<label for="gender" class="mb-20">성별</label> <input name="gender"
							type="radio" class="d-none form-check-input" value="male"
							id="male">남성
					</div>

					<div>
						<label for="gender"></label> <input name="gender" type="radio"
							class="d-none form-check-input" value="female" id="female">여성
					</div>


					<button id="signupBtn" class="signupbtn mt-30 mb-60">회원가입</button>
				</form>

				<!-- Daum 우편번호 서비스 CDN-->
				<script
					src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
				<!-- Daum 우편번호 서비스 함수 파일-->
				<script src="/re/js/daumPostCode.js" type="text/javascript"></script>
				<script src="/re/js/signup.js" type="text/javascript"></script>
			</div>
		</div>
	</div>

	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
    </body>
</html>