 (function (){
 	console.log("detailappjs");
 	console.log(location);
 	//lazy loading
 	$(window).scroll(function(){
			var $current = $(window);
			var $mazinoLine =$(document).height();
			console.log($mazinoLine - $current.height() );
			console.log("right: "+$current.scrollTop());
			if($mazinoLine - $current.height() <= $current.scrollTop()*3){
		//		console.log("kk");
				var imgsrc = $('.in_img_lst').find('[data-lazy-image]').attr('data-lazy-image');
				$('.in_img_lst').find('[data-lazy-image]').attr("src",imgsrc);
				$('.in_img_lst').find('[data-lazy-image]').removeAttr("data-lazy-image");
			}
	})
 })();