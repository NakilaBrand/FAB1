console.log("1");
var plat = $_GET('id');
console.log(plat);
afficherLePlat(plat);

function afficherLePlat(plat){
	fetch("/FAB1/service/plats/" + plat
    ).then(function (reponse) {
        return reponse.json();
    }).then(function (data) {
    	
    	
    	var photo = document.getElementById('photoPlat');
    	photo.style.backgroundImage = "url(\""+plat.imageURL+"\")";
    	photo.style.height = "400px";
    	photo.style.backgroundSize = "cover";
    	
        var titrePlat = document.getElementById('titrePlat');
        titrePlat.innerHTML = "";
        titrePlat.innerHTML = plat.nom;
        
        var textPlat = document.getElementById('descrPlatPlat');
        textPlat.innerHTML = "";
        textPlat.innerHTML = plat.description;
        
        var prixPlat = document.getElementById('prixPlat');
        prixPlat.innerHTML = "";
        prixPlat.innerHTML = plat.prix;
        
        var ajoutPlat = document.getElementById('ajoutPlat');
        ajoutPlat.innerHTML = "";
        ajoutPlat.innerHTML = "<button class=\"buttoncarte\" onclick=\"ajouterPanier("+plat.id+")\"><img src=\"icons/AjouterNoir.png\" height=\"20\"/></button>";
        

    });
}

/////////// fonction ajouter panier


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








function $_GET(param) {
	var vars = {};
	window.location.href.replace( location.hash, '' ).replace( 
		/[?&]+([^=&]+)=?([^&]*)?/gi, // regexp
		function( m, key, value ) { // callback
			vars[key] = value !== undefined ? value : '';
		}
	);

	if ( param ) {
		return vars[param] ? vars[param] : null;	
	}
	return vars;
}