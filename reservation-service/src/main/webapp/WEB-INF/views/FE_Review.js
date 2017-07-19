//FE lecture sample code

var template = Handlebars.compile(html);
template({
	a:1,
	b:2,
}); //html

function addTodo(data){
	var template = Handlebars.compile(todo);
	$("#li").append(template(data));
}
//--------
//6번

//A. 아래와 같은 경우는 어색하다.
var category;
$(function(){
	category = categorylist();
})
//
//--모듈화를 다음과 같이 개선하고 
var categorylist = (function(){
	var curruntCategoryId = 0;
	function init(){
		$('ul.event_tab_lst').on('click', 'li.item', categorylist.viewProductByCategory);
		$('ul.event_tab_lst').on('click', 'li.item', categorylist.updateCount);
		$('ul.lst_event_box').on('click', 'li.item', function(event){
			event.preventDefault();
			event.stopPropagation();
			
			var id = $(this).data('id');
			var baseUrl = 'http://localhost:8080';
			var url = baseUrl + '/product/detail/' + id;
			window.location.href = url;
		});
		
	
		function viewProductByCategory (event){
			
		},
		
		function viewMoreProductList (event){
			
		}, 
		
		function updateCount (event){

		}, 
		
		function scrollViewMoreProductList (){
				scrollViewMoreProductList: scrollViewMoreProductList
		}
		//외부 노출할 함수만 return 내에 작성
		return {
			init:init,
			scrollViewMoreProductList: scrollViewMoreProductList
		}
	}
});

//B. 이게 A 보다 낫다.
$(function(){
	categorylist.init();
})



//------------------
// component
	<script type="text/javascript" src="../dist/component.js"></script>
	<script type="text/javascript">
	var Test = {
			"a": function(){
				return "1";
			}
	}
	Test.prototype.increment = function(){
		this.a++;
	}
	Test.prototype.some(){
		return this.a;
	}

	var test = new Test();
	test.increment();
	test.some(); //2 

	var test2 = new Test();
	test2.increment();
	test2.some();//2

	function Rectangle(){
	}
	Rectangle.prototype = new eg.Component(); //egjs의 컴포넌트의 메소드를 Rectangle에서 구현하지 않아도 쓸 수 있다.
	Rectangle.prototype.constructor = Rectangle;

	Rectangle.prototype.some = function(){
		console.log("a");
	}
	var a = new Rectangle();
	//a.some();
	a.on("click", function(){
		console.log("aa");
	})

	</script>
	</body>
	</html>


//--extends를 활용

var a = new Checkbox("test");
//a.some();
a.on("checked", function(){
	
})



//===============
//FE 리뷰 

var Person = (function(){

	return function (name, age){
		//메모리상태 1
		return {
			intro: function (){					
				console.log(name, age); 
			}
		}
	}
}());

var john = Person('John', 30);
var jane = Person('Jane', 30);
john.intro();
jane.intro();

var Person2 = (function(){
	var obj = {key:value, key2:value2};
	return function (name, age){
		//메모리상태 1
		return {
			name: "terminator", //객체는 스코프체인을 타고가지 못한다.
			age: 123,
			intro: function (){					
				console.log(name, age); 
				console.log(this.name, this.age); 
			}
		}
	}
}());
//즉 위는 아래와 같다.
var ret = {};
ret.name = "terminator";
ret.age =123;
ret.intro =function(){

}
//======
//bind를 응용하여 다음과 같이 생성자 함수를 만들 수 있다. 
//이 때, Person은 그대로고, Man이라는 새로운 함수에 그 결과가 반영된다.
var Person = (function(){
	return function (sex, name, age){
	}
}());


var Man = Person.bind(null, 'M'); //bind의 첫 인자는 this. 자리가 선점된 새 함수로 Man을 만든다.
var man1 = Man('John', 30);
var man2 = Person.bind(null, 'M')('John', 30); 

var john = Person('M', 'John', 30);



//function declaration --권장 -- 순서에 덜 민감. 호이스팅해준다.
function foo(){

}

//function literal --구 버전에도 호환이 잘 안된다.
//var foo;
//var bar;
var foo = function(){
	bar(); //함수입장에서 bar는 undefined
}
foo();//error
var foo = function(){}

//변수에는 값 혹은 객체 혹은 함수가 들어갈 수 있다.