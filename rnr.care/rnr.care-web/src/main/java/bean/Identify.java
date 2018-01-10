package bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import rnr.care.entities.Member;
import rnr.care.entities.Moderator;
import rnr.care.entities.User;
import rnr.care.services.UserManagerLocal;

@ManagedBean
@SessionScoped
public class Identify {

	private User user = new User();
	private boolean loggedIn = false;

			

	public Identify() {
		super();
	}


	@EJB
	private UserManagerLocal userManagerLocal;

	public String doLogin() {
		String navigateTo = "";
		User userLoggedIn = userManagerLocal.findbylogin(user.getUserName(), user.getPassword());
		userManagerLocal.logIn(userLoggedIn);
		if (userLoggedIn != null) {
			user = userLoggedIn;
			loggedIn = true;
			if (userLoggedIn instanceof Moderator) {
				navigateTo = "/pages/moderator/home?faces-redirect=true";
			} else if (userLoggedIn instanceof Member) {
				navigateTo = "/pages/member/home?faces-redirect=true";
			}
		} else {
			navigateTo = "/error?faces-redirect=true";
		}

		return navigateTo;
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	
     public User douserconnected() {
    	 
    	 return userManagerLocal.getUserConnected();
    	 
     }
	


}
