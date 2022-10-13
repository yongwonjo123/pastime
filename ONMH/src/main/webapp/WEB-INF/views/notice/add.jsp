<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
	<link rel="stylesheet" href="/re/css/review.css" />
	<link rel="stylesheet" href="/re/css/login.css" />
	<script src="/re/js/review_form.js"></script>
</head>
<body>	
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
	<form method="post" enctype="multipart/form-data" class="review-form">
		<input type="hidden" name="id" value="${user.id}"/>
		<input type="hidden" name="price" value="${sub.total}"/>
		<h2 class="text-center pt-20 pb-10 px-40 font-weight-bold">관리자 공지사항 작성</h2>
		<div class="flex justify-between item-center pt-10 pb-50 px-40">
		</div>
		<div class="input-wrapper">
			<div class="flex justify-between item-baseline py-10">
				<div class="rating">
					<input type="text" name="title" id="title" placeholder="공지사항 제목" class = "inputsize">
				</div>
				<div class="text-right"><input type="file" name="image" id="image" class = "picsize" multiple/><label for="image">사진 등록</label></div>
			</div>
			<div class="text-center py-15">
				<textarea class="contents" name="content" placeholder="공지사항에 대한 내용 작성" required></textarea>
			</div>
			<div class="text-center">
				<button class="btn gray round px-40 font-size-small" id="review-submit">공지사항 작성</button>
			</div>
		</div>
	</form>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>