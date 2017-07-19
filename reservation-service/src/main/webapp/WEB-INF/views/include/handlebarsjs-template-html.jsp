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
		<a href="#" class="item_book" clickId="{{id}}">
			<div class="item_preview">
				<img alt="{{description}}"  class="img_thumb" src="/imgresources{{saveFileName}}">
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
