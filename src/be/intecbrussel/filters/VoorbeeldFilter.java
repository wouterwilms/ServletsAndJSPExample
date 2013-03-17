package be.intecbrussel.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class VoorbeeldFilter implements Filter {
	
	private String attribuutTekst;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		System.out.println("voorbeeldFilter is uitgevoerd");
		
		request.setAttribute("attributeByFilter", attribuutTekst);
		
		chain.doFilter(request, response);
	
	}

	public void init(FilterConfig fConfig) throws ServletException {

		attribuutTekst = fConfig.getInitParameter("attribuutTekst");
		
	}
	
	public void destroy() {

		
	}

}
