package fr.ginc.fab1.services;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
	@Path("/email/{email}")
	@GET
	public Utilisateur getUtilisateurById(@PathParam("email") String email){
		return daoStr.findByAttr(Utilisateur.class, "email", email);
	}
	
	@POST
	public void addUtilisateur(Utilisateur u){
		try {
			daoInt.add(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Path("/{id}")
	@PUT
	public Utilisateur updateUtilisateur(@PathParam("id") int id , Utilisateur u){
		Utilisateur user = daoInt.findById(Utilisateur.class, id);
		user.setEmail(u.getEmail());
		user.setIsAdmin(u.getIsAdmin());
		user.setNom(u.getNom());
		user.setPrenom(u.getPrenom());
		user.setRestaurantPrefere(u.getRestaurantPrefere());
		user.setTelephone(u.getTelephone());
		//TODO encrypt
		user.setPassword(u.getPassword());
		
		return user;
	}
	
	@Path("/{id}")
	@DELETE
	public void deleteNote(@PathParam("id") int id)
	{
		Utilisateur user = daoInt.findById(Utilisateur.class, id);
		try {
			daoInt.delete(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
