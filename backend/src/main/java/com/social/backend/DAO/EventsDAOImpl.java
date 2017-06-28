package com.social.backend.DAO;

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

import com.social.backend.model.Events;


@Transactional
@Repository("eventsDAO")
public class EventsDAOImpl implements EventsDAO {
	private static final Logger log = LoggerFactory.getLogger(EventsDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	
	

	public boolean saveEvent(Events event) {
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



	public boolean updateEvent(Events event) {
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



	public boolean removeEvent(int eventId) {
		try {
			log.debug("Starting Method removeEvent.");
				sessionFactory.getCurrentSession().createQuery("Update Events set e_eventStatus = 0 where e_eventId = '"+eventId+"'").executeUpdate();
			log.debug("Event removed with Id:-"+eventId);
			log.debug("Ending Method removeEvent.");
			return true;
		} catch (HibernateException e) {
			log.error("Error Occured in removeEvent with (id = '"+eventId+"') "+e.getMessage());
			e.printStackTrace();
			return false;
		}
	}



	public List<Events> getAllEvents() {
		try {
			log.debug("Starting of Method getAllEvents");
			Query query = sessionFactory.getCurrentSession().createQuery("FROM Events WHERE e_eventStatus = 1");
			log.debug("Starting of get Event List");
			@SuppressWarnings("unchecked")
			List<Events> list = query.list();
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



	public Events getEventById(int eventId) {
		try {
			log.debug("Staring of Method getEventById with eventId :- "+eventId);
			Query query = sessionFactory.getCurrentSession().createQuery("FROM Events WHERE e_eventId = '"+eventId+"' AND e_eventStatus = 1");
			@SuppressWarnings("unchecked")
			List<Events> eventList = query.list();
			if(eventList != null && !eventList.isEmpty()){
				log.debug("Record Found in method getEventById with eventId ="+eventId);
				return eventList.get(0);
			}else{
				log.debug("No Record Found in getEventById with eventId ="+eventId);
				return null;
			}
	} catch (HibernateException e) {
		log.error("Error Occures in getEventById Method..!! (eventId = '"+eventId+"')");
		e.printStackTrace();
		return null;
	}
	}



	



}
