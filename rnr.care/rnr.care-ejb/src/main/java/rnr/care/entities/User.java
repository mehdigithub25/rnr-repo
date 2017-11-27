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


import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


import javax.xml.bind.annotation.XmlType;



/**
 * Entity implementation class for Entity: User
 *
 */


@Entity

@XmlAccessorType(XmlAccessType.NONE)
@Inheritance(strategy = InheritanceType.JOINED)
@XmlRootElement(name = "user")





@XmlType(propOrder = {"idUser","firstName","lastName","userName","password","email"})

public class User implements Serializable {

	@Id

	// @GeneratedValue(strategy = GenerationType.TABLE, generator = "USER_GEN")
	
	/////////////////////// *******////////////////
	// @Entity
	// @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
	// public abstract class User implements Serializable {

	// @Id



	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUser;

	// private int idUser;
	/////////////// ************/////////


	
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
	@XmlTransient
	@OneToMany(targetEntity = Post.class, mappedBy = "user")
	private List<Post> Posts;
	@XmlTransient
	@OneToMany(targetEntity = Comment.class, mappedBy = "user")
	private List<Comment> comments;

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


	@XmlElement(name = "idUser")



	public void setIdUser(int IdUser) {
		this.idUser = IdUser;
	}

	public String getFirstName() {
		return this.firstName;
	}
	@XmlElement(name="firstName")
	public void setFirstName(String FirstName) {
		this.firstName = FirstName;
	}

	public String getLastName() {
		return this.lastName;
	}
	@XmlElement(name="lastName")
	public void setLastName(String LastName) {
		this.lastName = LastName;
	}

	public String getUserName() {
		return this.userName;
	}
	@XmlElement(name="userName")
	public void setUserName(String UserName) {
		this.userName = UserName;
	}

	public String getPassword() {
		return this.password;
	}
	@XmlElement(name="password")
	public void setPassword(String Password) {
		this.password = Password;
	}

	public String getEmail() {
		return this.email;
	}
	@XmlElement(name="email")
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

	/*public List<Post> getPosts() {
		return Posts;
	}

	public void setPosts(List<Post> posts) {
		Posts = posts;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}*/

	public User(int idUser, String firstName, String lastName, String userName, String password, String email,
			List<Post> posts, List<Comment> comments) {
		super();
		this.idUser = idUser;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		Posts = posts;
		this.comments = comments;
	}

}