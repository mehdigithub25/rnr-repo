package gui.eventManager;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import rnr.care.entities.Event;
import rnr.care.entities.User;
import rnr.care.services.EventManagerRemote;
import rnr.care.services.UserManagerRemote;

public class UpdateTest {

	public static void main(String[] args) throws NamingException {
		// TODO Auto-generated method stub
		Context context = new InitialContext();

		float subfees = 50;
		String jndi = "rnr.care-ear/rnr.care-ejb/EventManager!rnr.care.services.EventManagerRemote";
		EventManagerRemote eventManagementRemote = (EventManagerRemote) context.lookup(jndi);
		String jndi1 = "rnr.care-ear/rnr.care-ejb/UserManager!rnr.care.services.UserManagerRemote";
		UserManagerRemote userManagementRemote = (UserManagerRemote) context.lookup(jndi1);

		 //List<Event> events = new ArrayList<>();
	
		//for (Event r : events) {
		//User u = userManagementRemote.findUserById(2);
		
		//System.out.println(eventManagementRemote.findEventByUser(1));
		// }
		//List<Event> event;
		//eventManagementRemote.findEventByMultiChoices("", "location","aaaa");

	}

}
