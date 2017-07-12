<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimun-scale=1, user-scalable=no">"
	<title>카테고리 생성 페이지 </title>
	<link href="/resources/css/style.css" rel="stylesheet">
</head>


<body>
<div id="container">
		
		<h1>카테고리 생성하기 </h1>
			<form method="post" action ="/category/api">
				<br><br>
				카테고리 추가 : <input type="text" name="name"> 
				<input type="submit" value="확인">
			</form>
		<br><br>
		<div class='category-List'>	
		<!--  -->
			<span>카테고리 리스트</span> <br><br>
			<c:if test="${requestScope.categoryList == null }">
				리스트 출력 실패 
			</c:if>
			<table id="categoryTable">
				<tr>
					<td>  id   </td>
					<td></td>
					<td>  이름   </td>
				</tr>
				<c:forEach var="item" items ="${requestScope.categoryList }">
					<tr class="${item.id }" >
					    <td > ${item.id} </td>
					    <td></td>
					    <td class="display${item.id}"> ${item.name } </td>
					    <td><input type="hidden" name="id" value="${item.id}">
						    <input type="text" class="mod_name${item.id}" value=${item.name } ></td>
						    <td><button   class="modify" id="${item.id }" >수정 </button></td>
					    
					    <td><button class="delete" id="${item.id }">삭제 </button></td>
				    </tr>
			   
			    </c:forEach>
			</table>
		</div>
</div> <!-- end of container -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="resources/js/app.js"></script>
	
</body>
</html>