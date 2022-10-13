<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
<link rel="stylesheet" href="/re/css/mypage.css" />
<link rel="stylesheet" href="/re/css/info.css" />
<link rel="stylesheet" href="/re/css/signup.css">
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
	<div class="mypage-container">
	<!-- mypage-navigation -->
		<div class="mypage-nav-wrap">
			<div class="area-sm">
				<div class="common-title-wrap">
					<h2 class="title">마이페이지</h2>
				</div>
				<article class="nav-tabs-st1">
					<div class="tab-wrap slyTab" data-sly-type="link"
						style="overflow: hidden;">
						<div class="slyTab-inner"
							style="transform: translateZ(0px); width: 301px;">
							<div class="tab-item active">
								<a href="/mypage/myclub">내 모임</a>
							</div>
							
							<div class="tab-item">
								<a href="/mypage/info/${item.id}">회원정보 수정</a>
							</div>
						</div>
					</div>
				</article>
			</div>
		</div>
		
		<!-- mypage-club-contents -->
		<div class="area-sm-content">
    <div class="frame-wrap notice-sec-wrap">
      <!-- 알림 공지-->
 <div class="notice-info-wrap">
        <p class="txt-notice">알려드립니다.</p>
        <p class="txt-notice-desc"> 비밀번호 <strong>변경</strong>만 가능합니다.</p>
        <p class="txt-notice-desc"> 개명, 이사 등으로 인한 개인정보변경이 필요한 경우 관리자에 문의부탁드립니다.</p>
      </div>
    </div>
         <div class="flex justify-center">
              <form method="post"  class="signupForm">
					<div>
						<label for="userId">아이디</label>
						<div class="flex item-center">

							<input type="text" name="id" id="userId" placeholder="ID"
								maxlength="32" class="inputsize" value="${item.id}" readonly="readonly">
							
						</div>
					</div>

					<div class="mt-10">
						<label for="pwd">비밀번호 변경</label> <input type="password"
							name="password" id="password"
							placeholder="비밀번호는 최소 8~15자, 하나 이상의 숫자와 문자, 특수기호를 포함"
							maxlength="15" class="inputsize">
					</div>

					<div class="mt-10">
						<label for="name">이름</label> <input type="text" name="name"
							id="userName" placeholder="Name" maxlength="8" class="inputsize" value="${item.name}" readonly="readonly">
					</div>

					<div class="mt-10">
						<label for="email">이메일</label> <input type="email" name="email"
							id="email" placeholder="email" class="inputsize" value="${item.email}" readonly="readonly">
					</div>

					<div class="mt-10">
						<label for="tel">전화번호</label> <input type="text" name="phone"
							id="tel" placeholder="Tel" maxlength="16" class="inputsize" value="${item.phone}" readonly="readonly">
					</div>
					<div class="mt-10">
						<label for="addr">거주 주소</label>
						<div class="flex item-center">
							<input type="text" name="address" id="address"
								placeholder="Address" maxlength="64" class="inputsize" value="${item.address}" readonly="readonly">
						
						</div>

					</div>

					<button id="updatebtn" class="signupbtn mt-30 mb-60">회원 정보 변경</button>
				</form>
            </div>
</body>
</html>
