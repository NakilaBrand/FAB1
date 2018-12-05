/**
 * 
 */
var apiHost = "http://localhost:8080/"
var user = {

}


function setUser() {
    user.email = document.getElementById("email").value;
    user.password = document.getElementById("password").value;

    connectUser();


}

function connectUser() {
    var err = "Mot de passe incorrect"

    fetch(apiHost+"FAB1/service/utilisateurs/connexion", {
        method: 'post',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    })
        .then(function functionName (response) {
            if (response.ok) {
                alert("connecté");
                return;
            }
            return response.json();


        }).then( function functionName (repJson) {
            if (repJson == null){
                return;
            }
            alert(repJson);
    })

}