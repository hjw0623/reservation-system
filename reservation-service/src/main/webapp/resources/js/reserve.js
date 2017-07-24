(function (){
	var locUrl = location.href;
	var forDelete = 'http://localhost:8080';

	var currentUrl = locUrl.substring(forDelete.length, locUrl.length);
	//console.log(currentUrl);
	var userUrl = currentUrl+"/userinfo";
	var getPriceUrl = currentUrl+'/priceinfo';
	var getProductUrl= location.href+'/productinfo';
	var getImagesUrl = currentUrl+'/images';
	var displayUrl = currentUrl+'/displayinfo';
	var week = new Array('(일)', '(월)', '(화)', '(수)', '(목)', '(금)', '(토)');
	var priceCategory = new Array('일반', '청소년', '유아');
	var priceCategoryCount = [0,0,0];
	console.log(priceCategoryCount);
	var priceLength=0;
	var reservationUrl = currentUrl+'/reservation';
	var productId = 0;
	var userId = 0;
	function getUserInfo(getUserUrl){
	 	$.ajax({
	 		method:"GET",
	 		url:getUserUrl,
	 		success:function(data){
	 			console.log(data);
	 			//예매자 이름 
	 			$('.section_booking_form').find('.inline_form').eq(0).find('.inline_control > input').val(data.username);
	 			$('.section_booking_form').find('.inline_form').eq(2).find('.inline_control > input').val(data.email);
	 			userId = data.userId;
	 		}
	 	})
	};
	getUserInfo(userUrl);

	console.log("====product info ======");
	function getProductInfo(getProductUrl){
		$.ajax({
			method:"GET",
			url:getProductUrl,
			success:function(data){
				$('.top_title').find('.title').text(data.name);
				$('.group_visual').find('.preview_txt_tit').text(data.name);
				productId = data.productId;		
			},
		});
	};

	function getDisplayInfo(getDisplayInfoUrl){
		$.ajax({
 			method:"GET",
 			url:getDisplayInfoUrl,
			success:function(data){
				
				var start = new Date(data.displayStart).getDay();
				var startLabel = week[start];
				var end  = new Date(data.displayEnd).getDay();
				var endLabel = week[end];
				var item = '장소 : '+data.placeStreet+'<br>('+data.placeName+')<br>'
							+'기간 : '+data.displayStart+startLabel+'~'+data.displayEnd+endLabel;
				var $locationInfo = $('.section_store_details').find('.dsc').eq(0).html(item);     
				//기간정보 
				$('.group_visual').find('.preview_txt_dsc').eq(1).html(item);       
			},
 		});
	};
	getDisplayInfo(displayUrl);

	//가격정보 가져오기 
	function getPriceList(getPriceUrl){
		$.ajax({
			method:"GET",
			url:getPriceUrl,
			success:function(data){
				console.log("price list=======");
				console.log(data);
				var idx =0;
				priceLength = data.length;
				$.each(data, function(){
					var priceItem =  '<div class="qty">'
                         			+'<div class="count_control">'
                                	+'<div class="clearfix">'
                                    +'<a href="#" class="btn_plus_minus spr_book2 ico_minus3 disabled" title="빼기"> </a> '
                                    +'<input type="tel" class="count_control_input" value="0" readonly title="수량">'
                                    +'<a href="#" class="btn_plus_minus spr_book2 ico_plus3" title="더하기"> </a>'
                               		+'</div>'
                           			+'<div class="individual_price "><span class="total_price">'
                           			+ '0</span><span class="price_type">원</span>'
                           			+'</div>'
		                            +'</div>'
		                            +'<div class="qty_info_icon">'
		                            +' <strong class="product_amount"><span>'+priceCategory[data[idx].priceType -1]+'</span> </strong>'
		                            +' <strong class="product_price"><span class="price">'+data[idx].price+'</span> <span class="price_type">원</span> </strong>'
		                            +' <em class="product_dsc">'+data[idx].price+'원 ('+data[idx].discountRate*100+'% 할인가)</em> </div>'
                        			+'</div>';

					$('.section_booking_ticket').find('.ticket_body').append(priceItem);
					idx++;
				});
			}
		})
	}
	getPriceList(getPriceUrl);

	
	//이미지 모두 불러오기.
	function getProductImageList(getImagesUrl, getProductUrl){
		$.ajax({
			method:"GET",
			url: getImagesUrl,
			success: function(data){
				var idx =0;
				listSize = data.length;	
				console.log(data);
				$('.container_visual').css("width", 414+"px");
				$.each(data, function(){
					var item = '<li class="item" style="width: 414px;"> '
								+'<img alt="" class="img_thumb" src="'+'/imgresources'+data[idx].saveFileName 
								+'" > <span class="img_bg"></span>'
								+'<div class="preview_txt">'
	                            +'<h2 class="preview_txt_tit"></h2>'
	                            +'<em class="preview_txt_dsc"></em>'
	                            +'<em class="preview_txt_dsc"></em>'
                                +'</div>'
                                +'</li>'
                    $('.container_visual').find('.visual_img').append(item);
                    //<!-- [D] 첫 이미지 이면 off 클래스 추가 -->
                    
                  	idx++;
                  	/*
  					$('.btn_prev').find('.spr_book2.ico_arr6_lt').addClass('off');

                    if(data.length===1){
                    	//console.log('length is : 1');
                    	$('.group_visual').find('.prev').remove();
                    	$('.group_visual').find('.nxt').remove();
                    }*/
				});
			},
			error:function(data){
					alert("failed to load images ");
			}	

		});
		getProductInfo(getProductUrl);

	};
	getProductImageList(getImagesUrl, getProductUrl);

	//이벤트 

	//이용자 약관 전체 동의 
	$('.section_booking_agreement').find('.agreement.all').on("click", '.chk_txt_label', function(event){
		console.log("check");
		if($('.section_booking_agreement').find('.chk_agree').is(":checked")){
		//	console.log("true -> false");
			$('.section_booking_agreement').find('.chk_agree').attr("checked", false);
			//$('.ct_wrap > .box_bk_btn').find('.bk_btn_wrap').addClass("disable");

		}else{
		//	console.log("false->true");
			$('.section_booking_agreement').find('.chk_agree').attr("checked", true);
			//$('.ct_wrap > .box_bk_btn').find('.bk_btn_wrap').removeClass("disable");
		}
	});
	//약관 펼쳐보기 
	$('.section_booking_agreement').find('.agreement').on("click", '.btn_agreement', function(event){
		if($(this.closest('.agreement')).hasClass("open")){
			$(this.closest('.agreement')).removeClass("open");
		}else{
			$(this.closest('.agreement')).addClass("open");
		}
		event.preventDefault();

	});
	// + 버튼 이벤트 처리
	$('.section_booking_ticket').on("click", ".ico_plus3", function(event){
		event.preventDefault();
		//바로 이전 노드
		var $eachBarMenu = $(this).prev();
		var currentValue =	$eachBarMenu.val()-0;
		//console.log("curVal : "+currentValue);
		$eachBarMenu.val(currentValue+1);
		if($eachBarMenu.val()-0 >0){
			$eachBarMenu.prev().removeClass("disabled");
			$(this).closest('.count_control').find('.individual_price').addClass('on_color');
		}
		var $value = $(this).prev().val();
		var $price = $(this).closest('.qty').find('.price').text()-0;
		var eachSum = $price * $value;
		//console.log("each sum : "+ eachSum);
		$(this).closest('.qty').find('.total_price').text(eachSum).val();
		$(this).prev().trigger('change');
	});
	//  - 버튼 처리
	$('.section_booking_ticket').on("click", ".ico_minus3", function(event){
		event.preventDefault();
		var $eachBarMenu = $(this).next();
		var currentValue =	$eachBarMenu.val()-0;
		//console.log("curVal : "+currentValue);
		if($eachBarMenu.val()-0 >0){
			$eachBarMenu.val(currentValue-1);
			//수량이 0이라면 
			if($eachBarMenu.val()-0 ==0){
				$eachBarMenu.prev().addClass("disabled");
				$(this).closest('.count_control').find('.individual_price').removeClass('on_color');
			}
			var $value = $(this).next().val();
			var $price = $(this).closest('.qty').find('.price').text()-0;
			var eachSum = $price * $value;
			$(this).closest('.qty').find('.total_price').text(eachSum).val();
		}
		$(this).next().trigger('change');
	});

	//총 0매
	$('.section_booking_ticket').change( function(event){
 		//console.log("changed");
 		var reservationInfo ="";
 		var totalCount = 0;
 		for(var i=0; i<priceLength; i++){
 			var $regionalSum = $('.ticket_body').find('.qty').eq(i).find('.count_control_input').val() -0;
 			var $priceCategory = $('.ticket_body').find('.qty').eq(i).find('.product_amount > span').text();
 			if($regionalSum>0){
 				totalCount += $regionalSum;
 				reservationInfo = reservationInfo+$priceCategory+"("+$regionalSum+"),";
 			}
 		}
 		reservationInfo = "총 "+totalCount+"매 - "+reservationInfo;
 		$('.section_booking_form').find('.last').find('.inline_txt.selected').text(reservationInfo);
	});

	//email 유효성 검사	
	function checkEmailValidation(email){
		var regex=/([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
    	return (email !== '' && email !== 'undefined' && regex.test(email)); 
	}
	//연락처 유효성 검사
	function checkPhoneValidation(phone){
		var regex = /^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$/;
		return (phone !=='' && phone !=='undefined' && regex.test(phone));
	}

	function checkNameValidation(name){
		return (name !='' && name !='undefined');
	}
	function checkCountValidation(){
		var totalCount = 0;
 		for(var i=0; i<priceLength; i++){
 			var $regionalSum = $('.ticket_body').find('.qty').eq(i).find('.count_control_input').val() -0;
 			if($regionalSum>0){
 				totalCount += $regionalSum;
 			}
 		}
 		if(totalCount>0){
 			return true;
 		}
 		else {
 			return false;
 		}
	}
	//유효성 검사 
	$('.ct_wrap').change(function(event){
		var $name = $('.section_booking_form').find('input[name=name]').val();
		var checkName = checkNameValidation($name);
		//console.log(checkName);

		var $tel = $('.section_booking_form').find('input[name=tel]').val();
		var checkPhone = checkPhoneValidation($tel);
		//console.log(checkPhone);

		var $email = $('.section_booking_form').find('input[name=email]').val();
		var checkEmail = checkEmailValidation($email);
		//console.log(checkEmail);

		var checkValidCount = checkCountValidation();
		//console.log("countCheck: "+checkValidCount);
		var agreement = $('.section_booking_agreement').find('.chk_agree').is(":checked");
		//console.log("약관동의 : "+agreement);

		if(checkName&&checkPhone&&checkEmail&&checkValidCount&&agreement){
			$('.ct_wrap > .box_bk_btn').find('.bk_btn_wrap').removeClass("disable");
		}else{
			$('.ct_wrap > .box_bk_btn').find('.bk_btn_wrap').addClass("disable");
		}	

	});

	//예약하기 버튼 이벤트 
	var preventDuplicate = false;
	$('.box_bk_btn').on("click", '.bk_btn', function(event){
		if($('.bk_btn_wrap').hasClass('disable')){
			console.log("입력 정보가 유효하지 않습니다.");
		}else{
			//Object 생성
			var $name = $('.section_booking_form').find('input[name=name]').val();
			var $tel = $('.section_booking_form').find('input[name=tel]').val();
			var $email = $('.section_booking_form').find('input[name=email]').val();
			if(!preventDuplicate){
				for(var i=0; i <priceLength; i++){
					var priceName = $('.ticket_body').find('.qty').eq(i).find('.product_amount >span').text();
					var amount  = $('.ticket_body').find('.qty').eq(i).find('.count_control_input').val();
					if(priceName===priceCategory[i]){
						priceCategoryCount[i] = (priceCategoryCount[i]-0)+(amount-0);	
					}
				}
			}
			preventDuplicate=true;
			var reservationObj = new ReservationObj( priceCategoryCount[0], priceCategoryCount[1],
				 									priceCategoryCount[2],  $name,$tel,$email,"2017-07-24" );
			console.log(reservationObj);

			//reservation insert
			makeReservation(reservationUrl, reservationObj );
		}
	});
	function ReservationObj( gTC, yTC, cTC, name, tel, email, date, type){
		this.id = 0;
		this.productId = 0;
		this.userId = 0;
		this.generalTicketCount = gTC;
		this.youthTicketCount = yTC;
		this.childTicketCount = cTC;
		this.reservationName = name;
		this.reservationTel = tel;
		this.reservationEmail = email;
		this.reservationDate = date;
		this.reservationType = 0;
	};

	function makeReservation(reservationUrl, ReservationObj ){
		$.ajax({
			method:"POST",
			url:reservationUrl,
			data: JSON.stringify(ReservationObj),
			headers:{
					"Content-Type":"application/json"
			},
   			success:function(data){
   				console.log(data);
   				if(data.userId!==null ||data.userId!=='undefined'||data.userId!==0){
   					location.replace('/myreservation');
   				}
   				console.log("insert reservation success");
   				
   			},error:function(){
   				console.log(JSON.stringify(ReservationObj));
   			}
		})
	}
})();