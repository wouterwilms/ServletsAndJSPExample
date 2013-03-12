package be.intecbrussel.servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.intecbrussel.entities.Auto;


@WebServlet("/JSTLServlet")
public class JSTLServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	private static final String VIEW = "WEB-INF/JSP/JSTL.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
		
		List<String> instructeurs = Arrays.asList("Mohamed", "Kenneth", "Kevin");
		
		request.setAttribute("instructeurs", instructeurs);
		
		Auto eersteAuto = new Auto ("Ferrari", "458 Italia", "Ferrari/Maserati naturally aspirated direct fuel injection 270 cu in V8 producing 562 hp at 9000 rpm", new BigDecimal(229825));
		
		Auto tweedeAuto = new Auto ("Aston Martin", "DB9" , "Aston Martin naturally aspirated DOHC 6L V12 producing 469 hp at 6000 rpm ", new BigDecimal(198700));
		
		Auto derdeAuto = new Auto ("Pagani", "Huayra", "Mercedes-AMG bi-turbo M158 5980cc V12 producing 730 hp", new BigDecimal(1510940));

		ArrayList<Auto> collectie = new ArrayList<Auto>();
		
		collectie.add(eersteAuto);
		
		collectie.add(tweedeAuto);
		
		collectie.add(derdeAuto);
		
		request.setAttribute("collectie", collectie);	
		
		Map<String, Auto> collectieMap = new LinkedHashMap<String, Auto>();
		
		collectieMap.put(instructeurs.get(1), eersteAuto);
		
		collectieMap.put(instructeurs.get(2), tweedeAuto);
		
		collectieMap.put(instructeurs.get(0), derdeAuto);
		
		request.setAttribute("collectieMap", collectieMap);		
		
		dispatcher.forward(request, response);
		
	}


}
