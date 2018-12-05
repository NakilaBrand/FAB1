afficherListe();


function afficherListe() {
    var choix = document.getElementById("restaurant").value;
    fetch("/FAB1/service/restaurants/" + choix
    ).then(function (reponse) {
        return reponse.json();
    }).then(function (data) {
        var listePlat = document.getElementById('liste_plat');
        listePlat.innerHTML = "";


        data.plats.forEach(function (plat) {
            var div = document.createElement('div');
            div.setAttribute('class', "col-12 col-sm-6 col-md-4")
            div.innerHTML = "<div class=\"plat\"> <h3 class=\"plats__title\">" + plat.nom + "</h3> <a href=\"avis.html\"><button class=\"buttonNote\" type=\"rsvBtn\">Noter</button></a><img src=\"icons/AjouterNoir.png\" height=\"30\"/><div class=\"plats__transform\"><img class=\"imgCarte\" src=\"" + plat.imageURL + "\" alt=\"" + plat.nom + "\"></div></div>"
            listePlat.appendChild(div);
        })

    });
}

function ajouterPanier(id) {

    var data = {};

    fetch("/FAB1/service/commandes/panier/" + id, {
        method: "POST",
        headers: {
            "Content-Type": "application/json; charset=utf-8"
        },
        body: JSON.stringify(data)
    });

}


