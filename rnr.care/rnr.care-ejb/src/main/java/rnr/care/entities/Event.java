package rnr.care.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: Event
 *
 */
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Event implements Serializable {

	@Id
	@XmlElement
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	@XmlElement
	private String title;
	@Column
	@XmlElement
	private String description;
	@Column
	@XmlElement
	private String location;
	@Temporal(TemporalType.DATE)
	@XmlElement
	private Date date;
	@Column
	@XmlElement
	private int partnumber;
	@Column
	@XmlElement
	private String type;

	
	
	@ManyToOne
	private User AssociationAgent;

	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "event")
	private List<Participation> participation;

	public List<Participation> getParticipation() {
		return participation;
	}

	public void setParticipation(List<Participation> participation) {
		this.participation = participation;
	}

	public Event() {
		super();
	}

	public Event(String title, String description, int partnumber) {
		super();
		this.title = title;
		this.description = description;

		this.partnumber = partnumber;
	}

	public Event(String title, String description, String location, int partnumber) {
		super();
		this.title = title;
		this.description = description;
		this.location = location;
		this.partnumber = partnumber;
	}

	public Event(String title, String description, String location, int partnumber, String type) {
		super();
		this.title = title;
		this.description = description;
		this.location = location;
		this.partnumber = partnumber;
		this.type = type;

	}

	public Event(String title, String description, String location, int partnumber, Date date) {
		super();
		this.title = title;
		this.description = description;
		this.location = location;
		this.partnumber = partnumber;
		this.date = date;
	}

	public Event(String title, String description, String location, int partnumber, User u) {
		super();
		this.title = title;
		this.description = description;
		this.location = location;
		this.partnumber = partnumber;
		this.AssociationAgent = u;
	}

	public Event(String title, String description, String location, Date date, String type, int partnumber, User u) {
		super();
		this.title = title;
		this.description = description;
		this.location = location;
		this.date = date;
		this.type = type;
		this.partnumber = partnumber;
		this.AssociationAgent = u;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getPartnumber() {
		return this.partnumber;
	}

	public void setPartnumber(int partnumber) {
		this.partnumber = partnumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public User getAssociationAgent() {
		return AssociationAgent;
	}

	public void setAssociationAgent(User associationAgent) {
		AssociationAgent = associationAgent;
	}

}
