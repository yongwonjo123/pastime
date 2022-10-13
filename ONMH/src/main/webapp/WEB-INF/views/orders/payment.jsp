<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="/re/js/daumPostCode.js" type="text/javascript"></script>
	<script src="/re/js/payment.js"></script>
	
	<script>
		$(function(){
			$('#address-btn').click(function(){
				execDaumPostcode();
			});
		});
	</script>
	
	<link rel="stylesheet" href="/re/css/payment.css" />
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
	<div>
		<div class="flex justify-center item-center pb-30 pt-50 wrapper">
			<h1 class="font-title">모임 회비 결제</h1>

		</div>
	</div>
	<div id="payment-wrapper" class="py-60">
		<div class="wrapper flex justify-center">
			<article>
				<section class="mb-20">
					<h2 class="pb-20">결제할 모임</h2>
					<ul class="orders-list">
						<c:forEach items="${list}" var="item">
							<li>
								<div class="img-border thumbnail">
									<img src="${item.thumbnail}" alt="${item.images.get(0).filename}" />
								</div>
								<div>
									${item.name}
								</div>
								<div hidden="true">
									${item.amount}개
								</div>
								<div>
									<fmt:formatNumber value="${item.price}" pattern="###,###,###원"/>
								</div>
							</li>	
						</c:forEach>
						<section class="mt-20">
					<form method="post" class="payment-form">
						<input type="hidden" name="id" value="${user.id}"/>

						<div class="text-right">
							<input class="mb-20" id="request" type="hidden" name="request"/>
						</div>
						<div class="flex justify-between item-center py-10">
							<section class="flex justify-center text-center item-center ml-30">
								<div class="px-50" hidden="true">
									<span class="font-gray">상품 개수</span>
									<h2>${amount}개</h2>
								</div>
								<div class="px-50">
									<span class="font-gray">회비: <fmt:formatNumber value="${total}" pattern="###,###,###원"/></span>
								</div>
							</section>
							<button class="py-10 px-60 font-size-large">구매하기</button>
						</div>
					</form>
				</section>
					</ul>
					
				</section>
				
			</article>
		
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>