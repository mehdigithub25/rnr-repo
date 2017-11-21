package rnr.care.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import rnr.care.entities.Partner;

/**
 * Entity implementation class for Entity: InsuranceAgent
 *
 */
@Entity
@XmlRootElement(name="InsuranceAgent")
@XmlType(propOrder = {"agency"})
public class InsuranceAgent extends Partner implements Serializable {

	
	private String agency;
	private static final long serialVersionUID = 1L;

	public InsuranceAgent() {
		super();
	}   
	public String getAgency() {
		return this.agency;
	}
	@XmlElement(name="agency")
	public void setAgency(String agency) {
		this.agency = agency;
	}
	public InsuranceAgent(int idUser, String firstName, String lastName, String userName, String password, String email,
			String address, int numPhone, Float subscriptionFees, Boolean state, String agency) {
		super(idUser, firstName, lastName, userName, password, email, address, numPhone, subscriptionFees, state);
		this.agency = agency;
	}
	public InsuranceAgent(String firstName, String lastName, String userName, String password, String email,
			String address, int numPhone, String agency) {
		super(firstName, lastName, userName, password, email, address, numPhone);
		this.agency = agency;
	}
	public InsuranceAgent(int idUser, String firstName, String lastName, String userName, String password, String email,
			String address, int numPhone, String agency) {
		super(idUser, firstName, lastName, userName, password, email, address, numPhone);
		this.agency = agency;
	}
   
}
