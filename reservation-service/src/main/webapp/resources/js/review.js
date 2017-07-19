(function (){
 	var detailUrl = '/booking/bizes';
 	var imgUrl = detailUrl+'/image';
 	var countUrl = detailUrl+'/count';
 	var productInfoUrl= detailUrl+'/info';
 	var productDetailUrl = detailUrl+'/pdetail';
 	var displayUrl = detailUrl+'/display';
 	var commentUrl = detailUrl+'/comment';
 	var avgUrl = detailUrl+'/avgscore';
 	var countCommentUrl = detailUrl+'/commentnum';
 	var reviewsUrl = detailUrl+'/reviewMore';

	var urlParsing = location.href.replace(/[^(\/a-zA-Z0-9)]/gi,"").split('/');
 	var id = urlParsing[urlParsing.length-1];
 	console.log("id:"+id);
 	//예매자 한줄평 더 보기 페이지 (review.jsp)
	function getReviewAll(getReviewUrl, id){
		$.ajax({
			method:"GET",
			url:getReviewUrl+'/reviews'+'?id='+id,
//			data:{id:id},
			success:function(data){
				console.log(data);
				var idx = 0;
				$.each(data, function(){
					var userNameInitial = data[idx].userName;
					userNameInitial = userNameInitial.substring(0,4)+"****";
					var date = data[idx].create_date.split('-');
					if(date[1]<10) date[1] = date[1]%10;
					var visit = date[0]+'.'+date[1]+'.'+date[2]+'.'+' 방문';
					var item = '<li class="list_item"><div> <div class="review_area">'
                               +'<div class="thumb_area">'
                               +'</div>'
                               +'<h4 class="resoc_name">'+data[idx].productName+'</h4>'
                               +'<p class="review">'+data[idx].comment+'</p>'
                               +'</div> <div class="info_area">'
                               +'<div class="review_info"> <span class="grade">'+data[idx].score+'</span>'
                               +'<span class="name">'+userNameInitial+'</span> <span class="date">'+visit+'</span> '
                               +'</div> </div> </div> </li>'
                    $('.list_short_review').append(item);

                    if(data[idx].imgList.length!=0){
						var imgItem = '<a href="#" class="thumb" title="이미지 크게 보기"> '
						+'<img width="90" height="90" class="img_vertical_top" src="'
						+'/imgresources'+data[idx].imgList[0].save_file_name  +'" alt="리뷰이미지"> '
						+'</a><span class="img_count">'+data[idx].imgList.length+'</span> '
						$('.list_item').find('.thumb_area').append(imgItem);
					}
                    idx++;
				});

				$('.review_header').find('.btn_back').attr("href",detailUrl+'/'+id);
			}
		});
	};
	getReviewAll(reviewsUrl, id);
	
	//평균 구하기
	function getAverageScore(getAvgUrl, id){
		$.ajax({
			method:"GET",
			url:getAvgUrl,
			data:{id,id},
			success:function(data){
				console.log("avgscore");
				console.log(data);

				$('.grade_area').find('.text_value > span').text(data);//.val();
				var graphBar = (data * 20)+"%" ;
				$('.grade_area').find('.graph_value').css("width", graphBar);
			}
		});
	};
	//전체 코멘트
	function getCountComment(getCntUrl, id){
		$.ajax({
			method:"GET",
			url:getCntUrl,
			data:{id,id},
			success:function(data){
				$('.grade_area').find('.join_count > em').text(data+"건").val();
				$('.btn_review_more').attr("href",detailUrl+"/reviewMore/"+id);
				if(data<=3){
					$('.section_review_list').find('.btn_review_more').addClass('hide');
				}
			}
		});
	};
	getAverageScore(avgUrl, id);
	getCountComment(countCommentUrl,id);

 })();