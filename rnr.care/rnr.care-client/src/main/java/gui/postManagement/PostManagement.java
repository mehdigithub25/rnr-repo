package gui.postManagement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import rnr.care.services.PostManagementRemote;

public class PostManagement {

	public static void main(String[] args) throws NamingException {
		Context context =  new InitialContext();
		String jndi = "rnr.care-ear/rnr.care-ejb/PostManagement!rnr.care.services.PostManagementRemote";
		PostManagementRemote PMR = (PostManagementRemote) context.lookup(jndi);
		
		
				
	}

}
