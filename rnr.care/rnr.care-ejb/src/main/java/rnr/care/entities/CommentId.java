package rnr.care.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class CommentId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer idUser;
	private Integer idPost;
	private Date dateOfThePublish;

	public CommentId() {

	}

	public CommentId(Integer idUser, Integer idPost) {
		super();
		this.idUser = idUser;
		this.idPost = idPost;
		this.dateOfThePublish = new Date();

	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public Integer getIdPost() {
		return idPost;
	}

	public void setIdPost(Integer idPost) {
		this.idPost = idPost;
	}

	public Date getDateOfThePublish() {
		return dateOfThePublish;
	}

	public void setDateOfThePublish(Date dateOfThePublish) {
		this.dateOfThePublish = dateOfThePublish;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfThePublish == null) ? 0 : dateOfThePublish.hashCode());
		result = prime * result + ((idPost == null) ? 0 : idPost.hashCode());
		result = prime * result + ((idUser == null) ? 0 : idUser.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommentId other = (CommentId) obj;

		if (idPost == null) {
			if (other.idPost != null)
				return false;
		} else if (!idPost.equals(other.idPost))
			return false;
		if (idUser == null) {
			if (other.idUser != null)
				return false;
		} else if (!idUser.equals(other.idUser))
			return false;
		return true;
	}

}
