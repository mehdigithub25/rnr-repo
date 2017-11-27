package rnr.care.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import rnr.care.entities.Partner;

/**
 * Entity implementation class for Entity: Professional
 *
 */
@Entity
@XmlRootElement
public class Professional extends Partner implements Serializable {

	@XmlElement
	private String specialty;
	@XmlElement
	private String officeAddress;
	
	private static final long serialVersionUID = 1L;

	public Professional() {
		super();
	}   
	public String getSpecialty() {
		return this.specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}   
	public String getOfficeAddress() {
		return this.officeAddress;
	}

	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}   


	public Professional(String firstName, String lastName, String userName, String password, String email,
			String address, int numPhone, Float subscriptionFees, Boolean state, String specialty,
			String officeAddress) {
		super(firstName, lastName, userName, password, email, address, numPhone, subscriptionFees, state);
		this.specialty = specialty;
		this.officeAddress = officeAddress;
	}
   
}
