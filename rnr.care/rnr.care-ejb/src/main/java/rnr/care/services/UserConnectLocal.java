package rnr.care.services;

import javax.ejb.Local;

import rnr.care.entities.User;

@Local
public interface UserConnectLocal {
	
	

	

	public  User getUserConnected() ;

	public  void logIn(User usr) ;

	public  void logOut() ;
	

}
