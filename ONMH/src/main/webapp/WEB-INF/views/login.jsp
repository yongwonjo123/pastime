<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
<link rel="stylesheet" href="/re/css/login.css">

</head>
<body>
	
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
	<div class = "wrapper mb-120">
		<div class = "flex justify-center">
			<div class = "loginbox text-center mt-120">
				
				<div>
					<h4 class = "loginfont mt-60">로그인</h4>
				</div>
			    <form method="post" action="login" class="loginForm">
			        <div class = "mt-30">
			            <input type="text" name="id" id="userId" placeholder="아이디" class = "inputsize">
			        </div>
			        <div>
			            <input type="password" name="password" id="password" placeholder="비밀번호" class = "inputsize mt-10">
			        </div>
			        
			        
			        <div class="id-pw-wrap">
			        	<label class="cxbx-tag-1"><input type="checkbox" name="autoLogin" class = "mt-20 mr-10">자동 로그인</label>
						<div class="find-text">
							<a href="/findid" class="txt">아이디찾기</a> 
							 
						</div>
					</div>
					<button class = "loginbtn mt-10">로그인</button>
					<input type="button" class="signinbtn mt-10" onclick="location.href='/signup'" value="회원가입">
			    </form>
			    <div class = "flex justify-center column items-center ">
				    <div class = "idbox flex justify-center items-center">
				       
				
				    </div>
				    
				</div>
		    </div>
	    </div>
    </div>
</body>