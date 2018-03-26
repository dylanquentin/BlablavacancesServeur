var log;
var password;
var name;
var mail;
var idUser;
var idVoyage=new Object();

function getUser(name) {
	getUserGeneric(name, "v1/user/");
}

function getUserGeneric(name, url) {
	$.getJSON(url + name, function(data) {
		afficheUser(data); 
	});
}

function login() {
	getWithAuthorizationHeader("v1/login", function(data){
		$("#formConnec").hide();
		//afficheUser(data);
		if(data.name === ($("#loginConnect")).val()){

			log = data.alias;
			name = data.name;
			mail = data.email;
			idUser=data.id;
			console.log("idUser qd il se co "+idUser);
			$(".connexion").hide();
			$(".connect").show(); 
			//$(".pageVoyage").show();
			$("#profil").show();
			$(".accueilConnec").show();
			$("#creeVoyage").show();
			$("#mesVoyages").show();
			$("#toutVoyage").show();
			$("#accueil").hide();
			$("#charte").hide();
			$("#tuto").hide();
			$("#contact").hide();


			$(".accueilConnec #nomProfil").append(name);
			$(".accueilConnec #monLogin").append(log);
			$(".accueilConnec #monEmail").append(mail);
			listerVoyage();
	}else{
		alert("Mot de passe ou login Incorrect");

	}
});
}


function profile() {
	getWithAuthorizationHeader("v1/profile", function (data) {
		afficheUser(data);
		
	});
}

function getWithAuthorizationHeader(url, callback) {
	if($("#loginConnect").val() != "") {
		$.ajax
		({
			type: "GET",
			url: url,
			dataType: 'json',
			beforeSend : function(req) {
				req.setRequestHeader("Authorization", "Basic " + btoa($("#loginConnect").val() + ":" + $("#passwordConnect").val()));
			},
			success: callback,
			error : function(jqXHR, textStatus, errorThrown) {
				alert('error: ' + textStatus);
			}
		});
	} else {
		$.getJSON(url, function(data) {
			afficheUser(data);
		});
	}
}


$(function(){
	$('#formInscr').submit(function(){
		nom = $(this).find('input[name=nom]').val();
		prenom = $(this).find('input[name=prenom]').val();
		login = $(this).find('input[name=login]').val();
		password = $(this).find('input[name=password]').val();
		postUser(nom,prenom,login,password);
	});

});



function postUser(name, alias, email, pwd) {
	postUserGeneric(name, alias, email, pwd, 'v1/user/')
}

function postUserGeneric(name, alias, email, pwd, url) {
	console.log("postUserGeneric " + url)
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : url,
		dataType : "json",
		data : JSON.stringify({
			"name" : name,
			"alias" : alias,
			"email" : email,
			"password" : pwd,
			"id" : 0
		}),
		success : function(data, textStatus, jqXHR) {
			afficheUser(data);
		},
		error : function(jqXHR, textStatus, errorThrown) {
			console.log('postUser error: ' + textStatus);
		}
	});
}

function listUsers() {
	listUsersGeneric("v1/user/");
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
		ul.appendChild(li);
	}
	$("#reponse").html(ul);
}

function userStringify(user) {
	return user.id + ". " + user.name + " &lt;" + user.email + "&gt;" + " (" + user.alias + ")";
}

function postVoyage(nomVoyage, ville, description, depart, retour,voyageurs,url) {
	console.log("postVoyage" + url)
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : url,
		dataType : "json",
		data : JSON.stringify({
			"id" : 0,
			"idUser" : idUser,
			"name" : nomVoyage,
			"ville" : ville,
			"description" : description,
			"depart" : depart,
			"retour" : retour,
			"capacite" : voyageurs
		}),
		success : function(data, textStatus, jqXHR) {
			console.log('postVoyage : success', data.id, data);
			idVoyage=data.id;
		},
		error : function(jqXHR, textStatus, errorThrown) {
			console.log('postVoyage error: ', textStatus);
		}
	});
}
function listerVoyage(){
	$.getJSON("v1/voyages", function(data) {
		var str="<tbody>";
		var index = 0;
		console.log(data.length);
		console.log(data[index].idUser);
		for (index = 0; index < data.length; ++index) {
			if(data[index].idUser==idUser){
				str+="<tr>"
				str+="<td>"+data[index].name+"</td>";
				str+="<td>"+data[index].ville+"</td>";
				str+="<td>"+data[index].description+"</td>";
				console.log(data[index].depart);
				if(data[index].depart===undefined){
									str+="<td> - </td>";

				}else{
					str+="<td>"+data[index].depart+"</td>";
				}
					if(data[index].retour===undefined){
									str+="<td> - </td>";

				}else{
					str+="<td>"+data[index].retour+"</td>";
				}
				
				str+="<td>"+data[index].capacite+"</td>";
				str+="</tr>"
			}
		}
		//console.log(str);
		str+="</tbody>"
		$("#tabVoyages").append(str);

	});
	
}

function postPreference(aime, moyen, aimePas) {
	console.log("postPreference" + "/v1/preference/");
	//idVoyage=getVoyage($("#nomVoyage").val());
    //console.log("voici mon id"+idVoyage.data.id.toString());
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : "v1/preference/",
		dataType : "json",
		data : JSON.stringify({
			"idVoyage" : idVoyage,
			"motive" : aime,
			"neutre" : moyen,
			"pasEnvie" : aimePas
		}),
		success : function(data, textStatus, jqXHR) {
			afficheUser(data);
		},
		error : function(jqXHR, textStatus, errorThrown) {
			console.log('postPreference error: ' + textStatus);
		}
	});
}
