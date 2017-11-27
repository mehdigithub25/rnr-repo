package gui.participationManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import rnr.care.entities.Event;
import rnr.care.entities.User;
import rnr.care.services.EventManagerRemote;
import rnr.care.services.ParticipationManagementRemote;
import rnr.care.services.UserManagerRemote;

public class TestParticipation {

	public static void main(String[] args) throws NamingException {
		// TODO Auto-generated method stub

		Context context = new InitialContext();

		float subfees = 50;
		String jndi = "rnr.care-ear/rnr.care-ejb/EventManager!rnr.care.services.EventManagerRemote";

		EventManagerRemote eventManagementRemote = (EventManagerRemote) context.lookup(jndi);
		String jndi1 = "rnr.care-ear/rnr.care-ejb/UserManager!rnr.care.services.UserManagerRemote";
		UserManagerRemote userManagementRemote = (UserManagerRemote) context.lookup(jndi1);
		String jndi2 = "rnr.care-ear/rnr.care-ejb/ParticipationManagement!rnr.care.services.ParticipationManagementRemote";
		ParticipationManagementRemote participationManagementRemote = (ParticipationManagementRemote) context
				.lookup(jndi2);

	User user = userManagementRemote.findUserById(1);

		Event event = eventManagementRemote.findEventById(1);

		//participationManagementRemote.saveOrUpdateParticipation(6, 1, new Date,user , event);
	}

}
