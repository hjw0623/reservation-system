(function (window){
	var apiURL = '/category/api';
	//var URL = '/category';
	
	function CategoryObj(id, name){
		this.id = id;
		this.name = name;
	}
	//update event handler
	$('.category-List').on("click", ".modify", function(event){
		var id = $(this).get(0).id;
		var name = $('.mod_name'+id).val();
		var updateUrl = apiURL+'/'+id;
		var category = new CategoryObj(id, name);
		//console.log(category);
		if(category.name==""||category.name.length<2){
			alert("수정할 이름을 최소 2자 입력해주세요");
			return; //retur 시 아래 조건문이 필요가 없다.
		}
		if(category.name!=""&& category["name"].length>=2){
			// var jsonData = JSON.stringify(category); //응집성 측면에서 doUpdate안에 넣어주자.
			//doUpdate(updateUrl, category);
		}
		doUpdate(updateUrl, category);
	})
	
	//update function
	function doUpdate(updateUrl, category){
		var jsonData = JSON.stringify(category);
		$.ajax({
			method:"PUT",
			url:updateUrl,
			data:jsonData,
			headers:{
					"Content-Type":"application/json"
			},
			success:function(){
				$('.display'+category["id"]).text(category["name"]);
			}
		});
	}
	//delete event handler
	$('.category-List').on("click", ".delete", function(event){
		//alert("delete button clicked ");
		var deleteId = $(this).get(0).id;
		var deleteUrl = apiURL+'/'+deleteId;
		 doDelete(deleteUrl, deleteId);
	})

	//delete function
	function doDelete(deleteUrl, id){
		 $.ajax({
			type:'DELETE',
			url:deleteUrl,
			success: function(){
				console.log("delete success");
				$('.'+id).remove();
			}
		});
	 
	}
})(window);