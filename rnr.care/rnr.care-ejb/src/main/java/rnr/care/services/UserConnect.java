package rnr.care.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import rnr.care.entities.User;

/**
 * Session Bean implementation class UserConnect
 */
@Stateless
@LocalBean
@WebService(name = "rnrPortype", portName = "rnrPort", serviceName = "UserConnectService", targetNamespace = "http://rnranimal.tn", endpointInterface = "rnr.care.services.UserConnectRemote")
public class UserConnect implements UserConnectRemote, UserConnectLocal {
	private static User usr;

	public UserConnect() {

	}

	public UserConnect(User usr) {
		super();
		this.usr = usr;
	}

	/**
	 * Default constructor.
	 */
	@WebMethod
	@WebResult()
	@Override
	public User getUserConnected() {
		return usr;
	}
	@WebMethod
	@WebResult()
	@Override
	public void logIn(User usr) {
		UserConnect.usr = usr;

	}
	@WebMethod
	@WebResult()
	@Override
	public void logOut() {
		UserConnect.usr = null;

	}

}
