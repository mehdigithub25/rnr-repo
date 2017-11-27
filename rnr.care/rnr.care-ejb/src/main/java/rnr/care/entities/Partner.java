package rnr.care.entities;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Float;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import rnr.care.entities.Member;

/**
 * Entity implementation class for Entity: Partner
 *
 */
@Entity
@XmlRootElement
@Inheritance(strategy = InheritanceType.JOINED)
public class Partner extends Member implements Serializable {

	@XmlElement
	private Float subscriptionFees;
	@XmlElement
	private Boolean state;
	private static final long serialVersionUID = 1L;

	public Partner() {
		super();
	}   
	public Float getSubscriptionFees() {
		return this.subscriptionFees;
	}

	public void setSubscriptionFees(Float SubscriptionFees) {
		this.subscriptionFees = SubscriptionFees;
	}   
	public Boolean getState() {
		return this.state;
	}

	public void setState(Boolean State) {
		this.state = State;
	}
	public Partner(int idUser, String firstName, String lastName, String userName, String password, String email,
			String address, int numPhone, Float subscriptionFees, Boolean state) {
		super(idUser, firstName, lastName, userName, password, email, address, numPhone);
		this.subscriptionFees = subscriptionFees;
		this.state = state;
	}
	public Partner(String firstName, String lastName, String userName, String password, String email, String address,
			int numPhone, Float subscriptionFees, Boolean state) {
		super(firstName, lastName, userName, password, email, address, numPhone);
		this.subscriptionFees = subscriptionFees;
		this.state = state;
	}

   
}
