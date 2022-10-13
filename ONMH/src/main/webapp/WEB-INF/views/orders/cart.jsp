<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
	<link rel="stylesheet" href="/re/css/cart.css" />
	<script> const path = '/club';</script>
	<script src="/re/js/block_cartlink.js"></script>
	<script src="/re/js/cart.js"></script>
</head>
<body class="back-white">
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
	<div class="back-white">
		<div class="flex justify-between item-center pb-30 pt-50 wrapper">
			<h1 class="font-title">관심 모임</h1>
			
		</div>
	</div>
	<div class="cart-wrapper">
		<table class="wrapper cart-table">
			<thead>
				
			</thead>
			<tbody>
				<tr id="empty-msg">
					<td class="py-15 text-center font-gray font-size-small" colspan="6">관심 목록이 비어있습니다.</td>
				</tr>
				<c:forEach items="${list}" var="item">
					<tr class="px-40" data-ccode="${item.code}">
						<td class="cart-cell"></td>
						<td class="cart-cell px-20">
							<div class="img-border cart-img">
								<img src="${item.thumbnail}" />
							</div>
						</td>
						<td class="px-60 cart-name block-link" data-ccode="${item.code}">${item.name} / ${item.placeFormatted} / ${item.startDate} ${item.startTime} ~ ${item.endTime}</td>
						<td class="text-center">
							<div class="flex justify-center item-center">
								<div class="text-center cart-amount mx-10">
									<fmt:formatNumber value="${item.price}" pattern="###,###,###원"/>
								</div>
							</div>
						</td>
						<td class="cart-price px-50">
						<button class="delete-btn mr-10">삭제하기</button>
						</td>
						<td class="cart-cell relative"></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>