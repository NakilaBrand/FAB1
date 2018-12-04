package fr.ginc.fab1.bean;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@javax.persistence.Entity

public class Commentaire implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private java.lang.Integer id;
    
    private java.lang.Integer note;
    
    private java.lang.String description;
    
    private java.util.Date date;
    

    
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
    
    public void setNote(java.lang.Integer note) {
        this.note = note;
    }
    
    
    public java.lang.Integer getNote() {
        return this.note;
    }
    
    public void setDescription(java.lang.String description) {
        this.description = description;
    }
    
    
    public java.lang.String getDescription() {
        return this.description;
    }
    
    public void setDate(java.util.Date date) {
        this.date = date;
    }
    
    
    public java.util.Date getDate() {
        return this.date;
    }
    

    
    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    
    
    public Utilisateur getUtilisateur() {
        return this.utilisateur;
    }
    
}

