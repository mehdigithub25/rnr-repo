package rnr.care.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import rnr.care.entities.Testimonial;
import rnr.care.entities.User;

/**
 * Session Bean implementation class TestimonalService
 */
@Stateless
@LocalBean
public class TestimonalService implements TestimonalServiceRemote, TestimonalServiceLocal {
	@PersistenceContext
	EntityManager entityManager;

	public TestimonalService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addTestimonial(Testimonial commentaire) {
		entityManager.persist(commentaire);

	}

	@Override
	public void deleteTestimonialById(int id) {
		entityManager.remove(findTestimonialById(id));

	}

	@Override
	public void deleteTestimonial(Testimonial testimonial) {
		// TODO Auto-generated method stub

	}

	@Override
	public Testimonial findTestimonialById(int id) {
		return entityManager.find(Testimonial.class, id);
	}

	@Override
	public List<Testimonial> findallTestimonal() {
		String jpql = "SELECT u FROM Testimonial u";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public List<Testimonial> findbyarticle(int id) {
		return entityManager.createQuery("select t from Testimonial t inner join t.firstname t where t.id =:id1")
				.setParameter("id1", id).getResultList();
	}

	@Override
	public void updateTestimonial(Testimonial test) {
		entityManager.merge(test);
	}

	@Override
	public List<Testimonial> findtestimoniall(User user) {
		String jpql = "select t from Testimonial t where t.user=:dep";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", user);
		return query.getResultList();
	}

	@Override
	public List<Testimonial> TestimonialByUser(int user) {
		String jpql = "select t from Testimonial e where e.User=:dep ";

		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", user);
		return query.getResultList();
	}

	@Override
	public List<Testimonial> findtestimoniall(String contenu) {
		// TODO Auto-generated method stub
		return null;
	}

}
