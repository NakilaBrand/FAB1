
	fetch("/FAB1/service/accueil"
	).then(function(reponse) {
		return reponse.json();
	}).then(function(plat) {

		var pdm = document.getElementById('platDuMoment');
		pdm.innerHTML = "";
		pdm.innerHTML = plat.description;
		
        var photoPlat = document.getElementById('photo');
        photoPlat.setAttribute('src',plat.imageURL);

        
	});
