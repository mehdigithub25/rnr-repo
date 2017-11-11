package rnr.care.services;

import java.util.List;

import javax.ejb.Remote;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import rnr.care.entities.Post;

@Remote
@WebService
public interface PostManagementRemote {
	@WebMethod(operationName = "addOperation")
	@WebResult(name = "")
	void addPost(Post post);

	@WebMethod(operationName = "updateOperation")
	@WebResult(name = "")
	void updatePost(Post post);

	@WebMethod(operationName = "deletByIdOperation")
	@WebResult(name = "")
	void deletePostById(int id);

	@WebMethod(operationName = "deletPostOperation")
	@WebResult(name = "")
	void deletePost(@WebParam(name = "post") Post post);

	@WebMethod(operationName = "findbyidPostOperation")
	@WebResult(name = "post")
	Post findPostById(@WebParam(name = "id") int id);

	@WebMethod(operationName = "findallPostOperation")
	@WebResult(name = "listPost")
	List<Post> findAllPosts();

	@WebMethod(operationName = "findPostByUserperation")
	@WebResult(name = "listPostUser")
	Post findPostByUser(@WebParam(name = "id") int id);

}
