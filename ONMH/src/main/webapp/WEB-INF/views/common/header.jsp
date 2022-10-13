<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="headerstart ">
	<div class = "headercontent">
			<a href = "/"><div class = "logosize">
           		<img alt="" src="/re/img/logo.png" id ="logoimgsize logoimg">
            </div></a>
            <div class = "menefont">
	            <a href="/club/list" class = "menupadding">정기모임</a>
	            <a href="/orders/cart" class = "menupadding">관심모임</a>
	            <a href="/thunder/list" class = "menupadding">모임리뷰</a>
	            <a href="/notice/list" class = "menupadding">고객센터</a>            
            </div>
          		<div id="user-menu" class= "menefont">
          			<c:choose>
          				<c:when test="${sessionScope.user == null}">
          					<a class= "btn" href = "/login">로그인</a>
          				</c:when>
				<c:otherwise>
					<span id="user-btn">
						<div class="whole-profile-wrap">
							<div class="profile-wrap" size="28">
								<img class="profile" src="/re/img/profile.png">
							</div>
						</div>
					</span>
				</c:otherwise>
			</c:choose>
          			
                	<c:if test="${sessionScope.user != null}">
	                	<ul id="user-dropdown">
						    <li><a class="" href="/mypage/myclub">마이페이지</a></li>
						    <c:if test="${sessionScope.user.grade == 1}">
						    	<li><a class="" href="/admin/memberControll">관리자페이지</a></li>
						    </c:if>
						    <li><a class="" href="/logout">로그아웃</a></li>
					  	</ul>
                	</c:if>
                	
				</div>
	</div>
</div>