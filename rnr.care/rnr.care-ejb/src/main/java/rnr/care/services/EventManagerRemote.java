package rnr.care.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import rnr.care.entities.Event;

@WebService
@Remote
public interface EventManagerRemote {
	@WebMethod(operationName = "add")
	@WebResult(name = "")
	void saveOrUpdateEvent(@WebParam(name = "event") Event event);

	@WebMethod(operationName = "update")
	@WebResult(name = "")
	void updateEvent(@WebParam(name = "event") Event event);

	@WebMethod(operationName = "deleteById")
	@WebResult()
	void deleteEventById(@WebParam(name = "id") int id);

	@WebMethod(operationName = "delete")
	@WebResult()
	void deleteEvent(@WebParam(name = "event") Event event);

	@WebMethod(operationName = "findById")
	@WebResult(name = "event")
	Event findEventById(@WebParam(name = "id") int id);

	@WebMethod(operationName = "findAll")
	@WebResult(name = "ListOfEvents")
	List<Event> findAllEvents();

	

	@WebMethod(operationName = "findByUser")
	@WebResult(name = "ListOfEventsByUser")
	public List<Event> findEventByUser(@WebParam(name = "id") int id);
	
	//public List<Event> findEventByMultiChoices(String type,String location);
}
