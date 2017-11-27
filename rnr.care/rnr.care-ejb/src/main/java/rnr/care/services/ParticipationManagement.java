package rnr.care.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import rnr.care.entities.Event;
import rnr.care.entities.Participation;
import rnr.care.entities.User;

/**
 * Session Bean implementation class ParticipationManagement
 */
@WebService(name = "rnrPortype", portName = "rnrPort", serviceName = "ParticipationService", targetNamespace = "http://rnranimal.tn", endpointInterface = "rnr.care.services.ParticipationManagementRemote")

@Stateless
public class ParticipationManagement implements ParticipationManagementRemote, ParticipationManagementLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public ParticipationManagement() {
		// TODO Auto-generated constructor stub
	}

	@WebMethod()
	@WebResult()
	@Override
	public void saveOrUpdateParticipation(@WebParam(name = "int")int number,@WebParam(name = "date") Date d ,@WebParam(name = "event") Event e,@WebParam(name = "user")User u){

		Participation p = new Participation(number,d, e, u);
		entityManager.persist(p);
	}

	/*@WebMethod()
	@WebResult()
	@Override
	public void cancelParticipationById(Participation p) {
		//p.setActivate(false);
		entityManager.merge(p);

	}

	@WebMethod()
	@WebResult()
	@Override
	public Participation findParticipationByEvent(int id, int iduser) {
		String jpql = "SELECT e FROM Participation e  WHERE e.event.id=:param AND e.AssociationAgent.idUser=:param2";
		Query query = entityManager.createQuery(jpql);
		return (Participation) query.getSingleResult();
	}*/
	
	@WebMethod()
	@WebResult()
	@Override
	public List<Participation> findAllParticicpations() {
		String jpql = "SELECT p FROM Participation p";
		Query query = entityManager.createQuery(jpql);
		
		return query.getResultList();
	}

}
