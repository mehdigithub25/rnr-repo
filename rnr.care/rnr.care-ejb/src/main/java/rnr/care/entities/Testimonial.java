package rnr.care.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



/**
 * Entity implementation class for Entity: Testimonial
 *
 */
@Entity

public class Testimonial implements Serializable {

	@Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_testimonal;
	private String date_temoin;
	private String typetem;
	private String image;
	private String contenu;
	@ManyToOne
	private User user;
	private static final long serialVersionUID = 1L;

	



	public Testimonial(String typetem, String contenu) {
		super();
		this.typetem = typetem;
		this.contenu = contenu;
	}

	public Testimonial(String typetem, String image, String contenu) {
		super();
		this.typetem = typetem;
		this.image = image;
		this.contenu = contenu;
	}

	public Testimonial() {

	}

	public Testimonial(String date_temoin, String typetem, String image, String contenu, User user) {
		super();
		this.date_temoin = date_temoin;
		this.typetem = typetem;
		this.image = image;
		this.contenu = contenu;
		this.user = user;
	}



	public Testimonial(String contenu) {
		super();
		this.contenu = contenu;
	}

	public Integer getId_testimonal() {
		return id_testimonal;
	}

	public void setId_testimonal(Integer id_testimonal) {
		this.id_testimonal = id_testimonal;
	}

	public String getDate_temoin() {
		return date_temoin;
	}

	public void setDate_temoin(String date_temoin) {
		this.date_temoin = date_temoin;
	}

	public String getTypetem() {
		return typetem;
	}

	public void setTypetem(String typetem) {
		this.typetem = typetem;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
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
