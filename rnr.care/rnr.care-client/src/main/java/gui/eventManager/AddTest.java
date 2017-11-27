package gui.eventManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import rnr.care.entities.Event;
import rnr.care.services.EventManagerRemote;
import rnr.care.services.UserManagerRemote;

public class AddTest {
	public static void main(String[] args) throws NamingException {
		// TODO Auto-generated method stub
		Context context = new InitialContext();

		float subfees = 50;
		String jndi = "rnr.care-ear/rnr.care-ejb/EventManager!rnr.care.services.EventManagerRemote";
		EventManagerRemote eventManagementRemote = (EventManagerRemote) context.lookup(jndi);
		String jndi1 = "rnr.care-ear/rnr.care-ejb/UserManager!rnr.care.services.UserManagerRemote";
		UserManagerRemote userManagementRemote = (UserManagerRemote) context.lookup(jndi1);

		// List<Event> events = new ArrayList<>();
		//
		// for (Event r : events) {
		// // User u = userManagementRemote.findUserById(1);
		//
		// System.out.println(eventManagementRemote.findEventByUser(1));
		// }

		Event event1 = new Event("title", "description", " location", 50, userManagementRemote.findUserById(1));
		Event event2 = new Event("title", "description", " location", 50, userManagementRemote.findUserById(2));
		Event event3 = new Event("title", "description", " location", 50, userManagementRemote.findUserById(2));

		eventManagementRemote.saveOrUpdateEvent(event1);
		eventManagementRemote.saveOrUpdateEvent(event2);
		eventManagementRemote.saveOrUpdateEvent(event3);

	}

}
