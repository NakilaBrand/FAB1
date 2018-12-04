package fr.ginc.fab1.services;

import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import fr.ginc.fab1.bean.Plat;

@Path("/accueil")
public class TestService {
	@GET
	public Plat getPlatTest() throws SQLException
	{
		
		Plat testPlat = new Plat();
		
		testPlat.setId(1);
		testPlat.setDescription("coucou c'est le plat");
		testPlat.setNom("PLAT TOP FLEX");
		testPlat.setPrix(300d);
		testPlat.setImageURL("https://www.mincidelice.com/files/boutique/produits/2247-plat-boeuf-legumes.jpg");
		
		return testPlat;
	}
	
	
}
