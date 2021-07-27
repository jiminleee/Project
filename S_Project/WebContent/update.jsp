<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="UpdateController" method="post"  enctype="multipart/form-data">

	<table>
		
		<tr>
			<td> 내용 수정 </td>
			<td> <input  name="content" value="${p.p_content }"> </td> <p>		
		</tr>
		
		
		
		
		<tr>
			<td> 사진 </td>
			
			<td> <img src="img/${p.p_img }" width="100px" > 
			<input type="file" name="file">
			
			</td> 		
		</tr>

			
		
		
		<tr>
		
		<td>
			<input name = "no" value="${param.no }" type = "hidden">	
		</td>  
		</tr>
		
		<tr>
			<td colspan="2"> <button  onclick="location.href='Main'"> 등록 </button> </td>
	 	</tr>
	
	
		</table>

	</form>

	${r }






</body>
</html>