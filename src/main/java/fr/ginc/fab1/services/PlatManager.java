package fr.ginc.fab1.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import fr.ginc.fab1.bean.Commentaire;
import fr.ginc.fab1.bean.Plat;
import fr.ginc.fab1.dao.GenericDao;
import fr.ginc.fab1.dao.GenericDaoImpl;

@Path("/plats")
public class PlatManager {

	private GenericDao<Plat,Integer > platDAO;
	/////////////
	  public PlatManager(){
	        platDAO = new GenericDaoImpl<>();
	    }
	    
	    @GET
	    public List<Plat> getPlats()
	    {
	        List<Plat> listePlats= platDAO.findAll(getClass());
	        return listePlats;
	        
	    }
	    	    
	    
	    @GET
	    @Path("/{id:\\d+}")
	    public Plat obtenirPlat(@PathParam("id") int id)
	    {    
	        return platDAO.findById(getClass(), id);
	    }
	      
	    
	    @POST
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Plat ajouterPlat(Plat plat)
	    {
	        try {
				platDAO.add(plat);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return plat;
	    }
	    @POST
	    @Consumes(MediaType.APPLICATION_JSON)
	    @Path("/{id:\\d+}")
	    public Commentaire ajouterCommentaire(@PathParam("id") int id,Commentaire commentaire)
	    {
	    	List<Commentaire> listeCommentaires= obtenirPlat(id).getCommentaires();
	    	listeCommentaires.add(commentaire);
	    	
	    	
	    	obtenirPlat(id).setCommentaires(listeCommentaires);
	        try {
				platDAO.update(  obtenirPlat(id));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return commentaire;
	    }
	    
	    @PUT
	    @Path("/{id:\\d+}")
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Plat modifierPlat(@PathParam("id") int id, Plat plat)
	    {    
	        plat.setId(id);
	        try {
				platDAO.update(plat);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return plat;
	    }
	    
	    @DELETE
	    @Path("/{id:\\d+}")
	    public void supprimerPlat(@PathParam("id") int id)
	    {
	    	
	        try {
				platDAO.delete(obtenirPlat(id));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	   
}