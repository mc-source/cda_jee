package cda.afip.servlets;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import cda.afip.model.User;
import cda.afip.model.UserManager;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet({ "/MainServlet", "/main" })
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(MainServlet.class);

	//méthode (action) appelée automatiquement lors
	//appel 'get' (http)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vue_name = "accueil.jsp"; //chemin relatif vue à afficher
		String title="Accueil";

		//récuperer Paramètre d'URL  : .main?page=xxx (param=page)
		String page = request.getParameter("page");
		logger.info("page demandée = "+page);
		if(page!=null) {			
			if("logout".equals(page)) {
				request.getSession().setAttribute("user", null);			
			}else {
				vue_name="views/"+ page+".jsp"; 
				title=page.substring(0,1).toUpperCase()
						+page.substring(1).toLowerCase();
			}
		}


		String path = getServletContext().getRealPath(vue_name);
		logger.info("vue à afficher = "+path);
		/*
		 * Test si page (et donc vue) n'existe pas :
		 * Retour vers page error(.jsp)!!
		 */
		if(!ExistView(vue_name)) {
			//page demandée n'existe pas!!!
			vue_name="views/error.jsp";
			title="404";
		}
		request.setAttribute("title", title);	

		//Renvoyer une vue! (page jsp, html..)	
		RequestDispatcher dispatcher = request.getRequestDispatcher(vue_name);
		dispatcher.forward(request, response); //afficher!		
		logger.info("MainServlet : appel méthode doGet..");

		//envoi info à la vue 
		//request.setAttribute("message", "Bienvenue sur notre site!");
		//request.setAttribute("user", "anonymous!");		
		//saveInSession(request, LocalDateTime.now());
	}
	//méthode (action) appelée automatiquement lors
	//appel 'post' (http) : exp. formulaire!!
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("MainServlet : appel méthode doPost..");
		HttpSession session = request.getSession();

		String login = request.getParameter("login");
		String password = request.getParameter("password");

		String vue_name="views/login.jsp";
		String message="Accès non autorisé!";	
		String title="Login";

		UserManager um = new UserManager();
		User user = um.login(login, password);
//		if("admin".equals(login) && "123".equals(password)) {
		if(user!=null) {		
			message="Welcome";
			title="Admin Area!";
			vue_name="views/admin.jsp";			
		}	
//		//Gestion Session
		session.setAttribute("user", user);
		request.setAttribute("title", title);	
		request.setAttribute("message", message);		
		request.getRequestDispatcher(vue_name).forward(request, response);
	}

	private boolean ExistView(String vue_name) {
		String fullPath = getServletContext().getRealPath(vue_name);
		try {
			File fview=new File(fullPath);
			return fview.exists();
		} catch (Exception e) {	}
		return false;
	}


	private void saveInSession(HttpServletRequest request, Object x) {
		HttpSession session = request.getSession();
		session.setAttribute("x", x );	
	}

}
