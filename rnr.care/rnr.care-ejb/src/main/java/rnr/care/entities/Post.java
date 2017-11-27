package rnr.care.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: Post
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@XmlRootElement(name = "post")

public class Post implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer id;

	private String title;

	private String context;

	private Category category;

	@ManyToOne(targetEntity = User.class)
	private User user;

	@OneToMany(targetEntity = Comment.class, mappedBy = "post")
	private List<Comment> comments;

	private static final long serialVersionUID = 1L;

	public Post() {
		super();
	}

	public Post(String title, String context, Category category) {
		super();
		this.title = title;
		this.context = context;
		this.category = category;
	}

	/*
	 * public Post(Integer id, User user) { super(); this.id = id; this.user = user;
	 * 
	 * }
	 */

	/*
	 * public Post(Integer id, String title, Category category, User user,
	 * List<Comment> comments) { super(); this.id = id; this.title = title;
	 * this.category = category; this.user = user; this.comments = comments; }
	 */

	public Post(String title, String context, Category category, User user) {
		super();
		this.title = title;
		this.context = context;
		this.category = category;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	@XmlElement
	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	@XmlElement
	public void setTitle(String title) {
		this.title = title;
	}

	@Enumerated(EnumType.STRING)
	public Category getCategory() {
		return category;
	}

	@XmlElement
	public void setCategory(Category category) {
		this.category = category;
	}

	/*
	 * public User getUser() { return user; }
	 * 
	 * public void setUser(User user) { this.user = user; }
	 */

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getContext() {
		return context;
	}

	@XmlElement
	public void setContext(String context) {
		this.context = context;
	}

	/*
	 * public List<Comment> getComments() { return comments; }
	 * 
	 * public void setComments(List<Comment> comments) { this.comments = comments; }
	 */

	@Override
	public String toString() {
		return "Post [IdPost=" + id + ", title=" + title + ", category=" + category + "]";
	}

}
