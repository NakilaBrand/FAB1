package fr.ginc.fab1.services;

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

import fr.ginc.fab1.bean.Reservation;
import fr.ginc.fab1.bean.Utilisateur;
import fr.ginc.fab1.dao.GenericDao;
import fr.ginc.fab1.dao.GenericDaoImpl;

@Path("/reservations")
public class ReservationManager {
	
	List<Reservation> listeReservations;
	private GenericDao<Reservation, Integer> genericDao;
	@Context
	private HttpServletRequest httpServletRequest;
	
	public ReservationManager(){
		genericDao = new GenericDaoImpl<Reservation, Integer>();
	}
	
	@GET
	public List<Reservation> getReservations()
	{
		List<Reservation> listeReservations= genericDao.findAll(Reservation.class);
		return listeReservations;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Reservation ajouterReservation(Reservation reservation)
	{	
		HttpSession session = httpServletRequest.getSession();
		Utilisateur user = (Utilisateur) session.getAttribute("utilisateur");
		reservation.setUtilisateur(user);
		try {
			genericDao.add(reservation);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reservation;
	}
}
