<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<td colspan="2" align="center" class="d_td1"><h3>상세 페이지</h3>
</td>
</tr>

	<tr>
		<td class="d_td1">글 번호</td>
		<td class="d_td2">${reviews.r_no }</td>
	</tr>
	<tr>
		<td class="d_td1">글 제목</td>
		<td class="d_td2">${reviews.r_title }</td>
	</tr>
	<tr>
		<td>내용</td>
		<td>${reviews.r_txt }</td>
	</tr>
	<tr>
		<td class="d_td1">작성날짜</td>
		<td class="d_td2"><fmt:formatDate value="${reviews.r_date }" type="both" dateStyle="short" timeStyle="short" /></td>
	</tr>
	<tr>
		<td>
		<a href="ReviewUpdateController?no=${reviews.r_no}"><button>수정</button></a>
		<button onclick="ReviewDel(${reviews.r_no})">삭제</button>
		</td>
	<tr>


</table>

</body>
</html>