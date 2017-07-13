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
		  console.log("prev Idx :"+slideIndex);

		  slideIndex +=1;
		//  console.log(slideIndex);
		  if(slideIndex > listSize){
			  slideIndex =1;
		  }
		  if(slideIndex <1){
			  slideIndex=listSize;
		  }
		  len = ((slideIndex-1)*size);
		  console.log("next Idx :"+slideIndex);
		  console.log("len :"+len);

		  slideShow(len);
	};
	
	// button slide
	manualSlide = function (n) {
		console.log("n: "+ slideIndex);
		console.log("len: "+len);
		
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
					var categoryNum = 0;
					//console.log(data);
					$.each( data, function(){
						var item = '<li class="item" data-category="'+data[categoryNum].id+'">'
								+'<a class="anchor">'
								+'<span>'+data[categoryNum].name+'</span></a>'
								+'</li>';
						$('.section_event_tab > ul').append(item);
						categoryNum++;
					});
					$('.event_tab_lst li:last-child').find('.anchor').addClass('last');
				},
			});
		},
	
		//버튼 이벤트 처리 
		next :  function(){ $('.btn_nxt_e').off("click").on("click",  function(event){	
				event.stopPropagation();
				clearInterval(timer);
				manualSlide(1);
				setTimeout(autoSlide, 2000);
			}).bind(slideIndex);
		},
		
		prev : function(){ $('.btn_pre_e').off("click").on("click",  function(event){
				event.stopPropagation();
				clearInterval(timer);
				manualSlide(-1);
				setTimeout(autoSlide, 2000);
			}).bind(slideIndex);
		},
		//예약 버튼 누르면 main페이지 이동
		reservLogoButton : $('.logo').on("click", ".ico_bk_logo", function(e){
			location.href="/";
		}),
		
		//네이버 버튼 
		naverLogoButton : $('.logo').on("click", ".ico_n_logo",function(e){
			location.href="https://m.naver.com";
		}),
		
		detailButton : $('.visual_img').on("click",".event_txt_tit", function(e){
			location.href="/detail";
		}),
		detailButton2 :  $('.visual_img').on("click",".event_txt_dsc", function(e){
			location.href="/detail";
		}),
		//my reservationPage
		myReservButton : $('.header_tit ').on("click", ".btn_my", function(e){
			location.href="/my";
		})
	};
})(spec);

mainCategory.getCategoryList(spec.categoryUrl);
mainCategory.startSlide();
mainCategory.next();
mainCategory.prev();