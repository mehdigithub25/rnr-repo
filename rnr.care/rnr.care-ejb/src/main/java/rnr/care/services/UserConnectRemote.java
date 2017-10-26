package rnr.care.services;

import javax.ejb.Remote;

import rnr.care.entities.User;

@Remote
public interface UserConnectRemote {
	
	public  User getUserConnected() ;

	public  void logIn(User usr) ;

	public  void logOut() ;

}
