package rnr.care.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import rnr.care.entities.User;

/**
 * Session Bean implementation class UserConnect
 */
@Stateless
@LocalBean
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

	@Override
	public User getUserConnected() {
		return usr;
	}

	@Override
	public void logIn(User usr) {
		UserConnect.usr = usr;

	}

	@Override
	public void logOut() {
		UserConnect.usr = null;

	}

}
