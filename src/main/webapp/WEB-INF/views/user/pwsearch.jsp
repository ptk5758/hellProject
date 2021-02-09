<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="/css/user.css?ver=1">
<style>
	body{
		margin: 0;
		padding: 0;
	}
</style>
<div class="idsearch">
	<div class="idsearchTop">
		<div>비밀번호 찾기</div>
	</div>
	<div class="idsearchContent">
		<div class="idsearchContent_text">
			<div>회원가입하실때 사용하신 정보를 입력하여 주시길 바랍니다.</div>
		</div>
		<div class="idsearchContent_Item">
			<div>이름</div>
			<div><input name="name"></div>
		</div>
		<div class="idsearchContent_Item">
			<div>아이디</div>
			<div><input name="id"></div>
		</div>
		<div class="idsearchContent_Item">
			<div>이메일</div>
			<div><input name="email"></div>
		</div>
	</div>
	<div class="idsearchBottom">
		<div><button id="bth1" onclick="idsearchdo()">전송</button></div>
		<div><button id="bth2" onclick="window.close()">닫기</button></div>
	</div>
</div>
<script src="/js/user/Userpwsearch.js?ver=1"></script>