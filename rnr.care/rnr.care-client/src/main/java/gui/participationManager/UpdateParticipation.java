package gui.participationManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import rnr.care.entities.Participation;
import rnr.care.services.ParticipationManagementRemote;

public class UpdateParticipation {

	public static void main(String[] args) throws NamingException {
		// TODO Auto-generated method stub
		Context context = new InitialContext();

		String jndi = "rnr.care-ear/rnr.care-ejb/ParticipationManagement!rnr.care.services.ParticipationManagementRemote";
		ParticipationManagementRemote participationManagementRemote = (ParticipationManagementRemote) context
				.lookup(jndi);

		//Participation p = participationManagementRemote.findParticipationByEvent(5);
		//System.out.println(p.getNumberparticipant());
		// participationManagementRemote.cancelParticipationById(p);
	}

}
