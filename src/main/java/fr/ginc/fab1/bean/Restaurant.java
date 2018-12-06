package fr.ginc.fab1.bean;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@javax.persistence.Entity

public class Restaurant implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String nom;
    
    private String adresse;
    
    private String codePostal;
    
    private String ville;
    
    private String telephone;
    

    
    @javax.persistence.ManyToMany(
        cascade = {javax.persistence.CascadeType.ALL},
    	fetch = javax.persistence.FetchType.LAZY
    )
    List<Plat> plats;
    
    @javax.persistence.ManyToMany(
        cascade = {javax.persistence.CascadeType.ALL},
    	fetch = javax.persistence.FetchType.LAZY
    )
    List<TrancheHoraire> tranchehoraire;
    
    @javax.persistence.OneToMany(
    	fetch = javax.persistence.FetchType.LAZY
    )
    List<Reservation> reservation;
    
    @javax.persistence.OneToMany(
        cascade = {javax.persistence.CascadeType.ALL},
    	fetch = javax.persistence.FetchType.LAZY
    )
    List<Commande> commande;

    
    public void setId(Integer id) {
        this.id = id;
    }
    
    
    public Integer getId() {
        return this.id;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
    public String getNom() {
        return this.nom;
    }
    
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
    
    public String getAdresse() {
        return this.adresse;
    }
    
    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }
    
    
    public String getCodePostal() {
        return this.codePostal;
    }
    
    public void setVille(String ville) {
        this.ville = ville;
    }
    
    
    public String getVille() {
        return this.ville;
    }
    
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    
    public String getTelephone() {
        return this.telephone;
    }
    

    
    public void setPlat(Plat plat) {
        this.plats.add(plat);
    }
    
    
    public java.util.Collection<Plat> getPlats() {
        return this.plats;
    }
    
    public void setTranchehoraire(TrancheHoraire trancheHoraire) {
        this.tranchehoraire.add(trancheHoraire);
    }
    
    
    public List<TrancheHoraire> getTranchehoraire() {
        return this.tranchehoraire;
    }
    
    public void setReservation(Reservation reservation) {
        this.reservation.add(reservation);
    }
    
    
    public java.util.Collection<Reservation> getReservation() {
        return this.reservation;
    }
    
    public void setCommande(Commande commande) {
        this.commande.add(commande);
    }
    
    
    public java.util.Collection<Commande> getCommande() {
        return this.commande;
    }
    
}

