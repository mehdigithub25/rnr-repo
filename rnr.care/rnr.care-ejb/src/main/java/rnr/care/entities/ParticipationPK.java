package rnr.care.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
@SuppressWarnings("serial")
public class ParticipationPK implements Serializable {
	private int id;
	private int idUser;

	public ParticipationPK() {
		super();

	}

	public ParticipationPK(int id, int idUser) {
		super();
		this.id = id;
		this.idUser = idUser;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + idUser;
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
		ParticipationPK other = (ParticipationPK) obj;
		if (id != other.id)
			return false;
		if (idUser != other.idUser)
			return false;
		return true;
	}

}
