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
            //div.innerHTML = "<div class=\"plat\"> <h3 class=\"plats__title\">" + plat.nom + "</h3> <a href=\"avis.html\"><button class=\"buttonNote\" type=\"rsvBtn\">Noter</button></a><button class=\"buttonNote\" type=\"rsvBtn\" onclick=\"ajouterPanier("+plat.id+")\"><img src=\"icons/AjouterNoir.png\" height=\"15\"/></button><div class=\"plats__transform\"></div></div>"
            
            //<img class=\"imgCarte\" src=\"" + plat.imageURL + "\" alt=\"" + plat.nom + "\" >
            
            var plat_design = "<div class=\"container-fluid\">";
            plat_design += "<div class=\"row\" id=\"blackrow\">";
            plat_design += "<div class=\"col-6\">";
            plat_design += "<a style=\"text-decoration: none\" href=\"plats.html/\"><h3 class=\"cartetoplat\">"+ plat.nom +"</h3></a>";
            plat_design += "</div>";
            plat_design += "<div class=\"col-3\">";
            plat_design += "<button class=\"buttoncarte\">Noter</button>";
            plat_design += "</div>";
            plat_design += "<div class=\"col-3\">";
            plat_design += "<button class=\"buttoncarte\" onclick=\"ajouterPanier("+plat.id+")\"><img src=\"icons/AjouterNoir.png\" height=\"20\"/></button>";
            plat_design += "</div>";
            plat_design += "</div>";
            plat_design += "</div>";
            
            div.innerHTML = plat_design;
            
            
            
            div.style.backgroundImage = "url(\""+plat.imageURL+"\")";
            div.style.height = "400px";
            div.style.backgroundSize = "cover";
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


