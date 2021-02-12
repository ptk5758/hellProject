<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
<link rel="stylesheet" type="text/css" href="/css/bbs/freebbs.css?ver=1">	
	<div class="freeMain">
		<h1>대충 자유게시판</h1>
		<div class="freeBoard" id="freeBoard">
			<div class="freeBoardList listtop">
				<div class="freeBoardList_Num">No</div>
				<div class="freeBoardList_Subject">제목</div>
				<div class="freeBoardList_User">유저</div>
				<div class="freeBoardList_Date">날짜</div>				
				<div class="freeBoardList_Ref">조회수</div>
				<div class="freeBoardList_Like">추천</div>
			</div>
		</div>
		<div class="freeBoardSearchOption">
			<div class="freeBoard_refresh">
				<img src="/img/re.png">
			</div>
			<div class="freeBoard_select">
				<select name="title">
					<option value="subject">제목</option>
					<option value="user">글쓴이</option>
					<option value="content">내용</option>
				</select>
			</div>
			<div class="freeBoard_input">
				<input name="value">
			</div>
			<div class="freeBoard_searchbutton">
				<button onclick="searchdo()">검색</button>
			</div>
			<div class="freeBoard_postingbutton">
				<button onclick="location.href='/bbs/free/posting'">글작성하기</button>
			</div>
		</div>
		<div id="freeBoardPage"></div>
	</div>
	<!-- <h1 onclick="location.href='/bbs/free/posting'">글쓰기</h1> -->
	<script src="/js/free/freelist.js?ver=1"></script>
<%@ include file="/WEB-INF/views/include/footer.jsp" %>
	