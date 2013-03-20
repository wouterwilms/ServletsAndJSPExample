package be.intecbrussel.servlets;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

@WebServlet("/TextToUTF")
public class TextToUTF8BinairServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;       

	private static final String VIEW = "/WEB-INF/JSP/UTF.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
		
		dispatcher.forward(request, response);		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
		
		String boodschap = request.getParameter("broncode");
		
		if (boodschap.equals("")) {
					
			request.setAttribute("error", "U hebt niets ingegeven!");
			
			dispatcher.forward(request, response);	
			
		} else {

		byte[] binair = null;

		try {
			binair = boodschap.getBytes("UTF8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		StringBuilder string = new StringBuilder();
		
		for (int i = 0; i < binair.length; i++) {
					
			String bin = StringUtils.leftPad(Integer.toBinaryString(binair[i]), 8, '0');
						
			string.append(bin + " ");
						
		}
		
		request.setAttribute("boodschap", string);
		
		dispatcher.forward(request, response);	
		
		}
		
	}

}
