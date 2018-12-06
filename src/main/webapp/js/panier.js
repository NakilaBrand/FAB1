recupererPanier();

function recupererPanier(){
	
	fetch("/FAB1/service/commandes/panier"
	).then(function(reponse) {
		
		//si null ,ne rien faire
		return reponse.json();
	}).then(function(data) {
		var panierPlat = document.getElementById('tableau');
		panierPlat.innerHTML = "";
		
		var tr = document.createElement('tr');
        var titre = "<tr>";
        titre += "<th>Plats</th>";
        titre += "<th>Sous-total</th>";
        titre += "<th></th>";
        titre += "</tr>";
        
        tr.innerHTML = titre;
        panierPlat.appendChild(tr);
		
		var index=0;	


		data/*.plats*/.forEach(function (plat){
			var tr = document.createElement('tr');
			//td.setAttribute('class',"coucou c'est la classe")
			
			tr.innerHTML ="<td>"+plat.nom+"</td><td>"+plat.prix+"</td><td><button class=\"buttonNote\" type=\"rsvBtn\" onclick=\"supprimerPanier("+index+")\"><img src=\"icons/remove.png\" height=\"15\"/></button></td>"
			
			
			panierPlat.appendChild(tr);
			index++;
		})
		
		tr= document.createElement('tr');
		var total = "<tr>";
		total += "<th> </th>";
		total += "<th>Total</th>";
		total += "<th><button class=\"buttonCmd\" onclick=\"validerCommande()\">Commander</button></th>";
		total += "</tr>";
		tr.innerHTML = total;
		panierPlat.appendChild(tr);
	});
	
}

function supprimerPanier(id){
	fetch("/FAB1/service/commandes/panier/remove/"+id
	).then(function(reponse) {
		
		//si null ,ne rien faire
		return reponse.json();
	}).then(function(data) {
		var panierPlat = document.getElementById('tableau');
panierPlat.innerHTML = "";
		
		var tr = document.createElement('tr');
		var titre = "<tr>";
		titre += "<th>Plats</th>";
		titre += "<th>Sous-total</th>";
		titre += "<th></th>";
		titre += "</tr>";
		
		tr.innerHTML = titre;
		panierPlat.appendChild(tr);
		
		var index=0;

		data/*.plats*/.forEach(function (plat){
			var tr = document.createElement('tr');
			//td.setAttribute('class',"coucou c'est la classe")
			
			tr.innerHTML ="<td>"+plat.nom+"</td><td>"+plat.prix+"</td><td><button class=\"buttonNote\" type=\"rsvBtn\" onclick=\"supprimerPanier("+index+")\"><img src=\"icons/remove.png\" height=\"15\"/></button></td>"
			
			//<a href=\"supprimerPanier("+index+")\"><img src=\"icons/remove.png\" height=\"20\"/></a>
			panierPlat.appendChild(tr);
			index++;
		})

		tr= document.createElement('tr');
		var total = "<tr>";
		total += "<th> </th>";
		total += "<th>Total</th>";
		total += "<th><button class=\"buttonCmd\" onclick=\"validerCommande()\">Commander</button></th>";
		total += "</tr>";
		tr.innerHTML = total;
		panierPlat.appendChild(tr);
	});
}


function validerCommande(){

    var data = {};

    fetch("/FAB1/service/commandes", {
        method: "POST",
        headers: {
            "Content-Type": "application/json; charset=utf-8"
        },
        body: JSON.stringify(data)
    });

}