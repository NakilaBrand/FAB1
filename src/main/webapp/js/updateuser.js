/**
 * 
 */
var apiHost = "http://localhost:8080/"
var user = {

}
var u;

function setUser() {
	user.nom = document.getElementById("nom").value;
	user.prenom = document.getElementById("prenom").value;
	user.telephone = document.getElementById("telephone").value;
	user.email = document.getElementById("mail").value;
	if (checkPassword()) {
		user.password = document.getElementById("password").value;
		updateUser();
	} else {
		afficheErreur("Veuillez confirmer votre mot de passe plz");
	}
}

function checkPassword() {
	if (document.getElementById("password").value == document
			.getElementById("passwordconfirm").value) {
		return true;
	} else {
		return false;
	}

}
function afficheErreur(erreur) {
	alert(erreur);
}

function updateUser() {
	var error = false;
	fetch(apiHost + "FAB1/service/utilisateurs/modification", {
		method : 'put',
		headers : {
			'Accept' : 'application/json',
			'Content-Type' : 'application/json'
		},
		body : JSON.stringify(user)
	}).then(function f(reponse) {
		if (reponse.ok) {
			//pop un plus joli :
			alert("Maj effectuée");
		}
	})
}

function getUser() {

    return new Promise((resolve, reject) => {
        fetch(apiHost + "FAB1/service/utilisateurs/usersession", {
            method : 'get',
            headers : {
                'Accept' : 'application/json',
                'Content-Type' : 'application/json'
            }
        }).then(function f(reponse) {
            return reponse.json();
        }).then(function (userJson) {
            resolve(userJson);
        })
    });
}

function afficherUser() {
	 getUser().then(function (user) {

         document.getElementById("prenom").setAttribute("value",user.prenom);
         document.getElementById("nom").setAttribute("value",user.nom);
         document.getElementById("telephone").setAttribute("value",user.telephone);
         document.getElementById("mail").setAttribute("value",user.email);
         document.getElementById("password").setAttribute("value",user.password);
     });

}
afficherUser();




















