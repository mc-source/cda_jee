package cda.afip.servlets;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.log4j.Logger;

@WebServlet("/uploads")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
maxFileSize = 1024 * 1024 * 5, 
maxRequestSize = 1024 * 1024 * 5 * 5)
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(UploadServlet.class);
	private static final String UPLOAD_DIRECTORY = "uploads";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("btn_file_upload")!=null) {			
			String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists()) uploadDir.mkdir();

			for (Part part : request.getParts()) {
				String fileName = getFileName(part);	    
				if(fileName!=null) {
					logit("POST - upload : fileName = "+uploadPath + File.separator + fileName);
					part.write(uploadPath + File.separator + fileName);
				}
			}
		}
	}
	private String getFileName(Part part) {
		for (String content : part.getHeader("content-disposition").split(";"))	    	
			if (content.trim().startsWith("filename")) {

				String temp = content.substring(content.indexOf("=") + 2, content.length() - 1);
				File f = new File(temp);

				String filename = temp.substring(f.getParent().length()+1);
				logit("content : "+filename);	
				return filename;    
			}
		return null;
	}
	private void logit(String message) {
		logger.info("===========================================");
		logger.info("====>"+message);
		logger.info("===========================================");
	}
}
