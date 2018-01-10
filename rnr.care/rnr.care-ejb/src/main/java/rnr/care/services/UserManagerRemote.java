package rnr.care.services;

import java.util.List;

import javax.ejb.Remote;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import rnr.care.entities.Member;
import rnr.care.entities.User;

@WebService
@Remote
public interface UserManagerRemote {

	@WebMethod(operationName = "addUser1")
	@WebResult()

	void addUser(@WebParam(name = "user") User user);

	@WebMethod(operationName = "updateUser1")
	@WebResult
	void updateUser(@WebParam(name = "user") User user);

	// @WebMethod(operationName="deleteUser1")
	// @WebResult
	// void deleteUser(@WebParam(name ="user")User user);

	/*
	 * @WebMethod(operationName = "deleteUserById1")
	 * 
	 * @WebResult void deleteUserById(@WebParam(name = "IdUser") int id);
	 * 
	 * // @WebMethod(operationName="deleteUser1") // @WebResult // void
	 * deleteUser(@WebParam(name ="user")User user);
	 */

	@WebMethod(operationName = "findUserById1")
	@WebResult
	User findUserById(@WebParam(name = "IdUser") int id);

	// @WebMethod(operationName="findUserByPseudo1")
	// @WebResult
	// User findUserByPseudo(@WebParam(name = "UserName") String pseudo);

	// @WebMethod(operationName="findUserByPseudo1")
	// @WebResult
	// User findUserByPseudo(@WebParam(name = "UserName") String pseudo);

	@WebMethod(operationName = "findAllUsers1")
	@WebResult(name = "listOfUser")
	List<User> findAllUsers();

	@WebMethod(operationName = "findMemberByPseudo1")
	@WebResult

	public Member findMemberByPseudo(@WebParam(name = "UserName") String pseudo);

	@WebMethod(operationName = "findAllVolunteer")
	@WebResult
	public List<Member> findAllVolunteer();

	@WebMethod(operationName = "getUserConnected")
	@WebResult()
	public User getUserConnected();

	@WebMethod(operationName = "logIn")
	@WebResult()
	public void logIn(@WebParam(name = "user") User usr);

	@WebMethod(operationName = "logOut")
	@WebResult()
	public void logOut();

	@WebMethod(operationName = "findAllMember")
	@WebResult
	List<User> findAllMember(@WebParam(name = "UserName") String preudo);

	@WebMethod(operationName = "findbylogin")
	@WebResult
	User findbylogin(@WebParam(name = "UserName") String username, @WebParam(name = "Password") String password);

	public List<User> findAllMember1();

}