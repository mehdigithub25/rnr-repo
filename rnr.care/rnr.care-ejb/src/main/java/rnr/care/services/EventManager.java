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

/**
 * Session Bean implementation class EventManager
 */
@WebService(name = "rnrPortype", portName = "rnrPort", serviceName = "EventService", targetNamespace = "http://rnranimal.tn", endpointInterface = "rnr.care.services.EventManagerRemote")

@Stateless
public class EventManager implements EventManagerRemote, EventManagerLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public EventManager() {
		// TODO Auto-generated constructor stub
	}

	@WebMethod(operationName = "add")
	@WebResult(name = "")

	@Override
	public void saveOrUpdateEvent(@WebParam(name = "event") Event event) {
		entityManager.persist(event);

	}

	@WebMethod(operationName = "update")
	@WebResult(name = "")
	@Override
	public void updateEvent(@WebParam(name = "event") Event event) {
		entityManager.merge(event);

	}

	@WebMethod(operationName = "deleteById")
	@WebResult()
	@Override
	public void deleteEventById(@WebParam(name = "id") int id) {
		entityManager.remove(findEventById(id));

	}

	@WebMethod(operationName = "delete")
	@WebResult()
	@Override
	public void deleteEvent(@WebParam(name = "event") Event event) {
		entityManager.remove(event);

	}

	@WebMethod(operationName = "findById")
	@WebResult(name = "event")
	@Override
	public Event findEventById(@WebParam(name = "id") int id) {

		return entityManager.find(Event.class, id);
	}

	@WebMethod(operationName = "findAll")
	@WebResult(name = "ListOfEvents")
	@Override
	public List<Event> findAllEvents() {
		String jpql = "SELECT e FROM Event e";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	

	@WebMethod(operationName = "findByUser")
	@WebResult(name = "ListOfEventsByUser")
	public List<Event> findEventByUser(@WebParam(name = "id") int id) {
		Query query = entityManager.createQuery("SELECT e FROM Event e  WHERE e.AssociationAgent.idUser=:param ");
		query.setParameter("param", id);
		return query.getResultList();
	}

	/*public List<Event> findEventByMultiChoices(String type, String location) {

		String jpql = "SELECT e FROM Event e  WHERE e.type=:t  AND e.location=:l";
		
		Query query = entityManager.createQuery(jpql);
		query.setParameter("t",type);
		//query.setParameter("d",date);
		query.setParameter("l",location);
		return query.getResultList();
	}*/
}
