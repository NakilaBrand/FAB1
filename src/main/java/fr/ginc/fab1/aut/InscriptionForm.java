package fr.ginc.fab1.aut;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import fr.ginc.fab1.bean.Utilisateur;
import fr.ginc.fab1.dao.GenericDao;
import fr.ginc.fab1.dao.GenericDaoImpl;

public final class InscriptionForm {
	private static final String CHAMP_EMAIL = "email";
	private static final String CHAMP_PASS = "password";
	private static final String CHAMP_CONF = "confirmation";
	private static final String CHAMP_NOM = "nom";
	private static final String CHAMP_PRENOM = "prenom";
	private static final String CHAMP_TEL = "telephone";

	private String resultat;
	private Map<String, String> erreurs = new HashMap<String, String>();
	private List<String> listErreurs = new ArrayList<>();
	private GenericDao<Utilisateur, String> dao = new GenericDaoImpl<>();

	public String getResultat() {
		return resultat;
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}
	public List<String> getListErreurs() {
		return listErreurs;
	}

	public Utilisateur inscrireUtilisateur(HttpServletRequest request) {
		String email = getValeurChamp(request, CHAMP_EMAIL);
		String motDePasse = getValeurChamp(request, CHAMP_PASS);
		String confirmation = getValeurChamp(request, CHAMP_CONF);
		String nom = getValeurChamp(request, CHAMP_NOM);
		String prenom = getValeurChamp(request, CHAMP_PRENOM);
		String tel = getValeurChamp(request, CHAMP_TEL);

		Utilisateur utilisateur = new Utilisateur();

		try {
			validationEmail(email);
		} catch (Exception e) {
			setErreur(CHAMP_EMAIL, e.getMessage());
			listErreurs.add("Veuillez renseigner un email valide");
			
		}
		utilisateur.setEmail(email);

		try {
			validationMotsDePasse(motDePasse, confirmation);
		} catch (Exception e) {
			setErreur(CHAMP_PASS, e.getMessage());
			setErreur(CHAMP_CONF, null);
		}
		utilisateur.setPassword(motDePasse);

		try {
			validationNom(nom);
		} catch (Exception e) {
			listErreurs.add("Veuillez renseigner un nom valide");
			setErreur(CHAMP_NOM, e.getMessage());
		}
		utilisateur.setNom(nom);
		
		try {
			validationNom(prenom);
		} catch (Exception e) {
			listErreurs.add("Veuillez renseigner un prenom valide");
			setErreur(CHAMP_NOM, e.getMessage());
		}
		utilisateur.setPrenom(prenom);
		
		try {
			validationTel(tel);
		} catch (Exception e) {
			listErreurs.add("Veuillez renseigner un numero de tel valide");
			setErreur(CHAMP_TEL, e.getMessage());
		}
		utilisateur.setTelephone(tel);
		utilisateur.setIsAdmin(false);
		

		if (erreurs.isEmpty()) {
			if (dao.findByAttr(Utilisateur.class, "email", utilisateur.getEmail()) == null) {
				try {

					dao.add(utilisateur);
				} catch (Exception e) {

					e.printStackTrace();
				}
				resultat = "Succes de l'inscription.";
			}else{
				
				resultat = "Echec de l'inscription : un Utilisateur avec cet email existe deja";
			}
		} else {
			resultat = "Echec de l'inscription.";
		}

		return utilisateur;
	}

	private void validationTel(String tel)  throws Exception{
		
		Integer.parseInt(tel);
		if(tel.length() != 10){
			throw new Exception("Merci de saisir un numero de telephone valide.");
		}
		
	}

	private void validationEmail(String email) throws Exception {
		if (email != null) {
			if (!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
				throw new Exception("Merci de saisir une adresse mail valide.");
			}
		} else {
			throw new Exception("Merci de saisir une adresse mail.");
		}
	}

	private void validationMotsDePasse(String motDePasse, String confirmation) throws Exception {
		if (motDePasse != null && confirmation != null) {
			if (!motDePasse.equals(confirmation)) {
				listErreurs.add("Les mots de passe entres sont differents, merci de les saisir à nouveau.");
				throw new Exception("Les mots de passe entres sont differents, merci de les saisir à nouveau.");
				
			} else if (motDePasse.length() < 5) {
				listErreurs.add("Les mots de passe doivent contenir au moins 5 caracteres.");
				throw new Exception("Les mots de passe doivent contenir au moins 5 caracteres.");
			}
		} else {
			throw new Exception("Merci de saisir et confirmer votre mot de passe.");
		}
	}

	private void validationNom(String nom) throws Exception {
		if (nom != null && nom.length() < 3) {
			throw new Exception("Le nom d'utilisateur doit contenir au moins 3 caractères.");
		}
	}

	/*
	 * Ajoute un message correspondant au champ spécifié à la map des erreurs.
	 */
	private void setErreur(String champ, String message) {
		erreurs.put(champ, message);
	}

	/*
	 * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
	 * sinon.
	 */
	private static String getValeurChamp(HttpServletRequest request, String nomChamp) {
		String valeur = request.getParameter(nomChamp);
		if (valeur == null || valeur.trim().length() == 0) {
			return null;
		} else {
			return valeur.trim();
		}
	}

}