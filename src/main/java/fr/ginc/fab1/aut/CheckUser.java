package fr.ginc.fab1.aut;

import java.util.ArrayList;
import java.util.List;

import fr.ginc.fab1.bean.Utilisateur;

public class CheckUser {
	/**
	 * 
	 * @param utilisateur
	 * @return la liste des messages d'erreurs lors du check de l'utilisateur
	 */
	public static List<String> check(Utilisateur u) {
		List<String> erreurs = new ArrayList<String>();
		try {
			checkEmail(u.getEmail());
		} catch (Exception e) {
			erreurs.add(e.getMessage());
		}
		try {
			checkMDP(u.getPassword());
		} catch (Exception e) {
			erreurs.add(e.getMessage());
		}
		try {
			
			checkTel(u.getTelephone());
		} catch (Exception e) {
			erreurs.add(e.getMessage());
		}
		return erreurs;
	}
	

	private static void checkTel(String telephone) throws Exception {
		if(telephone == null){
			throw new Exception("veuillez renseigner un numéro de tel");
		}
		else if( telephone.length() != 10){ 
			throw new Exception("Merci de rentrer un numéro de téléphone valide de 10 chiffres");
		}try{
			Integer.parseInt(telephone);
		}catch(Exception e){
			throw new Exception("Merci de rentrer uniquement des chiffres");
		}

	}

	private static void checkEmail(String email) throws Exception {
		if (email != null && !email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
			throw new Exception("Merci de saisir une adresse mail valide.");
		}
	}

	private static void checkMDP(String motDePasse) throws Exception {
		if (motDePasse != null) {
			if (motDePasse.length() < 5) {
				throw new Exception("Le mot de passe doit contenir au moins 5 caracteres.");
			}
		} else {
			throw new Exception("Merci de saisir votre mot de passe.");
		}
	}
}
