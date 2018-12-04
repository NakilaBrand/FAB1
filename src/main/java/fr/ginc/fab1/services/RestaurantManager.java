package fr.ginc.fab1.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import fr.ginc.fab1.bean.Commande;
import fr.ginc.fab1.bean.Restaurant;
import fr.ginc.fab1.dao.GenericDao;
import fr.ginc.fab1.dao.GenericDaoImpl;


@Path("/restaurants")
public class RestaurantManager {
	
	List<Restaurant> listeRestaurants;
	private GenericDao<Restaurant, Integer> genericDao;
	
	public RestaurantManager(){
		genericDao = new GenericDaoImpl<Restaurant, Integer>();
	}
	
	@GET
	public List<Restaurant> getRestaurants()
	{
		List<Restaurant> listeRestaurants= genericDao.findAll(Restaurant.class);
		return listeRestaurants;
		
	}
	
	@GET
	@Path("/{id:\\d+}")
	public Restaurant getRestaurantById(@PathParam("id") int id)
	{
		return genericDao.findById(Restaurant.class, id);
	}

}
