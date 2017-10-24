package gui.userManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import rnr.care.entities.AssociationAgent;
import rnr.care.entities.Member;
import rnr.care.services.UserManagerRemote;

public class TestUser {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		String jndi = "rnr.care-ear/rnr.care-ejb/UserManager!rnr.care.services.UserManagerRemote";
		UserManagerRemote userManagementRemote = (UserManagerRemote) context.lookup(jndi);

		 float subfees=50 ;
		// Member member = new Member("ali",
		// "bougerra","aloulou","aloulou","ali.bougera@gmail.com","29 av de la
		// liberté",25645987);
		// Professional professional = new Professional("ali",
		// "bougerra","aloulou","aloulou","ali.bougera@gmail.com","29 av de la
		// liberté",25645987,subfees,true,"dog","fil houma");

		// System.out.println((userManagementRemote.findUserById(1)).getFirstName());

		// userManagementRemote.addUser(professional);

	//	Member member = new Member("aaa", "aaa", "aaa", "aaa", " aaa", "aaa", 1254);

		AssociationAgent ag = new AssociationAgent("vvvv", "vvvv", "vvvv", "vvvv", "vvvv", "vvvv", 879, subfees, true,
				"dog", "aaaa");
		userManagementRemote.addUser(ag);
		// User user= userManagementRemote.findbylogin("aaa", "aaa");
		// Member member= userManagementRemote.findbylogin("aa", "aa");

		// System.out.println(user.getIdUser());

	}

}