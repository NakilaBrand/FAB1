package fr.ginc.fab1.aut;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
//

import fr.ginc.fab1.bean.Utilisateur;
import fr.ginc.fab1.dao.GenericDao;
import fr.ginc.fab1.dao.GenericDaoImpl;

public final class ConnexionForm {
	private static final String CHAMP_EMAIL = "email";
	private static final String CHAMP_PASS = "password";

	private String resultat;
	private Map<String, String> erreurs = new HashMap<String, String>();
	private GenericDao<Utilisateur, String> daoString = new GenericDaoImpl<>();
	//private GenericDao<Utilisateur, Integer> daoInt = new GenericDaoImpl<>();

	public String getResultat() {
		return resultat;
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public Utilisateur connecterUtilisateur(HttpServletRequest request) throws Exception {
		/* Récupération des champs du formulaire */
		String email = getValeurChamp(request, CHAMP_EMAIL);
		String motDePasse = getValeurChamp(request, CHAMP_PASS);

		Utilisateur utilisateur;

		/* Validation du champ email. */
		try {
			validationEmail(email);
		} catch (Exception e) {
			setErreur(CHAMP_EMAIL, e.getMessage());
		}

		/* Validation du champ mot de passe. */
		try {
			validationMotDePasse(motDePasse);
		} catch (Exception e) {
			setErreur(CHAMP_PASS, e.getMessage());
		}

		/* Initialisation du résultat global de la validation. */
		if (erreurs.isEmpty()) {
			resultat = "Succes de la connexion.";
		} else {
			resultat = "Echec de la connexion.";
		}
		utilisateur = daoString.findByAttr(Utilisateur.class, "email", email);
		
		
		//TODO need mdp crypté
		if(utilisateur != null && !utilisateur.getPassword().trim().equals(motDePasse.trim())){
			System.out.println("movai mdp");
			throw new Exception("Mot de passe defectueux !! bip bip");
		}
		System.out.println(utilisateur.getPassword());
		System.out.println("---------------------------------------\n"
				+ "Vous etes co en tant que "
				+ utilisateur.getNom() + " " + utilisateur.getPrenom());

		return utilisateur;
	}

	/**
	 * Valide l'adresse email saisie.
	 */
	private void validationEmail(String email) throws Exception {
		if (email != null && !email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
			throw new Exception("Merci de saisir une adresse mail valide.");
		}
	}

	/**
	 * Valide le mot de passe saisi.
	 */
	private void validationMotDePasse(String motDePasse) throws Exception {
		if (motDePasse != null) {
			if (motDePasse.length() < 5) {
				throw new Exception("Le mot de passe doit contenir au moins 5 caracteres.");
			}
		} else {
			throw new Exception("Merci de saisir votre mot de passe.");
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
			return valeur;
		}
	}
}