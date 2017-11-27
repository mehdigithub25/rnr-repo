package rnr.care.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


import javax.xml.bind.annotation.XmlType;


import rnr.care.entities.User;

/**
 * Entity implementation class for Entity: Moderator
 *
 */
@Entity



@XmlRootElement(name="Moderator")


public class Moderator extends User implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Moderator() {
		super();
	}

	public Moderator(int idUser, String firstName, String lastName, String userName, String password, String email) {
		super(idUser, firstName, lastName, userName, password, email);
		// TODO Auto-generated constructor stub
	}
   
}
