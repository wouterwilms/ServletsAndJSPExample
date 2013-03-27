package be.intecbrussel.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.intecbrussel.dao.DAOException;
import be.intecbrussel.dao.UserDAO;
import be.intecbrussel.entities.User;
import be.intecbrussel.util.Security;

@WebFilter("/SecretPart")
public class SecurityFilter implements Filter {
	
	// Om een gebruiker in te loggen gaan we moeten controleren
	// of de gebruiker bestaat in de gebruikers DB. Hier zorgen 
	// we ervoor dat we over een UserDAO beschikken.
	private final UserDAO userDAO = new UserDAO();

	// Met deze utility Class kunnen we een veilige hash genereren
	// voor het paswoord van een gebruiker.
	private final Security security = new Security();
	
	public SecurityFilter() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		// Als de security check faalt gaan we redirecten naar een login
		// venster met de volgende URL.
		final String REDIRECT_URL = request.getServletContext()
				.getContextPath() + "/UserServlet";

		// Met deze boolean geven we aan of er al dan niet een cookie 
		// aanwezig is die de gebruiker toegang geeft tot het beveiligd
		// onderdeel.
		boolean securityCookieOK = false;
		
		// Met deze boolean geven we aan of een gebruikersnaam gevonden is
		// in de gebruikers DB
		boolean found = false;

		// Met deze boolean geven we aan of die gebruiker ook toegang krijgt
		// tot het beveiligd deel (dat het meegegeven paswoord ook correct is)
		boolean acces = false;
		
		// In de filter krijg je een request object mee van het type ServletRequest.
		// Omdat we hier zeker weten dat we te maken hebben met een HttpServletRequest
		// casten wij de request naar een HttpServletRequest zodat we toegang hebben
		// tot al de methodes van HttpServletRequest.
		HttpServletRequest httpRequest = (HttpServletRequest) request;

		// Analoog met request
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		// Een van de methodes die we nu kunnen gebruiken van HttpServletRequest is
		// 'getSession()'. Hiermee vragen we nu de session op van de gebruiker.
		HttpSession session = httpRequest.getSession();
		
		// Initieel geven we 
		session.setAttribute("userNotFound", found);
		
		session.setAttribute("WrongPassword", acces);

		if (httpRequest.getCookies() != null) {

			for (Cookie cookie : httpRequest.getCookies()) {

				if (cookie.getName().equals("accesCookie")
						&& cookie.getValue().equals(
								session.getAttribute(
										"accesCode"))) {

					securityCookieOK = true;

				}

			}

		}

		if (securityCookieOK) {

			chain.doFilter(request, response);

		} else {

			String userName = request.getParameter("loginUserName");

			String pwd = request.getParameter("loginPassword");

			if (userName != null && pwd != null) {

				User user = new User();				

				try {

					user = userDAO.findOne(userName);

					found = true;

				} catch (DAOException ex) {

					System.out.println(ex.getMessage());

				}

				String hashedPwd = security.heavyHash(pwd);

				if (found) {

					if (hashedPwd.equals(user.getPwdHash())) {

						acces = true;
						
					}

				} else { 
					
					session.setAttribute("userNotFound", !found);				
					
					httpResponse.sendRedirect(REDIRECT_URL);
					
					return;
				
				}

				if (acces) {

					Cookie accesCookie = new Cookie("accesCookie", hashedPwd);

					accesCookie.setMaxAge(600);

					httpResponse.addCookie(accesCookie);

					session.setAttribute("accesCode",
							hashedPwd);

					chain.doFilter(request, response);

				} else { 			
					
					session.setAttribute("wrongPassword", !acces);
					
					httpResponse.sendRedirect(REDIRECT_URL);
					
					return;
					
				}
								
			} else {

				httpResponse.sendRedirect(REDIRECT_URL);

				return;

			}

		}

	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
