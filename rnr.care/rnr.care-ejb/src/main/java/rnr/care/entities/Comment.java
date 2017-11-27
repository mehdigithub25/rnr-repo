package rnr.care.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Comment
 *
 */
@Entity

public class Comment implements Serializable {
	@EmbeddedId

	private CommentId commentId;
	private String context;
	@ManyToOne
	@JoinColumn(name = "idUser", referencedColumnName = "idUser", updatable = false, insertable = false)
	private User user;
	@ManyToOne
	@JoinColumn(name = "idPost", referencedColumnName = "id", updatable = false, insertable = false)
	private Post post;
	private static final long serialVersionUID = 1L;

	public Comment() {
		super();
	}

	public Comment(User user, Post post, String context) {
		super();

		this.user = user;
		this.post = post;
		this.context = context;
		this.commentId = new CommentId(user.getIdUser(), post.getId());
	}

	public CommentId getCommentId() {
		return commentId;
	}

	public void setCommentId(CommentId commentId) {
		this.commentId = commentId;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
