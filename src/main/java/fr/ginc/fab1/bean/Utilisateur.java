package fr.ginc.fab1.bean;

public class Utilisateur {
	private String email;
	private String mdp;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public Utilisateur(String email, String mdp) {
		super();
		this.email = email;
		this.mdp = mdp;
	}
	public Utilisateur() {
		
	}
	
}
