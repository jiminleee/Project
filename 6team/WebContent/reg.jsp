<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>





<table>

	<tr>

		<td>	

			<button>  <a href="javascript:history.back();">뒤로가기</a>  </button>
	
		</td>

	</tr>


</table>

<p>


	<form action="RegController" method="post" enctype="multipart/form-data">
	
	<table border="1">
	
	<tr>
	
		<td> 작성내용 : <textarea rows="" cols="" name="content"></textarea> </td>
		
	</tr>
	
		<tr>
	
		<td> 사진 첨부 : <input type="file" name="file"> </td>
		
	</tr>
	
	<tr>
			<td colspan="2"> <button>등록</button> </td>
	</tr>
	
	
	
	</table>
	
</form>
	
${r }
	
	





</body>
</html>