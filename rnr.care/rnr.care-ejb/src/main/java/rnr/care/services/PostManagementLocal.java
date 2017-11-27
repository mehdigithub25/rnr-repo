package rnr.care.services;

import java.util.List;

import javax.ejb.Local;

import rnr.care.entities.Post;

@Local
public interface PostManagementLocal {
	void addPost(Post post);

	void updatePost(Post post);

	void deletePostById(int id);

	void deletePost(Post post);

	Post findPostById(int id);

	List<Post> findAllPosts();

}
