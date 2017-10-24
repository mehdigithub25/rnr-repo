package rnr.care.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Entity implementation class for Entity: Member
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Member extends User implements Serializable {

	private String address;
	private int numPhone;
	private static final long serialVersionUID = 1L;

	public Member() {
		super();
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getNumPhone() {
		return this.numPhone;
	}

	public void setNumPhone(int numPhone) {
		this.numPhone = numPhone;
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
	


}
