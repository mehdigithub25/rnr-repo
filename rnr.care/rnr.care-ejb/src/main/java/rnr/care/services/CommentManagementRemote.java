package rnr.care.services;

import javax.ejb.Remote;

import rnr.care.entities.Comment;

@Remote
public interface CommentManagementRemote {
	void addCommentPost(Integer idUser, Integer idPost, String context);

	void DeletCommentPost(Comment comment);

}
