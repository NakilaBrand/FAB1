recupererPanier();







function recupererPanier(){
	
	fetch("/FAB1/service/commandes"
	).then(function(reponse) {
		return reponse.json();
	}).then(function(data) {
		var panierPlat = document.getElementById('panier_plat');
		panierPlat.innerHTML = "";


		data/*.plats*/.forEach(function (plat){
			var tr = document.createElement('tr');
			var td = document.createElement('td');
			td.setAttribute('class',"coucou c'est la classe")
			td.innerHTML =  "<div class=\"plat\">"+plat.nom+" <img src=\"icons/AjouterNoir.png\" height=\"30\"/></div>"
			tr.appendChild(td);
			td.innerHTML = "";
			tr.appendChild(td);
			td.innerHTML = "";
			tr.appendChild(td);
			td.innerHTML = "";
			panierPlat.appendChild(li);
		})
   
	});
	
}