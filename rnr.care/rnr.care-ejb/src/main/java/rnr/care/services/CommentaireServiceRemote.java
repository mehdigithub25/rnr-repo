package rnr.care.services;

import java.util.List;

import javax.ejb.Remote;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import rnr.care.entities.Commentaire;

@Remote
@WebService
public interface CommentaireServiceRemote {
	 @WebMethod
	    @WebResult
	void addCommentaire(Commentaire commentaire);
	 @WebMethod
	    @WebResult
	    int numbreCommentaireByuser(Commentaire c);
	 void deleteCommentaireById(int id);
	 @WebMethod
	    @WebResult
	 void deleteCommentaire(Commentaire commentaire);
	 @WebMethod
	    @WebResult
	Commentaire findCommentaireById(int id);
	 List<Commentaire> findAllCommentaire();
}
