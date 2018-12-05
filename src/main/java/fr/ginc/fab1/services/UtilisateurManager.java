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

	@Path("/{id}")
	@GET
	public Utilisateur getUtilisateurById(@PathParam("id") int id) {
		return daoInt.findById(Utilisateur.class, id);
	}

	@Path("/email/{email}")
	@GET
	public Utilisateur getUtilisateurById(@PathParam("email") String email) {
		return daoStr.findByAttr(Utilisateur.class, "email", email);
	}

	@Path("/inscription")
	@POST
	public Response addUtilisateur(Utilisateur u) {

		try {
			List<String> errs = CheckUser.check(u);
			if (!errs.isEmpty()) {
				return Response.status(Response.Status.BAD_REQUEST).entity(errs).build();
			}
			daoInt.add(u);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.ok().build();
	}

	@Path("/connexion")
	@POST
	public Response connexion(Utilisateur u) {
		String email = u.getEmail();
		List<String> errs = new ArrayList<>();

		Utilisateur user = daoStr.findByAttr(Utilisateur.class, "email", email);

		if (user == null) {
			errs.add("Utilisateur inconnu");
			return Response.serverError().entity(errs).build();
		}
		if (user.getPassword().trim().equals(u.getPassword().trim())) {
			// mise en sessions
			HttpSession session = httpServletRequest.getSession();
			session.setAttribute("utilisateur", user);

			return Response.ok().build();
		}
		errs.add("Mot de passe incorrect");
		return Response.serverError().entity(errs).build();

	}

	@Path("/{id}")
	@PUT
	public Response updateUtilisateur(@PathParam("id") int id, Utilisateur u) {
		Utilisateur user = daoInt.findById(Utilisateur.class, id);
		List<String> errs = CheckUser.check(u);
		if (!errs.isEmpty()) {
			return Response.serverError().entity(errs).build();
		}
		user.setEmail(u.getEmail());
		user.setIsAdmin(u.getIsAdmin());
		user.setNom(u.getNom());
		user.setPrenom(u.getPrenom());
		user.setRestaurantPrefere(u.getRestaurantPrefere());
		user.setTelephone(u.getTelephone());
		// TODO encrypt
		user.setPassword(u.getPassword());
		return Response.ok().build();
	}

	@Path("/{id}")
	@DELETE
	public void deleteNote(@PathParam("id") int id) {
		Utilisateur user = daoInt.findById(Utilisateur.class, id);
		try {
			daoInt.delete(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
