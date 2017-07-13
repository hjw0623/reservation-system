var hero = aHero();
var newSaga = function(){
	log(hero);
	var foil = aFoil();
	console.log("newSaga");
	/*
	lexical scope
	hero : global scope can be accessed inside newSaga
	newSaga : itself is also in global scope.
	foil :  is in the scope of the function body, so it can be accessed, too
	*/
	var saga = function(){
		console.log("saga");
		var deed = aDeed();
		log(hero+deed+foil);
	};
	saga();
	saga();
};
//log(foil); //cause erro
newSaga();
newSaga();
