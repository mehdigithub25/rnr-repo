package rnr.care.services;

import java.util.List;

import javax.ejb.Local;

import rnr.care.entities.Claim;
import rnr.care.entities.Member;

@Local
public interface ClaimManagerLocal {

	public void addClaim(Claim claim);

	public void updateClaim(Claim claim);

	public Claim findClaimById(int id);

	public List<Claim> findAllClaims();
	
	public void disableClaim(int id);
	
	public  void sendMessage(String sender, String pwd, String to, String subject, String text) ;
	
	

}
