<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/movie.css">
</head>
<body>
${r }
<form action="MovieRegController" method="post" enctype="multipart/form-data">
	<table id="mTbl">
	<tr>
	<td>영화제목</td>	
	<td><input name = "title" ></td>	
	</tr>
	<tr>
	<td>배우</td>	
	<td><input name = "actor"></td>	
	</tr>
	<tr>
	<td>사진</td>	
	<td><input type="file" name = "file"></td>	
	</tr>
	<tr>
	<td>줄거리</td>	
	<td><textarea rows="" cols="" name="story"></textarea></td>	
	</tr>
	<tr>
	<td colspan="2"><button>등록</button></td>
	</tr>
	</table>
</form>

<form action="SearchController">
	<table id = "mTbl3">
		<tr>
		<td>
			<input name ="title">
		</td>
		<td>
			<button>검색</button>
		</td>
		</tr>
	</table>		
</form>


<c:forEach var="m" items="${movies }">
	
	<table id="mTbl2">
		<tr>
			
			<td id="m_td2" rowspan="4"><img src="img/${m.m_img }" id="tdImg" ></td>
		</tr>
		<tr>
			<td>제목</td>
			<td class="m_td1">${m.m_title}</td>
		</tr>
		<tr>
			<td>배우</td>
			<td class="m_td1">${m.m_actor }</td>
		</tr>
		<tr>
			<td>줄거리</td>
			<td class="m_td1">${m.m_story }</td>
		</tr>
		<tr>
			<td>
			<button onclick="location.href='MovieUpdateController?no=${m.m_no}'">수정</button>
			</td>
		</tr>
		<tr>
			<td>
			<button onclick="deleteMovie('${m.m_no}');">삭제</button>
			</td>
		</tr>
		
	</table>
		</c:forEach>

</body>
</html>