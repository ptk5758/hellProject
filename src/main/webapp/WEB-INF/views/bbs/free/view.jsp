<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
<link rel="stylesheet" type="text/css" href="/css/bbs/freebbs.css?ver=1">	
	<div class="viewmain">
		<div class="viewBoard" id="viewBoard">
			<div class="viewBoard_SubjectBoard">대충 제목</div>
			<div class="viewBoard_itenInfo">
				<div class="viewBoard_itenInfo_user">
					<span class="bold">작성자</span>
					<span>관리자</span>
				</div>
				<div class="viewBoard_itenInfo_ref">
					<span class="bold">조회수</span>
					<span>5</span>
				</div>
				<div class="viewBoard_itenInfo_like">
					<span class="bold">추천</span>
					<span>3</span>
				</div>
			</div>
			<div class="viewBoard_contentBoard">대충 내용</div>
		</div>
		<div class="viewBoard_likeBoard">
			<input type="checkbox" id="likecheck" value="${uid}">
			<label id="likebutton" for="likecheck">좋아요</label>
		</div>
	</div>	
	<script src="/js/free/freeview.js?ver=1"></script>
	<script>
		let uid = "${uid}";
		getFreeVO(uid);
	</script>
<%@ include file="/WEB-INF/views/include/footer.jsp" %>
	