<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
	<link rel="stylesheet" href="/re/css/shopping.css" />
	<script>
		const path = '/club';
	</script>
	<script src="/re/js/block_link.js"></script>
</head>
<body>
	<div>
		<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
		<!-- <div class="shopping-list-visual"></div> -->
		<div class="shopping-container">
			<form>
				
				<div class="py-25 flex justify-between item-center">
					<div class="flex item-center">
						<input type="hidden" name="search" value="2">
						<input class="input-search mr-20" type="text" name="keyword" placeholder="검색어를 입력해주세요" value="${pager.keyword}">
				</div>
					
				</div>
			</form>
			
			<div class="all-club">현재 진행중인 모임 <span class="numb-point"><fmt:formatNumber value="${pager.total}" pattern=""/></span> 개  <a class="btn-review-add ml-20" href="add">모임 등록</a></div> 
			<div class="flex wrap">
				<c:forEach items="${list}" var="item">
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
				</c:forEach>
			</div>
			<jsp:include page="/WEB-INF/views/common/pagination.jsp"/>
		</div>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
	</div>
</body>
</html>