package fr.ginc.fab1.services;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import fr.ginc.fab1.aut.CheckUser;
import fr.ginc.fab1.bean.Utilisateur;
import fr.ginc.fab1.dao.GenericDao;
import fr.ginc.fab1.dao.GenericDaoImpl;

@Path("/utilisateurs")
public class UtilisateurManager {
	private GenericDao<Utilisateur, Integer> daoInt = new GenericDaoImpl<>();
	private GenericDao<Utilisateur, String> daoStr = new GenericDaoImpl<>();
	@Context
	private HttpServletRequest httpServletRequest;

	@GET
	public List<Utilisateur> getUtilisateurs() {
		return daoInt.findAll(Utilisateur.class);
	}

	@Path("/usersession")
	@GET
	public Utilisateur getUtilisateurById() {
		HttpSession session = httpServletRequest.getSession();
		Utilisateur res = (Utilisateur) session.getAttribute("utilisateur");
		System.out.println(res);
		return res; 
		
	}

	@Path("/email/{email}")
	@GET
	public Utilisateur getUtilisateurById(@PathParam("email") String email) {
		return daoStr.findByAttr(Utilisateur.class, "email", email);
	}

	@Path("/inscription")
	@POST
	public Response addUtilisateur(Utilisateur u) {
		Response res = null;

		try {
			List<String> errs = CheckUser.check(u);
			if (!errs.isEmpty()) {
				return Response.status(Response.Status.BAD_REQUEST).entity(errs).build();
			}

			Utilisateur isPresent = daoStr.findByAttr(Utilisateur.class, "email", u.getEmail());

			if (isPresent != null) {
				errs.add("Cet Email existe déja !");
				res = Response.status(Response.Status.BAD_REQUEST).entity(errs).build();
				
			} else {
				// ----------A changer si on veut etre admin-----------------//
				u.setIsAdmin(false);
				daoInt.add(u);
				res = Response.ok().build();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}

	@Path("/connexion")
	@POST
	public Response connexion(Utilisateur u) {
		String email = u.getEmail();
		List<String> errs = new ArrayList<>();

		Utilisateur user = daoStr.findByAttr(Utilisateur.class, "email", email);

		if (user == null) {
			errs.add("Utilisateur inconnu");
			return Response.status(Response.Status.BAD_REQUEST).entity(errs).build();
		}
		if (user.getPassword().trim().equals(u.getPassword().trim())) {
			// mise en sessions
			HttpSession session = httpServletRequest.getSession();
			
			session.setAttribute("utilisateur", user);
			

			return Response.ok().build();
		}
		errs.add("Mot de passe incorrect");
		return Response.status(Response.Status.BAD_REQUEST).entity(errs).build();

	}

	@Path("/modification")
	@PUT
	public Response updateUtilisateur(Utilisateur u) {
		HttpSession session = httpServletRequest.getSession();
		Utilisateur user = (Utilisateur) session.getAttribute("utilisateur");
		List<String> errs = CheckUser.check(u);
		if(!errs.isEmpty() && verifEmail(u,errs)){
			return Response.status(Response.Status.BAD_REQUEST).entity(errs).build();
		}
		
		user.setEmail(u.getEmail());
		user.setNom(u.getNom());
		user.setPrenom(u.getPrenom());
		user.setRestaurantPrefere(u.getRestaurantPrefere());
		user.setTelephone(u.getTelephone());
		// TODO encrypt
		user.setPassword(u.getPassword());
		try {
			daoInt.update(user);
		} catch (Exception e) {
			errs.add("Erreur serveur");
			return Response.status(Response.Status.BAD_REQUEST).entity(errs).build();
		}
		return Response.ok().build();
	}

	private boolean verifEmail(Utilisateur u , List<String> errs) {
		try {
			
			Utilisateur isPresent = daoStr.findByAttr(Utilisateur.class, "email", u.getEmail());

			if (isPresent != null) {
				errs.add("Cet Email existe déja !");
			} else {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Path("/desinscription")
	@DELETE
	public void deleteUtilisateur() {
		HttpSession session = httpServletRequest.getSession();
		Utilisateur user = (Utilisateur) session.getAttribute("utilisateur");
		session.setAttribute("utilisateur", null);

		try {
			daoInt.delete(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Path("/deconnexion")
	@POST
	public void deconnexion() {
		HttpSession session = httpServletRequest.getSession();
		session.setAttribute("utilisateur", null);
		session.setAttribute("panier", null);
	}

}
