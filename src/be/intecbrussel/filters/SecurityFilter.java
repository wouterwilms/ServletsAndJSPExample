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

	// Met deze boolean geven we aan of er al dan niet een cookie
	// aanwezig is die de gebruiker toegang geeft tot het beveiligd
	// onderdeel.
	private boolean securityCookieOK;

	// Met deze boolean geven we aan of een gebruikersnaam gevonden is
	// in de gebruikers DB
	private boolean found;

	// Met deze boolean geven we aan of die gebruiker ook toegang krijgt
	// tot het beveiligd deel (dat het meegegeven paswoord ook correct is)
	private boolean acces;

	public SecurityFilter() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		// ==============================================
		// In dit gedeelte doen we wat voorbereiding
		// ==============================================

		// initieel zetten we de al de controles op false
		securityCookieOK = false;
		found = false;
		acces = false;
		
		// Als de security check faalt gaan we redirecten naar een login
		// venster met de volgende URL.
		final String REDIRECT_URL = request.getServletContext()
				.getContextPath() + "/UserServlet";

		// In de filter krijg je een request object mee van het type
		// ServletRequest.
		// Omdat we hier zeker weten dat we te maken hebben met een
		// HttpServletRequest
		// casten wij de request naar een HttpServletRequest zodat we toegang
		// hebben
		// tot al de methodes van HttpServletRequest.
		HttpServletRequest httpRequest = (HttpServletRequest) request;

		// Analoog met request
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		// Een van de methodes die we nu kunnen gebruiken van HttpServletRequest
		// is
		// 'getSession()'. Hiermee vragen we nu de session op van de gebruiker.
		HttpSession session = httpRequest.getSession();

		// We zetten in de session een boolean die aangeeft of de user
		// al dan niet gevonden is. Deze attributen gebruiken we om bij
		// een fout aan te geven waar de fout juist zit. Ofwel bij het
		// opvragen van de gebruiker 'userNotFound' ofwel bij het controleren
		// van het paswoord 'wrongPassword'.
		session.setAttribute("userNotFound", false);
		session.setAttribute("wrongPassword", false);

		// ==============================================
		// In dit gedeelte controleren we de cookie
		// ==============================================

		// controleren of er cookies zijn
		if (httpRequest.getCookies() != null) {

			// de cookies overlopen
			for (Cookie cookie : httpRequest.getCookies()) {

				// kijken of er een 'accesCookie' aanwezig is en of die de 
				// juiste waarde heeft
				if (cookie.getName().equals("accesCookie")
						&& cookie.getValue().equals(
								session.getAttribute("accesCode"))) {

					// laten weten dat de cookie in orde is
					securityCookieOK = true;

				}

			}

		}

		// controleren of de cookie in orde is
		if (securityCookieOK) {

			// de gebruiker mag gewoon doorgaan
			chain.doFilter(request, response);

		} else {
			
			// ==============================================
			// In dit gedeelte proberen we de user in te loggen
			// ==============================================

			// de ingegeven userName opvragen
			String userName = request.getParameter("loginUserName");

			// het ingegeven paswoord opvragen
			String pwd = request.getParameter("loginPassword");

			// controleren of deze waarden niet null zijn
			if (userName != null && pwd != null) {

				User user = new User();

				// controleren of de user aanwezig is
				try {

					user = userDAO.findOne(userName);

					// aangeven dat de user gevonden is
					found = true;

				} catch (DAOException ex) {

					System.out.println(ex.getMessage());

				}
				
				// het meegegeven paswoord hashen
				String hashedPwd = security.heavyHash(pwd);

				// als de user gevonden is
				if (found) {

					// controleren of de paswoord hash overeenkomt met de
					// hash in de database
					if (hashedPwd.equals(user.getPwdHash())) {

						// aangeven dat het paswoord juist is
						acces = true;

					}

				} else {
					
					// Als de user niet gevonden zou zijn passen we
					// het session attribuut aan om de gebruiker dit
					// te laten weten.
					session.setAttribute("userNotFound", !found);

					// We sturen de gebruiker naar de login - pagina
					httpResponse.sendRedirect(REDIRECT_URL);

					// De methode mag (moet) nu stoppen
					return;

				}
				
				// als het paswoord juist is
				if (acces) {
					
					// zetten we een cookie zodat de gebruiker niet telkens
					// zijn gegevens moet ingeven om in het beveiligd gedeelte
					// te komen
					Cookie accesCookie = new Cookie("accesCookie", hashedPwd);

					accesCookie.setMaxAge(600);

					httpResponse.addCookie(accesCookie);

					// Om de waarde van de cookie te controleren zetten we
					// deze waarde in een session attribuut
					session.setAttribute("accesCode", hashedPwd);

					// de gebruiker mag nu doorgaan
					chain.doFilter(request, response);

				} else {

					// Als het paswoord niet juist is passen we het
					// het session attribuut aan om de gebruiker dit
					// te laten weten.
					session.setAttribute("wrongPassword", !acces);

					// We sturen de gebruiker naar de login - pagina
					httpResponse.sendRedirect(REDIRECT_URL);

					// De methode mag (moet) nu stoppen
					return;

				}

			} else {
								
				// Als er geen paswoord of username is ingegeven
				// sturen we de gebruiker naar een login - pagina
				// waar hij deze kan ingeven
				httpResponse.sendRedirect(REDIRECT_URL);

				// De methode mag (moet) nu stoppen
				return;

			}

		}

	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
