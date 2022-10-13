<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="aheaderstart ">
	<div class = "headercontent">
			<a href = "/"><div class = "alogosize">
			<h5>Pastime 관리자 페이지</h5>
<!--            		<img alt="" src="/re/img/logoadmin.png" id ="logoimgsize logoimg">-->            </div></a>
            <div class = "menefont">
	            <a href="memberControll" class = "menupadding">회원관리</a>
	            <a href="clubControll" class = "menupadding">모임관리</a>
	            <a href="reviewControll" class = "menupadding">리뷰관리</a>
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
						     <li><a class="" href="/">메인페이지</a></li>
					  	</ul>
                	</c:if>
                	
				</div>
	</div>
</div>