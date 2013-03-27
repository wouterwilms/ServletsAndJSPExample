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

	private final UserDAO userDAO = new UserDAO();

	private final Security security = new Security();
	
	public SecurityFilter() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		final String REDIRECT_URL = request.getServletContext()
				.getContextPath() + "/UserServlet";

		boolean securityCookieOK = false;
		
		boolean found = false;

		boolean acces = false;
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;

		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		HttpSession session = httpRequest.getSession();
		
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
