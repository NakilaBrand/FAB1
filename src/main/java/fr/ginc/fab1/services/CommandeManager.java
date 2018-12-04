package fr.ginc.fab1.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import fr.ginc.fab1.bean.Commande;
import fr.ginc.fab1.dao.GenericDao;
import fr.ginc.fab1.dao.GenericDaoImpl;

@Path("/commandes")
public class CommandeManager {
	
	List<Commande> listeCommandes;
	private GenericDao<Commande, Integer> genericDao;
	
	public CommandeManager(){
		genericDao = new GenericDaoImpl<Commande, Integer>();
	}
	
	@GET
	public List<Commande> getCommandes()
	{
		List<Commande> listeCommandes= genericDao.findAll(Commande.class);
		return listeCommandes;
	}
	
	@GET
	@Path("/{id:\\d+}")
	public Commande obtenirCommande(@PathParam("id") int id)
	{
		return genericDao.findById(Commande.class, id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Commande ajouterCommande(Commande Commande)
	{
		try {
			genericDao.add(Commande);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Commande;
	}
	
}
