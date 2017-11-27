package rnr.care.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import rnr.care.entities.Partner;

/**
 * Entity implementation class for Entity: Professional
 *
 */
@Entity
@XmlRootElement(name="Professional")
@XmlType(propOrder = {"specialty","officeAddress","type"})
public class Professional extends Partner implements Serializable {

	
	private String specialty;
	private String officeAddress;
	private String type ;
	
	public String getType() {
		return type;
	}
	@XmlElement(name="type")
	public void setType(String type) {
		this.type = type;
	}


	private static final long serialVersionUID = 1L;

	public Professional() {
		super();
	}   
	public String getSpecialty() {
		return this.specialty;
	}
	@XmlElement(name="specialty")
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}   
	public String getOfficeAddress() {
		return this.officeAddress;
	}
	@XmlElement(name="officeAddress")
	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}   


	public Professional(String firstName, String lastName, String userName, String password, String email,
			String address, int numPhone, String specialty, String officeAddress, String type) {
		super(firstName, lastName, userName, password, email, address, numPhone);
		this.specialty = specialty;
		this.officeAddress = officeAddress;
		this.type = type;
	}
	public Professional(String firstName, String lastName, String userName, String password, String email,
			String address, int numPhone, Float subscriptionFees, Boolean state, String specialty,
			String officeAddress) {
		super(firstName, lastName, userName, password, email, address, numPhone, subscriptionFees, state);
		this.specialty = specialty;
		this.officeAddress = officeAddress;
	}
	public Professional(String firstName, String lastName, String userName, String password, String email,
			String address, int numPhone, String specialty, String officeAddress) {
		super(firstName, lastName, userName, password, email, address, numPhone);
		this.specialty = specialty;
		this.officeAddress = officeAddress;
	}
	public Professional(int idUser, String firstName, String lastName, String userName, String password, String email,
			String address, int numPhone, String specialty, String officeAddress) {
		super(idUser, firstName, lastName, userName, password, email, address, numPhone);
		this.specialty = specialty;
		this.officeAddress = officeAddress;
	}
	public Professional(int idUser, String firstName, String lastName, String userName, String password, String email,
			String address, int numPhone, String specialty, String officeAddress, String type) {
		super(idUser, firstName, lastName, userName, password, email, address, numPhone);
		this.specialty = specialty;
		this.officeAddress = officeAddress;
		this.type = type;
	}
	
	
   
}
