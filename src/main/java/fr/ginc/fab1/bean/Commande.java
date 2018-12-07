package fr.ginc.fab1.bean;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@javax.persistence.Entity

public class Commande implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private java.lang.Integer id;
    
    private String jour;
    
    private String heure;
    
    private java.lang.String statut;
    // "commandee"  ou "livree"
    
    private java.lang.Integer choixRestaurant;
    
    
    
    @javax.persistence.ManyToMany(
        cascade = {javax.persistence.CascadeType.ALL},
    	fetch = javax.persistence.FetchType.LAZY
    )
    java.util.Collection<Plat> platsCommandes;
    
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
    
    public void setJour(String jour) {
        this.jour = jour;
    }
    
    
    public String getJour() {
        return this.jour;
    }
    
    public void setHeure(String heure) {
        this.heure = heure;
    }
    
    
    public String getHeure() {
        return this.heure;
    }
    
    public void setStatut(java.lang.String statut) {
        this.statut = statut;
    }
    
    
    public java.lang.String getStatut() {
        return this.statut;
    }
    
    public void setChoixRestaurant(java.lang.Integer choixRestaurant) {
        this.choixRestaurant = choixRestaurant;
    }
    
    public java.lang.Integer getChoixRestaurant() {
        return this.choixRestaurant;
    }
    

    
    public void setPlatsCommandes(java.util.Collection<Plat> platsCommandes) {
        this.platsCommandes = platsCommandes;
    }
    
    
    public java.util.Collection<Plat> getPlatsCommandes() {
        return this.platsCommandes;
    }
    
    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    
    
    public Utilisateur getUtilisateur() {
        return this.utilisateur;
    }
    
}

