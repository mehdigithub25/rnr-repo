package rnr.care.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Commentaire
 *
 */
@Entity

public class Commentaire implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCommentaire;
	private String datecom;
	private String contenu;
	private Integer nbCom;
	private String x;

	@ManyToOne
	private User user;
	private static final long serialVersionUID = 1L;

	public Commentaire(String contenu, Integer nbCom, String x, User user) {
		super();
		this.contenu = contenu;
		this.nbCom = nbCom;
		this.x = x;
		this.user = user;
	}

	public Commentaire(String contenu, User user) {
		super();
		this.contenu = contenu;
		this.user = user;
	}

	public Commentaire(String contenu) {
		super();
		this.contenu = contenu;
	}

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public Commentaire() {
		super();

	}

	public Integer getIdCommentaire() {
		return this.idCommentaire;
	}

	public void setIdCommentaire(Integer idCommentaire) {
		this.idCommentaire = idCommentaire;
	}

	public String getDatecom() {
		return this.datecom;
	}

	public void setDatecom(String datecom) {
		this.datecom = datecom;
	}

	public String getContenu() {
		return this.contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Integer getNbCom() {
		return this.nbCom;
	}

	public void setNbCom(Integer nbCom) {
		this.nbCom = nbCom;
	}

	@Override
	public String toString() {
		return "Commentaire [datecom=" + datecom + ", contenu=" + contenu + ", nbCom=" + nbCom + ", user=" + user + "]";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}