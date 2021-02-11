<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/main.css?ver=1">
</head>
<body>
	<header>
		<div onclick="location.href='/'">메인화면</div>
		<div>
			<input type="checkbox" id="menu">
			<label class="menuButton" for="menu">메뉴</label>
			<div id="menuBoard">
				<div class="loginBoard">
				<c:if test="${sessionID == null }">
					<div class="loginItem">
						<input placeholder="아이디" id="id">
					</div>
					<div class="loginItem">
						<input placeholder="비밀번호" id="password">
					</div>
					<div class="loginItem">
						<button onclick="login()">로그인</button>
					</div>
				</c:if>
				<c:if test="${sessionID != null }">
					<div class="loginItem">
						<div>아이디: ${sessionID }</div>
					</div>
					<div class="loginItem">
						<div>닉네임: ${sessionNickName }</div>
					</div>
					<div class="loginItem">
						<div>등급: ${sessionLevel }</div>
					</div>
				</c:if>				
				</div>
				
				<div class="loginOptionBoard">					
					<c:if test="${sessionID == null }">
					<div class="loginOptionBoardItem" onclick="idsearch()">아이디찾기</div>
					<div class="loginOptionBoardItem" onclick="pwsearch()">비밀번호찾기</div>
					<div onclick="location.href='/signup'" id="signup" class="loginOptionBoardItem">회원가입</div>
					</c:if>
					<c:if test="${sessionID != null }">
					<div onclick="location.href='/logout'" class="loginOptionBoardItem">로그아웃</div>
					<div class="loginOptionBoardItem">1:1 문의답변</div>
					<div id="signup" class="loginOptionBoardItem">마이페이지</div>
					</c:if>
				</div>
			</div>
		</div>		
	</header>
	<nav>
		<div onclick="location.href='/BMI'">BMI 측정하러가기</div>
		<div onclick="location.href='/BMI/list'">다른유저의 BMI</div>
		<div onclick="location.href='/bbs/'">커뮤니티</div>
		<div>4번</div>
		<div>5번</div>
	</nav>
	