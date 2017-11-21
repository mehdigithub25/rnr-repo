package rnr.care.services;

import java.util.List;

import javax.ejb.Local;

import rnr.care.entities.Member;
import rnr.care.entities.User;

@Local
public interface UserManagerLocal {
	void addUser(User user);

	void updateUser(User user);

	void deleteUserById(int id);

	//void deleteUser(User user);

	User findUserById(int id);
	
	//User findUserByPseudo(String pseudo);

	List<User> findAllUsers();
	
	public Member findMemberByPseudo(String pseudo);

	List<User> findAllMember(String preudo);
	
	User findbylogin(String username, String password);
	
	public List<Member> findAllVolunteer() ;
	
	
	public  User getUserConnected() ;

	public  void logIn(User usr) ;

	public  void logOut() ;

}
