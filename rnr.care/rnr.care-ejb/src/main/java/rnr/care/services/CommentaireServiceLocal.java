package rnr.care.services;

import java.util.List;

import javax.ejb.Local;

import rnr.care.entities.Commentaire;

@Local
public interface CommentaireServiceLocal {
	 void addCommentaire(Commentaire commentaire);
		

	 void deleteCommentaireById(int id);

	 void deleteCommentaire(Commentaire commentaire);
	 List<Commentaire> findAllCommentaire();
int numbreCommentaireByuser(Commentaire c);
	 Commentaire findCommentaireById(int id);
}
