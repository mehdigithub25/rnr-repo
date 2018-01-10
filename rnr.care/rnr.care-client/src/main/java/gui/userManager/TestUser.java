package gui.userManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


import rnr.care.entities.AssociationAgent;
import rnr.care.entities.Member;

import rnr.care.entities.User;
import rnr.care.services.ClaimManagerRemote;
import rnr.care.services.UserConnectRemote;
import rnr.care.services.UserManagerRemote;

public class TestUser {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		String jndi = "rnr.care-ear/rnr.care-ejb/UserManager!rnr.care.services.UserManagerRemote";
		
		UserManagerRemote userManagementRemote = (UserManagerRemote) context.lookup(jndi);

		String jndi1 = "rnr.care-ear/rnr.care-ejb/UserConnect!rnr.care.services.UserConnectRemote";
		UserConnectRemote userConnectRemote = (UserConnectRemote) context.lookup(jndi1);
		
		String jndi2 = "rnr.care-ear/rnr.care-ejb/ClaimManager!rnr.care.services.ClaimManagerRemote";
		ClaimManagerRemote claimManagerRemote = (ClaimManagerRemote) context.lookup(jndi2);

		
	//	System.out.println("0000000"+claimManagerRemote.);
		
		claimManagerRemote.sendMessage("mehdi.benaissa1@esprit.tn", "macro7mito", "mehdi.benaissa26@gmail.com", "alooo", "test");
		
		
		

		//User user = userManagementRemote.findbylogin("member1", "member1");

	//	userConnectRemote.logIn(user);

		// userConnectRemote.logOut();

		//System.out.println(userConnectRemote.getUserConnected().getFirstName());
		
	//	System.out.println( user.getClass().toString());
		

		
		
		
//***********************************************************************************//
		
		
		
		
		
		//float subfees=50 ;
	//	Member member = new Member("ali","bougerra","ali","ali","ali.bougera@gmail.com","29 av de laliberté",25645987);


		// ***********************************************************************************//

		// float subfees=50 ;
		// Member member = new Member("ali",
		// "bougerra","aloulou","aloulou","ali.bougera@gmail.com","29 av de la
		// liberté",25645987);

		// Professional professional = new Professional("ali",
		// "bougerra","aloulou","aloulou","ali.bougera@gmail.com","29 av de la
		// liberté",25645987,subfees,true,"dog","fil houma");

		// System.out.println((userManagementRemote.findUserById(1)).getFirstName());

		// userManagementRemote.addUser(professional);

		// Member member = new Member("aaa", "aaa", "aaa", "aaa", " aaa", "aaa", 1254);

		//AssociationAgent ag = new AssociationAgent("yasmineAzaiezAssociation", "yasmineAzaiezAssociation", "yasmineAzaiezAssociation", "yasmineAzaiezAssociation",
		 //"yasmineAzaiezAssociation", "yasmineAzaiezAssociation", 879, subfees, true,
		 //"dog", "sos animal");
	//	 userManagementRemote.addUser(member);
		// userManagementRemote.addUser(ag);
		// User user= userManagementRemote.findbylogin("aaa", "aaa");
		// Member member= userManagementRemote.findbylogin("aa", "aa");

		// System.out.println(user.getIdUser());

	}

}
