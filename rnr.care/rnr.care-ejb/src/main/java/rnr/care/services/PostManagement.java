package rnr.care.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import rnr.care.entities.Post;

/**
 * Session Bean implementation class PostManagement
 */
@Stateless
@LocalBean
@WebService(name = "rnrPortype", portName = "rnrPort", serviceName = "PostService", targetNamespace = "http://rnranimal.tn", endpointInterface = "rnr.care.services.PostManagementRemote")
public class PostManagement implements PostManagementRemote, PostManagementLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public PostManagement() {

	}

	@Override
	public void addPost(Post post) {

		entityManager.merge(post);

	}

	@Override
	public void updatePost(Post post) {
		entityManager.merge(post);

	}

	@Override
	public void deletePostById(int id) {
		entityManager.remove(findPostById(id));

	}

	@Override
	public void deletePost(Post post) {
		entityManager.remove(post);

	}

	@Override
	public Post findPostById(int id) {

		return entityManager.find(Post.class, id);
	}

	@Override
	public List<Post> findAllPosts() {
		String jpql = "SELECT p FROM Post p";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();

	}

	@Override
	public Post findPostByUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
