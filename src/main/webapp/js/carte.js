fetch("/FAB1/services/carte/"+document.getElementById("choixPlat").value
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
