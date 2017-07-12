(function (){
	
	var categoryUrl='/home';
	//카테고리 조회 
	function getCategoryList(getListUrl){
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
	}
	getCategoryList(categoryUrl);
	
//$('ul.visual_img').animate({"margin-left": -676});
	var slideIndex = 1;
	//배너 그림 가로 크기 
	var size = $('ul.visual_img > li').outerWidth(); //338 px
	var listSize =$('ul.visual_img >li.item').length; //전체 프로모션 개수 
	console.log("list size:"+listSize);
	
	var timer =null;
	
	autoSlide();
	//auto slide
	function autoSlide(){
		clearInterval(timer);
		timer=setInterval(plusSlides, 2000);
	}
	function plusSlides() {
		  slideIndex +=1;
		  if(slideIndex > listSize){
			  slideIndex =1;
		  }
		  if(slideIndex <1){
			  slideIndex=listSize;
		  }
		  var len = ((slideIndex-1)*size);
		  slideShow(len);
	}
	
	//global variable
	auto = true;
	// button slide
	function manualSlide(n) {
		  slideIndex +=n;
		  if(slideIndex > listSize){
			  slideIndex =1;
		  }
		  if(slideIndex <1){
			  slideIndex=listSize;
		  }
		  var len = ((slideIndex-1)*size);
		  slideShow(len);
		
	}

	//슬라이드 쇼 with animate
	function slideShow(length){
		if(auto){
			$('ul.visual_img').animate({"margin-left": -length},1000);
		}
		else{console.log("still working");}
		var state = $('ul.visual_img').css("margin-left");
		
	}	
	//버튼 이벤트 처리 
	$('.btn_nxt_e').unbind("click").bind("click",  function(event){	
		event.stopPropagation();
		clearInterval(timer);
		manualSlide(1);
		setTimeout(autoSlide, 2000);
	});
	$('.btn_pre_e').unbind("click").bind("click",  function(event){
		event.stopPropagation();
		clearInterval(timer);
		manualSlide(-1);
		setTimeout(autoSlide, 2000);
	});
	
	//예약 버튼 누르면 main페이지 이동
	$('.logo').on("click", ".ico_bk_logo", function(e){
		location.href="/";
	});
	
	//네이버 버튼 
	$('.logo').on("click", ".ico_n_logo",function(e){
		location.href="https://m.naver.com";
	});
	
	$('.visual_img').on("click",".event_txt_tit", function(e){
		location.href="/detail";
	});
	$('.visual_img').on("click",".event_txt_dsc", function(e){
		location.href="/detail";
	});
	//my reservationPage
	$('.header_tit ').on("click", ".btn_my", function(e){
		location.href="/my";
	});
	
}) ();