package rnr.care.services;

import java.util.List;

import javax.ejb.Local;

import rnr.care.entities.Event;

@Local
public interface EventManagerLocal {
	void saveOrUpdateEvent(Event event);

	void updateEvent(Event event);

	void deleteEventById(int id);

	void deleteEvent(Event event);

	Event findEventById(int id);

	List<Event> findAllEvents();

	

	public List<Event> findEventByUser(int id);
}
