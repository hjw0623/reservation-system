<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="/resources/css/test.css" rel="stylesheet">

<title>Insert title here</title>
</head>
<body>
<div>
  <div class="demo">
    <div class="func">
      <a id="btn_trigger" class="btn btn-cta-primary btn_trigger" href="#">Trigger 'foo' Event</a>  
      <a id="btn_attach" class="btn btn-cta-primary btn_attach" href="#">Attach 'foo' Event</a>  
      <a id="btn_detach" class="btn btn-cta-secondary btn_detach" href="#">Detach 'foo' Event</a>
    </div>
    <div class="desc" id="desc"></div>
    <div class="desc" id="desc2"></div>
  </div>
</div>
   <script src="/resources/js/node_modules/jquery/dist/jquery.js"></script>
    <script src="/resources/js/node_modules/handlebars/dist/handlebars.js"></script>
    <script src="/resources/js/node_modules/@egjs/dist/component.js"></script>
    <script src="/resources/js/eventemitter.js"></script> 
</body>
</html>