package rnr.care.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

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
@Inheritance(strategy = InheritanceType.JOINED)

@XmlRootElement(name = "user")



@XmlType(propOrder = {"idUser","firstName","lastName","userName","password","email"})

public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUser;
	
	private String firstName;
	private String lastName;
	@Column(unique = true)
	private String userName;
	private String password;
	private String email;
	private static final long serialVersionUID = 1L;
	@XmlTransient
	@OneToMany(targetEntity = Post.class, mappedBy = "user")
	private List<Post> Posts;
	@XmlTransient
	@OneToMany(targetEntity = Comment.class, mappedBy = "user")
	private List<Comment> comments;

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