var spec2 = {
	 getPlistUrl : '/bottom/category',
	 bottomUrl : '/bottom',
	 num : 10,
	 cId : 1, 
}

var categoryProductList = (function (spec, cId, number){
	//private
	var categoryId =spec.cId; 	
	var num = spec.number;
	//public 
	return {
		initParam : function (spec){
			num = spec.num;
			categoryId = spec.cId;
		},
		//상품 리스트 가져오기get
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
						console.log(data);
						var source = $("#category-product-entry-template").html();
						var template=Handlebars.compile(source);
						for(var i=0; i<data.length; i++){
							var obj=template(data[i]);
							//console.log(obj);
							if(i%2===0){
								$('.lst_event_box:eq(0)').append(obj);
							}else{
								$('.lst_event_box:eq(1)').append(obj);
							}
						}
					}else{
						var source = $("#empty-category-product-entry-template").html();
						var template=Handlebars.compile(source);
						var obj = template();
						$('.lst_event_box:eq(0)').append(obj);	
					}
				},
				error:function(data){
					alert("ajax failed");
				}
			});
		},
		//
	
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
				categoryProductList.getProductListByCategory(spec2.getPlistUrl, categoryId, num); 
				categoryProductList.getCountProductList(spec2.bottomUrl, categoryId);	
			}).bind(num).bind(categoryId),
		
		//더보기 버튼 이벤트 
		seeMore : $('.more').on("click", ".btn", function(){
			num+=10;	
			categoryProductList.getProductListByCategory(spec2.getPlistUrl, categoryId, num); 
		}).bind(num),
		
		seeMoreScroll : $(window).scroll(function(){
			var $current = $(window);
			var $mazinoLine =$(document).height();
			if($mazinoLine - $current.height() <= $current.scrollTop()){
				num+=10;	
				//console.log("scroll");
				categoryProductList.getProductListByCategory(spec2.getPlistUrl, categoryId, num); 
			}
		}),
		
		
	}
})();

categoryProductList.initParam(spec2);
categoryProductList.getProductListByCategory(spec2.getPlistUrl, spec2.cId, spec2.num);
categoryProductList.getCountProductList(spec2.bottomUrl, spec2.cId);