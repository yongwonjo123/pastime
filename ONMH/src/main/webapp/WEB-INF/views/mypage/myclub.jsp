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
        <p class="txt-notice-desc">모임 별로 최대신청가능 횟수가 상이하니 새 모임 신청 시 반드시 확인바랍니다.</p>
        <p class="txt-notice-desc">결제를 완료해야만 , 모임에 참여가 가능합니다.</p>
      </div>
    </div>

          <div class="no-info-wrap mt-40">
        <img src="/re/img/icon-none.svg" alt="">
        <h3 class="txt-no-title">모임이 없습니다.</h3>
        <p class="txt-no-desc">원하는 모임에 가입해보세요.</p>
        <div class="btn-wrap mt-40">
          <a href="/" class="btn-full-xl btn-outline-st1">메인페이지로</a>
        </div>
      </div>
</div>
</body>
</html>
