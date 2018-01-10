package rnr.care.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import rnr.care.entities.Annonce;

/**
 * Session Bean implementation class AnnonceService
 */
@Stateless
@LocalBean
public class AnnonceService implements AnnonceServiceRemote, AnnonceServiceLocal {

	@PersistenceContext
	EntityManager entityManager;

	public AnnonceService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addAnnonce(Annonce annonce) {
		entityManager.merge(annonce);

	}

	@Override
	public void updateAnnonce(Annonce annonce) {
		entityManager.merge(annonce);

	}

	@Override
	public void deleteAnnonceById(int id) {
		entityManager.remove(findAnnonceById(id));

	}

	@Override
	public void deleteAnnonce(Annonce annonce) {
		entityManager.remove(entityManager.merge(annonce));

	}

	@Override
	public Annonce findAnnonceById(int id) {
		return entityManager.find(Annonce.class, id);
	}

	@Override
	public List<Annonce> findAllAnnonces() {
		String jpql = "SELECT u FROM Annonce u";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public long Countnbreannonce() {
		long nb = 0;
		String jpql = "SELECT COUNT(u)   FROM Annonce  u WHERE u.duree IN ('5min', '15min') AND  u.nom_annonce LIKE 'a%' ";
		Query query = entityManager.createQuery(jpql);

		nb = (long) query.getSingleResult();
		return nb;
	}

	@Override
	public List<Annonce> theMostAnnoncedandRatedAnnonceByduree() {
	
int nbre=0;
		String jpql = "SELECT u FROM Annonce u WHERE u.duree IN ('5min','15min') ORDER BY u.type DESC";
		Query query = entityManager.createQuery(jpql);
		nbre=nbre+1;
		Countnbreannonce();
		return query.getResultList();
	}

}
