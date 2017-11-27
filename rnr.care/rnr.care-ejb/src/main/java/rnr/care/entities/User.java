package rnr.care.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: User
 *
 */

/////// **********////////
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements Serializable {

	// @TableGenerator(name = "USER_GEN", table = "ID_GEN", pkColumnName =
	// "GEN_NAME", valueColumnName = "GEN_VAL", allocationSize = 1)
	@Id
	// @GeneratedValue(strategy = GenerationType.TABLE, generator = "USER_GEN")
	
	/////////////////////// *******////////////////
	// @Entity
	// @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
	// public abstract class User implements Serializable {

	// @Id
	@XmlElement
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUser;
	// private int idUser;
	/////////////// ************/////////
	@XmlElement
	private String firstName;
	@XmlElement
	private String lastName;
	
	@Column(unique = true)
	@XmlElement
	private String userName;
	@XmlElement
	private String password;
	@XmlElement
	private String email;
	private static final long serialVersionUID = 1L;

////farah
	
	@OneToMany(mappedBy = "AssociationAgent", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private List<Event> AssociationAgentEvent;

	public List<Event> getAssociationAgentEvent() {
		return AssociationAgentEvent;
	}

	public void setAssociationAgentEvent(List<Event> associationAgentEvent) {
		AssociationAgentEvent = associationAgentEvent;
	}

	@OneToMany(mappedBy = "user")
	private List<Participation> participation;

	public List<Participation> getParticipation() {
		return participation;
	}

	public void setParticipation(List<Participation> participation) {
		this.participation = participation;
	}

	
	public User() {
		super();
	}

	public User(String firstName, String lastName, String userName, String password, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int IdUser) {
		this.idUser = IdUser;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String FirstName) {
		this.firstName = FirstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String LastName) {
		this.lastName = LastName;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String UserName) {
		this.userName = UserName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String Password) {
		this.password = Password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String Email) {
		this.email = Email;
	}

	public User(int idUser, String firstName, String lastName, String userName, String password, String email) {
		super();
		this.idUser = idUser;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;
	}

}
