package rnr.care.services;

import java.util.List;

import javax.ejb.Local;

import rnr.care.entities.Testimonial;
import rnr.care.entities.User;


@Local
public interface TestimonalServiceLocal {
 
	
	
	void addTestimonial(Testimonial commentaire);
	
	 void deleteTestimonialById(int id);

	 void deleteTestimonial(Testimonial testimonial);

	 Testimonial findTestimonialById(int id);
	
	 List<Testimonial> findallTestimonal();
	 public List<Testimonial> findbyarticle(int id);
	 void updateTestimonial(Testimonial test);
	 public List<Testimonial>findtestimoniall(String contenu);
	 List<Testimonial> TestimonialByUser(int user);
	 public List<Testimonial> findtestimoniall(User user);
}
