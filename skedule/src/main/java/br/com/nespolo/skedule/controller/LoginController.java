package br.com.nespolo.skedule.controller;

import java.io.IOException;
import java.io.Serializable;
import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import br.com.nespolo.skedule.global.util.DateUtility;

@ViewScoped
@Controller
@ManagedBean(name = "loginController")
public class LoginController implements Serializable
{
	private static final long serialVersionUID = 6046276213130133806L;

	@Inject
	private transient Logger logger;
	private String username;
	private String password;

	public LoginController()
	{
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	/**
	 * Listen for button clicks on the #{loginController.login} action,
	 * validates the username and password entered by the user and navigates to
	 * the appropriate page.
	 * 
	 * @param actionEvent
	 */
	public void login(ActionEvent actionEvent)
	{
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		try
		{
			String navigateString = "";
			// Checks if username and password are valid if not throws a ServletException
			request.login(username, password);
			// gets the user principle and navigates to the appropriate page
			Principal principal = request.getUserPrincipal();
			if (request.isUserInRole("Administrator"))
			{
				navigateString = "/admin/AdminHome.xhtml";
			} else if (request.isUserInRole("Manager"))
			{
				navigateString = "/manager/ManagerHome.xhtml";
			} else if (request.isUserInRole("User"))
			{
				navigateString = "/user/UserHome.xhtml";
			} else
				navigateString = "/p/skedule.jsf";
			try
			{
				logger.log(Level.INFO, "User ({0}) loging in #" + DateUtility.getCurrentDateTime(), request.getUserPrincipal().getName());
				context.getExternalContext().redirect(request.getContextPath() + navigateString);
			} catch (IOException ex)
			{
				logger.log(Level.SEVERE, "IOException, Login Controller" + "Username : " + principal.getName(), ex);
				context.addMessage(null, new FacesMessage("Error!", "Exception occured"));
			}
		} catch (ServletException e)
		{
			logger.log(Level.SEVERE, e.toString());
			context.addMessage(null, new FacesMessage("Error!", "The username or password you provided does not match our records."));
		}
	}

	/**
	 * Listen for logout button clicks on the #{loginController.logout} action
	 * and navigates to login screen.
	 */
	public void logout()
	{
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		logger.log(Level.INFO, "User ({0}) loging out #" + DateUtility.getCurrentDateTime(), request.getUserPrincipal().getName());
		if (session != null)
		{
			session.invalidate();
		}
		FacesContext.getCurrentInstance().getApplication().getNavigationHandler()
				.handleNavigation(FacesContext.getCurrentInstance(), null, "/Login.xhtml?faces-redirect=true");
	}

	public String doLogin() throws ServletException, IOException
	{
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		HttpServletRequest request = ((HttpServletRequest) context.getRequest());

		ServletResponse resposnse = ((ServletResponse) context.getResponse());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/j_spring_security_check");
		dispatcher.forward(request, resposnse);
		FacesContext.getCurrentInstance().responseComplete();

		return null;
	}
}
