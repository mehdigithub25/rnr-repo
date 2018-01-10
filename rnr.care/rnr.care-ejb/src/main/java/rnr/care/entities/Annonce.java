package rnr.care.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
public class Annonce implements Serializable {
	@Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_annonce;
	private String categorie;
	@Temporal(TemporalType.DATE)
	private Date date;
	private String 	duree;
	private String 	image;
	private String nom_annonce;
	private String type;
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private User user;
	public Annonce(String categorie, String nom_annonce) {
		super();
		this.categorie = categorie;
		this.nom_annonce = nom_annonce;
	}
	public Integer getId_annonce() {
		return id_annonce;
	}
	
	public Annonce() {
		super();
	}
	public void setId_annonce(Integer id_annonce) {
		this.id_annonce = id_annonce;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDuree() {
		return duree;
	}
	public void setDuree(String duree) {
		this.duree = duree;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getNom_annonce() {
		return nom_annonce;
	}
	public void setNom_annonce(String nom_annonce) {
		this.nom_annonce = nom_annonce;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
