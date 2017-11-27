package rnr.care.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Entity implementation class for Entity: Member
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@XmlRootElement(name="Member")
@XmlType(propOrder = {"address","numPhone","volunteer"})

public class Member extends User implements Serializable {

	private String address;
	private int numPhone;
	@Column( name="volunteer", nullable = true)
	private boolean volunteer ;

	public boolean isVolunteer() {
		return volunteer;
	}
	@XmlElement(name="volunteer")
	public void setVolunteer(boolean volunteer) {
		this.volunteer = volunteer;
	}

	private static final long serialVersionUID = 1L;

	public Member() {
		super();
	}

	public String getAddress() {
		return address;
	}
	@XmlElement(name="address")
	public void setAddress(String address) {
		this.address = address;
	}

	public int getNumPhone() {
		return numPhone;
	}
	@XmlElement(name="numPhone")
	public void setNumPhone(int numPhone) {
		this.numPhone = numPhone;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Member(int idUser, String firstName, String lastName, String userName, String password, String email,
			String address, int numPhone) {
		super(idUser, firstName, lastName, userName, password, email);
		this.address = address;
		this.numPhone = numPhone;
	}

	public Member(String firstName, String lastName, String userName, String password, String email, String address,
			int numPhone) {
		super(firstName, lastName, userName, password, email);
		this.address = address;
		this.numPhone = numPhone;
	}

	public Member(int idUser, String firstName, String lastName, String userName, String password, String email,
			String address, int numPhone, boolean volunteer) {
		super(idUser, firstName, lastName, userName, password, email);
		this.address = address;
		this.numPhone = numPhone;
		this.volunteer = volunteer;
	}

	public Member(String firstName, String lastName, String userName, String password, String email, String address,
			int numPhone, boolean volunteer) {
		super(firstName, lastName, userName, password, email);
		this.address = address;
		this.numPhone = numPhone;
		this.volunteer = volunteer;
	}

}
