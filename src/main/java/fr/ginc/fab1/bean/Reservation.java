package fr.ginc.fab1.bean;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.fasterxml.jackson.annotation.JsonFormat;

@javax.persistence.Entity

public class Reservation implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private java.lang.Integer id;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private java.util.Date jour;
    
    private java.lang.Integer nbPersonne;
    

    
    @javax.persistence.ManyToOne(
    	fetch = javax.persistence.FetchType.LAZY,
    	optional = false
    )
    Restaurant restaurant;
    
    @javax.persistence.ManyToOne(
    	fetch = javax.persistence.FetchType.LAZY
    )
    TrancheHoraire horaireSelectionne;
    
    @javax.persistence.ManyToOne(
     
    	fetch = javax.persistence.FetchType.LAZY
    )
    Utilisateur utilisateur;

    
    public void setId(java.lang.Integer id) {
        this.id = id;
    }
    
    public java.lang.Integer getId() {
        return this.id;
    }
    
    public void setJour(java.util.Date Jour) {
        this.jour = Jour;
    }
    
    public java.util.Date getJour() {
        return this.jour;
    }
    
    public void setNbPersonne(java.lang.Integer nbPersonne) {
        this.nbPersonne = nbPersonne;
    }
    
    
    public java.lang.Integer getNbPersonne() {
        return this.nbPersonne;
    }
    

    
    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    
    
    public Restaurant getRestaurant() {
        return this.restaurant;
    }
    
    public void setHoraireSelectionne(TrancheHoraire horaireSelectionne) {
        this.horaireSelectionne = horaireSelectionne;
    }
    
    
    public TrancheHoraire getHoraireSelectionne() {
        return this.horaireSelectionne;
    }
    
    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    
    public Utilisateur getUtilisateur() {
        return this.utilisateur;
    }

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", Jour=" + jour + ", nbPersonne=" + nbPersonne + ", restaurant=" + restaurant
				+ ", horaireSelectionne=" + horaireSelectionne + ", utilisateur=" + utilisateur + "]";
	}
    
    
    
}

