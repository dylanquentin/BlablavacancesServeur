var valeurselectionnee;
var textselectionne;
var tmp;
var ulTest = document.createElement('ul');
ulTest.className = "list-group";


var boolSelect = true;
var boolQte = true;
var boolDateD = true;
var boolDateF = true;
var boolBudget = true;

var tabSelec = new Array();
var tabQte = new Array();
var tabDateD = new Array();
var tabDateF = new Array();
var tabBudget = new Array();

var tabRes = new Array();
var tabRes2 = new Array();
var tabRes3 = new Array();
var tabResF = new Array();


function listUsers() {
	listUsersGeneric("v1/voyages/");
}

function listUsersGeneric(url) {
	$.getJSON(url, function(data) {
		afficheListUsers(data)
	});
}

function afficheUser(data) {
	//console.log(data);
	$("#reponse").html(userStringify(data));
}

function afficheListUsers(data) {
	var ul = document.createElement('ul');
	ul.className = "list-group";
	var index = 0;
	for (index = 0; index < data.length; ++index) {
		var li = document.createElement('li');
		li.className = "list-group-item";
		li.innerHTML = userStringify(data[index]);
		//console.log(li);
		ul.appendChild(li);
	}
	$("#reponse").html(ul);
}

function userStringify(voyages) {
	return "nom du voyage = " + voyages.name + "|id du createur du voyage = " + voyages.idUser + "|destination = " + voyages.ville + "|description du voyage = " + voyages.description + "|date du depart = " + voyages.depart + "|date du retour = " + voyages.retour + "|nombre de participants = " + voyages.capacite + "|budget necessaire = " + voyages.budget;
}

function selection(){
	var selectElmt = document.getElementById("select");
	valeurselectionnee = selectElmt.options[selectElmt.selectedIndex].value;
	textselectionne = selectElmt.options[selectElmt.selectedIndex].text;
}

function listUsersTest() {
	listUsersGenericTest("v1/voyages/");
}

function listUsersGenericTest(url) {
	$.getJSON(url, function(data) {
		afficheListUsersTest(data)
	});
}

/*function afficheUserTest(data) {
	//console.log(data);
	$("#reponseTest").html(userStringifyTest(data));
}*/

function skipBouton1(){
	boolSelect = !boolSelect;
}

function skipBouton2(){
	boolDateD = !boolDateD;
}

function skipBouton3(){
	boolDateF = !boolDateF;
}

function skipBouton4(){
	boolQte = !boolQte;
}

function skipBouton5(){
	boolBudget = !boolBudget;
}
 
function clearListUsersTest(data) {
	$("#reponseTest").empty();
	while (ulTest.firstChild) {
    	ulTest.removeChild(ulTest.firstChild);
	}
	tabSelec.splice(0,tabRes.length+1);
	tabQte.splice(0,tabRes.length+1);
	tabDateD.splice(0,tabRes.length+1);
	tabDateF.splice(0,tabRes.length+1);
	tabBudget.splice(0,tabRes.length+1);
	
	tabRes.splice(0,tabRes.length+1);
	tabRes2.splice(0,tabRes.length+1);
	tabRes3.splice(0,tabRes.length+1);
	tabResF.splice(0,tabRes.length+1);
	
}

