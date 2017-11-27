package rnr.care.services;

import javax.ejb.Remote;
import javax.jws.WebMethod;

import javax.jws.WebParam;

import javax.jws.WebResult;
import javax.jws.WebService;

import rnr.care.entities.User;


@Remote
@WebService
public interface UserConnectRemote {
	@WebMethod(operationName = "getUserConnected")
	@WebResult()

	public User getUserConnected();

	@WebMethod(operationName = "logIn")
	@WebResult()
	public void logIn(@WebParam(name = "user") User usr);

	@WebMethod(operationName = "logOut")
	@WebResult()
	public void logOut();


}
