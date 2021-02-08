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
			<span>로그인</span>
			<span onclick="location.href='/signup'">회원가입</span>
		</div>
	</header>
	<nav>
		<div onclick="location.href='/BMI'">BMI 측정하러가기</div>
		<div onclick="location.href='/BMI/list'">다른사람 최근측정</div>
		<div>3번</div>
		<div>4번</div>
		<div>5번</div>
	</nav>