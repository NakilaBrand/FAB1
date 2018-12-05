afficherTranche();


function afficherTranche() {
    var choix = document.getElementById("restaurant").value;
    fetch("/FAB1/service/restaurants/" + choix
    ).then(function (reponse) {
        return reponse.json();
    }).then(function (data) {
    	
        var liste_reservation = document.getElementById('liste_reservation');
        liste_reservation.innerHTML = "";
        


        data.tranchehoraire.forEach(function (tranche) {
            var div = document.createElement('li');
            var html = "  <input type = \"radio\" name=\"tranche\" id=\"    "
            html += tranche.id+"\">   "
            html += tranche.debut+"  </input><br>  "
            
            div.innerHTML = html;
            
            liste_reservation.appendChild(div);
        })
    });
}

function ajouterPanier(id) {

    var data = {};

    fetch("/FAB1/service/reservations/", {
        method: "POST",
        headers: {
            "Content-Type": "application/json; charset=utf-8"
        },
        body: JSON.stringify(data)
    });

}


