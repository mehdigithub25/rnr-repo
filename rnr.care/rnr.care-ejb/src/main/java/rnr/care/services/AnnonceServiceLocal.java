package rnr.care.services;

import java.util.List;

import javax.ejb.Local;

import rnr.care.entities.Annonce;


@Local
public interface AnnonceServiceLocal {
	 void addAnnonce(Annonce annonce);
		
	 void updateAnnonce(Annonce annonce);

	 void deleteAnnonceById(int id);

	 void deleteAnnonce(Annonce annonce);

	Annonce findAnnonceById(int id);
	 public long Countnbreannonce();
	 List<Annonce> findAllAnnonces();
	 List<Annonce> theMostAnnoncedandRatedAnnonceByduree();
}
