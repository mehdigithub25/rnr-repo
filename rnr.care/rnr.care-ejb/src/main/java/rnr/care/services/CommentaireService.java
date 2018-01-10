package rnr.care.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import rnr.care.entities.Commentaire;

/**
 * Session Bean implementation class CommentaireService
 */
@Stateless
@LocalBean
@WebService
public class CommentaireService implements CommentaireServiceRemote, CommentaireServiceLocal {

	@PersistenceContext
	private EntityManager entityManager;

	public CommentaireService() {

	}

	@WebMethod
	@WebResult
	@Override
	public void addCommentaire(Commentaire commentaire) {
		entityManager.persist(commentaire);// TODO Auto-generated method stub

	}

	@WebMethod
	@WebResult
	@Override
	public void deleteCommentaireById(int id) {
		entityManager.remove(id);

	}

	@WebMethod
	@WebResult
	@Override
	public void deleteCommentaire(Commentaire commentaire) {
		entityManager.remove(commentaire);

	}

	@WebMethod
	@WebResult
	@Override
	public Commentaire findCommentaireById(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(Commentaire.class, id);
	}
	@WebMethod
	@WebResult
	@Override
	public List<Commentaire> findAllCommentaire() {
		String jpql = "SELECT c FROM Commentaire c";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}
	@WebMethod
	@WebResult
	@Override
	public int numbreCommentaireByuser(Commentaire c) {
		return entityManager.createQuery("select count(*) from Commentaire c where user.id=:id1", int.class)
				.setParameter("id1", c.getIdCommentaire()).getSingleResult();
	}

	
	
	
}
