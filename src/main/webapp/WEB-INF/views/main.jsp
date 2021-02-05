<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
	<form class="MainBoard" id="userForm">
		<div class="Main_Item">
			<div class="Main_Item_Text">성별</div>
			<div class="Main_Item_Value genderRadio">
				<label for="gender1">남자</label><input id="gender" type="radio" value="남자" name="gender" checked="checked">
				<label for="gender2">여자</label><input id="gender" type="radio" value="여자" name="gender">
			</div>
		</div>
		<div class="Main_Item">
			<div class="Main_Item_Text">키</div>
			<div class="Main_Item_Value"><input placeholder="키" id="height" name="height"></div>
		</div>
		<div class="Main_Item">
			<div class="Main_Item_Text">몸무게</div>
			<div class="Main_Item_Value"><input placeholder="몸무게" id="weight" name="weight"></div>
		</div>
		<div class="Main_Item">
			<div class="Main_Item_Text">나이</div>
			<div class="Main_Item_Value"><input placeholder="나이" id="age" name="age"></div>
		</div>
		<div class="Main_Item">
			<div><button id="WeightButton">계산하기</button></div>
		</div>
		<div id="resultBoard"></div>
	</form>
<script src="/js/WeightManager.js?ver=1"></script>
<%@ include file="/WEB-INF/views/include/footer.jsp" %>