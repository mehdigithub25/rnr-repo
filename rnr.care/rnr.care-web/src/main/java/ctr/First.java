package ctr;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import rnr.care.services.ClaimManagerRemote;

public class First {

	public static void main(String[] args) throws NamingException {

		Context context = new InitialContext();

		String jndi2 = "rnr.care-ear/rnr.care-ejb/ClaimManager!rnr.care.services.ClaimManagerRemote";
		ClaimManagerRemote claimManagerRemote = (ClaimManagerRemote) context.lookup(jndi2);

		claimManagerRemote.sendMessage("mehdi.benaissa1@esprit.tn", "macro7mito", "mehdi.benaissa26@gmail.com", "test",
				"last test");

	}

}
