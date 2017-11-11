package rnr.care.services;

import javax.ejb.Local;

import rnr.care.entities.Comment;

@Local
public interface CommentManagementLocal {
	void addCommentPost(Integer idUser, Integer idPost, String context);

	void DeletCommentPost(Comment comment);
	
	

}
