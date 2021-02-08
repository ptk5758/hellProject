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
		<div onclick="location.href='/BMI'">로고</div>
		<div>
			<c:if test="${sessionID == null }">
				<span>로그인</span>
				<span onclick="location.href='/signup'">회원가입</span>
			</c:if>
			<c:if test="${sessionID != null }">
				<span>로그아웃</span>
				<span onclick="">마이페이지</span>
			</c:if>
		</div>
	</header>
	<nav>
		<div onclick="location.href='/BMI'">BMI 측정하러가기</div>
		<div onclick="location.href='/BMI/list'">다른사람 최근측정</div>
		<div>3번</div>
		<div>4번</div>
		<div>5번</div>
	</nav>