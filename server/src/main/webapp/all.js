var log;
var password;
var name;
var mail;

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
			psswd = data.password;
			console.log(psswd);
			$(".connexion").hide();
			$(".connect").show(); 
			//$(".pageVoyage").show();
			$("#profil").show();
			$(".profil").show();
			$("#creeVoyage").show();
			$("#mesVoyages").show();
			$("#toutVoyage").show();
			$(".profil input[name=nom]").attr("value",name);
			$(".profil input[name=login]").attr("value",log);
			$(".profil input[name=email]").attr("value",mail);
			$(".profil input[name=password]").attr("value",password);




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