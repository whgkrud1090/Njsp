<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<ul class="nav nav-sidebar">
	<!-- a tag : get method -->
	<li class="active"><a href="${cp }/userList">사용자 리스트 <span class="sr-only">(current)</span></a></li>
	<li class="active"><a href="${cp }/userListOnlyHalf">사용자리스트(onlyHalf) <span class="sr-only">(current)</span></a></li>
	<li class="active"><a href="${cp }/userPagingList?page=1">사용자 페이징 리스트<span class="sr-only">(current)</span></a></li>
	<li class="active"><a href="${cp }/lprodList">제품그룹 리스트</a></li>
	<li class="active"><a href="${cp }/lprodPagingList?page=1">제품그룹 페이징 리스트</a></li>
</ul>