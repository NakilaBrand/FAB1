package fr.ginc.fab1.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.ginc.fab1.aut.ConnexionForm;
import fr.ginc.fab1.aut.InscriptionForm;
import fr.ginc.fab1.bean.*;
import fr.ginc.fab1.dao.GenericDao;
import fr.ginc.fab1.dao.GenericDaoImpl;

@WebServlet("/inscription")
public class ServletInscription extends HttpServlet {
	public static final String VUE = "/WEB-INF/inscription.jsp";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Affichage de la page de connexion */
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		InscriptionForm form = new InscriptionForm();
		
		/* Traitement de la requête et récupération du bean en résultant */
		Utilisateur utilisateur = form.inscrireUtilisateur(request);

		/* Récupération de la session depuis la requête */
		HttpSession session = request.getSession();
		
		if (form.getErreurs().isEmpty()) {
			session.setAttribute("utilisateur", utilisateur);
		} else {
			session.setAttribute("utilisateur", null);
		}
		

		
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}
}