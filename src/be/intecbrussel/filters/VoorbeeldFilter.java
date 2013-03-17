package be.intecbrussel.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class VoorbeeldFilter implements Filter {
	
	private String attribuutTekst;
	
	private FilterConfig config = null;
	
    private ServletContext sc = null;
    
    private static final String VIEW = "/WEB-INF/JSP/toManyFilterHits.jsp";
	
	int hitCount;
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		// incrementing hitCount
		hitCount++;
		
		// controleren of er meer dan vijf hits zijn
		if (hitCount > 5){
					
		// De request en response forwarden naar een VIEW
		sc.getRequestDispatcher(VIEW).forward(request, response);	
			
		} else {
		
		System.out.println(config.getFilterName() + " is " + hitCount + " maal uitgevoerd");
		
		request.setAttribute("attributeByFilter", attribuutTekst);
		
		// Hiermee geef je de request en response door naar de volgende stap 
		// in de FilterChain (ofwel een volgende filter ofwel de Servlet)
		chain.doFilter(request, response);
		
		}
		
	}

	// Deze methode wordt uitgevoerd bij de initialisatie van de Filter 
	// (ofwel bij de opstart van Catalina ofwel bij de eerste request 
	// die door deze filter dient te worden onderschept)
	public void init(FilterConfig fConfig) throws ServletException {

		attribuutTekst = fConfig.getInitParameter("attribuutTekst");
		
		sc = fConfig.getServletContext();
		
		this.config = fConfig;
		
	}
	
	// Deze methode wordt uitgevoerd bij het stoppen van de Server
	public void destroy() {

		config = null;
		
	}

}
