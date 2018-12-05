package fr.ginc.fab1.services;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import fr.ginc.fab1.bean.Commande;
import fr.ginc.fab1.bean.Plat;
import fr.ginc.fab1.dao.GenericDao;
import fr.ginc.fab1.dao.GenericDaoImpl;
import fr.ginc.fab1.exception.DAOException;

@Path("/commandes")
public class CommandeManager {
	
	List<Commande> listeCommandes;
	private GenericDao<Commande, Integer> genericDao;
	private List<Plat> panier;
	private GenericDao<Plat,Integer > platDAO;
	@Context
	private HttpServletRequest httpServletRequest;
	
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
	public Commande getCommande(@PathParam("id") int id)
	{
		return genericDao.findById(Commande.class, id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Commande ajouterCommande(Commande Commande)
	{
		try {
			genericDao.add(Commande);
		} catch (DAOException e) {
			new DAOException("La commande n'a pas été prise en compte");
		}
		return Commande;
	}
	
	@POST
	@Path("/panier/{id:\\d+}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void ajouterPanier(int id)
	{
		//recuperer le panier en session
		HttpSession session = httpServletRequest.getSession();
		panier = (List<Plat>) session.getAttribute("panier");
		
		if(panier == null){
			List<Plat> panier = new ArrayList<>();
		}
		try {
			panier.add(platDAO.findById(Plat.class, id));
			//stocker Panier en session
			session.setAttribute("panier",panier);
		} catch (Exception e) {
			new DAOException("L'ajout en panier n'a pas fonctionné");
		}
	}
	
	@GET
	@Path("/panier/{id:\\d+}")
	public List<Plat> recupererPanier()
	{
		//recuperer le panier en session
		HttpSession session = httpServletRequest.getSession();
		panier = (List<Plat>) session.getAttribute("panier");
		
		if(panier == null){
			List<Plat> panier = new ArrayList<>();
		}
		
		return panier;
	}
	
}
