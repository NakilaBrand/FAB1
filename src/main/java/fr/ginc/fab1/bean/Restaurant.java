package fr.ginc.fab1.bean;


@javax.persistence.Entity

public class Restaurant implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;

    @javax.persistence.Id
    private java.lang.Integer id;
    
    private java.lang.String nom;
    
    private java.lang.String adresse;
    
    private java.lang.String codePostal;
    
    private java.lang.String ville;
    
    private java.lang.String telephone;
    

    
    @javax.persistence.OneToMany(
        cascade = {javax.persistence.CascadeType.ALL},
    	fetch = javax.persistence.FetchType.LAZY
    )
    java.util.Collection<Plat> plats;
    @javax.persistence.ManyToMany(
        cascade = {javax.persistence.CascadeType.ALL},
    	fetch = javax.persistence.FetchType.LAZY
    )
    java.util.Collection<TrancheHoraire> tranchehoraire;
    @javax.persistence.OneToMany(
        mappedBy = "restaurant",
    	cascade = {javax.persistence.CascadeType.ALL},
    	fetch = javax.persistence.FetchType.LAZY
    )
    java.util.Collection<Reservation> reservation;
    @javax.persistence.OneToMany(
        cascade = {javax.persistence.CascadeType.ALL},
    	fetch = javax.persistence.FetchType.LAZY
    )
    java.util.Collection<Commande> commande;

    
    public void setId(java.lang.Integer id) {
        this.id = id;
    }
    
    
    public java.lang.Integer getId() {
        return this.id;
    }
    
    public void setNom(java.lang.String nom) {
        this.nom = nom;
    }
    
    
    public java.lang.String getNom() {
        return this.nom;
    }
    
    public void setAdresse(java.lang.String adresse) {
        this.adresse = adresse;
    }
    
    
    public java.lang.String getAdresse() {
        return this.adresse;
    }
    
    public void setCodePostal(java.lang.String codePostal) {
        this.codePostal = codePostal;
    }
    
    
    public java.lang.String getCodePostal() {
        return this.codePostal;
    }
    
    public void setVille(java.lang.String ville) {
        this.ville = ville;
    }
    
    
    public java.lang.String getVille() {
        return this.ville;
    }
    
    public void setTelephone(java.lang.String telephone) {
        this.telephone = telephone;
    }
    
    
    public java.lang.String getTelephone() {
        return this.telephone;
    }
    

    
    public void setPlats(java.util.Collection<Plat> plats) {
        this.plats = plats;
    }
    
    
    public java.util.Collection<Plat> getPlats() {
        return this.plats;
    }
    
    public void setTranchehoraire(java.util.Collection<TrancheHoraire> tranchehoraire) {
        this.tranchehoraire = tranchehoraire;
    }
    
    
    public java.util.Collection<TrancheHoraire> getTranchehoraire() {
        return this.tranchehoraire;
    }
    
    public void setReservation(java.util.Collection<Reservation> reservation) {
        this.reservation = reservation;
    }
    
    
    public java.util.Collection<Reservation> getReservation() {
        return this.reservation;
    }
    
    public void setCommande(java.util.Collection<Commande> commande) {
        this.commande = commande;
    }
    
    
    public java.util.Collection<Commande> getCommande() {
        return this.commande;
    }
    
}

