var spec={
	 categoryUrl:'/home'
}

var mainCategory=(function (spec){
	//private
	var slideIndex = 1;
	var size = $('ul.visual_img > li').outerWidth(); //338 px
	var listSize =$('ul.visual_img >li.item').length; //전체 프로모션 개수
	var timer =null;
	var len;
	
	plusSlides = function () {
		  slideIndex +=1;
		  if(slideIndex > listSize){
			  slideIndex =1;
		  }
		  if(slideIndex <1){
			  slideIndex=listSize;
		  }
		  len = ((slideIndex-1)*size);
		  slideShow(len);
	};
	
	// button slide
	manualSlide = function (n) {
		  slideIndex +=n;
		  if(slideIndex > listSize){
			  slideIndex =1;
		  }
		  if(slideIndex <1){
			  slideIndex=listSize;
		  }
		  var len = ((slideIndex-1)*size);
		  slideShow(len);
	};
	
	slideShow = function (length){
			$('ul.visual_img').animate({"margin-left": -length},1000);
	};
	
	autoSlide = function (){
		clearInterval(timer);
		timer=setInterval(plusSlides, 2000);
	};
	//public
	return{
		startSlide : function (){
			autoSlide();
		},
		getCategoryList : function (getListUrl){
			$.ajax({
				method:"GET",
				url:getListUrl,
				success:function(data){				
					var source = $("#category-entry-template").html();
					var template=Handlebars.compile(source);
					for(var i=0; i<data.length; i++){
						var obj=template(data[i]);
						$('.section_event_tab > ul').append(obj);
					}
					$('.event_tab_lst li:last-child').find('.anchor').addClass('last');
				},
			});
		},
		//버튼 이벤트 처리 
		nextBtn :  function(){ $('.btn_nxt_e').off("click").on("click",  function(event){	
				event.stopPropagation();
				clearInterval(timer);
				manualSlide(1);
				setTimeout(autoSlide, 2000);
			}).bind(slideIndex);
		},
		
		prevBtn : function(){ $('.btn_pre_e').off("click").on("click",  function(event){
				event.stopPropagation();
				clearInterval(timer);
				manualSlide(-1);
				setTimeout(autoSlide, 2000);
			}).bind(slideIndex);
		},

		//나중에 event.js로 이관	
		//예약 버튼 누르면 main페이지 이동
		reservLogoButton : $('.logo').on("click", ".ico_bk_logo", function(e){
			location.href="/";
		}),
		//네이버 버튼 
		naverLogoButton : $('.logo').on("click", ".ico_n_logo",function(e){
			location.href="https://m.naver.com";
		}),
		//my reservationPage
		myReservButton : $('.btn_my ').on("click",  function(e){
			location.href="/login/api/Oauth";
		}),
		//프로모션에서 세부 페이지 이동 일단 default페이지로 이동한다. 
		detailButton : $('.visual_img').on("click",".event_txt_tit", function(e){
			location.href="/detaildefault";
		}),
		detailButton2 :  $('.visual_img').on("click",".event_txt_dsc", function(e){
			location.href="/detaildefault";
			
		}),
		
		
		//하단 리스트 목록 클릭시 그 리스트의 세부 페이지로 이동 
		bizesButton :  $('.wrap_event_box').on("click", ".item_book", function(e){
			console.log(location.href);
			var productId = $(this).attr('clickId');
			console.log(productId);
			location.href="/booking/bizes/"+productId;
		}),
	};
})();

mainCategory.getCategoryList(spec.categoryUrl);
mainCategory.startSlide();
mainCategory.nextBtn();
mainCategory.prevBtn();