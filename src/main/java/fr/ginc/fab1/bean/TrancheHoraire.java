package fr.ginc.fab1.bean;


@javax.persistence.Entity

public class TrancheHoraire implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;

    @javax.persistence.Id
    private java.lang.Integer id;
    
    private java.util.Date debut;
    
    private java.util.Date fin;
    

    

    
    public void setId(java.lang.Integer id) {
        this.id = id;
    }
    
    
    public java.lang.Integer getId() {
        return this.id;
    }
    
    public void setDebut(java.util.Date debut) {
        this.debut = debut;
    }
    
    
    public java.util.Date getDebut() {
        return this.debut;
    }
    
    public void setFin(java.util.Date fin) {
        this.fin = fin;
    }
    
    
    public java.util.Date getFin() {
        return this.fin;
    }
    

    
}

