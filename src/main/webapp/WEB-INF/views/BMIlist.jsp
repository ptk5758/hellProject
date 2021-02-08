<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
	<link rel="stylesheet" type="text/css" href="/css/bmi.css?ver=1">
	<div class="bmiList">
		<div class="bmi_option">
			<div class="bmi_option_title">
				<span id="countresult">5</span>
				<span>의 결과</span>
			</div>
			<div class="bmi_option_board">
				<div>보기</div>
				<div>
					<select id="pagecut">
						<option>5</option>
						<option>10</option>
						<option>20</option>
					</select>
				</div>
				<div>
					<select onchange="getselectbmiList(this)">
						<option>저체중</option>
						<option>정상</option>
						<option>과체중</option>
						<option>비만</option>
						<option>고도 비만</option>						
					</select>
				</div>
			</div>
		</div>
		<div class="bmi_list_board" id="bmiboard">
			<h1>로딩중</h1>
		</div>
		<div class="bmi_page" id="pageBoard">
			<div>1</div>
			<div>2</div>
			<div>3</div>
			<div>4</div>
			<div>5</div>
		</div>
	</div>
	<script src="/js/bmi/bmilistPage.js?ver=1"></script>
<%@ include file="/WEB-INF/views/include/footer.jsp" %>
