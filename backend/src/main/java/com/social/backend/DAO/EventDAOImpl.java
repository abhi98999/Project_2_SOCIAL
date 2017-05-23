/*package com.social.backend.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.social.backend.model.Event;

@EnableTransactionManagement
@Repository
@Transactional
public class EventDAOImpl implements EventDAO{

	private static final Logger log = LoggerFactory.getLogger(EventDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	public EventDAOImpl(SessionFactory sessionFactory ) {
		this.sessionFactory = sessionFactory;
	}
	
	public boolean saveEvent(Event event) {
		try {
			log.debug("Starting Method saveEvent.");
				sessionFactory.getCurrentSession().save(event);
			log.debug("Ending Method saveEvent");
			return true;
		} catch (HibernateException e) {
			log.error("Error Occured in Method saveEvent:-"+e.getMessage());
			e.printStackTrace();
			return false;
		}		
	}
	
	public boolean updateEvent(Event event) {
		
		try {
			log.debug("Starting Method updateEvent.");
				sessionFactory.getCurrentSession().update(event);
			log.debug("Ending Method updateEvent");
			return true;
		} catch (HibernateException e) {
			log.error("Error Occured in Method updateEvent:-"+e.getMessage());
			e.printStackTrace();
			return false;
			}
	}

	public boolean removeEvent(String e_eventId) {
		
		try {
			log.debug("Starting Method removeEvent.");
				sessionFactory.getCurrentSession().createQuery("Update Event set eventStatus = 0 where eventId = '"+e_eventId+"'").executeUpdate();
			log.debug("Event removed with Id:-"+e_eventId);
			log.debug("Ending Method removeEvent.");
			return true;
		} catch (HibernateException e) {
			log.error("Error Occured in removeEvent with (id = '"+e_eventId+"') "+e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	
	public List<Event> getAllEvents() {
	
		try {
			log.debug("Starting of Method getAllEvents");
			Query query = sessionFactory.getCurrentSession().createQuery("FROM Event WHERE eventStatus = 1");
			log.debug("Starting of get Event List");
			@SuppressWarnings("unchecked")
			List<Event> list = query.list();
			if(list==null || list.isEmpty()){
				log.debug("No Event's are Availible");
			}
		log.debug("Ending of Method getAllEvents");
		return list;
		}catch (HibernateException e) {
			log.error("Error Occured in Method getAllEvents :-"+e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public Event getEventById(String e_eventId) {
		try {
			log.debug("Staring of Method getEventById with eventId :- "+e_eventId);
			Query query = sessionFactory.getCurrentSession().createQuery("FROM Event WHERE eventId = '"+e_eventId+"' AND eventStatus = 1");
			@SuppressWarnings("unchecked")
			List<Event> eventList = query.list();
			if(eventList != null && !eventList.isEmpty())
				{
					log.debug("Record Found in method getEventById with eventId ="+e_eventId);
						return eventList.get(0);
				}
				else
				{
					log.debug("No Record Found in getEventById with eventId ="+e_eventId);
					return null;
				}
				}
				catch (HibernateException e) 
				{
					log.error("Error Occures in getEventById Method..!! (eventId = '"+e_eventId+"')");
					e.printStackTrace();
					return null;
				}
		
	}
	

}
*/