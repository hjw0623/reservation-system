<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>이미지 파일 업로드Form</title>
</head>
<body>
<!-- -->
<form method="post" action="/files" enctype="multipart/form-data">

    <select name="product-List" id="product-List">
    	<!--'<option value="'+data[idx].name+'id="'+data[idx].id+'>'+data[idx].description+'</option>'-->
    </select>
    <br> <br>
    <a href="#" class="add-input">버튼 추가</a><br><br>
    <span id="1">   메인 이미지  등록 </span><br><br>

    <input type="file" name="file" id="input_"><br><br>

   	<br><br> <input type="submit" value="등록">
</form>

<script src="/resources/js/node_modules/jquery/dist/jquery.js"></script>

<script src="/resources/js/imgform.js"></script>

</body>
</html>