package rnr.care.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import rnr.care.entities.Partner;

/**
 * Entity implementation class for Entity: AssociationAgent
 *
 */
@Entity

public class AssociationAgent extends Partner implements Serializable {

	
	private String activity;
	private String associationName;
	private static final long serialVersionUID = 1L;

	public AssociationAgent() {
		super();
	}   
	public String getActivity() {
		return this.activity;
	}

	public void setActivity(String Activity) {
		this.activity = Activity;
	}   
	public String getAssociationName() {
		return this.associationName;
	}

	public void setAssociationName(String AssociationName) {
		this.associationName = AssociationName;
	}
	public AssociationAgent(int idUser, String firstName, String lastName, String userName, String password,
			String email, String address, int numPhone, Float subscriptionFees, Boolean state, String activity,
			String associationName) {
		super(idUser, firstName, lastName, userName, password, email, address, numPhone, subscriptionFees, state);
		this.activity = activity;
		this.associationName = associationName;
	}
	public AssociationAgent(String firstName, String lastName, String userName, String password, String email,
			String address, int numPhone, Float subscriptionFees, Boolean state, String activity,
			String associationName) {
		super(firstName, lastName, userName, password, email, address, numPhone, subscriptionFees, state);
		this.activity = activity;
		this.associationName = associationName;
	}

   
}
