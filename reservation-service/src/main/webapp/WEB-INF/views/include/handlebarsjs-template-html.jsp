<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <script id="category-entry-template" type="text/x-handlebars-template">
	<li class="item" data-category="{{id}}">
		<a class="anchor">
			<span> {{name}} </span>
		</a>
    </li>
 </script>
   
 <script id="category-product-entry-template" type="text/x-handlebars-template">
	<li class="item">
		<a href="#" class="item_book">
			<div class="item_preview">
				<img alt={{description}}  class="img_thumb" src="https://ssl.phinf.net/naverbooking/20170303_271/1488514705030TuUK4_JPEG/17%B5%E5%B8%B2%B0%C9%C1%EE_%B8%DE%C0%CE%C6%F7%BD%BA%C5%CD_%C3%D6%C1%BE.jpg?type=l591_945">
				<span class="img_border"></span> 
			</div>
			<div class="event_txt">
				<h4 class="event_txt_tit"> 
		  			<span> {{description}} </span>
					<small class="sm">샤롯데 씨어터 {{id}}</small> 
				</h4>
		        <p class="event_txt_dsc"> {{event}} </p> 
			</div>
		</a>
	</li>
</script>
<script id="empty-category-product-entry-template" type="text/x-handlebars-template">
	<li class="item">
		<a href="#" class="item_book">
			<div class="item_preview">
				<div class="event_txt">
					<h4 class="event_txt_tit"> 
						<span>해당 카테고리에 맞는 목록이 없습니다.</span>
					</h4>
				<div>
			</div>
		</a>
	</li>
</script>
