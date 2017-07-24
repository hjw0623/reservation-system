/*
(function (){

	function Rectangle(){}
	Rectangle.prototype = new eg.Component();
	Rectangle.prototype.constructor = Rectangle;
	Rectangle.prototype.some = function(){
		console.log("a");
	}

	var rt = new Rectangle();
	rt.some();
	rt.on("click", function(){
		console.log("event calling")
	});
	rt.trigger('click');
})();
*/

window.onload = function(){
	function Some(){

	}
	Some.prototype = new eg.Component(); //extends
	Some.prototype.constructor = Some;
	Some.prototype.foo = function(){
		this.trigger("hi");// fire hi event.
	}

	var some = new Some();

	function desc(str) {
		document.getElementById('desc').innerText = str;
	}
	function desc2(str) {
		document.getElementById('desc2').innerText = str;
	}
	var count = 0;
	function fired(){
		count++;
		desc2(count+" fired hi event");
	}

	document.getElementById('btn_trigger').addEventListener("click",function(e) {
		e.preventDefault();
		some.foo();
		desc("'hi' event trigger.");
	});

	document.getElementById('btn_attach').addEventListener("click",function(e) {
		e.preventDefault();
		some.on("hi",fired);
		desc("'hi' event on.");
	});

	document.getElementById('btn_detach').addEventListener("click",function(e) {
		e.preventDefault();
		some.off("hi",fired);
		desc("'hi' event off.");
	});
}
