<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/post.js"></script>
</head>
<body>
${r }
	<form action="SearchController">
		<table>
			<tr>
	
				<td align="center"> 검색 <input name="content" type="text" placeholder="게시글 검색"> 	
				</td>
				
				<td> <button> 찾기 </button> </td>
	
			</tr>
		</table>
	</form>
				
	
	<hr>
	
	<form action="reg.jsp">
	
		<table>
		
			 <tr>
		 
		 		<td> <button> 게시글 작성 </button>   </td>
		 
			 </tr>
			
		</table>
	
	
	</form>		
	
	<table>
	<tr>
	<td>추천</td>
	</tr>
	</table>
	<c:forEach var="u" items="${users }">
	<table>
		<tr>
			<td>${u.a_id }</td>
		</tr>	
	</table>
	</c:forEach>
	
	
		
	<c:forEach var="p" items="${posts }">
				
	<table border="1">
	
	
	<tr>
	
		<td> Text Number : ${p.p_no } 	</td>
	
	</tr>
	
	
	<P>
	
	<tr>
	
	<td> <textarea rows="5" cols="" readonly="readonly"> ${p.p_content } </textarea>	</td>
	
	</tr>	
	
	<tr>
			
		<td  rowspan="1"><img src="img/${p.p_img }"></td>
	</tr>	
	
	
	<tr>
	
	<td> 
	
	<button onclick="location.href='UpdateController?no=${p.p_no}'"> 수정 </button> 	
	
	<button onclick="deleteText('${p.p_no }');"> 삭제 </button>			
	
	</td>
	
	
	
	</tr>
	
	</table>			
	
	</c:forEach>

	

	



</body>
</html>