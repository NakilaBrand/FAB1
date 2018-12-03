package fr.ginc.fab1.bean;


@javax.persistence.Entity

public class Utilisateur implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;

    @javax.persistence.Id
    private java.lang.Integer id;
    
    private java.lang.String nom;
    
    private java.lang.String prenom;
    
    private java.lang.String email;
    
    private java.lang.String password;
    
    private java.lang.String telephone;
    
    private java.lang.Boolean isAdmin;
    

    
    @javax.persistence.ManyToOne(
        cascade = {javax.persistence.CascadeType.ALL},
    	fetch = javax.persistence.FetchType.LAZY
    )
    Restaurant restaurantPrefere;

    
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
    
    public void setPrenom(java.lang.String prenom) {
        this.prenom = prenom;
    }
    
    
    public java.lang.String getPrenom() {
        return this.prenom;
    }
    
    public void setEmail(java.lang.String email) {
        this.email = email;
    }
    
    
    public java.lang.String getEmail() {
        return this.email;
    }
    
    public void setPassword(java.lang.String password) {
        this.password = password;
    }
    
    
    public java.lang.String getPassword() {
        return this.password;
    }
    
    public void setTelephone(java.lang.String telephone) {
        this.telephone = telephone;
    }
    
    
    public java.lang.String getTelephone() {
        return this.telephone;
    }
    
    public void setIsAdmin(java.lang.Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    
    
    public java.lang.Boolean getIsAdmin() {
        return this.isAdmin;
    }
    

    
    public void setRestaurantPrefere(Restaurant restaurantPrefere) {
        this.restaurantPrefere = restaurantPrefere;
    }
    
    
    public Restaurant getRestaurantPrefere() {
        return this.restaurantPrefere;
    }
    
}

