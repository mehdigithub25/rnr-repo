package rnr.care.services;

import java.util.List;

import javax.ejb.Remote;

import javax.jws.WebService;

import rnr.care.entities.Testimonial;
import rnr.care.entities.User;


@Remote
@WebService
public interface TestimonalServiceRemote {
	void addTestimonial(Testimonial commentaire);
	 void deleteTestimonialById(int id);

	 void deleteTestimonial(Testimonial testimonial);

	 Testimonial findTestimonialById(int id);
	
	 List<Testimonial> findallTestimonal();
	 public List<Testimonial> findbyarticle(int id);
	 void updateTestimonial(Testimonial test);
	 public List<Testimonial> findtestimoniall(User user);
	 
}
