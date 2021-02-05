<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
	<link rel="stylesheet" type="text/css" href="/css/bmi.css?ver=1">
	<div class="bmiList">
		<div class="bmi_option">(대충 검색하는 인터페이스)</div>
		<div class="bmi_list_board" id="bmiboard">
			<div class="bmi_list_item">
				<div class="bmi_list_num">Num</div>
				<div class="bmi_list_height">키</div>
				<div class="bmi_list_weight">몸무게</div>
				<div class="bmi_list_BMI">BMI</div>
				<div class="bmi_list_answer">결과</div>
				<div class="bmi_list_date">날짜</div>
				<div class="bmi_list_user">유저</div>
			</div>
		</div>
		<div class="bmi_page">(대충 페이징)</div>
	</div>
	<script src="/js/bmi/bmilistPage.js?ver=1"></script>
<%@ include file="/WEB-INF/views/include/footer.jsp" %>