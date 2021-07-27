<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

  
	<form action="ReviewRegController" method="post">

		<table border="1" id="tbl_reg">
			<tr>
				<td id="r_td1">글 제목</td>
				<td><input name="title" id="title"></td>
			</tr>
			<tr>
				<td id="r_td2">내용</td>
				<td><textarea name="txt" id="txt"> </textarea></td>
			</tr>
			<tr>
				<td colspan="2" id="r_td3" >
				<button>등록</button>
<!--				<button onclick="regReview();">등록</button>-->
				</td>
			</tr>
			
		</table>
</form>
</body>
</html>