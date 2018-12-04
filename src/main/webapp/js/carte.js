fetch("/FAB1/services/plats/restaurants/"+document.getElementById("choixRestaurant").value
	).then(function(reponse) {
		return reponse.json();
	}).then(function(data) {

		var listePlat = document.getElementById('listePlat');
		pdm.innerHTML = "";
	
		
		data.forEach(function (plat){
			var li = document.createElement('li');
			
			
			li.setAttribute('id',plat.id);
			
			
			li.innerHTML = "<span> <img src=\"" +plat.imageURL "\" alt=\"plat_"+plat.id"\" /></span>" +"<span  onclick=\"ajouterPanier("+plat.id+")\"\"></span>"+notes.text;
			
			
			
            ul.appendChild(li);
		})

        
	});


function ajouterPanier (id) {
	
	var data = {
			
		};

		fetch("/FAB1/service/commandes/restaurant/"+id, {
			method : "POST",
			headers : {
				"Content-Type" : "application/json; charset=utf-8"
			},
			body : JSON.stringify(data)
		});
	
}


