package fr.ginc.fab1.bean;


@javax.persistence.Entity

public class Reservation implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;

    @javax.persistence.Id
    private java.lang.Integer id;
    
    private java.util.Date Jour;
    
    private java.lang.Integer nbPersonne;
    

    
    @javax.persistence.ManyToOne(
        cascade = {javax.persistence.CascadeType.ALL},
    	fetch = javax.persistence.FetchType.LAZY,
    	optional = false
    )
    Restaurant restaurant;
    @javax.persistence.ManyToOne(
        cascade = {javax.persistence.CascadeType.ALL},
    	fetch = javax.persistence.FetchType.LAZY
    )
    TrancheHoraire horaireSelectionne;
    @javax.persistence.ManyToOne(
        cascade = {javax.persistence.CascadeType.ALL},
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
        this.Jour = Jour;
    }
    
    
    public java.util.Date getJour() {
        return this.Jour;
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
    
}

