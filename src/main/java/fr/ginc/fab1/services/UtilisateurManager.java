package fr.ginc.fab1.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import fr.ginc.fab1.bean.Utilisateur;
import fr.ginc.fab1.dao.GenericDao;
import fr.ginc.fab1.dao.GenericDaoImpl;

@Path("/utilisateurs")
public class UtilisateurManager {
	private GenericDao<Utilisateur, Integer> daoInt = new GenericDaoImpl<>();
	private GenericDao<Utilisateur, String> daoStr = new GenericDaoImpl<>();
	
	@GET
	public List<Utilisateur> getUtilisateurs(){
		return daoInt.findAll(Utilisateur.class);
	}
	
	@Path("/{id}")
	@GET
	public Utilisateur getUtilisateurById(@PathParam("id") int id){
		return daoInt.findById(Utilisateur.class, id);
	}
	
	@Path("/{id}")
	@PUT
	public Utilisateur updateUtilisateur(@PathParam("id") int id , Utilisateur u){
		Utilisateur user = daoInt.findById(Utilisateur.class, id);
		
		return user;
	}

}
