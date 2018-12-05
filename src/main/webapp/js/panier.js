recupererPanier();







function recupererPanier(){
	
	fetch("/FAB1/service/commandes/panier"
	).then(function(reponse) {
		
		//si null ,ne rien faire
		return reponse.json();
	}).then(function(data) {
		var panierPlat = document.getElementById('panier_plat');
		//panierPlat.innerHTML = "";
		
		


		data/*.plats*/.forEach(function (plat){
			var tr = document.createElement('tr');
			//td.setAttribute('class',"coucou c'est la classe")
			
			tr.innerHTML ="<td>"+plat.nom+"</td><td>1</td><td>"+plat.prix+"</td><td>"+plat.prix/**quantite*/+"</td><td><a href=\"supprimerPanier("/*+plat.*/+")\"><img src=\"icons/remove.png\" height=\"20\"/></a></td>"
			
			
			panierPlat.appendChild(tr);
		})
   
	});
	
}

function supprimerPanier(){
	
}