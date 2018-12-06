package fr.ginc.fab1.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.ginc.fab1.bean.Utilisateur;

/**
 * Servlet implementation class ServletAjoutAvis
 */
@WebServlet(urlPatterns = {"/accueil.html", "/AdminReservations.html", "/AdminPlat.html", "/adminCarte.html", "/adminModifPlat.html",
		"/adminCommandes.html", "adminAccueil.html" })
public class ServletRedirection extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		Utilisateur user = (Utilisateur) request.getSession().getAttribute("utilisateur");

		response.setHeader("Cache-Control", "no-cache");
		System.out.println(user.getEmail() + "   " + user.getIsAdmin());
		if (user != null && user.getIsAdmin()) {
			if(path.equals("/accueil.html")){
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/adminAccueil.html");
				rd.forward(request, response);
			}
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF" + path);
			rd.forward(request, response);
		} else {
			if(path.equals("/accueil.html")){
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/accueil.html");
				rd.forward(request, response);
			}
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/erreur.html");
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/modules/module4/demonstrations/ajoutAvis.jsp");
		rd.forward(request, response);
	}

}
