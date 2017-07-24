/**

이미지 DB 저장용 Form 페이지 위한 스크립트
*/
(function (){
	var getProductList = '/bottom/all';
	var num = 1;
	function getProductListAll(getListUrl){

		$.ajax({
			method:"GET",
			url : getListUrl,
			success: function(data){
			//	console.log(data[0]);			
				var idx =0;
				var select = $('#product-List');
				$.each(data, function(){
					var item = '<option value="'+data[idx].id+'"'+'productName="'+data[idx].name+'">'+data[idx].description+'</option>';
					select.append(item);
					idx++;
				});
			}
		});

		//버튼 추가.
		$('.add-input').on("click", function(){
			console.log($('#input_'));
			var item = '<br><br><input type="file" name="file" id="input_">';
			console.log(item);
			$('#input_').after(item);
			num++;
		});
	};


	getProductListAll(getProductList);


})();