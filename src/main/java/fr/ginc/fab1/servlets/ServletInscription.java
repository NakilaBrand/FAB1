package fr.ginc.fab1.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.ginc.fab1.aut.ConnexionForm;
import fr.ginc.fab1.bean.*;

@WebServlet("/inscription")
public class ServletInscription extends HttpServlet {
	public static final String VUE = "/WEB-INF/inscription.jsp";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Affichage de la page de connexion */
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}
}