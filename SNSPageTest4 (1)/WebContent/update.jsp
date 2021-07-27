<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>육각정 : 내 정보</title>

	<link rel="stylesheet" href="css/join.css">
	<link rel="stylesheet" href="css/home.css">

</head>
<body>

	 <div class="contentPage">
			<div class="backBox">
				<button class="backBtn">
					<a href="javascript:history.back();">뒤로가기</a>
				</button>			
			</div>

	<form action="UpdateController" method="post"  enctype="multipart/form-data">

		
		 <div class="regBox" style="text-align: center;">
            
            <div class="updatePic">
            
	            <img src="img/${p.p_img }" width="100px" ><p>
	          	<input type="file" name="file" value="img/${p.p_img }">
	          	
            </div>
          	
	        <input name="content" value="${p.p_content }" class="updateContent">
            <input name="iiid" type="hidden" value="${sessionScope.a.a_id }">
            <input name = "no" value="${param.no }" type = "hidden">
            <div class="regMenu"><button class="regBtn">등록</button></div>
          </div>
		
	</form>

	${r }


</div>



</body>
</html>