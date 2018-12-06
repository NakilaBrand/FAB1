/**
 * 
 */
var apiHost = "http://localhost:8080/"
plat = {
		
}
function ajouter(){
	plat.description = document.getElementById("descriptionplat").value;
	plat.nom = document.getElementById("nom").value;
	plat.prix = document.getElementById("prix").value;
	fetch(apiHost+"FAB1/service/plats", {
        method: 'post',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(plat)
    }).then(function f(response){
    	
    })
}
