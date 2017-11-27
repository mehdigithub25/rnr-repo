package rnr.care.services;

import javax.ejb.Remote;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import rnr.care.entities.User;

@Remote
@WebService
public interface UserConnectRemote {
	@WebMethod(operationName = "getUserConnected")
	@WebResult()
	public  User getUserConnected() ;
	@WebMethod(operationName = "login")
	@WebResult()
	public  void logIn(User usr) ;
	@WebMethod(operationName = "logout")
	@WebResult()
	public  void logOut() ;

}
