package cda.afip.servlets;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import cda.afip.model.DocManager;
import cda.afip.model.Document;
import cda.afip.model.User;
import cda.afip.model.UserManager;

/**
 * Servlet implementation class DocServlet
 */
@WebServlet("/docs")
public class DocServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(DocServlet.class);
	
	private static final String VIEW_PATH="views/docs/";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Renvoyer (+ model eventuel) vue dans /docs		
		String view_name=VIEW_PATH+"index.jsp";
		String title = "Index";
		
		String action = request.getParameter("action");
		if(action!=null) {
			 view_name=VIEW_PATH+action+".jsp";
			 title = format_title(action);
		}
		
		DocManager dm = new DocManager(); 
		if(action==null || action.equals("index")) {
			List<Document> items = dm.getAll();
			request.setAttribute("items", items);
			
		}else if(action.equals("update") || action.equals("delete")) {		
			int id=0;
			try {
				id = Integer.parseInt(request.getParameter("id"));
			} catch (Exception e) {}
			
			Document item = dm.getById(id);			
			request.setAttribute("item", item);			
		}
					
		if(!ExistView(view_name)) {
			view_name="views/error.jsp";
			title="404";
		}	
		
		if(action!=null && (action.equals("update") || action.equals("add"))) {	
			// ajouter list 'users' au model
			request.setAttribute("users", new UserManager().getAll());
		}
		
		request.setAttribute("title", title);
		request.getRequestDispatcher(view_name).forward(request, response);
	}

	private String format_title(String title) {
		return title.substring(0,1).toUpperCase()+title.substring(1).toLowerCase();
	}

	private boolean ExistView(String vue_name) {
		String fullPath = getServletContext().getRealPath(vue_name);
		try {
			File fview=new File(fullPath);
			return fview.exists();
		} catch (Exception e) {	}
		return false;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DocManager dm = new DocManager(); 
		
		//traiter form (confirmation) suppression (delete)!
		if(request.getParameter("btn_delete_action")!=null) {
			int id = Integer.parseInt(request.getParameter("id"));
			Document item = dm.getById(id);
			if(item!=null)
				dm.delete(item);
		}
		else if(request.getParameter("btn_add_action")!=null) {		
			logger.info("===========>ADD!");
			
			Document doc = fromForm(request);
			if(doc!=null)
				dm.add(doc);
		}
		else if(request.getParameter("btn_update_action")!=null) {
			logger.info("===========>UPDATE!");
			
			Document doc = fromForm(request);
			if(doc!=null)
				dm.update(doc);
		}
				
		doGet(request, response);
	}

	private Document fromForm(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String path=request.getParameter("path");
		byte type=Byte.parseByte(request.getParameter("type"));
		int user_id=Integer.parseInt(request.getParameter("user"));
		User user = new UserManager().getById(user_id);
		
		logger.info("Document ==> form = id "+id+" | "+name+" | path = "+path+" | type = "+type+" | user = "+user );			
		
		Document doc = new Document(id, name, path ,type, user);
		return doc;
	}

}
