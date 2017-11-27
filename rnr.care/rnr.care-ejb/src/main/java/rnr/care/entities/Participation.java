package rnr.care.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: Participation
 *
 */
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)

public class Participation implements Serializable {

	@EmbeddedId
	private ParticipationPK participationPk;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
	private Event event;
	
	
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idUser", referencedColumnName = "idUser", insertable = false, updatable = false)
	private User user;

	@Column
	@XmlElement
	private int numberparticipant;
	@Temporal(TemporalType.DATE)
	@XmlElement
	private Date date;
	@Column
	@XmlElement
	private int activate =1;
	private static final long serialVersionUID = 1L;

	public Participation(int numberparticipant, User u, Event e) {
		super();
		this.participationPk = new ParticipationPK(e.getId(), u.getIdUser());
		this.numberparticipant = numberparticipant;
		this.user = u;
		this.event = e;
	}

	public Participation(User u, Event e) {
		super();
		this.participationPk = new ParticipationPK(e.getId(), u.getIdUser());
		this.user = u;
		this.event = e;
	}

	public Participation() {
		super();
	}

	public Participation(int numberparticipant, Event e, User u) {
		super();
		this.participationPk = new ParticipationPK(e.getId(), u.getIdUser());
		this.numberparticipant = numberparticipant;
		this.event = e;
		this.user = u;
	}
	
	public Participation(int numberparticipant,int activate, Event e, User u) {
		super();
		this.participationPk = new ParticipationPK(e.getId(), u.getIdUser());
		this.numberparticipant = numberparticipant;
		this.activate = activate;
		this.event = e;
		this.user = u;
	}
	
	public Participation(int numberparticipant,Date d, Event e, User u) {
		super();
		this.participationPk = new ParticipationPK(e.getId(), u.getIdUser());
		this.numberparticipant = numberparticipant;
	
		this.date = d;
		this.event = e;
		this.user = u;
	}

	public ParticipationPK getParticipationPk() {
		return participationPk;
	}

	public void setParticipationPk(ParticipationPK participationPk) {
		this.participationPk = participationPk;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getNumberparticipant() {
		return numberparticipant;
	}

	public void setNumberparticipant(int numberparticipant) {
		this.numberparticipant = numberparticipant;
	}

	public int getActivate() {
		return activate;
	}

	public void setActivate(int activate) {
		this.activate = activate;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	

}
