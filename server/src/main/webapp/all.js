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

			var alias1 = data.alias;
			var name1 = data.name;
			var email1 = data.email;
			var psswd1 = data.password;
			attributProfil(alias1,name1,email1,psswd1);
			console.log("login:"+log + "name="+name );
			$(".connexion").hide();
			$(".connect").show(); 
			$(".pageVoyage").show();
			$(".profil").append("Login : "+log+ " name = "+name);

		}else{
			alert("Mot de passe ou login Incorrect");

		}
	});
}

function attributProfil(alias,psswd , nom, email){
	log=alias;
	password=psswd;
	name=nom;
	mail=email;
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