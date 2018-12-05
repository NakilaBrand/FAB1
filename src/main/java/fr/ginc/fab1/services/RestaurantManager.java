package fr.ginc.fab1.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import fr.ginc.fab1.bean.Plat;
import fr.ginc.fab1.bean.Restaurant;
import fr.ginc.fab1.dao.GenericDao;
import fr.ginc.fab1.dao.GenericDaoImpl;
import fr.ginc.fab1.exception.DAOException;


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
	
	@PUT
	@Path("/{restaurantId:\\d+}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void ajouterPlat(Plat plat, @PathParam("restaurantId") int restaurantId)
	{	
		Restaurant restaurant = genericDao.findById(Restaurant.class, restaurantId);
		restaurant.setPlat(plat);
		try {
			genericDao.update(restaurant);
		} catch (Exception e) {
			e.printStackTrace();
		};
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addRestaurant(Restaurant restaurant)
	{	
		try {
			genericDao.add(restaurant);
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
	
}
