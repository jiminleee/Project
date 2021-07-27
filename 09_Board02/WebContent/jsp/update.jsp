<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="MovieUpdateController" method="post" enctype="multipart/form-data">
	<table id="mTbl">
	<tr>
	<td>영화제목</td>	
	<td><input name = "title" value="${m.m_title }" readonly="readonly"></td>	
	</tr>
	<tr>
	<td>배우</td>	
	<td><input name = "actor" value="${m.m_actor }"></td>	
	</tr>
	<tr>
	<td>사진</td>	
	<td>
	<img src="img/${m.m_img }" width="100px;"><br>
	<input type="file" name = "file"></td>	
	</tr>
	<tr>
	<td>줄거리</td>	
	<td><textarea name ="story">${m.m_story }</textarea></td>	
	</tr>
	<tr>
	<td>
	<input name ="no" value="${param.no }" type="hidden">
	</td>
	</tr>
	<tr>
	<td colspan="2"><button>등록</button></td>
	</tr>
	</table>

</body>
</html>