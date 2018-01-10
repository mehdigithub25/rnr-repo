package rnr.care.services;

import java.util.List;
import java.util.Properties;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import rnr.care.entities.Claim;
import rnr.care.entities.Member;

/**
 * Session Bean implementation class ClaimManager
 */
@Stateless
@LocalBean
public class ClaimManager implements ClaimManagerRemote, ClaimManagerLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public ClaimManager() {
		// TODO Auto-generated constructor stub
	}

	public void addClaim(Claim claim) {
		entityManager.persist(claim);

	}

	public void updateClaim(Claim claim) {
		entityManager.merge(claim);
	}

	public Claim findClaimById(int id) {
		return entityManager.find(Claim.class, id);
	}

	public List<Claim> findAllClaims() {
		String jpql = "SELECT u FROM Claim u WHERE  u.status=:l";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("l", true);
		return query.getResultList();
	}

	public void disableClaim(int id) {

		// String jpql = "UPDATE Claim C SET C.status = :l WHERE T.id = :A";

		String jpql = "UPDATE Claim C SET C.status = :l WHERE EXISTS (SELECT T FROM Claim T WHERE T.id =:A )";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("l", false);
		query.setParameter("A", id);

		query.executeUpdate();

	}

	public  void sendMessage(String sender, String pwd, String to, String subject, String text) {
		final String username = sender;
		final String password = pwd;

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject(subject);
			message.setText(text);
			Transport.send(message);
			System.out.println("Done");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}
	
	
	


}
