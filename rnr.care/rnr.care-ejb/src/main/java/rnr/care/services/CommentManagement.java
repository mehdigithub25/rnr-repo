package rnr.care.services;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import rnr.care.entities.Comment;
import rnr.care.entities.Post;
import rnr.care.entities.User;

/**
 * Session Bean implementation class CommentManagement
 */
@Stateless
public class CommentManagement implements CommentManagementRemote, CommentManagementLocal {

	@PersistenceContext
	private EntityManager entityManager;
	@EJB
	private UserManagerLocal userManagementLocal;
	@EJB
	private PostManagementLocal postManagementLocal;

	/**
	 * Default constructor.
	 */
	public CommentManagement() {

	}

	@Override
	public void addCommentPost(Integer idUser, Integer idPost, String context) {
		User user = userManagementLocal.findUserById(idUser);
		Post post = postManagementLocal.findPostById(idPost);
		Comment comment = new Comment(user, post, context);
		comment.setContext(context);
		entityManager.merge(comment);

	}

	@Override
	public void DeletCommentPost(Comment comment) {
		entityManager.remove(comment);
		

	}

	
}