function afficheListUsersTest(data) {
	var selectElmt = document.getElementById("select");
	textselectionne = selectElmt.options[selectElmt.selectedIndex].text;
	var selectQte = document.getElementById("Qte de populace");
	textQte = selectQte.value;
	var selectDateD = document.getElementById("DateD");
	var selectDateF = document.getElementById("DateF");
	var selectBudget = document.getElementById("Budget");
	
	var index = 0;
	var index2 = 0;
	var index3 = 0;
	var index4 = 0;
	var index5 = 0;
	var index6 = 0;
	var index7 = 0;
	var index8 = 0;
	var index9 = 0;
	var index10 = 0;

		var tabSelec = new Array();
		var tabQte = new Array();
		var tabDateD = new Array();
		var tabDateF = new Array();
		var tabBudget = new Array();
	
	for (index = 0; index < data.length; ++index) {
		var tabResF = new Array();
		var tabRes = new Array();
		var tabRes2 = new Array();
		var tabRes3 = new Array();

		if (boolSelect == true){
			if (data[index].ville == textselectionne){
				tabSelec[index] = data[index];
				tabSelec = tabSelec.filter(function(n){ return n != undefined });
				console.log(tabSelec);
			}
		}
		if (boolQte == true){
			if (data[index].capacite == textQte){
				tabQte[index] = data[index];
				tabQte = tabQte.filter(function(n){ return n != undefined });
				console.log(tabQte);
			}
		}	
		
		if (boolDateD == true){
			if (data[index].dateD == selectDateD){
				tabDateD[index] = data[index];
				tabDateD = tabDateD.filter(function(n){ return n != undefined });
				console.log(tabDateD);
			}
		}
		if (boolDateF == true){
			if (data[index].dateF == selectDateF){
				tabDateF[index] = data[index];
				tabDateF = tabDateF.filter(function(n){ return n != undefined });
				console.log(tabQte);
			}
		}
		if (boolBudget == true){
			if (data[index].budget == selectBudget){
				tabBudget[index] = data[index];
				tabBudget = tabBudget.filter(function(n){ return n != undefined });
				console.log(tabBudget);
			}
		}
	}
	for (index2 = 0; index2 <= tabSelec.length; ++index2) {
		for (index3 = 0; index3 <= tabQte.length; ++index3) {
			if ( tabSelec[0] == undefined ) {
				tabRes = tabQte;
			}else if ( tabQte[0] == undefined ) {
				tabRes = tabSelec;
			}else if ( tabSelec[index2] == tabQte[index3] ) {
				tabRes[index2] = tabSelec[index2];
				tabRes = tabRes.filter(function(n){ return n != undefined });
			}
		}
	}
	for (index4 = 0; index4 <= tabRes.length; ++index4) {
		for (index5 = 0; index5 <= tabDateD.length; ++index5) {
			if ( tabDateD[0] == undefined ) {
				tabRes2 = tabRes;
			}else if ( tabRes[0] == undefined ) {
				tabRes2= tabDateD;
			}else if ( tabRes[index4] == tabDateD[index5] ) {
				tabRes2 = tabRes;
			}
		}
	}
	for (index6 = 0; index6 <= tabRes2.length; ++index6) {
		for (index7 = 0; index7 <= tabDateF.length; ++index7) {
			if ( tabDateF[0] == undefined ) {
				tabRes3 = tabRes2;
			}else if ( tabRes2[0] == undefined ) {
				tabRes3 = tabDateF;
			}else if ( tabRes2[index6] == tabDateF[index7] ) {
				tabRes3 = tabRes2;
			}
		}
	}
	for (index8 = 0; index8 <= tabRes3.length; ++index8) {
		for (index9 = 0; index9 <= tabBudget.length; ++index9) {
			if ( tabBudget[0] == undefined ) {
				tabResF = tabRes3;
			}else if ( tabRes3[0] == undefined ) {
				tabResF = tabBudget;
			}else if ( tabRes3[index8] == tabBudget[index9] ) {
				tabResF = tabRes3;
			}
		}
	}
	for (index10 = 0; index10 < tabResF.length; ++index10) {
		var liTest = document.createElement('li');
		liTest.className = "list-group-item";
		liTest.innerHTML = userStringifyTest(tabResF[index10]);
		ulTest.appendChild(liTest);
		console.log(liTest);
	}
	$("#reponseTest").html(ulTest);

	tabSelec.splice(0,tabRes.length+1);
	tabQte.splice(0,tabRes.length+1);
	tabDateD.splice(0,tabRes.length+1);
	tabDateF.splice(0,tabRes.length+1);
	tabBudget.splice(0,tabRes.length+1);
	
	tabRes.splice(0,tabRes.length+1);
	tabRes2.splice(0,tabRes.length+1);
	tabRes3.splice(0,tabRes.length+1);
	tabResF.splice(0,tabRes.length+1);	
}

function userStringifyTest(voyages) {
	return "nom du voyage = " + voyages.name + "|id du createur du voyage = " + voyages.idUser + "|destination = " + voyages.ville + "|description du voyage = " + voyages.description + "|date du depart = " + voyages.depart + "|date du retour = " + voyages.retour + "|nombre de participants = " + voyages.capacite + "|budget necessaire = " + voyages.budget;
}

function updateTextInput(val) {
    document.getElementById('Budget').value=val; 
}

function updateTxtSlider(val) {
    document.getElementById('myRangeBudget').value=val; 
}
