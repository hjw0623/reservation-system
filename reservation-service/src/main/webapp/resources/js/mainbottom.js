var spec2 = {
	 getPlistUrl : '/bottom/category',
	 bottomUrl : '/bottom',
	 num : 10,
	 cId : 1, 
}

var categoryProductList = (function (spec, cId, number){
	//private
	var num = number;
	var categoryId =cId; 
	// 카테고리 목록 조회, 테이블 스키마에서 1은 전체 카테고리 
	
	//public 
	return {
		initParam : function (spec){
			num = spec.num;
			categoryId = spec.cId;
		},
		getProductListByCategory : function (getProductListUrl, categoryId, num){
			
			$.ajax({
				method:"GET",
				url:getProductListUrl,
				data : {categoryId : categoryId, num: num},
				success:function(data){
					var categoryNum = 0;
					$('.lst_event_box:eq(0)').empty();
					$('.lst_event_box:eq(1)').empty();
					if(data.length>0){
						$.each( data, function(){
							var item = 	'<li class="item">'
										+'<a href="#" class="item_book">'
										+'<div class="item_preview">'
										+'<img alt='+data[categoryNum].description
										+' class="img_thumb"'
										+'src="https://ssl.phinf.net/naverbooking/20170303_271/1488514705030TuUK4_JPEG'
										+'/17%B5%E5%B8%B2%B0%C9%C1%EE_%B8%DE%C0%CE%C6%F7%BD%BA%C5%CD_%C3%D6%C1%BE.jpg?type=l591_945">  '
										+'<span class="img_border"></span> </div>'
										+'<div class="event_txt">'
		                                +'<h4 class="event_txt_tit"> '
		                                +'<span>'+data[categoryNum].description+'</span>'
		                                +'<small class="sm">샤롯데 씨어터'+categoryNum+'</small> </h4>'
		                                +'<p class="event_txt_dsc">'
		                                +data[categoryNum].event
		                                +' </p> </div></a></li>';
							if(categoryNum%2===0){
								$('.lst_event_box:eq(0)').append(item);	
							}else{
								$('.lst_event_box:eq(1)').append(item);	
							}			
							categoryNum++;
						});	
					}else{
					//	console.log("list empty");
						var item = 	'<li class="item">'
							+'<a href="#" class="item_book">'
							+'<div class="item_preview">'
							+'<div class="event_txt">'
	                        +'<h4 class="event_txt_tit"> '
	                        +'<span>'+'해당 카테고리에 맞는 목록이 없습니다.'+'</span>'
	                        +'</div></a></li>';
						$('.lst_event_box:eq(0)').append(item);	
					}
				},
			});
		},
		//기본 전체 목록 조회 
		//getProductListByCategory(getPlistUrl, categoryId, num);
		//기본 전체 목록 카운트조회 
		//getCountProductList(bottomUrl, 1);
		
		//특정 카테고리 상품의 count조회 
		getCountProductList : function (getProductListUrl, categoryId){
			$.ajax({
				method:"GET",
				url: getProductListUrl,
				data : {categoryId:categoryId},
				success:function(res){
					$('.event_lst_txt > .pink').text(res+"개");	
				}
			});
		},
	
		//category click event
		categorySelect : $('.event_tab_lst.tab_lst_min').on("click", ".item", function(event){
				num=10; //init
				$('.event_tab_lst.tab_lst_min .anchor').removeClass('active');
				$(this).find('.anchor').addClass('active');
				categoryId = $(this).data('category');	
				console.log(categoryId);
				console.log(spec2.getPlistUrl);
				console.log(num);
				
				categoryProductList.getProductListByCategory(spec2.getPlistUrl, categoryId, num); 
				categoryProductList.getCountProductList(spec2.bottomUrl, categoryId);	
			}).bind(num).bind(categoryId),
		
		//더보기 버튼 이벤트 
		seeMore : $('.more').on("click", ".btn", function(){
			num+=10;	
			categoryProductList.getProductListByCategory(spec2.getPlistUrl, categoryId, num); 
		}).bind(num),
	}
})();

categoryProductList.initParam(spec2);
categoryProductList.getProductListByCategory(spec2.getPlistUrl, spec2.cId, spec2.num);
categoryProductList.getCountProductList(spec2.bottomUrl, spec2.cId);