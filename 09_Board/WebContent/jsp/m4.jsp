<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table id="tbl_review">
		<tr>
			<td class="r_td_title">후기 페이지 &nbsp;&nbsp; ${r }</td>
			<td class="r_td_title"><a href="ReviewRegController"> 글쓰기 </a></td>
		</tr>
	</table>



<table id="tbl_review2">
		
		<c:forEach var="r" items="${reviews }">
			<tr class="r_tr1">
				<td class="r_td1"
					onclick="location.href='ReviewDetailController?no=${r.r_no }'">
					${r.r_title}</td>
				<td>${r.r_txt }</td>	
				<td class="r_td2"><fmt:formatDate value="${r.r_date}"
						type="both" dateStyle="short" timeStyle="short" /></td>
			</tr>
		</c:forEach>
	</table>

<table id = "tbl_review3" align="center">
	<tr>
		
		<td id ="r_pageTD" align="center">
		
		<a href="ReviewPageController?p=1">[맨처음]</a>		
		
		<c:forEach var="p" begin="1" end="${pageCount }">
		<a href="ReviewPageController?p=${p }">[${p }]</a>		
		</c:forEach>
		
		<a href="ReviewPageController?p=${pageCount}">[맨끝]</a>		
		
		</td>
	</tr>
	
</table>

</body>
</html>