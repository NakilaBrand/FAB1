package fr.ginc.fab1.bean;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@javax.persistence.Entity

public class Plat implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private java.lang.Integer id;
    
    private java.lang.String nom;
    
    private java.lang.String description;
    
    private java.lang.Double prix;
    
    private java.lang.Double noteMoyenne;
    
    private java.lang.String imageURL;
    

    
    @javax.persistence.OneToMany(
        cascade = {javax.persistence.CascadeType.ALL},
    	fetch = javax.persistence.FetchType.LAZY
    )
    java.util.List<Commentaire> commentaires;

    
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
    
    public void setDescription(java.lang.String description) {
        this.description = description;
    }
    
    
    public java.lang.String getDescription() {
        return this.description;
    }
    
    public void setPrix(java.lang.Double prix) {
        this.prix = prix;
    }
    
    
    public java.lang.Double getPrix() {
        return this.prix;
    }
    
    public void setNoteMoyenne(java.lang.Double noteMoyenne) {
        this.noteMoyenne = noteMoyenne;
    }
    
    
    public java.lang.Double getNoteMoyenne() {
        return this.noteMoyenne;
    }
    
    public void setImageURL(java.lang.String imageURL) {
        this.imageURL = imageURL;
    }
    
    
    public java.lang.String getImageURL() {
        return this.imageURL;
    }
    

    
    public void setCommentaires(java.util.List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }
    
    
    public java.util.List<Commentaire> getCommentaires() {
        return this.commentaires;
    }
    
}

